package flyn.mist.helper

import android.app.Activity
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import flyn.mist.R
import flyn.mist.util.ViewUtils
import flyn.mist.view.DarkProgressDialog
import flyn.mist.view.ProgressDialog

class UIHelper(private val activity: Activity) {

    private var progressDialog: ProgressDialog? = null
    private var darkProgressDialog: DarkProgressDialog? = null
    private var view_noData: View? = null
    private var tv_nodata_message: TextView? = null

    fun destroy() {
        hideProgress()
        hideDarkProgress()
        progressDialog = null
        darkProgressDialog = null
        ViewUtils.hiddenKeyBoard(activity)
    }

    fun showNoDataView(message: String) {
        if (view_noData == null) {
            view_noData = LayoutInflater.from(activity).inflate(R.layout.view_no_data, null)
            tv_nodata_message = view_noData?.findViewById(R.id.tv_nodata_message)
        }
        if (!TextUtils.isEmpty(message)) {
            tv_nodata_message?.text = message
        }

        val viewGroup = activity.findViewById<View>(android.R.id.content) as ViewGroup
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        layoutParams.gravity = Gravity.CENTER
        viewGroup.removeView(view_noData)
        viewGroup.addView(view_noData, layoutParams)
        view_noData?.bringToFront()
    }

    fun hideNoDataView() {
        view_noData?.let {
            val viewGroup = activity.findViewById<View>(android.R.id.content) as ViewGroup
            viewGroup.removeView(view_noData)
        }
    }

    fun showProgress() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(activity)
            progressDialog?.show()
        } else if (progressDialog?.isShowing!!) {
            progressDialog?.show()
        }
    }

    fun hideProgress() {
        progressDialog?.isShowing ?: progressDialog?.dismiss()
    }

    fun showDarkProgress() {
        if (darkProgressDialog == null) {
            darkProgressDialog = DarkProgressDialog(activity)
            darkProgressDialog!!.show()
        } else if (darkProgressDialog?.isShowing!!) {
            darkProgressDialog?.show()
        }
    }

    fun hideDarkProgress() {
        darkProgressDialog?.isShowing ?: darkProgressDialog?.dismiss()
    }

    companion object {
        fun attachToActivity(activity: Activity): UIHelper {
            return UIHelper(activity)
        }
    }

}
