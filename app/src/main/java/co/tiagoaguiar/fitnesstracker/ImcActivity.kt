package co.tiagoaguiar.fitnesstracker

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

class ImcActivity : AppCompatActivity() {
    private lateinit var editHeight: EditText
    private lateinit var editWeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        editHeight = findViewById(R.id.edit_height)
        editWeight = findViewById(R.id.edit_weight)

        val btnSend: Button = findViewById(R.id.btn_calcular)
        btnSend.setOnClickListener {
            if (!validateForm()) {
                Toast.makeText(this, "Input cant be zero or empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener // kill event fun
            }
            val weight = editWeight.text.toString().toInt()
            val height = editHeight.text.toString().toInt()
            val res = calcImc(weight, height)
            Log.d("Teste", "resultado: $res") // log debug

            val imcResponseId = imcResponse(res)
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.imc_response, res))
                .setMessage(imcResponseId)
                .setPositiveButton(android.R.string.ok) { dialog, which -> }
                .create()
                .show()
            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    private fun imcResponse(imc: Double): String {
        return when {
            imc < 15.0 -> return "uuuffff too low"
            imc < 16.0 -> return "too low"
            imc < 18.5 -> return "low"
            imc < 25.0 -> return "normal"
            imc < 30.0 -> return "high"
            imc < 35.0 -> return "too high"
            imc < 40.0 -> return "uuuuufff too high"
            else -> "close to death..."
        }

    }

    private fun calcImc(weight: Int, height: Int): Double {
        return weight / ((height / 100.0) * (height / 100.0))
    }

    private fun validateForm(): Boolean {
        //not null
        // not zero
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0"))
    }
}
