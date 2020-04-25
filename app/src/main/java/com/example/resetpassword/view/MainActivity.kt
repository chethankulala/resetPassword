package com.example.resetpassword.view

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.resetpassword.model.ResetModel
import com.example.resetpassword.R
import com.example.resetpassword.databinding.ActivityMainBinding
import com.example.resetpassword.viewmodel.ResetViewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    private var viewModel: ResetViewModel? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ResetViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding!!.viewModel = viewModel

        var resetToolbar: Toolbar = findViewById(R.id.resetToolbar) as Toolbar
        setSupportActionBar(resetToolbar)
        supportActionBar?.title = " "
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUI()
    }

    private fun setUI() {
        viewModel!!.reset.observe(this, Observer { resetModel: ResetModel ->
            if (TextUtils.isEmpty(Objects.requireNonNull<ResetModel>(resetModel).newPassword)) {
                binding!!.etNewPassword.error = "Enter New Password"
                binding!!.etNewPassword.requestFocus()
            }
            else if (!resetModel.isPasswordValid) {
                binding!!.etNewPassword.error = "Enter Password with 6 or more character"
                binding!!.etNewPassword.requestFocus()
            }
            else if (TextUtils.isEmpty(Objects.requireNonNull<ResetModel>(resetModel).confirmPassword)) {
                binding!!.etConfirmPassword.error = "Enter Confirm Password"
                binding!!.etConfirmPassword.requestFocus()
            }
            else if (!resetModel.isPasswordMatch) {
                binding!!.etConfirmPassword.error = "Password Not Matching"
                binding!!.etConfirmPassword.requestFocus()
            }
            else {
                Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
