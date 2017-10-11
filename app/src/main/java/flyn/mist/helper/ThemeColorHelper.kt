package flyn.mist.helper

import android.support.annotation.VisibleForTesting
import android.support.v4.content.ContextCompat
import flyn.mist.MistApplication
import flyn.mist.R

class ThemeColorHelper private constructor() {

    private val THEME_COLOR = "THEME_COLOR"
    var themeColor: Int = 0

    init {
        themeColor = ContextCompat.getColor(MistApplication.appContext, R.color.colorAccent)
        SharedPreferencesHelper().rxPreferences.getInteger(THEME_COLOR)
                .asObservable()
                .subscribe({ color ->
                    themeColor = color
                }, {
                    themeColor = ContextCompat.getColor(MistApplication.appContext, R.color.colorAccent)
                })
    }


    fun switchThemeColor(color: Int) {
        themeColor = color
        SharedPreferencesHelper().rxPreferences.getInteger(THEME_COLOR).set(color)
    }

    @VisibleForTesting
    fun getThemeColorFromSP(): Int {
        return SharedPreferencesHelper().rxPreferences.getInteger(THEME_COLOR).get()
    }

    companion object {
        fun getInstance(): ThemeColorHelper {
            return Inner.instance
        }

        private object Inner {
            val instance = ThemeColorHelper()
        }
    }

}