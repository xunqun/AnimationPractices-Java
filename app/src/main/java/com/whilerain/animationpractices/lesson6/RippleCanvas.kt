package com.whilerain.animationpractices.lesson6

import android.content.Context

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.View
import com.koso.kosometer.R
import com.koso.kosometer.utils.UiUtils

class RippleCanvas @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val DEFAULT_DURATION: Int = 3000

    /**
     * The attributes from xml
     */
    var anchorX: Float

    var anchorY: Float

    var color: Int

    var fill: Boolean

    var duration: Int = 4000

    var initRadius: Int = 0

    /**
     * Stored ripple items
     */
    private var ripples = mutableListOf<RippleAnimator>()


    private var paint = Paint()

    /**
     * Layout parameters
     */
    private var drawLeft: Int = 0

    private var drawTop: Int = 0

    private var drawWidth: Int = 0


    private var drawHeight: Int = 0

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RippleCanvas,
            0, 0
        ).apply {

            try {
                anchorX = getFloat(R.styleable.RippleCanvas_anchorX, 0.5f)
                anchorY = getFloat(R.styleable.RippleCanvas_anchorY, 0.5f)
                color = getColor(R.styleable.RippleCanvas_color, resources.getColor(R.color.colorSurfaceMain))
                fill = getBoolean(R.styleable.RippleCanvas_fill, true)
                duration = getInt(R.styleable.RippleCanvas_duration, DEFAULT_DURATION)
                initRadius = getDimensionPixelSize(R.styleable.RippleCanvas_initRadius, 0)
            } finally {
                recycle()
            }
        }

        if(fill) {
            paint.style = Paint.Style.FILL
        }else{
            paint.style = Paint.Style.STROKE
        }
        paint.color = color
        paint.isAntiAlias = true
        paint.strokeWidth = UiUtils.dpToPx(2).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        drawAllRipples(canvas)
        super.onDraw(canvas)
    }

    private fun drawAllRipples(canvas: Canvas?) {
        var iterator = ripples.iterator()
        while (iterator.hasNext()) {
            iterator.next().apply {
                if (this.isFinished) {
                    iterator.remove()
                } else {
                    if (canvas != null) draw(canvas)
                }
            }
        }
    }

    fun createRipple() {
        ripples.add(
            RippleAnimator(
                duration.toLong(), if (width > height) width else height,
                (width * anchorX).toInt(), (height * anchorY).toInt()
            ).apply { this.start() }
        )

    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        drawLeft = 0 + paddingLeft
        drawTop = 0 + paddingTop
        drawWidth = right - left - paddingRight - paddingLeft
        drawHeight = top - bottom - paddingTop - paddingBottom
    }

    inner class RippleAnimator(val duration: Long, val targetRadius: Int, val x: Int, val y: Int) :
        CountDownTimer(duration, 10) {
        private var ratio: Float = 0f
        private var tickCounter = 0
        var isFinished = false

        override fun onFinish() {
            isFinished = true
        }

        override fun onTick(millisUntilFinished: Long) {
            tickCounter++
            ratio = (duration - millisUntilFinished).toFloat() / duration
            invalidate()
        }

        fun draw(canvas: Canvas) {
            var radius = (drawWidth - initRadius)  * ratio + initRadius
            paint.alpha = ((1 - ratio) * 255).toInt()
            canvas.drawOval(RectF(x - radius, y - radius, x + radius, y + radius), paint)
        }
    }
}
