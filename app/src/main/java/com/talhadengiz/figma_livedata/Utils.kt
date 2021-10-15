package com.talhadengiz.figma_livedata

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import android.widget.TextView

//Hidden status bar
fun removeStatus(activity: Activity) {
    activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    activity.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
}

fun showDialog(title: String, content: String, activity: Activity) {
    val dialog = Dialog(activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.layout_dialog)
    val titleDialog = dialog.findViewById(R.id.tv_title) as TextView
    titleDialog.text = title
    val body = dialog.findViewById(R.id.tv_content) as TextView
    body.text = content
    val yesBtn = dialog.findViewById(R.id.tv_ok) as TextView
    yesBtn.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}