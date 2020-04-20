package com.wahyuakbarwibowo.aplikasimakanan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_makanan.view.*

class MainActivity : AppCompatActivity() {

    val listMakanan = ArrayList<Makanan>()
    var adapter: AdapterMakanan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listMakanan.add(
            Makanan(
                "Basko", "Bakso adalah makanan berbentuk bulat dan terbuat dari" +
                        "olahan dagin", R.drawable.bakso
            )
        )
        listMakanan.add(
            Makanan("Jengkol", "Jengkol enak tapi bau", R.drawable.jengkol)
        )
        listMakanan.add(
            Makanan("Kuda", "Kuda goreng tidak enak dimakan", R.drawable.kuda)
        )
        listMakanan.add(
            Makanan(
                "Pizza", "Pizza merupakan makanan dari Italia",
                R.drawable.pizza
            )
        )
        listMakanan.add(
            Makanan("Risoles", "Risoles enak sih", R.drawable.risoles)
        )
        listMakanan.add(
            Makanan("Sushi", "Sushi merupakan makanan asal Jepang", R.drawable.sushi)
        )

        adapter = AdapterMakanan(this, listMakanan)
        gvListMakanan.adapter = adapter
    }

    inner class AdapterMakanan: BaseAdapter{
        var listMakanan = ArrayList<Makanan>()
        var context: Context? = null
        constructor(context: Context, listOfFood: ArrayList<Makanan>):super(){
            this.context = context
            this.listMakanan = listOfFood
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val makanan = this.listMakanan[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.item_makanan, null)
            foodView.ivGambarMakanan.setImageResource(makanan.gambar!!)
            foodView.ivGambarMakanan.setOnClickListener{

                val intent = Intent(context, DetailMakanan::class.java)
                intent.putExtra("nama", makanan.nama!!)
                intent.putExtra("deskripsi", makanan.deskripsi!!)
                intent.putExtra("gambar", makanan.gambar!!)
                context!!.startActivity(intent)
            }
            foodView.tvNamaMakanan.text = makanan.nama!!
            return foodView
        }
        override fun getItem(position: Int): Any {
            return listMakanan[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listMakanan.size
        }
    }
}
