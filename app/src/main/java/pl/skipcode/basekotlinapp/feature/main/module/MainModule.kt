package pl.skipcode.basekotlinapp.feature.main.module

import dagger.Module
import dagger.Provides
import pl.skipcode.basekotlinapp.feature.main.MainContract
import pl.skipcode.basekotlinapp.feature.main.navigation.MainRouter
import pl.skipcode.basekotlinapp.feature.main.presentation.MainPresenter

@Module
class MainModule {

    @Provides
    fun providePresenter() : MainContract.Presenter =
            MainPresenter()

    @Provides
    fun provideRouter() : MainContract.Router =
            MainRouter()

}