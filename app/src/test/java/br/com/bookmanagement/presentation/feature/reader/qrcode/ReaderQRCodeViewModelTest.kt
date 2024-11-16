package br.com.bookmanagement.presentation.feature.reader.qrcode

import br.com.bookmanagement.core.BookTest
import br.com.bookmanagement.domain.model.Books
import br.com.bookmanagement.domain.usecase.ReaderQRCodeUseCase
import br.com.bookmanagement.presentation.BookManagementUiState
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.flow
import org.junit.Test

class ReaderQRCodeViewModelTest : BookTest() {

    private val mockUseCase = mockk<ReaderQRCodeUseCase>(relaxed = true)
    private val viewModel = ReaderQRCodeViewModel(mockUseCase)
    private val mockBooks = Books(23, listOf())

    @Test
    fun `should fetchData successfully`() = coTest {
        coEvery { mockUseCase.getData(any()) } returns flow { emit(Result.success(mockBooks)) }

        viewModel.fetchData("fetch")

        assertNotNull((viewModel.readerQRCodeState.value as QRCodeUiState.Success).item)
        assertEquals(mockBooks, (viewModel.readerQRCodeState.value as QRCodeUiState.Success).item)
    }

    @Test
    fun `should handle error on fetchData function`() = coTest {
        val expectedError = Exception("error fetch data")
        coEvery { mockUseCase.getData("fetch") } returns flow { emit(Result.failure(expectedError)) }

        viewModel.fetchData("fetch")

        assertTrue(viewModel.readerQRCodeState.value is QRCodeUiState.Error)
        assertEquals(expectedError, (viewModel.readerQRCodeState.value as QRCodeUiState.Error).throwable)
    }

    @Test
    fun `should set loading state while fetching`() = coTest {
        viewModel.fetchData("fetch")

        assertTrue(viewModel.readerQRCodeState.value is QRCodeUiState.Loading)
    }
}