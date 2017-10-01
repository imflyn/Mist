package flyn.mist

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory


class MistApplication : Application() {

    private lateinit var mContext: MistApplication
    val appContext: MistApplication
        get() = mContext

    override fun onCreate() {
        super.onCreate()
        mContext = this
        Glide.get(this).setMemoryCategory(MemoryCategory.HIGH)
    }


    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).clearMemory()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}