package pl.skipcode.basekotlinapp.feature.splash

import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface SplashContract {

    interface Router : BaseContract.Router{
        fun openMainActivity()
        fun goToAuthActivity()
    }

    interface Presenter : BaseContract.Presenter {
        fun visible()
        fun hidden()
    }
}