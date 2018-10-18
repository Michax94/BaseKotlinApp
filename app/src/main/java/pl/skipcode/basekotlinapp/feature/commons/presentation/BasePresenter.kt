package pl.skipcode.basekotlinapp.feature.commons.presentation

import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.basekotlinapp.feature.commons.BaseContract
import pl.skipcode.basekotlinapp.utils.configuration.ConfigurationInterface
import timber.log.Timber

abstract class BasePresenter(
        private val compositeDisposable: CompositeDisposable,
        private val configuration: ConfigurationInterface
) : BaseContract.Presenter{

    override fun initialize() {
//        compositeDisposable.add(configuration.authorizationObservable()
//                .subscribe {
//                    Timber.e("BasePresenter Logout = $it")
//                    configuration.logout()
//                })
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}