package flyn.mist.ui.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.FrameLayout
import flyn.mist.R
import flyn.mist.helper.ThemeColorHelper
import flyn.mist.model.Music
import flyn.mist.ui.adapter.LeftMenuAdapter
import flyn.mist.ui.presenter.CurrentMusicPresenter
import flyn.mist.ui.view.ICurrentMusicView
import flyn.mist.util.ViewUtils
import kotlinx.android.synthetic.main.fragment_leftmenu.*


class LeftMenuFragment : BaseFragment(), ICurrentMusicView {

    private lateinit var menuAdapter: LeftMenuAdapter
    private lateinit var currentMusicPresenter: CurrentMusicPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentMusicPresenter = CurrentMusicPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_leftmenu
    }

    override fun initView(savedInstanceState: Bundle?) {
        val layoutParams = recycleView.layoutParams as FrameLayout.LayoutParams
        layoutParams.topMargin = ViewUtils.getDeviceWidth() * 9 / 16
        recycleView.layoutParams = layoutParams

        recycleView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        menuAdapter = LeftMenuAdapter(recycleView)
        recycleView.adapter = menuAdapter

    }

    override fun setListener() {
    }

    override fun initData() {
        menuAdapter.data = listOf(
                getString(R.string.time_stop),
                getString(R.string.theme_color),
                getString(R.string.settings),
                getString(R.string.feedback),
                getString(R.string.about)
        )

        currentMusicPresenter.getCurrentMusic()
    }

    override fun onDestroy() {
        super.onDestroy()
        currentMusicPresenter.onDestroy()
    }

    override fun onGetCurrentMusicSuccess(music: Music) {

    }

    override fun onGetCurrentMusicFailed() {
        val layoutParams = rl_background.layoutParams as FrameLayout.LayoutParams
        layoutParams.height = ViewUtils.getDeviceWidth() * 9 / 16
        rl_background.layoutParams = layoutParams
        rl_background.setBackgroundColor(ThemeColorHelper.getInstance().themeColor)
        recycleView.setBackgroundResource(android.R.color.white)
        tv_back_title.typeface = Typeface.createFromAsset(activity.assets, "fonts/GistRough.otf")
        tv_back_title.setText(R.string.app_name)
        tv_back_title.setTextColor(ContextCompat.getColor(mContext, android.R.color.white))
        tv_back_title.textSize = 24F
    }
}
