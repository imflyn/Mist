package flyn.mist.ui.fragment


import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import flyn.mist.MistApplication
import flyn.mist.helper.UIHelper


abstract class BaseFragment : Fragment() {

    lateinit var uiHelper: UIHelper;
    lateinit var mContext: Activity;
    lateinit var mInflater: LayoutInflater;
    lateinit var mHandler: Handler;
    lateinit var mRootView: View;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getLayoutId() > 0) {
            mRootView = mInflater.inflate(getLayoutId(), container, false)
        }
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
        setListener()
        initData()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity;
        uiHelper = UIHelper.attachToActivity(activity)
        mInflater = LayoutInflater.from(activity)
        mHandler = MistApplication.appContext.handler
    }

    abstract fun getLayoutId(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun setListener()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        uiHelper.destroy()
    }
}