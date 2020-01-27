package com.example.mobiotics

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Encryption : AppCompatActivity(){

    var mEncryptionEDT : EditText?= null
    var mOutputTxt : TextView ?=null
    var mSubmitBtn : Button ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encryption)

        init()
    }

    fun init(){

        mEncryptionEDT = findViewById(R.id.encryption_edt)
        mSubmitBtn = findViewById(R.id.encryption_btn)
        mOutputTxt = findViewById(R.id.encryption_output_txt)

        mSubmitBtn?.setOnClickListener { encryption(mEncryptionEDT?.text.toString()) }

    }


    fun encryption(aInput:String){

        if(aInput.equals("")){
            mSubmitBtn?.visibility == View.GONE
        }else{
            mSubmitBtn?.visibility == View.VISIBLE
        }

            val charArray = arrayOf(aInput)

            var output = ""
            var currentStr = charArray[0]
            var index = 0
            var idx = 1
            for (i in charArray) {
                if ((index + 1) < charArray.size) {
                    if (i == charArray[index + 1]) {
                        idx += 1
                    }else{
                        output = "$output + $currentStr) + $idx"
                        idx = 1
                    }
                    currentStr = charArray[index + 1]
                    index += 1
                }else if ((index + 1) == charArray.size) {
                output = "$output + $currentStr) + $idx"
            }
                mOutputTxt?.text = output
            }

    }

}