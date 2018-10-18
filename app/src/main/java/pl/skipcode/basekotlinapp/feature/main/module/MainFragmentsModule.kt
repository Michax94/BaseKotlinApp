package pl.skipcode.basekotlinapp.feature.main.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.module.DashboardModule
import pl.skipcode.basekotlinapp.feature.main.fragments.dashboard.ui.DashboardFragment

@Module
abstract class MainFragmentsModule {

    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun bindsDashboardFragment(): DashboardFragment

}