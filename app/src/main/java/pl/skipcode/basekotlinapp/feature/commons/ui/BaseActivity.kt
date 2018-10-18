package pl.skipcode.basekotlinapp.feature.commons.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import pl.skipcode.basekotlinapp.R
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {

    abstract val layoutId: Int
    abstract val frameLayoutId: Int?

    enum class ANIM {
        FADE_IN, NONE
    }

    private var actualFragment: Fragment? = null
    private var frameLayout: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        if(frameLayoutId != null) {
            frameLayout = findViewById(frameLayoutId!!)
        }
    }

    fun <T> startActivity(
            activityClass: Class<T>,
            flags: List<Int>? = null,
            parcelable: Pair<String, Parcelable>? = null
    ) where T : BaseActivity {
        val intent = Intent(this, activityClass)
        flags?.forEach { intent.addFlags(it) }
        parcelable?.let { intent.putExtra(it.first, it.second) }
        startActivity(intent)
    }

    fun setFragment(fragment: Fragment, animType: ANIM) {
        if (frameLayout != null &&
                (getActualFragment() == null || getActualFragment()?.javaClass?.name != fragment.javaClass.name)) {

            val fragmentManager = supportFragmentManager

            while (fragmentManager.backStackEntryCount > 0) {
                fragmentManager.popBackStackImmediate()
            }

            val fragmentTransaction = fragmentManager.beginTransaction()
            setTransactionAnim(fragmentTransaction, animType)

            fragmentTransaction.replace(frameLayout!!.id, fragment, fragment.javaClass.simpleName)
            fragmentTransaction.commitAllowingStateLoss()
            setActualFragment(fragment)
        }
    }


    fun pushFragment(fragment: Fragment, animType: ANIM) {
        if (isDestroyed) {
            return
        }

        if (frameLayout != null &&
                (getActualFragment() == null || getActualFragment()?.javaClass?.name != fragment.javaClass.name)) {

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            setTransactionAnim(fragmentTransaction, animType)

            fragmentTransaction.replace(frameLayout!!.id, fragment, fragment.javaClass.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commitAllowingStateLoss()
            setActualFragment(fragment)
        }
    }

    fun addFragment(fragment: Fragment, animType: ANIM) {
        if (frameLayout != null &&
                (getActualFragment() == null || getActualFragment()?.javaClass?.name != fragment.javaClass.name)) {

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            setTransactionAnim(fragmentTransaction, animType)

            fragmentTransaction.add(frameLayout!!.id, fragment, fragment.javaClass.simpleName)
            fragmentTransaction.addToBackStack(System.currentTimeMillis().toString() + "")
            fragmentTransaction.commitAllowingStateLoss()
            setActualFragment(fragment)
        }
    }

    private fun getActualFragment(): Fragment? {
        return actualFragment
    }

    private fun setActualFragment(fragment: Fragment?) {
        this.actualFragment = fragment
    }

    private fun setTransactionAnim(fragmentTransaction: FragmentTransaction, animType: ANIM) {
        when (animType) {
            BaseActivity.ANIM.FADE_IN -> fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out,
                    R.anim.fade_in, R.anim.fade_out)
            BaseActivity.ANIM.NONE -> return
        }
    }
}