package com.igordesouza.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import androidx.core.content.ContextCompat

private const val STROKE_WIDTH = 12f // has to be float

class MyCanvasView(context : Context) : View(context) {

    private lateinit var cacheCanvas: Canvas
    private lateinit var cacheBitmap: Bitmap
    private val backgroundColor = ContextCompat.getColor(context, R.color.colorBackground)
    private val drawColor = ContextCompat.getColor(context, R.color.colorPaint)

    // Set up the paint with which to draw.
    private val paint = Paint().apply {
        color = drawColor
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }

    private var path = Path()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if(::cacheBitmap.isInitialized)
            cacheBitmap.recycle()

        cacheBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        cacheCanvas = Canvas(cacheBitmap)
        cacheCanvas.drawColor(backgroundColor)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(cacheBitmap, 0f, 0f, null)
    }
}