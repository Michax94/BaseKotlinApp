package pl.skipcode.basekotlinapp.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.skipcode.basekotlinapp.feature.auth.module.AuthModule
import pl.skipcode.basekotlinapp.feature.main.module.MainModule
import pl.skipcode.basekotlinapp.feature.main.ui.AuthActivity
import pl.skipcode.basekotlinapp.feature.main.ui.MainActivity
import pl.skipcode.basekotlinapp.feature.splash.ui.SplashActivity
import pl.skipcode.basekotlinapp.feature.splash.module.SplashModule

@Module
abstract class ActivityBinderModule {

    @Binds
    abstract fun activity(activity: AppCompatActivity): AppCompatActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindsSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [AuthModule::class])
    abstract fun bindsAuthActivity(): AuthActivity

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindsMainActivity(): MainActivity

}