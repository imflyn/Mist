package flyn.mist.ui.view

import flyn.mist.model.SongList


interface ISongListView : IView {

    fun onGetSongLists(songLists: List<SongList>)


}