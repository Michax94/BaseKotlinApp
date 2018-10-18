package pl.skipcode.basekotlinapp.feature.auth.presentation

import android.Manifest
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import okhttp3.internal.http2.ErrorCode
import org.junit.Test

import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import pl.skipcode.basekotlinapp.R
import pl.skipcode.basekotlinapp.data.api.auth.LoginResponse
import pl.skipcode.basekotlinapp.data.api.auth.Result
import pl.skipcode.basekotlinapp.feature.auth.AuthContract
import pl.skipcode.basekotlinapp.feature.commons.presentation.BasePresenter
import pl.skipcode.basekotlinapp.feature.splash.BaseTest
import pl.skipcode.basekotlinapp.utils.configuration.Configuration
import pl.skipcode.basekotlinapp.utils.network.errors.ErrorStatus
import pl.skipcode.basekotlinapp.utils.network.rest.ResponseExeption
import pl.skipcode.basekotlinapp.utils.network.services.AuthService
import pl.skipcode.basekotlinapp.utils.tools.permissions.PermissionsHelperInterface

class AuthPresenterTest : BaseTest(){

    @Mock
    private lateinit var view: AuthContract.View

    @Mock
    private lateinit var router: AuthContract.Router

    @Mock
    private lateinit var premissionsHelper: PermissionsHelperInterface

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var authService: AuthService

    @Mock
    private lateinit var configuration: Configuration

    @Mock
    private lateinit var basePresenter: BasePresenter

    @Mock
    private lateinit var loginResponse: LoginResponse

    @Mock
    private lateinit var responseExeption: ResponseExeption

    private lateinit var presenter: AuthContract.Presenter

    override fun setup(){
        super.setup()
        trampolineRxPlugin()
        presenter = AuthPresenter(
                view,
                router,
                authService,
                premissionsHelper,
                compositeDisposable,
                configuration
        )
    }

    override fun tearDown(){
        super.tearDown()
        Mockito.verifyNoMoreInteractions(
                view,
                router,
                authService,
                premissionsHelper,
                compositeDisposable,
                configuration
        )
    }

    private fun initialize(){
        presenter.initialize()

//        verify(basePresenter, times(1)).initialize()
//        verify(basePresenter, times(1)).initialize()

//        verify(configuration, times(1)).authorizationObservable()

//        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(premissionsHelper, times(1)).request(Manifest.permission.CAMERA)
        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
    }

    @Test
    fun `should subscribe for permissions changes when initialize is called`() {
        `when`(premissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(Observable.never())

        initialize()
    }

    @Test
    fun `should finish when permissions are not granted`() {
        `when`(premissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(Observable.just(false))

        initialize()

        verify(router, times(1)).finish()
        verify(view, times(1)).showMessage(R.string.error_permissions_camera)
    }

    @Test
    fun `should do nothing when permissions are granted`() {
        `when`(premissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(Observable.just(true))

        initialize()
    }

    @Test
    fun `should show message about empty username when validate is called`() {
        `when`(view.readEtUsername()).thenReturn("")

        presenter.validateUsername()

        verify(view, times(1)).readEtUsername()
        verify(view, times(1)).showMessage(R.string.validate_username_empty)
    }

    @Test
    fun `should show message about too short username when validate is called`() {
        `when`(view.readEtUsername()).thenReturn("M1")

        presenter.validateUsername()

        verify(view, times(1)).readEtUsername()
        verify(view, times(1)).showMessage(R.string.validate_username_too_short)
    }

//    @Test
//    fun `should show message wrong username when login request is called`() {
//        val username = "user"
//        val key = "K2I0-I5HG-XRQT-WNXX"
//
//        `when`(view.readEtUsername()).thenReturn(username)
//        `when`(responseExeption).thenReturn(ResponseExeption(100, 401))
//        `when`(responseExeption.errorCode).thenReturn(100)
//        `when`(responseExeption.errorStatus).thenReturn(401)
//        `when`(authService.loginUser(username, key)).thenReturn(Single.error(responseExeption))
//
//        presenter.callLogin()
//
//        verify(view, times(1)).readEtUsername()
//        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
//        verify(authService, times(1)).loginUser(username, key)
//        verify(configuration, times(1)).logout()
//        verify(view, times(1)).showMessage(R.string.error_api_unauthorized)
//    }

    @Test
    fun `should go to main activity when login request is called`() {
        val username = "user"
        val key = "K2I0-I5HG-XRQT-WNXG"
        val token = "MDQ6VXNlcjEyOTMyMjM2"

        `when`(loginResponse.results).thenReturn(listOf(Result(username, token)))
        `when`(view.readEtUsername()).thenReturn(username)
        `when`(authService.loginUser(username, key)).thenReturn(Single.just(loginResponse))

        presenter.callLogin()

        verify(view, times(1)).readEtUsername()
        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(authService, times(1)).loginUser(username, key)
        verify(loginResponse, times(2)).results
        verify(configuration, times(1)).userToken = token
        verify(configuration, times(1)).userName = username
        verify(router, times(1)).goToMainActivity()
    }

    @Test
    fun `should clear composite when clear is called`(){
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }

}