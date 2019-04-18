package com.example.gezegendeki_kilolarm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val _Kilo_to_Pound = 2.2045
    val Mars = 0.38
    val Venus=0.91
    val Jupiter= 2.34
    val Saturn=1.06
    val Neptune=1.19
    val Pluto=0.06
    val pound_to_kilo=0.45359237



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rb_jupiter.setOnClickListener(this)
        rb_mars.setOnClickListener(this)
        rb_neptune.setOnClickListener(this)
        rb_pluto.setOnClickListener(this)
        rb_saturn.setOnClickListener(this)
        rb_venus.setOnClickListener(this)



        /*btn_hesapla.setOnClickListener(object : View.OnClickListener{
            override  fun onClick(v: View?){
                Log.e("Emre", "Butona Basıldı")
            }
        })

        btn_hesapla.setOnClickListener{ view ->
            Log.e("Emre2","butona basıldı")
        btn_hesapla.setOnClickListener{
            var kulaniciAgirlikPount = kilotopound(Kullanicikilo.toString().toDouble())
            var marstakiAğırlikpount = kulaniciAgirlikPount * Mars
            var marstakilo = poundtoKilo(marstakiAğırlikpount)
            var VenusAğırlikpount = kulaniciAgirlikPount * Venus
           var Venuskilo = poundtoKilo(VenusAğırlikpount)
            var JupiterAğırlikpount = kulaniciAgirlikPount * Jupiter
            var Jupiterkilo = poundtoKilo(JupiterAğırlikpount)
            var SaturnAğırlikpount = kulaniciAgirlikPount * Saturn
            var Saturnkilo = poundtoKilo(SaturnAğırlikpount)
            var NeptuneAğırlikpount = kulaniciAgirlikPount * Neptune
            var Neptunekilo = poundtoKilo(NeptuneAğırlikpount)
            var PlutoAğırlikpount = kulaniciAgirlikPount * Pluto
            var Plutokilo = poundtoKilo(PlutoAğırlikpount)
            tv_sonuc.text=marstakilo.formatla(kactaneRakam=2).toString()
            tv_sonuc.text=Venuskilo.formatla(kactaneRakam=2).toString()
            tv_sonuc.text=Jupiterkilo.formatla(kactaneRakam=2).toString()
            tv_sonuc.text=Saturnkilo.formatla(kactaneRakam=2).toString()
            tv_sonuc.text=Neptunekilo.formatla(kactaneRakam=2).toString()
            tv_sonuc.text=Plutokilo.formatla(kactaneRakam=2).toString()
        }*/
    }

    fun kilotopound(Kilo : Double) : Double{
        return Kilo * _Kilo_to_Pound
    }
    fun poundtoKilo(pound : Double):Double{
        return pound * pound_to_kilo
    }

    override fun onClick(v: View?) {

        var isChecked: Boolean = (v as RadioButton).isChecked


        if (!TextUtils.isEmpty((txt_kilo.text.toString()))) {
            var Kullanicikilo = txt_kilo.text.toString().toDouble()
            var KullaniciPound = kilotopound(Kullanicikilo)

            when (v.id) {
                R.id.rb_mars -> if (isChecked ) {
                    rb_venus.isChecked=false
                    rb_saturn.isChecked=false
                    rb_pluto.isChecked=false
                    rb_neptune.isChecked=false
                    rb_jupiter.isChecked=false

                    hesaplaAgirlikpound(KullaniciPound, v)
                }
                R.id.rb_jupiter -> if (isChecked) {
                    rb_venus.isChecked=false
                    rb_saturn.isChecked=false
                    rb_pluto.isChecked=false
                    rb_neptune.isChecked=false
                    rb_mars.isChecked=false
                    hesaplaAgirlikpound(KullaniciPound, v)
                }
                R.id.rb_neptune -> if (isChecked) {
                    rb_venus.isChecked=false
                    rb_saturn.isChecked=false
                    rb_pluto.isChecked=false
                    rb_mars.isChecked=false
                    rb_jupiter.isChecked=false
                    hesaplaAgirlikpound(KullaniciPound, v)
                }
                R.id.rb_pluto -> if (isChecked) {
                    rb_venus.isChecked=false
                    rb_saturn.isChecked=false
                    rb_mars.isChecked=false
                    rb_neptune.isChecked=false
                    rb_jupiter.isChecked=false
                    hesaplaAgirlikpound(KullaniciPound, v)
                }
                R.id.rb_saturn -> if (isChecked) {
                    rb_venus.isChecked=false
                    rb_mars.isChecked=false
                    rb_pluto.isChecked=false
                    rb_neptune.isChecked=false
                    rb_jupiter.isChecked=false
                    hesaplaAgirlikpound(KullaniciPound, v)
                }
                R.id.rb_venus -> if (isChecked) {
                    rb_mars.isChecked=false
                    rb_saturn.isChecked=false
                    rb_pluto.isChecked=false
                    rb_neptune.isChecked=false
                    rb_jupiter.isChecked=false
                    hesaplaAgirlikpound(KullaniciPound, v)
                }
            }
        }
    }

    fun hesaplaAgirlikpound (pound:Double , radioButton: RadioButton){

        var sonucKilo:Double=0.0
        when(radioButton.id){
            R.id.rb_mars -> sonucKilo=pound*Mars
            R.id.rb_jupiter -> sonucKilo=pound*Jupiter
            R.id.rb_neptune -> sonucKilo=pound*Neptune
            R.id.rb_pluto -> sonucKilo=pound*Pluto
            R.id.rb_saturn -> sonucKilo=pound*Saturn
            R.id.rb_venus -> sonucKilo=pound*Venus
            else -> sonucKilo = 0.0
        }
        var sonucTokilo =poundtoKilo(sonucKilo)
        tv_sonuc.text=sonucTokilo.formatla(kactaneRakam=2)
    }


    fun Double.formatla(kactaneRakam:Int)=java.lang.String.format("%.${kactaneRakam}f",this)
}
