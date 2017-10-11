package flyn.mist.ui.view

import flyn.mist.model.Music

interface ICurrentMusicView : IView {


    fun onGetCurrentMusicSuccess(music: Music)

    fun onGetCurrentMusicFailed()
}