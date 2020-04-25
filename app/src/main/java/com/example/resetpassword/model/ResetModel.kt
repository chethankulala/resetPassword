package com.example.resetpassword.model

class ResetModel(val newPassword: String, val confirmPassword: String) {

    val isPasswordValid: Boolean
        get() = newPassword.length >= 6

    val isPasswordMatch: Boolean
        get() {
            if (newPassword.equals(confirmPassword))
                return true
            return false
        }

}