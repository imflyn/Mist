package flyn.mist.service

import flyn.mist.model.Music

class MusicService private constructor() {

    fun getCurrentMusic(): Music? {
        return null
    }

    companion object {
        fun getInstance(): MusicService {
            return Inner.instance
        }

        private object Inner {
            val instance = MusicService()
        }
    }
}