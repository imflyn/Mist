package flyn.mist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import flyn.mist.R
import flyn.mist.helper.ThemeColorHelper
import flyn.mist.util.ViewUtils

class LeftMenuAdapter(mRecyclerView: RecyclerView?) : BaseListAdapter<String>(mRecyclerView) {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val itemHolder = holder as ItemHolder
        var res = 0
        when (position) {
            0 -> {
                res = R.drawable.ic_clock
            }
            1 -> {
                res = R.drawable.ic_theme_color
            }
            2 -> {
                res = R.drawable.ic_setting
            }
            3 -> {
                res = R.drawable.ic_feedback
            }
            4 -> {
                res = R.drawable.ic_about
            }
        }
        itemHolder.iv_icon.setImageDrawable(ViewUtils.tintDrawable(res, ThemeColorHelper.getInstance().themeColor))
        itemHolder.tv_text.setTextColor(ThemeColorHelper.getInstance().themeColor)
        itemHolder.tv_text.text = getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val itemView = mInflater.inflate(R.layout.view_left_menu_item, parent, false)
        return ItemHolder(itemView)
    }

    private inner class ItemHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var tv_text: TextView
        internal var iv_icon: ImageView

        init {
            itemView.setOnClickListener(this)
            tv_text = itemView.findViewById(R.id.tv_text)
            iv_icon = itemView.findViewById(R.id.iv_icon)
        }

        override fun onClick(v: View) {
            when (adapterPosition) {
                0 -> {
                }
                1 -> {
                }
                2 -> {
                }
                3 -> {
                }
                4 -> {
                }
            }
        }
    }
}