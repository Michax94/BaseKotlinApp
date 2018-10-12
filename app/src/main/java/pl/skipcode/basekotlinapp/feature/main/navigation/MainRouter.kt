package pl.skipcode.basekotlinapp.feature.main.navigation

import pl.skipcode.basekotlinapp.feature.main.MainContract
import timber.log.Timber

class MainRouter : MainContract.Router {

    override fun goToAuthActivity() {
        Timber.d("goToAuthActivity")
    }
}