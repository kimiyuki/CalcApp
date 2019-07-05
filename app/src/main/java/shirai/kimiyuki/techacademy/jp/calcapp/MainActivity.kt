package shirai.kimiyuki.techacademy.jp.calcapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.util.ArrayMap
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var pref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        pref = getSharedPreferences("my_value_file", Context.MODE_PRIVATE)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        multiply.setOnClickListener(this)
        divide.setOnClickListener(this)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onClick(v: View?) {
        intent = Intent(this, ResultActivity::class.java)
        val ret = when (v?.id) {
            R.id.plus -> firstOperand.text.toString().toDouble() + secondOperand.text.toString().toDouble()
            R.id.minus -> firstOperand.text.toString().toDouble() - secondOperand.text.toString().toDouble()
            R.id.multiply -> firstOperand.text.toString().toDouble() * secondOperand.text.toString().toDouble()
            R.id.divide -> firstOperand.text.toString().toDouble() / secondOperand.text.toString().toDouble()
            else -> Log.d("999", "another clickable view")
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
