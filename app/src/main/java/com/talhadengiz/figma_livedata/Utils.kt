package com.talhadengiz.figma_livedata

import android.app.Activity
import android.content.Context
import android.view.Window
import android.view.WindowManager

//Hidden status bar
fun removeStatus(activity:Activity) {
    activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
}