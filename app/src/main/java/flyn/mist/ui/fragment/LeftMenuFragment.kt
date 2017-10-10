package flyn.mist.ui.fragment

import android.os.Bundle
import android.widget.FrameLayout
import flyn.mist.R
import flyn.mist.util.ViewUtils
import kotlinx.android.synthetic.main.fragment_leftmenu.*


class LeftMenuFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_leftmenu
    }

    override fun initView(savedInstanceState: Bundle?) {
        val layoutParams = recycleView.layoutParams as FrameLayout.LayoutParams
        layoutParams.topMargin = ViewUtils.getDeviceWidth() * 9 / 16
        recycleView.layoutParams = layoutParams
    }

    override fun setListener() {
    }

    override fun initData() {
    }

}
