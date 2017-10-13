package flyn.mist.service

import android.net.Uri
import flyn.mist.MistApplication
import flyn.mist.R
import flyn.mist.model.SongList

class SongListService {

    fun getSongLists(): List<SongList> {
        val songLists = ArrayList<SongList>()
        val songList = SongList()
        songList.name = MistApplication.appContext.getString(R.string.my_fav)
        songList.songNumber = 19
        songLists.add(songList)

        for (index in 1..10) {
            val songList2 = SongList()
            songList2.imagePath = Uri.parse("file:///storage/emulated/0/Yiting_music/images/song_t.png")
            songList2.name = "啊建档立卡就算哭了多久阿莱克斯酒店卡拉加速度卡死机了肯德基"
            songList2.songNumber = 33
            songLists.add(songList2)
        }

        return songLists
    }

}