package com.example.samplemvp.ui

import com.example.samplemvp.BasePresenter
import com.example.samplemvp.BaseView

interface TasksContract {

    interface View : BaseView<Presenter> {

    }


    interface Presenter : BasePresenter {

        var currentFiltering : TasksFilterType

    }
}