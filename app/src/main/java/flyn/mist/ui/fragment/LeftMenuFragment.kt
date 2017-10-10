package flyn.mist.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.FrameLayout
import flyn.mist.R
import flyn.mist.ui.adapter.LeftMenuAdapter
import flyn.mist.util.ViewUtils
import kotlinx.android.synthetic.main.fragment_leftmenu.*


class LeftMenuFragment : BaseFragment() {

    private lateinit var menuAdapter: LeftMenuAdapter

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
    }

}
