package com.example.kingpin.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kingpin.R
import com.example.kingpin.repo.SkillViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FormActivity : AppCompatActivity() {
    private lateinit var vm: SkillViewModel
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var github: EditText

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar2)
        val submit = findViewById<Button>(R.id.submitbutton)
        firstName = findViewById<EditText>(R.id.firstnameET)
        lastName = findViewById<EditText>(R.id.lastnameET)
        email = findViewById<EditText>(R.id.emaillET)
        github = findViewById<EditText>(R.id.githubET)
        setSupportActionBar(toolbar)

        vm = ViewModelProvider(this).get(SkillViewModel::class.java)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        submit.setOnClickListener {
            if (firstName.text.isEmpty() || lastName.text.isEmpty() || email.text.isEmpty() || github.text.isEmpty()) {
                Toast.makeText(this, "Fill all spaces please", Toast.LENGTH_SHORT).show()
            } else {

                showDialog(this)

            }

        }

    }

    fun showDialog(activity: Activity?) {
        val dialog = Dialog(activity!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.main_dialog)

        val builder = AlertDialog.Builder(this)
        val cancel = dialog.findViewById(R.id.cancelX) as ImageView
        cancel.setOnClickListener {
            dialog.dismiss()
        }
        val dialogButton =
            dialog.findViewById(R.id.mainlogbut) as Button
        dialogButton.setOnClickListener {
            val firstString = firstName.text.toString()
            val last = lastName.text.toString()
            val mail = email.text.toString()
            val git = github.text.toString()
            val call = vm.sendForm(
                firstName = firstString,
                lastName = last,
                email = mail,
                github = git
            )
            call.enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {

                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        dialog.dismiss()
                        Log.d(
                            "successful: ",
                            response.code().toString() + " " + response.message()
                        )
                        val layout = layoutInflater.inflate(R.layout.dialog, null)
                        builder.setView(layout)
                        builder.show()
                    } else {
                        dialog.dismiss()
                        val layout = layoutInflater.inflate(R.layout.fail_dialog, null)
                        builder.setView(layout)
                        builder.show()
                        Log.d(
                            "Unsuccessful: ",
                            response.code().toString() + " " + response.message()
                        )

                    }
                }

            })
        }
        dialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}



