package com.igordesouza.minipaint

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.WindowInsetsController
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myCanvasView = MyCanvasView(this)
        setViewVisibilityFullscreen(myCanvasView)
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
        setContentView(myCanvasView)
    }

    private fun setViewVisibilityFullscreen(myCanvasView: MyCanvasView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val controller = myCanvasView.windowInsetsController
            controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            controller?.hide(WindowInsetsCompat.Type.systemBars())
        } else {
            myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}