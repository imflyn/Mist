package flyn.mist.service

import flyn.mist.model.Music

class PlayMusicService private constructor() {

    fun getCurrentMusic(): Music? {
        return null
    }

    companion object {
        fun getInstance(): PlayMusicService {
            return Inner.instance
        }

        private object Inner {
            val instance = PlayMusicService()
        }
    }
}