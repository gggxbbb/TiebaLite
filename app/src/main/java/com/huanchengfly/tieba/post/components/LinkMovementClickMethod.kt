package com.huanchengfly.tieba.post.components

<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.text.Layout
>>>>>>> bffc7b1... fix: 修复长按贴中文本无法弹出菜单
=======
>>>>>>> 79a5a1c8d2d5b8786f584f2660dc7b56db8952b7
import android.text.Selection
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.MotionEvent
import android.widget.TextView


object LinkMovementClickMethod : LinkMovementMethod() {
    private const val CLICK_DELAY = 500L

    private var lastClickTime: Long = 0

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 79a5a1c8d2d5b8786f584f2660dc7b56db8952b7
    override fun canSelectArbitrarily(): Boolean {
        return false
    }

    override fun onTouchEvent(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {
        val action = event.actionMasked
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_DOWN) {
            var x = event.x.toInt()
            var y = event.y.toInt()
            x -= widget.totalPaddingLeft
            y -= widget.totalPaddingTop
            x += widget.scrollX
            y += widget.scrollY
            val layout = widget.layout
            val line = layout.getLineForVertical(y)
            val off = layout.getOffsetForHorizontal(line, x.toFloat())
            val link = buffer.getSpans(off, off, ClickableSpan::class.java)
            if (link.isNotEmpty()) {
                if (action == MotionEvent.ACTION_UP) {
                    link[0].onClick(widget)
                } else {
                    Selection.setSelection(buffer, buffer.getSpanStart(link[0]),
                            buffer.getSpanEnd(link[0]))
<<<<<<< HEAD
=======
    override fun onTouchEvent(widget: TextView?, buffer: Spannable?, event: MotionEvent?): Boolean {
        val action = event!!.action

        if (action == MotionEvent.ACTION_UP ||
                action == MotionEvent.ACTION_DOWN) {
            var x = event.x.toInt()
            var y = event.y.toInt()
            x -= widget!!.totalPaddingLeft
            y -= widget.totalPaddingTop
            x += widget.scrollX
            y += widget.scrollY
            val layout: Layout = widget.layout
            val line: Int = layout.getLineForVertical(y)
            val off: Int = layout.getOffsetForHorizontal(line, x.toFloat())
            val link = buffer!!.getSpans(off, off, ClickableSpan::class.java)
            if (link.isNotEmpty()) {
                if (action == MotionEvent.ACTION_UP) {
                    if (System.currentTimeMillis() - lastClickTime < CLICK_DELAY) {
                        link[0].onClick(widget)
                    }
                } else if (action == MotionEvent.ACTION_DOWN) {
                    Selection.setSelection(buffer,
                            buffer.getSpanStart(link[0]),
                            buffer.getSpanEnd(link[0]))
                    lastClickTime = System.currentTimeMillis()
>>>>>>> bffc7b1... fix: 修复长按贴中文本无法弹出菜单
=======
>>>>>>> 79a5a1c8d2d5b8786f584f2660dc7b56db8952b7
                }
                return true
            } else {
                Selection.removeSelection(buffer)
            }
        }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 79a5a1c8d2d5b8786f584f2660dc7b56db8952b7

        return false
    }

    override fun initialize(widget: TextView?, text: Spannable?) {
        Selection.removeSelection(text)
<<<<<<< HEAD
=======
        return super.onTouchEvent(widget, buffer, event)
>>>>>>> bffc7b1... fix: 修复长按贴中文本无法弹出菜单
=======
>>>>>>> 79a5a1c8d2d5b8786f584f2660dc7b56db8952b7
    }
}