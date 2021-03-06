package flyn.mist.ui.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import flyn.mist.MistApplication
import flyn.mist.helper.ActivityHelper
import flyn.mist.helper.UIHelper
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


abstract class BaseActivity : AppCompatActivity() {

    lateinit var uiHelper: UIHelper
    lateinit var mContext: Activity
    lateinit var mInflater: LayoutInflater
    lateinit var mHandler: Handler

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHelper.getInstance().addActivity(this)
        mContext = this
        uiHelper = UIHelper.attachToActivity(this)
        mInflater = LayoutInflater.from(this)
        mHandler = MistApplication.appContext.handler

        val view: View = mInflater.inflate(getLayoutId(), null, false)
        setContentView(view)
        toolbar?.let {
            setSupportActionBar(toolbar)
        }
        initView()
        themeSettings()
        setListener()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun themeSettings()

    abstract fun setListener()

    abstract fun initData()

    override fun onResume() {
        super.onResume()
        ActivityHelper.getInstance().setCurrentActivity(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        uiHelper.destroy()
        ActivityHelper.getInstance().removeActivity(this)
    }
}