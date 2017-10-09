package flyn.mist.ui.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import flyn.mist.helper.ActivityHelper
import flyn.mist.helper.UIHelper
import kotlinx.android.synthetic.main.activity_main.*


abstract class BaseActivity : AppCompatActivity() {

    lateinit var uiHelper: UIHelper;
    lateinit var mContext: Activity;
    lateinit var mInflater: LayoutInflater;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHelper.instance?.addActivity(this)
        mContext = this;
        uiHelper = UIHelper.attachToActivity(this)
        mInflater = LayoutInflater.from(this)

        val view: View = mInflater.inflate(getLayoutId(), null, false)
        setContentView(view)
        toolbar?.let {
            setSupportActionBar(toolbar)
        }
        initView()
        setListener()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun setListener()

    abstract fun initData()

    override fun onResume() {
        super.onResume()
        ActivityHelper.instance?.setCurrentActivity(this)
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
        ActivityHelper.instance?.removeActivity(this)
    }
}