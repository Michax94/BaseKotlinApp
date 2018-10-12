package pl.skipcode.basekotlinapp.feature.splash.presentation

import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import timber.log.Timber

class SplashPresenter(
        private val router: SplashContract.Router
) : SplashContract.Presenter {

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