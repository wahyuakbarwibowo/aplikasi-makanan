package com.wahyuakbarwibowo.aplikasimakanan

class Makanan {
    var nama: String? = null
    var deskripsi: String? = null
    var gambar: Int? = null
    constructor(nama: String, deskripsi: String, gambar: Int){
        this.nama = nama
        this.deskripsi = deskripsi
        this.gambar = gambar
    }
}