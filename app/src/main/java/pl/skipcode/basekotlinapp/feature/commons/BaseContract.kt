package pl.skipcode.basekotlinapp.feature.commons

interface BaseContract {

    interface Router {

    }

    interface Presenter {
        fun initialize()
        fun clear()
    }
}