package com.mz.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.mz.cronometro.databinding.ActivityMainBinding
import android.view.LayoutInflater as ViewLayoutInflater

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var correndo = false
    var pause:Long =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iniciar.setOnClickListener {
            IniciarCronometro()
        }

        binding.pausar.setOnClickListener {
            PausarCronometro()
        }

        binding.zerar.setOnClickListener {
            ZerarCronometro()
        }
    }

    private fun IniciarCronometro(){
        if(!correndo){
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            correndo = true
        }
    }

    private fun PausarCronometro(){
        if (correndo){
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            correndo = false
        }
    }

    private fun ZerarCronometro(){
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0

    }
}
