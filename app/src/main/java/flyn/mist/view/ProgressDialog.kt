package flyn.mist.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import flyn.mist.R

class ProgressDialog : Dialog {

    constructor(context: Context) : super(context, R.style.ProgressDialog) {}

    constructor(context: Context, themeResId: Int) : super(context, themeResId) {}

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_progress_dialog)
    }
}
