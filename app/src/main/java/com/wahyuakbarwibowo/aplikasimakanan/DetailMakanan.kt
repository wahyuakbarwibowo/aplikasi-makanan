package com.wahyuakbarwibowo.aplikasimakanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_makanan.*

class DetailMakanan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_makanan)

        val bundle = intent.extras
        if (bundle != null) {
            ivGambarMakanan.setImageResource(bundle.getInt("gambar"))
            tvNamaMakanan.text = bundle.getString("nama")
            tvDeskripsi.text = bundle.getString("deskripsi")
        }


    }
}
