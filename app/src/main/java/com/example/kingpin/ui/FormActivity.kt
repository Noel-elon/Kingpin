package com.example.kingpin.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kingpin.R
import com.example.kingpin.repo.SkillViewModel

class FormActivity : AppCompatActivity() {
    private lateinit var vm: SkillViewModel

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar2)
        val submit = findViewById<Button>(R.id.submitbutton)
        val firstName = findViewById<EditText>(R.id.firstnameET)
        val lastName = findViewById<EditText>(R.id.lastnameET)
        val email = findViewById<EditText>(R.id.emaillET)
        val github = findViewById<EditText>(R.id.githubET)
        setSupportActionBar(toolbar)

        vm = ViewModelProvider(this).get(SkillViewModel::class.java)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        submit.setOnClickListener {
//            if (firstName.text.isEmpty() || lastName.text.isEmpty() || email.text.isEmpty() || github.text.isEmpty()) {
//                Toast.makeText(this, "Fill all spaces please", Toast.LENGTH_SHORT).show()
//            } else {
                val builder = AlertDialog.Builder(this)
//                builder.setTitle("Androidly Alert")
//                builder.setMessage("We have a message")
                val layout = layoutInflater.inflate(R.layout.dialog, null)
                builder.setView(layout)


                builder.setPositiveButton(R.id.yesBut) { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT
                    ).show()
                }

                builder.setNegativeButton(R.id.cancelTv) { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        android.R.string.no, Toast.LENGTH_SHORT
                    ).show()
                }

                builder.show()

            //}

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }
}