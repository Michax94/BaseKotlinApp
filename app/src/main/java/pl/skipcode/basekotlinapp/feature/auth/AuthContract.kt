package pl.skipcode.basekotlinapp.feature.main

import pl.skipcode.basekotlinapp.feature.commons.BaseContract

interface AuthContract {

    interface Router : BaseContract.Router{
        fun openMainActivity()
    }

    interface Presenter : BaseContract.Presenter {
        fun visible()
        fun hidden()
    }

}