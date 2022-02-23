package com.example.canvas


import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import com.example.canvas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(DrawView(this))
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun onDraw(canvas: Canvas) {
            val bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_4444)
            // val canvas = Canvas(bitmap)

            // canvas background color
            //canvas.drawARGB(255, 78, 168, 186);

            var paint = Paint()
            paint.color = Color.parseColor("#000000")
            paint.strokeWidth = 30F
            paint.style = Paint.Style.STROKE
            paint.isAntiAlias = true
            paint.isDither = true

            // get device dimensions
            //val displayMetrics = DisplayMetrics()
            // //windowManager.defaultDisplay.getMetrics(displayMetrics)
            // // circle center
            //// println("Width : "+displayMetrics.widthPixels)
            // var center_x = (displayMetrics.widthPixels/2).toFloat()
            // var center_y = (displayMetrics.heightPixels/2).toFloat()
            // var radius = 50F

            // draw circle
            canvas.drawCircle(600f, 600f, 250f, paint)
            // now bitmap holds the updated pixels

            // set bitmap as background to ImageView
            binding.imageV.background = BitmapDrawable(resources, bitmap)
        }

    }


  // internal class DrawView(context: Context?) : View(context) {
  //     var p: Paint
  //     var rect: Rect
  //     protected override fun onDraw(canvas: Canvas) {
  //         // заливка канвы цветом
  //        // canvas.drawARGB(80, 102, 204, 255)

  //         // настройка кисти
  //         // красный цвет
  //       //  p.setColor(Color.RED)
  //         // толщина линии = 10
  //       //  p.setStrokeWidth(10F)

  //         // рисуем точку (50,50)
  //        // canvas.drawPoint(50f, 50f, p)

  //         // рисуем линию от (100,100) до (500,50)
  //       //  canvas.drawLine(100f, 100f, 500f, 50f, p)

  //         // рисуем круг с центром в (100,200), радиус = 50
  //         p.strokeWidth = 2f
  //         canvas.drawCircle(600f, 600f, 250f,  )


  //         // рисуем прямоугольник
  //         // левая верхняя точка (200,150), нижняя правая (400,200)
  //        // canvas.drawRect(200f, 150f, 400f, 200f, p)

  //         // настройка объекта Rect
  //         // левая верхняя точка (250,300), нижняя правая (350,500)
  //        // rect.set(250, 300, 350, 500)
  //         // рисуем прямоугольник из объекта rect
  //        // canvas.drawRect(rect, p)
  //     }

  //     init {
  //         p = Paint()
  //         rect = Rect()
  //     }
  // }
}