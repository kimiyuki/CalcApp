package shirai.kimiyuki.techacademy.jp.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val v1 = intent.getIntExtra("v1", 0)
        val v2 = intent.getIntExtra("v2", 0)
        textView.text = "${v1 + v2}"
    }
}
