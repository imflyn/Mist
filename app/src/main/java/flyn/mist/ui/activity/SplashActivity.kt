package flyn.mist.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.graphics.Typeface
import flyn.mist.MistApplication
import flyn.mist.R
import flyn.mist.helper.statusbar.Eyes
import kotlinx.android.synthetic.main.activty_splash.*

class SplashActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activty_splash
    }

    override fun initView() {
        Eyes.translucentStatusBar(this, true)

        val typeFace: Typeface = Typeface.createFromAsset(assets, "fonts/GistRough.otf");
        tv_title.typeface = typeFace;

        tv_title.animate().alpha(1f).setDuration(500).start()
        ll_content.animate().alpha(1f).setDuration(500).start()

        MistApplication.appContext.handler.postDelayed({
            tv_title.animate().alpha(.7f).setDuration(1000).start()
            ll_content.animate().alpha(.3f).setDuration(1000).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    finish()

                }
            }).start()
        }, 1500)
    }

    override fun setListener() {
    }

    override fun initData() {

    }
}

