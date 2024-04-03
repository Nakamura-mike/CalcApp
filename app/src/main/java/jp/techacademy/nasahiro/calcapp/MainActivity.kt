package jp.techacademy.nasahiro.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jp.techacademy.nasahiro.calcapp.databinding.ActivityMainBinding
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() , View.OnClickListener {
    //グローバル変数の宣言
    var answer = 0.0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ボタンが押された時
        binding.button3.setOnClickListener(this)// +
        binding.button4.setOnClickListener(this)// -
        binding.button5.setOnClickListener(this)// *
        binding.button6.setOnClickListener(this)// /
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        //EditTextに入力がない場合の判定
        if (("" == binding.editText1.text.toString()) || ("" == binding.editText2.text.toString())) {
            intent.putExtra("RET", "NG") //入力がない場合
        } else {  //入力がある場合
            //ボタンが押された時の処理内容
            var number1 = binding.editText1.text.toString().toDouble()
            var number2 = binding.editText2.text.toString().toDouble()

            //四則計算
            if (v?.id == R.id.button3) {
                answer = number1 + number2
            }
            if (v?.id == R.id.button4) {
                answer = number1 - number2
            }
            if (v?.id == R.id.button5) {
                answer = number1 * number2
            }
            if (v?.id == R.id.button6) {
                answer = number1 / number2
            }
            //計算結果
            intent.putExtra("VALUE1", answer)
            intent.putExtra("RET", "OK")
        }
        startActivity(intent)//遷移画面の表示
    }
}

