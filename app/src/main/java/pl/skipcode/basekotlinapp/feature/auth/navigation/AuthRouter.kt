package pl.skipcode.basekotlinapp.feature.auth.navigation

import pl.skipcode.basekotlinapp.feature.main.AuthContract
import timber.log.Timber

class AuthRouter : AuthContract.Router {

    override fun openMainActivity() {
        Timber.d("openMainActivity")
    }
}