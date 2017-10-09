package flyn.mist

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.multidex.MultiDex
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory


class MistApplication : Application() {


    private var mHandler: Handler? = null
    val handler: Handler
        get() {
            if (mHandler == null) {
                mHandler = Handler(Looper.getMainLooper())
            }
            return mHandler as Handler
        }


    override fun onCreate() {
        super.onCreate()
        appContext = this
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

    companion object {
        lateinit var appContext: MistApplication
            private set
    }
}