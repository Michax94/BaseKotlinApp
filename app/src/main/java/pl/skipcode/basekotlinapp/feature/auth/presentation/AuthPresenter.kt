package pl.skipcode.basekotlinapp.feature.auth.presentation

import pl.skipcode.basekotlinapp.feature.commons.BaseContract
import pl.skipcode.basekotlinapp.feature.main.AuthContract
import timber.log.Timber

class AuthPresenter : AuthContract.Presenter {

    override fun visible() {
        Timber.d("visible")
    }

    override fun hidden() {
        Timber.d("hidden")
    }

    override fun initialize() {
        Timber.d("initialize")
    }

    override fun clear() {
        Timber.d("clear")
    }
}