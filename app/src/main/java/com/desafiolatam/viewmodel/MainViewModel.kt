package com.desafiolatam.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val counterMutableStateFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    val counterStateFlow: StateFlow<Int> = counterMutableStateFlow.asStateFlow()

    fun increase() {
        counterMutableStateFlow.value += 1
    }
}