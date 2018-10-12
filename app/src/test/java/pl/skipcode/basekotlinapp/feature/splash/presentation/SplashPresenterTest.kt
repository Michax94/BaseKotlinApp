package pl.skipcode.basekotlinapp.feature.splash.presentation

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations
import pl.skipcode.basekotlinapp.feature.splash.SplashContract

class SplashPresenterTest{

    @Mock
    private lateinit var router: SplashContract.Router

    private lateinit var presenter: SplashPresenter

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = SplashPresenter(router)
    }

    @After
    fun tearDown(){
        verifyNoMoreInteractions(router)
    }

    @Test
    fun `should do nothing when initailize is called`(){
        presenter.initialize()
    }

    @Test
    fun `should do nothing when clear is called`(){
        presenter.clear()
    }

}