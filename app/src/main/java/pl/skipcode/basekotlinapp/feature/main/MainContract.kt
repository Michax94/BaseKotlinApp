package pl.skipcode.basekotlinapp.feature.main

import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface MainContract {

    interface View : BaseContract.View

    interface Router : BaseContract.Router{
        fun goToAuthActivity()
        fun goToAboutFragment()
    }

    interface Presenter : BaseContract.Presenter

}