package com.gautam0x.qrscannerdemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


/*--------------------------------------------------
Warning : You Need To Give Camera Permission Manually
----------------------------------------------------*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call QR Scanner Activity On Button Click
        scanBtn.setOnClickListener{
            val qrActivityIntent = Intent(this,ScannerActivity::class.java)
            startActivityForResult(qrActivityIntent,2)
        }
    }

    // After Scanner Activity Destroy Handle The Result
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // Extract String From Data
        val resultString = data?.extras?.getString("QRCode")

        // set text Value
        rsltText.text = resultString
    }
}
