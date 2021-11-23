package com.igordesouza.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.core.content.ContextCompat

class MyCanvasView(context : Context) : View(context) {

    private lateinit var cacheCanvas: Canvas
    private lateinit var cacheBitmap: Bitmap


    private val backgroundColor = ContextCompat.getColor(context, R.color.colorBackground)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if(::cacheBitmap.isInitialized)
            cacheBitmap.recycle()

        cacheBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        cacheCanvas = Canvas(cacheBitmap)
        cacheCanvas.drawColor(backgroundColor)
    }
}