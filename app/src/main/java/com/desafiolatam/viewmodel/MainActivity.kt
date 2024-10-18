package com.desafiolatam.viewmodel

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.desafiolatam.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val requestPermissionLauncher =  registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted ->
        if (isGranted) {
            permissionGranted()
        } else {
            permissionDenied()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)

        requestPermission()
    }

    private fun requestPermission() {
        when {
            ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                permissionGranted()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                Toast.makeText(this,"Necesito que me des los permisos de lo contrario no funcionaré",Toast.LENGTH_SHORT).show()
            }
            else -> {
                requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    private fun permissionGranted(){
        Toast.makeText(this, "Permiso concedido", Toast.LENGTH_LONG).show()
    }

    private fun permissionDenied(){
        Toast.makeText(this, "Permiso denegado", Toast.LENGTH_LONG).show()
    }

}