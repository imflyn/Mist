package flyn.mist.ui.presenter

import android.app.Activity
import android.support.v4.app.Fragment
import flyn.mist.ui.view.IView
import io.reactivex.disposables.CompositeDisposable

abstract class IPresenter<T : IView>(protected var iView: T) {

    protected var mContext: Activity
    protected val disposable = CompositeDisposable()

    init {
        if (iView is Activity) {
            mContext = iView as Activity
        } else if (iView is Fragment) {
            mContext = (iView as Fragment).activity
        } else if (iView is android.app.Fragment) {
            mContext = (iView as android.app.Fragment).activity
        } else {
            throw IllegalArgumentException("Can not get the activity value")
        }
    }

    fun onCreate() {

    }

    fun onStart() {

    }

    fun onResume() {

    }

    fun onPause() {

    }

    fun onStop() {

    }

    fun onDestroy() {
        disposable.dispose()
    }


}
