package pl.skipcode.basekotlinapp.feature.splash.module

import dagger.Module
import dagger.Provides
import pl.skipcode.basekotlinapp.feature.splash.SplashContract
import pl.skipcode.basekotlinapp.feature.splash.navigation.SplashRouter
import pl.skipcode.basekotlinapp.feature.splash.presentation.SplashPresenter
import pl.skipcode.basekotlinapp.feature.splash.ui.SplashActivity

@Module
class SplashModule {

    @Provides
    fun provideRouter(): SplashContract.Router =
            SplashRouter()

    @Provides
    fun providePresenter(router: SplashContract.Router): SplashContract.Presenter =
            SplashPresenter(
                    router
            )
}