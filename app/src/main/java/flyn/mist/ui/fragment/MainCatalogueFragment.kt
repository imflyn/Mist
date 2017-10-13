package flyn.mist.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import flyn.mist.R
import flyn.mist.helper.ThemeColorHelper
import flyn.mist.model.SongList
import flyn.mist.ui.adapter.MySongListAdapter
import flyn.mist.ui.presenter.SongListPresenter
import flyn.mist.ui.view.ISongListView
import flyn.mist.util.ViewUtils
import kotlinx.android.synthetic.main.fragment_main_catalogue.*


class MainCatalogueFragment : BaseFragment(), View.OnClickListener, ISongListView {

    private lateinit var songListPresenter: SongListPresenter
    private lateinit var mySongListAdapter: MySongListAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_main_catalogue
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        songListPresenter = SongListPresenter(this)
    }

    override fun initView(savedInstanceState: Bundle?) {
        recycleView_catalogue.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        recycleView_catalogue.isNestedScrollingEnabled = false
        mySongListAdapter = MySongListAdapter(recycleView_catalogue)
        recycleView_catalogue.adapter = mySongListAdapter
    }

    override fun themeSettings() {
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

        songListPresenter.getSongList()
    }

    override fun onDestroy() {
        super.onDestroy()
        songListPresenter.onDestroy()
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

    override fun onGetSongLists(songLists: List<SongList>) {
        mySongListAdapter.data = songLists
    }

}