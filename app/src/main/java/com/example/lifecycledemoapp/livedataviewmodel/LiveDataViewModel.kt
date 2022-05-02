package com.example.lifecycledemoapp.livedataviewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LiveDataViewModel : ViewModel() {


    // set default value for count
    private val _count = MutableLiveData(10)

    private val _newValue: MediatorLiveData<Int> = MediatorLiveData()

    init {

        _newValue.addSource(_count) {}
    }

    val newValue: MediatorLiveData<Int>
        get() = _newValue

    // backing field
    val count: LiveData<Int>
        get() = _count


    fun setCount(data: Int) {
        _count.value = data
//        _newValue.addSource(_count) {
        newValue.value = _count.value!! + 20
//        }

    }


    private val _stateFlow = MutableStateFlow(20)
    val stateFlow = _stateFlow

    private val _sharedFlow = MutableSharedFlow<Int>(15)
    val sharedFlow = _sharedFlow

    suspend fun incrementCounter(num: Int) {
        viewModelScope.launch {
//            delay(3000)
//            _sharedFlow.emit(num+num)

            for (i in 0..500) {
//                delay(500)

        // emit all the values
//    _sharedFlow.emit(i)

                // emit only initial and latest value
                _stateFlow.emit(i)
            }
        }
    }

}