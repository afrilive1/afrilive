
package com.afrilive.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ScrollView

class MainActivity : Activity() {

    private val bg = Color.rgb(15, 17, 28)
    private val panel = Color.rgb(29, 32, 47)
    private val accent = Color.rgb(255, 166, 40)
    private val white = Color.WHITE
    private val muted = Color.LTGRAY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = bg
        window.navigationBarColor = bg

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
        }

        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 20, 20, 24)
        }

        val logo = text("AFRILIVE", 30f, accent, true)
        content.addView(logo)

        content.addView(text("Your voice. Your vision. Africa live.", 14f, muted))
        content.addView(space(24))

        content.addView(text("Discover Africa live", 24f, white, true))
        content.addView(text("Connect, share and be seen.", 15f, muted))
        content.addView(space(20))

        val liveCard = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 22, 20, 22)
            setBackgroundColor(panel)
        }

        liveCard.addView(text("🔴  GO LIVE", 16f, accent, true))
        liveCard.addView(space(10))
        liveCard.addView(text("Start your own audio or video broadcast.", 16f, white))
        liveCard.addView(space(16))

        val liveButton = text("＋  Start a live session", 17f, white, true)
        liveButton.gravity = Gravity.CENTER
        liveButton.setPadding(12, 16, 12, 16)
        liveButton.setBackgroundColor(Color.rgb(190, 48, 55))
        liveCard.addView(liveButton)

        content.addView(liveCard)
        content.addView(space(28))

        content.addView(text("Explore AFRILIVE", 21f, white, true))
        content.addView(space(14))

        addFeature(content, "🎙️", "Live Audio", "Talk with people in real time.")
        addFeature(content, "📹", "Live Video", "Broadcast and connect face to face.")
        addFeature(content, "📺", "TV Studio", "Share videos, images and recorded audio.")
        addFeature(content, "🎵", "Music", "Bring music into your live sessions.")
        addFeature(content, "👤", "Your Profile", "Build your presence on AFRILIVE.")

        content.addView(space(24))
        content.addView(text("Welcome to AFRILIVE Africa 🌍", 15f, accent))
        content.addView(space(16))

        scroll.addView(content)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f
            )
        )

        val nav = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setPadding(4, 12, 4, 12)
            setBackgroundColor(panel)
        }

        listOf("Home", "Live", "Studio", "Profile").forEach { item ->
            val tab = text(item, 13f, if (item == "Home") accent else muted, true)
            tab.gravity = Gravity.CENTER
            tab.setPadding(8, 8, 8, 8)
            nav.addView(
                tab,
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            )
        }

        root.addView(nav)
        setContentView(root)
    }

    private fun addFeature(
        parent: LinearLayout,
        emoji: String,
        title: String,
        description: String
    ) {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
            setBackgroundColor(panel)
        }

        card.addView(text("$emoji  $title", 18f, white, true))
        card.addView(space(6))
        card.addView(text(description, 14f, muted))

        parent.addView(card)
        parent.addView(space(10))
    }

    private fun text(
        value: String,
        size: Float,
        color: Int,
        bold: Boolean = false
    ): TextView {
        return TextView(this).apply {
            text = value
            textSize = size
            setTextColor(color)
            if (bold) setTypeface(null, android.graphics.Typeface.BOLD)
        }
    }

    private fun space(height: Int): View {
        return View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                1, height
            )
        }
    }
}
