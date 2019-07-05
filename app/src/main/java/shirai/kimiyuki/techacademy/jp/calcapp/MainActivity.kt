package shirai.kimiyuki.techacademy.jp.calcapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.util.ArrayMap
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var pref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences("my_value_file", Context.MODE_PRIVATE)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        multiply.setOnClickListener(this)
        divide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val regex = """^0\.?0*$""".toRegex()
        if(v != null && (firstOperand.text.toString() == "" || secondOperand.text.toString() == "")){
            Snackbar.make(v, "数字を入れて下さい", Snackbar.LENGTH_LONG).show()
            return
        }
        if(v != null && v.id == R.id.divide && regex.matches(secondOperand.text.toString()) ) {
            Snackbar.make(v, "０で割るのは定義できません", Snackbar.LENGTH_LONG).show()
            return
        }

        intent = Intent(this, ResultActivity::class.java)
        val ret = when (v?.id) {
            R.id.plus -> firstOperand.text.toString().toDouble() + secondOperand.text.toString().toDouble()
            R.id.minus -> firstOperand.text.toString().toDouble() - secondOperand.text.toString().toDouble()
            R.id.multiply -> firstOperand.text.toString().toDouble() * secondOperand.text.toString().toDouble()
            R.id.divide -> firstOperand.text.toString().toDouble() / secondOperand.text.toString().toDouble()
            else -> null
        }
        if(v != null &&ret == null){
            Snackbar.make(v, "不明な操作です", Snackbar.LENGTH_LONG).show()
            return
        }
        intent.putExtra("ret", ret.toString())
        pref.edit().putFloat("v1", firstOperand.text.toString().toFloat()).apply()
        pref.edit().putFloat("v2", secondOperand.text.toString().toFloat()).apply()
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        firstOperand.setText(pref.getFloat("v1", 0F).toString())
        secondOperand.setText(pref.getFloat("v2", 0F).toString())
    }


}
