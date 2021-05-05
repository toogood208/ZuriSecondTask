package hfad.com.zurisecondtask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hfad.com.zurisecondtask.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    // initialize binding
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener { login() }
    }

    private fun login(){

        // grab the views
        val email = binding.emailField.text.toString()
        val password = binding.passwordField.text.toString()

        if (email == "tg@gmail.com" && password == "12345"){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "To login use Email:tg@gmail.com\n Password: 12345", Toast.LENGTH_LONG).show()
            binding.errorText.visibility = View.VISIBLE
        }
    }

}