package br.com.bookmanagement.data.repository

import br.com.bookmanagement.core.BookTest
import br.com.bookmanagement.data.remote.model.BooksDto
import br.com.bookmanagement.data.remote.service.ApiService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class BookRepositoryTest : BookTest() {

    private val mockBookService = mockk<ApiService>()
    private val repository = BookRepository(mockBookService)

    private val mockBook = BooksDto(
        20,
        listOf()
    )

    @Test
    fun `WHEN called the function getBooks THEN verify body is not null`() {
        coTest {
            coEvery { mockBookService.getVolumes(any()) } returns mockBook
            val result = repository.getVolumes("")

            assertNotNull(result)
        }
    }

    @Test
    fun `WHEN called the function getBooks THEN verify body`() {
        coTest {
            coEvery { mockBookService.getVolumes(any()) } returns mockBook

            val result = repository.getVolumes("")

            assertEquals(mockBook, result)
        }
    }

    @Test
    fun `WHEN called the function getBooks THEN verify is called one time`() {
        coTest {
            coEvery { mockBookService.getVolumes(any()) } returns mockBook

            repository.getVolumes("")

            coVerify(exactly = 1) { repository.getVolumes(any()) }
        }
    }
}