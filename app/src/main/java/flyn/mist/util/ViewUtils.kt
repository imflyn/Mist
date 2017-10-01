package flyn.mist.util

import android.app.Activity
import android.util.SparseArray
import android.view.View
import android.view.inputmethod.InputMethodManager

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

}