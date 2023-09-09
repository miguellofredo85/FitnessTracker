package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
//   private lateinit var btnImc:LinearLayout
    private lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MainAdapter()
        rv = findViewById(R.id.rv_main)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)


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
        // qual layout utiliza a celula especificada (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }
//cantidade de celulas
        override fun getItemCount(): Int {
            return 15
        }
        // e disparado toda vez que houver uma rolagem na
        // tela e seja ncesariao troca a celula

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

    }

    // a clase da celula em si!!
    private class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }
}