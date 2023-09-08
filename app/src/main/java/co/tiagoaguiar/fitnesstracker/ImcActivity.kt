    package co.tiagoaguiar.fitnesstracker

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.widget.Button
    import android.widget.EditText
    import android.widget.Toast

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
            }
        }
        private fun calcImc(weight: Int, height: Int):Double{
            return weight/((height/100.0)*(height/100.0))
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
