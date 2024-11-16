package br.com.bookmanagement.data.repository

import br.com.bookmanagement.core.BookTest
import br.com.bookmanagement.data.remote.datasource.RemoteDataSourceImpl
import br.com.bookmanagement.data.remote.model.BooksDto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class BookRepositoryImplTest : BookTest() {

    private val mockBookService = mockk<RemoteDataSourceImpl>()
    private val repository = BookRepositoryImpl(mockBookService)

    private val mockBook = BooksDto(
        20,
        listOf()
    )

    @Test
    fun `WHEN called the function getVolumesByTitle THEN verify body is not null`() = coTest {
        coEvery { mockBookService.getVolumesByTitle(any()) } returns mockBook
        val result = repository.getVolumesByTitle("")

        assertNotNull(result)
    }

    @Test
    fun `WHEN called the function getVolumesByTitle THEN verify body`() = coTest {
        coEvery { mockBookService.getVolumesByTitle(any()) } returns mockBook

        val result = repository.getVolumesByTitle("")

        assertEquals(mockBook, result)
    }

    @Test
    fun `WHEN called the function getVolumesByTitle THEN verify is called one time`() = coTest {
        coEvery { mockBookService.getVolumesByTitle(any()) } returns mockBook

        repository.getVolumesByTitle("")

        coVerify(exactly = 1) { mockBookService.getVolumesByTitle(any()) }
    }

    @Test
    fun `WHEN called the function getVolumesByIsbn THEN verify body is not null`() = coTest {
        coEvery { mockBookService.getVolumesByIsbn(any()) } returns mockBook
        val result = repository.getVolumesByIsbn("")

        assertNotNull(result)
    }

    @Test
    fun `WHEN called the function getVolumesByIsbn THEN verify body`() = coTest {
        coEvery { mockBookService.getVolumesByIsbn(any()) } returns mockBook

        val result = repository.getVolumesByIsbn("")

        assertEquals(mockBook, result)
    }

    @Test
    fun `WHEN called the function getVolumesByIsbn THEN verify is called one time`() = coTest {
        coEvery { mockBookService.getVolumesByIsbn(any()) } returns mockBook

        repository.getVolumesByIsbn("")

        coVerify(exactly = 1) { mockBookService.getVolumesByIsbn(any()) }
    }
}