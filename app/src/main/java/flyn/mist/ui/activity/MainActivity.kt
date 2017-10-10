package flyn.mist.ui.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import flyn.mist.R
import flyn.mist.helper.statusbar.Eyes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        supportActionBar?.setDisplayShowTitleEnabled(false)
        Eyes.setStatusBarLightMode(mContext, Color.WHITE)

        val typeFace: Typeface = Typeface.createFromAsset(assets, "fonts/GistRough.otf");
        tv_title.typeface = typeFace

    }

    override fun setListener() {

    }

    override fun initData() {

    }
}
