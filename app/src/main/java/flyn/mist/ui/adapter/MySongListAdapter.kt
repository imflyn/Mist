package flyn.mist.ui.adapter

import android.graphics.Bitmap
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import flyn.mist.R
import flyn.mist.helper.ThemeColorHelper
import flyn.mist.model.SongList
import flyn.mist.util.ViewUtils

class MySongListAdapter(mRecyclerView: RecyclerView?) : BaseListAdapter<SongList>(mRecyclerView) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val itemHolder = holder as MySongListAdapter.ItemHolder
        val songList: SongList = getItem(position)

        if (position == 0) {
            itemHolder.iv_songlist.setBackgroundColor(ContextCompat.getColor(mContext, ThemeColorHelper.getInstance().themeColor))
            itemHolder.iv_songlist.setImageResource(R.drawable.ic_fav)
        } else {
            ViewUtils.loadImage(songList.imagePath, itemHolder.iv_songlist, R.drawable.ic_album, object : RequestListener<Bitmap> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                    itemHolder.iv_songlist.setBackgroundColor(ContextCompat.getColor(mContext, ThemeColorHelper.getInstance().themeColor))
                    return false
                }

                override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    return false
                }
            })
        }

        itemHolder.tv_songlist_name.text = songList.name
        itemHolder.tv_song_num.text = mContext.getString(R.string.song_number, songList.songNumber)
        itemHolder.iv_more.setImageDrawable(ViewUtils.tintDrawable(R.drawable.ic_three_point, ThemeColorHelper.getInstance().themeColor))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val itemView = mInflater.inflate(R.layout.view_my_songlist_item, parent, false)
        return ItemHolder(itemView)
    }

    private inner class ItemHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var iv_songlist: ImageView
        internal var iv_more: ImageView
        internal var tv_songlist_name: TextView
        internal var tv_song_num: TextView

        init {
            iv_songlist = itemView.findViewById(R.id.iv_songlist)
            iv_more = itemView.findViewById(R.id.iv_more)
            tv_songlist_name = itemView.findViewById(R.id.tv_songlist_name)
            tv_song_num = itemView.findViewById(R.id.tv_song_num)

            iv_more.setOnClickListener(this)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.itemView -> {

                }
                R.id.iv_more -> {

                }
            }
        }
    }
}