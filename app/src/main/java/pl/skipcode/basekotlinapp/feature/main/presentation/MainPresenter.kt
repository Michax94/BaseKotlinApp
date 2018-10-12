package pl.skipcode.basekotlinapp.feature.main.presentation

import pl.skipcode.basekotlinapp.feature.main.MainContract
import timber.log.Timber

class MainPresenter : MainContract.Presenter {

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