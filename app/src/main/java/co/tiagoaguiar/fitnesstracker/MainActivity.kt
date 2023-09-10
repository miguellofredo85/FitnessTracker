package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
//   private lateinit var btnImc:LinearLayout
    private lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id =   1,
                drawable = R.drawable.baseline_wb_sunny_24,
                textId = R.string.imc,
                color = R.color.green
            ))
        mainItems.add(
            MainItem(
                id =   2,
                drawable = R.drawable.baseline_water_24,
                textId = R.string.tmb,
                color = R.color.teal_200
            ))

        //1- o layout XML
        //2- a onde a rv vai aparecer (tela principal cheia)
        //3- locia de conetar o xml da celula dentro do rv + quantidade de elementos
        val adapter = MainAdapter(mainItems)
        rv = findViewById(R.id.rv_main)
        rv.adapter = adapter
        rv.layoutManager = GridLayoutManager(this, 2)


        //class para admin rv e suas celulas (layout item)
        // Adapter ->
//        btnImc = findViewById(R.id.btn_imc)
//        btnImc.setOnClickListener {
//            var intentImc = Intent(this, ImcActivity::class.java)
//            startActivity(intentImc)
//        }
    }
    // e a classe quye administra o layout
    private inner class MainAdapter(private val mainItems: List<MainItem> ) : RecyclerView.Adapter<MainViewHolder>(){
        // 1- qual layout utiliza a celula especificada (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        //cantidade de celulas
        override fun getItemCount(): Int {
            return mainItems.size
        }
        // 2-e disparado toda vez que houver uma rolagem na
        // tela e seja ncesariao troca a celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position] // current cell position
            holder.bind(itemCurrent)
        }


    }

    // a clase da celula em si!!
    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item:MainItem){
            val img:ImageView = itemView.findViewById(R.id.item_img)
            val name: TextView = itemView.findViewById(R.id.item_txt_name)
            val container:LinearLayout = itemView.findViewById(R.id.item_container_imc)

            img.setImageResource(item.id) // o Id de cada MainItem
            name.setText(item.textId)
            container.setBackgroundColor(item.color)
}
    }
}