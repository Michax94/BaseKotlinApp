package pl.skipcode.basekotlinapp.feature.main

import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface MainContract {

    interface Router : BaseContract.Router{
        fun goToAuthActivity()
    }

    interface Presenter : BaseContract.Presenter {
        fun visible()
        fun hidden()
    }

}