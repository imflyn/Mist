package flyn.mist.ui.activity

import android.Manifest
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.graphics.Typeface
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.animation.AccelerateDecelerateInterpolator
import com.tbruyelle.rxpermissions2.RxPermissions
import flyn.mist.R
import flyn.mist.helper.statusbar.Eyes
import kotlinx.android.synthetic.main.activty_splash.*


class SplashActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activty_splash
    }

    override fun initView() {
        Eyes.translucentStatusBar(this, true)

        tv_title.typeface = Typeface.createFromAsset(assets, "fonts/GistRough.otf")

        tv_title.animate().alpha(1f).setDuration(1000).start()
        rootView.animate().alpha(1f).setDuration(1000).start()

        RxPermissions(mContext)
                .request(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe({
                    turnToMainActivity()
                }, {
                    turnToMainActivity()
                })
    }

    override fun themeSettings() {
    }

    override fun setListener() {
    }

    override fun initData() {
    }

    fun turnToMainActivity() {
        mHandler.postDelayed({
            tv_title.animate()
                    .scaleX(.37F)
                    .scaleY(.37F)
                    .translationY(tv_holder.y - tv_title.y)
                    .setDuration(500)
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationEnd(animation: Animator?) {
                            val options = ActivityOptionsCompat.makeCustomAnimation(mContext, R.anim.fadein, R.anim.fadeout)
                            ActivityCompat.startActivity(mContext, Intent(mContext, MainActivity::class.java), options.toBundle())
                            finish()
                        }
                    })
                    .start()
        }, 1500)
    }
}

