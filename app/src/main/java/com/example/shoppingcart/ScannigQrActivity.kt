package com.example.shoppingcart

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler

class ScannigQrActivity : AppCompatActivity(),ResultHandler  {

    private val REQUEST_CAMERA =1
    private var scannerView :ZXingScannerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scannig_qr)
        scannerView= ZXingScannerView(this)
        setContentView(scannerView)

        if (!checkPermission())
            requestPermission()


    }
    private fun checkPermission() : Boolean{

        return ContextCompat.checkSelfPermission(
            this@ScannigQrActivity,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }
    private fun requestPermission(){

        ActivityCompat.requestPermissions(this , arrayOf(android.Manifest.permission.CAMERA),REQUEST_CAMERA)
    }


    override fun onResume() {
        super.onResume()
        if (checkPermission()){
            if (scannerView==null)
            {scannerView= ZXingScannerView(this)
                setContentView(scannerView)
            }
         scannerView?.setResultHandler(this)
         scannerView?.startCamera()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scannerView?.stopCamera()
    }
    override fun handleResult(Data: Result?) {

        val result = Data?.text
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Result")
        builder.setPositiveButton("ok") {dialog, which ->

            scannerView?.resumeCameraPreview(this@ScannigQrActivity)
            startActivity(intent)


        }
        builder.setMessage(result)
        val alert = builder.create()



        val intent = Intent(this,UserIsInActivity::class.java)
        intent.putExtra("User-ID",result)
        startActivity(intent)



    }
}
