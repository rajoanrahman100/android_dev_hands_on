package com.example.myapplication.clappApp_project

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ClapActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var musicSeek: SeekBar
    private lateinit var playBtn: FloatingActionButton
    private lateinit var pauseBtn: FloatingActionButton
    private lateinit var stopBtn: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clap)
        musicSeek = findViewById(R.id.sbClapping)

        playBtn = findViewById(R.id.fabPlay)
        playBtn.setOnClickListener {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.mixkit)
            }
            mediaPlayer?.start()
        }
        pauseBtn = findViewById(R.id.fabPause)
        pauseBtn.setOnClickListener {
            mediaPlayer?.pause()
        }
        stopBtn = findViewById(R.id.fabStop)
        stopBtn.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
        }

        musicSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

        })


    }
}