package flyn.mist.util

import android.util.Log

object L {

    private val LOG_FORMAT = "%1\$s\n%2\$s"
    private val TAG = "MIST"
    @Volatile
    private var DISABLED = false

    private val functionName: String?
        get() {
            val sts = Thread.currentThread().stackTrace ?: return null

            sts.forEach {
                if (it.isNativeMethod) {
                    return@forEach
                }

                if (it.className == Thread::class.java.name) {
                    return@forEach
                }

                if (it.className == L::class.java.name) {
                    return@forEach
                }
                return "Thread:" + Thread.currentThread().name + "[" + it.fileName + "] line:" + it.lineNumber + "=="
            }
            return null
        }

    fun enableLogging() {
        DISABLED = false
    }

    fun disableLogging() {
        DISABLED = true
    }

    fun d(message: String, vararg args: Any) {
        log(Log.DEBUG, null, message, *args)
    }

    fun v(message: String, vararg args: Any) {
        log(Log.VERBOSE, null, message, *args)
    }

    fun i(message: String, vararg args: Any) {
        log(Log.INFO, null, message, *args)
    }

    fun w(message: String, vararg args: Any) {
        log(Log.WARN, null, message, *args)
    }

    fun e(ex: Throwable) {
        log(Log.ERROR, ex, null)
    }

    fun e(message: String, vararg args: Any) {
        log(Log.ERROR, null, message, *args)
    }

    fun e(ex: Throwable, message: String, vararg args: Any) {
        log(Log.ERROR, ex, message, *args)
    }

    private fun log(priority: Int, ex: Throwable?, msg: String?, vararg args: Any) {
        var message = msg
        if (DISABLED) {
            return
        }
        if (args.isNotEmpty()) {
            message = String.format("" + message, *args)
        }

        val log: String?
        if (ex == null) {
            log = message
        } else {
            val logMessage = if (message == null) ex.message else message
            val logBody = Log.getStackTraceString(ex)
            log = String.format(LOG_FORMAT, logMessage, logBody)
        }

        Log.println(priority, TAG, createMessage(log))
    }

    private fun createMessage(msg: String?): String {
        return if (functionName == null) msg ?: "" else functionName + msg
    }

}