package com.rinaldyhp.tokohpahlawanrepublicindonesia

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.rinaldyhp.tokohpahlawanrepublicindonesia.adapter.AdapterTokohPahlawan
import com.rinaldyhp.tokohpahlawanrepublicindonesia.databinding.ActivityMainBinding
import com.rinaldyhp.tokohpahlawanrepublicindonesia.model.Pahlawan

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listPahlawan = ArrayList<Pahlawan>()
        listPahlawan.add(Pahlawan
            ("Raden Hadji Oemar Said Tjokroaminoto",
            R.drawable.tjokroaminoto,
            "Ponorogo",
            "Rabu, 16 agustus 1882",
            "Menamatkan studi di OSVIA (1990)"))

        listPahlawan.add(Pahlawan
            ("Haji Agus Salim",
            R.drawable.agussalim,
            "Sumatera Barat",
            "Rabu, 8 Oktober 1884",
            "Europeesche Lagere School (ELS)\n" +
                    "Hoogere Burgerschool (HBS)\n"))

        listPahlawan.add(Pahlawan
            ("Ir. Soekarno",
            R.drawable.soekarno,
            "Surabaya, Jawa Timur",
            "Kamis, 6 Juni 1901",
            "Pendidikan sekolah dasar di Eerste Inlandse School, Mojokerto\n" +
                    "Pendidikan sekolah dasar di Europeesche Lagere School (ELS), Mojokerto (1911)\n" +
                    "Hoogere Burger School  (HBS) Mojokerto (1911-1915)\n" +
                    "Technische Hoge School, Bandung (sekarang berganti nama menjadi Institut Teknologi Bandung) (1920)\n"))

        listPahlawan.add(Pahlawan
            ("Mohammad Hatta",
            R.drawable.hatta,
            "Bukittinggi, Sumatera Barat",
            "Selasa, 12 Agustus 1902",
            "Nederland Handelshogeschool, Rotterdam, Belanda (1932)\n" +
                    "Sekolah Tinggi Dagang Prins Hendrik School, Batavia (1921)\n" +
                    "Meer Uirgebreid Lagere School (MULO), Padang (1919)\n" +
                    "Europeesche Lagere School (ELS), Padang, 1916\n" +
                    "Sekolah Dasar Melayu Fort de kock, Minangkabau (1913-1916)\n"))

        listPahlawan.add(Pahlawan
            ("Tan Malaka",
            R.drawable.tanmalaka,
            "Suliki,Sumatra Barat",
            "Rabu, 2 Juni 1897",
            "Kweekschool Bukit Tinggi (1913)\n" +
                    "Rijks Kweekschool, Haarlem Belanda\n"))

        listPahlawan.add(Pahlawan
            ("Ki Hajar Dewantara",
            R.drawable.kihajardewantara,
            "Yogyakarta",
            "Kamis, 2 Mei 1889",
            "ELS (Europeesche Lagere School) \n" +
                    "STOVIA (Sekolah Dokter Bumiputera)\n"))

        listPahlawan.add(Pahlawan
            ("Raden Adjeng Kartini",
            R.drawable.kartini,
            "Jepara Jawa Tengah",
            "Senin, 21 April 1879",
            "STOVIA"))

        listPahlawan.add(Pahlawan
            ("Sutan Sjahrir",
            R.drawable.sjahrir,
            "Kudus, Jawa Tengah",
            "Sabtu, 24 Februari 1945",
            "Sekolah dasar di Dalton Elementary School, Amsterdam.\n" +
                    "Sekolah menengah di Canisius College, Jakarta\n" +
                    "Strata 1 di Universitas Indonesia, Depok, Jawa Barat jurusan Ilmu Ekonomi (1974)\n" +
                    "Strata 2 di Kennedy School of Government, Universitas Harvard, USA (1983)\n"))

        listPahlawan.add(Pahlawan
            ("Jendral Soedirman",
            R.drawable.soedirman,
            "Purbalingga, Jawa Tengah",
            "Senin, 24 Januari 1916",
            "Sekolah Taman Siswa\n" +
                    "HIK (sekolah guru) Muhammadiyah, Solo tetapi tidak sampai tamat. \n" +
                    "Pendidikan Militer Pembela Tanah Air (PETA) di Bogor\n"))

        listPahlawan.add(Pahlawan
            ("Sutomo",
            R.drawable.bungtomo,
            "Surabaya",
            "Minggu, 3 Oktober 1920",
            "Meer Uitgebreid Lager Onderwijs (MULO)\n" +
                    "Hogere Burger School (HBS)\n"))


        binding.list.adapter = AdapterTokohPahlawan(this,listPahlawan, object : AdapterTokohPahlawan.OnClickListener {
            override fun detailData(item: Pahlawan?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pahlawan)

                    val image = this.findViewById<ImageView>(R.id.image_pahlawan)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPahlawan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val pendidikan = this.findViewById<TextView>(R.id.txtPendidikan)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"
                    pendidikan.text = "${item?.pendidikan}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }

        })


    }
}