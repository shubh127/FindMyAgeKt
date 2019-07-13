package com.shubham.findmyagekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_age.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_get_age -> {
                try {
                    val yearOfBirth = et_enter_birth_info.text.toString().trim()
                    if (!yearOfBirth.equals("", true)) {
                        val myAge = ((Calendar.getInstance().get(Calendar.YEAR)) - yearOfBirth.toInt())
                        tv_age_display.text = String.format(resources.getString(R.string.age_is), myAge)
                    } else {
                        Toast.makeText(this, getString(R.string.invalid_input), Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
