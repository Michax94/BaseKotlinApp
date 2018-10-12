package pl.skipcode.basekotlinapp.feature.auth.module

import dagger.Module
import dagger.Provides
import pl.skipcode.basekotlinapp.feature.auth.navigation.AuthRouter
import pl.skipcode.basekotlinapp.feature.auth.presentation.AuthPresenter
import pl.skipcode.basekotlinapp.feature.main.AuthContract
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.feature.splash.presentation.SplashPresenter

@Module
class AuthModule {

    @Provides
    fun providePresenter(): AuthContract.Presenter =
            AuthPresenter()

    @Provides
    fun provideRouter(): AuthContract.Router =
            AuthRouter()

}