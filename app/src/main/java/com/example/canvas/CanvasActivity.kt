package com.example.canvas

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import com.example.canvas.CanvasActivity.DrawView
import java.lang.StringBuilder


class CanvasActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }

    internal class DrawView(context: Context?) : View(context) {
        var p: Paint
        var rect: Rect
        var sb: StringBuilder
        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(0, 0, 0,0)
            p.color = Color.BLACK
            p.strokeWidth = 10f
            p.textSize = 30f

            // перенастраивам кисть на контуры
            p.style = Paint.Style.STROKE
            rect.offset(150, 0)

            canvas.drawCircle(600f, 700f, 250f, p);
        }

        init {
            p = Paint()
            rect = Rect(100, 200, 200, 300)
            sb = StringBuilder()
        }
    }
}