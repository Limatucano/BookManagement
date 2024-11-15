package br.com.bookmanagement.presentation.feature.reader.manual

import br.com.bookmanagement.core.BookTest
import br.com.bookmanagement.domain.model.Books
import br.com.bookmanagement.domain.usecase.ReaderManualUseCase
import br.com.bookmanagement.presentation.BookManagementUiState
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.flow
import org.junit.Test

class ReaderManualViewModelTest : BookTest() {

    private val mockUseCase = mockk<ReaderManualUseCase>(relaxed = true)
    private val viewModel = ReaderManualViewModel(mockUseCase)
    private val mockBooks = Books(23, listOf())

    @Test
    fun `should fetchData successfully`() = coTest {
        coEvery { mockUseCase.getData(any()) } returns flow { emit(Result.success(mockBooks)) }

        viewModel.fetchData("fetch")

        assertNotNull((viewModel.readerManualState.value as BookManagementUiState.Success<*>).item)
        assertEquals(mockBooks, (viewModel.readerManualState.value as BookManagementUiState.Success<*>).item)
    }

    @Test
    fun `should handle error on fetchData function`() = coTest {
        val expectedError = Exception("error fetch data")
        coEvery { mockUseCase.getData("fetch") } returns flow { emit(Result.failure(expectedError)) }

        viewModel.fetchData("fetch")

        assertTrue(viewModel.readerManualState.value is BookManagementUiState.Error)
        assertEquals(expectedError, (viewModel.readerManualState.value as BookManagementUiState.Error).trhowable)
    }

    @Test
    fun `should set loading state while fetching`() = coTest {
        viewModel.fetchData("fetch")

        assertTrue(viewModel.readerManualState.value is BookManagementUiState.Loading)
    }
}