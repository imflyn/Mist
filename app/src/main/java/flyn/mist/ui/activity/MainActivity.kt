package flyn.mist.ui.activity

import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.view.View
import flyn.mist.R
import flyn.mist.helper.ThemeColorHelper
import flyn.mist.helper.statusbar.Eyes
import flyn.mist.util.ViewUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), View.OnClickListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        supportActionBar?.setDisplayShowTitleEnabled(false)
        Eyes.translucentStatusBar(mContext, true)
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    override fun themeSettings() {
        tv_title.setTextColor(ContextCompat.getColor(mContext, ThemeColorHelper.getInstance().themeColor))
        ibtn_menu.setImageDrawable(ViewUtils.tintDrawable(R.drawable.ic_menu, ThemeColorHelper.getInstance().themeColor))
        ibtn_search.setImageDrawable(ViewUtils.tintDrawable(R.drawable.ic_search, ThemeColorHelper.getInstance().themeColor))

    }

    override fun setListener() {
        ibtn_menu.setOnClickListener(this)
        ibtn_search.setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ibtn_menu -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawers()
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
            }
            R.id.ibtn_search -> {

            }
        }
    }

}
