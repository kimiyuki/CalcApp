package shirai.kimiyuki.techacademy.jp.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val ret = intent.getDoubleExtra("result", 0.0)
        textView.text = "${ret.toString()}"
    }
}
