package flyn.mist.helper

import android.app.Activity
import flyn.mist.ui.activity.BaseActivity
import java.util.*

class ActivityHelper private constructor() {

    private var mActivityStack: Stack<Activity>? = null
    private var currentActivity: BaseActivity? = null

    val activityStack: Stack<Activity>
        get() {
            if (mActivityStack == null) {
                mActivityStack = Stack()
            }
            return mActivityStack as Stack<Activity>
        }

    /**
     * push ctivity to stack top
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        try {
            val activity = activityStack.lastElement()
            activity.finish()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * 移除指定的Activity
     */
    fun removeActivity(activity: Activity) {
        mActivityStack?.remove(activity)
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        activityStack.forEach {
            if (it.javaClass === cls) {
                it.finish()
            }
        }
    }

    fun getActivity(cls: Class<*>): List<Activity> {
        val activities = ArrayList<Activity>()
        activityStack.forEach {
            if (it.javaClass === cls) {
                activities.add(it)
            }
        }
        return activities
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        val stack = activityStack
        var i = 0
        val size = stack.size
        while (i < size) {
            stack[i]?.finish()
            i++
        }
        stack.clear()
    }


    fun setCurrentActivity(currentActivity: BaseActivity) {
        this.currentActivity = currentActivity
    }

    fun currentActivity(): BaseActivity? {
        return currentActivity
    }


    companion object {
        @Volatile
        var instance: ActivityHelper? = null
            get() {
                if (field == null) {
                    synchronized(ActivityHelper::class.java) {
                        if (field == null)
                            field = ActivityHelper()
                    }
                }
                return field
            }
    }

}