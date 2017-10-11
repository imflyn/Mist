package flyn.mist.helper

import android.preference.PreferenceManager
import com.f2prateek.rx.preferences2.RxSharedPreferences
import flyn.mist.MistApplication


class SharedPreferencesHelper {


    var rxPreferences: RxSharedPreferences

    init {
        val preferences = PreferenceManager.getDefaultSharedPreferences(MistApplication.appContext)
        rxPreferences = RxSharedPreferences.create(preferences)
    }

}