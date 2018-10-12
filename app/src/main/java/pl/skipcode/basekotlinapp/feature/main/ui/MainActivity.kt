package pl.skipcode.basekotlinapp.feature.main.ui

import android.os.Bundle
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseActivity
import pl.skipcode.basekotlinapp.feature.main.AuthContract
import pl.skipcode.basekotlinapp.feature.main.MainContract
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("message")
        presenter.initialize()
    }

    override fun onResume() {
        super.onResume()
        presenter.visible()
    }

    override fun onPause() {
        super.onPause()
        presenter.hidden()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }


}