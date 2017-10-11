package flyn.mist.util

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.util.SparseArray
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import flyn.mist.MistApplication

object ViewUtils {

    private var lastClickTime: Long = 0

    val isFastDoubleClick: Boolean
        get() {
            val time = System.currentTimeMillis()
            val timeD = time - lastClickTime
            if (timeD in 0..600) {
                return true
            }
            lastClickTime = time
            return false
        }

    // I added a generic return type to reduce the casting noise in client code
    operator fun <T : View> get(view: View, id: Int): View {
        var viewHolder: SparseArray<View>? = view.tag as SparseArray<View>
        if (viewHolder == null) {
            viewHolder = SparseArray()
            view.tag = viewHolder
        }
        var childView: View? = viewHolder.get(id)
        if (childView == null) {
            childView = view.findViewById(id)
            viewHolder.put(id, childView)
        }
        return childView as T
    }


    fun hiddenKeyBoard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(activity.currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun showKeyBoard(view: View) {
        val imm = view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }

    fun getPxFromDp(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, MistApplication.appContext.resources.displayMetrics).toInt()
    }

    fun getDeviceWidth(): Int {
        val wm = MistApplication.appContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val size = Point()
        wm.defaultDisplay.getSize(size)
        return size.x
    }

    fun getDeviceHeight(): Int {
        val wm = MistApplication.appContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val size = Point()
        wm.defaultDisplay.getSize(size)
        return size.y
    }

    fun tintDrawable(drawableRes: Int, color: Int): Drawable {
        val wrapDrawable = DrawableCompat.wrap(ContextCompat.getDrawable(MistApplication.appContext, drawableRes)).mutate()
        DrawableCompat.setTint(wrapDrawable, color)
        return wrapDrawable
    }
}