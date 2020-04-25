package com.example.resetpassword.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resetpassword.model.ResetModel


class ResetViewModel: ViewModel() {
    var newPassword = MutableLiveData<String>()
    var confirmPassword = MutableLiveData<String>()

    private var resetMutableLiveData: MutableLiveData<ResetModel>? = null

    val reset: MutableLiveData<ResetModel>
        get() {
            if (resetMutableLiveData == null) {
                resetMutableLiveData = MutableLiveData()
            }
            return resetMutableLiveData as MutableLiveData<ResetModel>
        }

    fun resetOnClick() {
        try {
            //Log.d("newPassword",newPassword.value!!.toString())
            //Log.d("newPassword",confirmPassword.value!!.toString())
            val resetModel = ResetModel(newPassword.value!!.toString(),confirmPassword.value!!.toString())
            resetMutableLiveData!!.value = resetModel
        } catch (e: Exception) {
            Log.d("resetOnClick",e.toString())
        }
    }
}