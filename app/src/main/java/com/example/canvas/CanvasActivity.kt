package com.example.canvas

import android.app.Activity
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import java.lang.StringBuilder
import android.graphics.Path
import androidx.core.content.ContextCompat
import java.util.*


class CanvasActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }

    internal class DrawView(context: Context?) : View(context) {
        val hour = Path()
        val minute = Path()
        var p: Paint
        var rect: Rect
        var sb: StringBuilder

        override fun onDraw(canvas: Canvas) {
            val scale = Math.min(width / 1000.0f, height / 1000.0f)
            canvas.scale(scale, scale)
            canvas.translate((width / scale - 1000) / 2, (height / scale - 1000) / 2)

            canvas.drawARGB(0, 0, 0,0)
            p.color = Color.BLACK
            p.strokeWidth = 10f
            p.textSize = 30f
            val xMax = 0f
            val xMin = 0f
            val yMax = 0f
            val yMin = 0f

            p.style = Paint.Style.STROKE
            rect.offset(150, 0)

            canvas.drawCircle(500f, 500f, 200f, p)
            for (i in 0..11) {
                if (i % 4 == 0) {
                    p.strokeWidth = 15f
                    canvas.drawLine(500f, 300f, 500f, 330f, p)
                } else {
                    p.strokeWidth = 15f
                    canvas.drawLine(500f, 300f, 500f, 325f, p)
                }
                canvas.rotate(30f,500f,500f)
            }
            p.strokeWidth = 3f
            p.color = ContextCompat.getColor(context,R.color.BLACK)
            p.style = Paint.Style.FILL
            val calendar = Calendar.getInstance()
            canvas.save()
            canvas.rotate((calendar[Calendar.HOUR] * 30 + calendar[Calendar.MINUTE]).toFloat(),500f,500f)

            p.strokeWidth = 11f
            canvas.drawLine(500f, 370f, 500f, 550f, p)
            canvas.restore()

            p.color = ContextCompat.getColor(context,R.color.RED)
            canvas.rotate(calendar[Calendar.MINUTE] * 6 + calendar[Calendar.SECOND] * 0.1f, 500f, 500f)

            p.strokeWidth = 9f
            canvas.drawLine(500f, 390f, 500f, 550f, p)
            p.color = ContextCompat.getColor(context,R.color.BLUE)
            p.strokeWidth = 9f
            canvas.save()

            canvas.rotate((calendar[Calendar.SECOND] * 6).toFloat(), 500f, 500f)
            canvas.drawLine(500f, 405f, 500f, 510f, p)
            canvas.restore()
            canvas.save()

            invalidate()
            handler.sendEmptyMessage(0)
            handler.sendEmptyMessageDelayed(0, 1000)
        }

        init {
            p = Paint()
            rect = Rect(100, 200, 200, 300)
            sb = StringBuilder()
        }
    }
}


