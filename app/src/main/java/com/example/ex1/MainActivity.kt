package com.example.ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


class MainActivity : AppCompatActivity() {
    var rutbai: Button? = null
    var labai1: ImageView? = null
    var labai2: ImageView? = null
    var labai3: ImageView? = null
    var thongbao: TextView? = null
    var sonut = 0 //de xet xem duoc may nut
    var darut = 0 //chi cho rut 3 la
    var batay = true //de xet truong hop 3 tay
    var chuoithongbao = ""
    var cacladarut = ArrayList<String>() //chua ten la da rut;

    //de de lam nen cho mang[][0] khong co y nghia (chi dung mang[][1]tro di
    var manghinhbai = arrayOf(
        intArrayOf(
            R.drawable.b2fv,
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck
        ), intArrayOf(
            R.drawable.b2fv,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.dj, R.drawable.dq, R.drawable.dk
        ), intArrayOf(
            R.drawable.b2fv,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk
        ), intArrayOf(
            R.drawable.b2fv,
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk
        )
    )
    var mangtenbai = arrayOf(
        arrayOf(
            "rong",
            "ach chuon", "hai chuon", "ba chuon", "bon chuon", "nam chuon",
            "sau chuon", "bay chuon", "tam chuon", "chin chuon", "muoi chuon",
            "boi chuon", "dam chuon", "gia chuon"
        ), arrayOf(
            "rong",
            "ach ro", "hai ro", "ba ro", "bon ro", "nam ro",
            "sau ro", "bay ro", "tam ro", "chin ro", "muoi ro",
            "boi ro", "dam ro", "gia ro"
        ), arrayOf(
            "rong",
            "ach co", "hai co", "ba co", "bon co", "nam co",
            "sau co", "bay co", "tam co", "chin co", "muoi co",
            "boi co", "dam co", "gia co"
        ), arrayOf(
            "rong",
            "ach bich", "hai bich", "ba bich", "bon bich", "nam bich",
            "sau bich", "bay bich", "tam bich", "chin bich", "muoi bich",
            "boi bich", "dam bich", "gia bich"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rutbai = findViewById<View>(R.id.rutbai) as Button
        labai1 = findViewById<View>(R.id.ivlabai1) as ImageView
        labai2 = findViewById<View>(R.id.ivlabai2) as ImageView
        labai3 = findViewById<View>(R.id.ivlabai3) as ImageView
        thongbao = findViewById<View>(R.id.txtthongbao) as TextView
        rutbai!!.setOnClickListener { // TODO Auto-generated method stub
            if (darut == 0) //lan dau hoac rut lai
            {
                darut = 0
                sonut = 0
                batay = true
                chuoithongbao = ""
                labai1!!.setImageResource(R.drawable.b2fv)
                labai2!!.setImageResource(R.drawable.b2fv)
                labai3!!.setImageResource(R.drawable.b2fv)
                cacladarut.clear()
            }
            darut++ //dem so lan rut
            //tao ngau nhien
            val rd = Random()
            var x: Int
            var y: Int
            //tao ngau nhien bao vao ArrayList de xet xem co bi trung khong
            while (true) {
                x = rd.nextInt(4) //0->3 (b-a+1)+a;
                y = rd.nextInt(13) + 1 //1->13
                if (cacladarut.contains(mangtenbai[x][y]) == false) {
                    cacladarut.add(mangtenbai[x][y])
                    break
                }
            }
            //chi can y<11 lap tuc khong con la batay nua
            if (y < 11) batay = false
            if (darut == 1) {
                sonut += if (y < 10) y else 0
                labai1!!.setImageResource(manghinhbai[x][y])
            } else if (darut == 2) {
                sonut += if (y < 10) y else 0
                labai2!!.setImageResource(manghinhbai[x][y])
            } else if (darut == 3) {
                sonut += if (y < 10) y else 0
                val kq = sonut % 10
                darut = 0
                labai3!!.setImageResource(manghinhbai[x][y])
                chuoithongbao += " so nut la $kq"
                //rutbai.setEnabled(false);
            }
            thongbao!!.text = ("Cac la da rut" + cacladarut.toString()
                    + chuoithongbao + "ba tay" + batay)
        }
    }
}