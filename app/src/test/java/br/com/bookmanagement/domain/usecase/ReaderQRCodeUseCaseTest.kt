package br.com.bookmanagement.domain.usecase

import android.net.http.HttpException
import br.com.bookmanagement.core.BookTest
import br.com.bookmanagement.data.remote.model.BooksDto
import br.com.bookmanagement.data.repository.IBookRepository
import br.com.bookmanagement.domain.mapper.toBooks
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import org.junit.Before
import org.junit.Test
import java.io.IOException

class ReaderQRCodeUseCaseTest : BookTest() {

    private lateinit var useCase: ReaderQRCodeUseCase
    private lateinit var repository: IBookRepository

    @Before
    fun setUp() {
        repository = mockk()
        useCase = ReaderQRCodeUseCase(repository)
    }

    @Test
    fun `should return Books when repository call is successful for getData`() = coTest {
        val query = "sample query"
        val books = BooksDto(
            23,
            listOf()
        )

        coEvery {
            repository.getVolumesByIsbn(query)
        } returns books

        val result = useCase.getData(query).first()
        assertTrue(result.isSuccess)
        assertEquals(result.getOrNull(), books.toBooks())
    }

    @Test
    fun `should return failure when IOException occurs for getData`() = coTest {
        val query = "sample query"
        val ioException = IOException("Network error")

        coEvery {
            repository.getVolumesByIsbn(query)
        } throws ioException

        val result = useCase.getData(query).first()
        assertTrue(result.isFailure)
        assertEquals(result.exceptionOrNull(), ioException)
    }

    @Test
    fun `should return failure when HttpException occurs for getData`() = coTest {
        val query = "sample query"
        val httpException = mockk<HttpException>()

        coEvery {
            repository.getVolumesByIsbn(query)
        } throws httpException

        val result = useCase.getData(query).first()
        assertTrue(result.isFailure)
        assertEquals(result.exceptionOrNull(), httpException)
    }
}