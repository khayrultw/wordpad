package com.khayrultw.wordpad.ui.presentations.word.base.viewModel

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class BaseAddEditWordViewModel(): BaseWordViewModel(), AddEditViewWordViewModel {
    protected val _finish: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val finish: SharedFlow<Unit> = _finish
}