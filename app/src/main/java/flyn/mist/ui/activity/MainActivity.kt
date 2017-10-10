package flyn.mist.ui.activity

import android.graphics.Typeface
import android.support.v4.view.GravityCompat
import android.view.View
import flyn.mist.R
import flyn.mist.helper.statusbar.Eyes
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        supportActionBar?.setDisplayShowTitleEnabled(false)
        Eyes.translucentStatusBar(mContext, true)
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        tv_title.typeface = Typeface.createFromAsset(assets, "fonts/GistRough.otf")

    }

    override fun setListener() {
        ibtn_menu.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers()
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }

    override fun initData() {

    }
}
