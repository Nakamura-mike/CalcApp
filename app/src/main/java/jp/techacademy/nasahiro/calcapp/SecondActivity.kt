package jp.techacademy.nasahiro.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.nasahiro.calcapp.databinding.ActivitySecondBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //
        val ret = intent.getStringExtra("RET")
        val roundoff = "未入力です。"

        if(ret == "OK"){
            val value1 = intent.getDoubleExtra("VALUE1", 0.0)
            binding.textView.text = "${value1}"
        }else {
            binding.textView.text = "${roundoff}"
        }
    }
}