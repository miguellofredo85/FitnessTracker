package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
//   private lateinit var btnImc:LinearLayout
    private lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv_main)
        //class para admin rv e suas celulas (layout item)
        // Adapter ->
//        btnImc = findViewById(R.id.btn_imc)
//        btnImc.setOnClickListener {
//            var intentImc = Intent(this, ImcActivity::class.java)
//            startActivity(intentImc)
//        }
    }
    // e a classe quye administra o layout
    private inner class MainAdapter : RecyclerView.Adapter<MainViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

    }

    // a clase da celula em si!!
    private class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)
}