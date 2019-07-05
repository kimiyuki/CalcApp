package shirai.kimiyuki.techacademy.jp.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val ret = intent.getStringExtra("ret")
        textView.text = ret
        val layout = findViewById<ConstraintLayout>(R.id.myConstrainLayout)
        layout.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
