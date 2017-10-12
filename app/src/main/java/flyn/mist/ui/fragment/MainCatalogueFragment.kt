package flyn.mist.ui.fragment

import android.os.Bundle
import android.view.View
import flyn.mist.R
import flyn.mist.helper.ThemeColorHelper
import flyn.mist.util.ViewUtils
import kotlinx.android.synthetic.main.fragment_main_catalogue.*


class MainCatalogueFragment : BaseFragment(), View.OnClickListener {


    override fun getLayoutId(): Int {
        return R.layout.fragment_main_catalogue
    }

    override fun initView(savedInstanceState: Bundle?) {
        iv_local_music.setImageDrawable(ViewUtils.tintDrawable(R.drawable.ic_music, ThemeColorHelper.getInstance().themeColor))
        iv_recently_play.setImageDrawable(ViewUtils.tintDrawable(R.drawable.ic_listen, ThemeColorHelper.getInstance().themeColor))
        iv_recently_add.setImageDrawable(ViewUtils.tintDrawable(R.drawable.ic_add, ThemeColorHelper.getInstance().themeColor))
        iv_manager_playlist.setImageDrawable(ViewUtils.tintDrawable(R.drawable.ic_settings_small, ThemeColorHelper.getInstance().themeColor))
    }

    override fun setListener() {
        ll_local_music.setOnClickListener(this)
        ll_recently_play.setOnClickListener(this)
        ll_recently_add.setOnClickListener(this)
        iv_manager_playlist.setOnClickListener(this)
    }

    override fun initData() {
        tv_local_music_num.text = "(" + 0 + ")"
        tv_recently_play_num.text = "(" + 0 + ")"
        tv_recently_add_num.text = "(" + 0 + ")"
        tv_created_playlist.text = getString(R.string.created_playlist, 0)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_local_music -> {

            }
            R.id.ll_recently_play -> {

            }
            R.id.ll_recently_add -> {

            }
            R.id.iv_manager_playlist -> {

            }
        }
    }

}