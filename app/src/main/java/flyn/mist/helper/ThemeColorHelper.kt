package flyn.mist.helper

import android.support.annotation.VisibleForTesting
import flyn.mist.R

class ThemeColorHelper private constructor() {

    private val THEME_COLOR = "THEME_COLOR"
    var themeColor: Int = 0

    init {
        themeColor = R.color.colorAccent
        SharedPreferencesHelper().rxPreferences.getInteger(THEME_COLOR)
                .asObservable()
                .subscribe({ color ->
                    themeColor = if (color <= 0) R.color.colorAccent else color
                }, {
                    themeColor = R.color.colorAccent
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