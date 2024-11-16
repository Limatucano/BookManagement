package br.com.bookmanagement.presentation.util

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<UIState>(initialUiState: UIState) : ViewModel() {
    protected val uiStateAccess = MutableStateFlow(initialUiState)
    val uiState: StateFlow<UIState> = uiStateAccess.asStateFlow()
}