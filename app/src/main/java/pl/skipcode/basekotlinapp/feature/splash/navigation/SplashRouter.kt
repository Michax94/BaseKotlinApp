package pl.skipcode.basekotlinapp.feature.splash.navigation

import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import timber.log.Timber

class SplashRouter : SplashContract.Router {

    override fun openMainActivity() {
        Timber.d("openMainActivity")
    }

    override fun goToAuthActivity() {
        Timber.d("goToAuthActivity")
    }
}