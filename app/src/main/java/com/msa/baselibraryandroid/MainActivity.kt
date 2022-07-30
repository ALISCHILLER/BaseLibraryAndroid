package com.msa.baselibraryandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.msa.base_msa_library.weight_android.toast.BaseToastStyle
import com.msa.base_msa_library.weight_android.toast.Base_Toast
import com.msa.base_msa_library.weight_android.toast.Base_Toast.Companion.GRAVITY_BOTTOM
import com.msa.base_msa_library.weight_android.toast.Base_Toast.Companion.LONG_DURATION

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Base_Toast.createToast(
            this@MainActivity,
            "Hurray success 😍",
            "Upload Completed successfully!",
            BaseToastStyle.SUCCESS,
            Base_Toast.GRAVITY_BOTTOM,
            Base_Toast.LONG_DURATION,
            ResourcesCompat.getFont(this, com.msa.base_msa_library.R.font.helvetica_regular)
            )
    }
}