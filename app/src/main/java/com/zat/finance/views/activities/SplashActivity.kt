package com.zat.finance.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zat.finance.R
import com.zat.finance.base.BaseActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        MainScope().launch {
            delay(3000)
                startActivity(

                    Intent(
                        this@SplashActivity,AuthActivity::class.java
                    )
                )
                finish()

        }
    }

    override fun attachViewMode() {
        TODO("Not yet implemented")
    }


}