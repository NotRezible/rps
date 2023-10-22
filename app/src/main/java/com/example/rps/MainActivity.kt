package com.example.rps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.view.View
import com.example.rps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var userChoice: String? = null
    private val options = arrayOf("Камень", "Ножницы", "Бумага", "Ящерица", "Спок");

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @SuppressLint("SetTextI18n")
    fun btnStart(view: View) {
        if(userChoice == null){
            binding.infoTextView.text = "Выберите событие"
            return
        }
        binding.infoTextView.text = "Выберите событие"
        var result = ""
        val computerChoice = getComouterChoice()
        if(computerChoice == userChoice) result = "Ничья"
        else if(((userChoice == "Камень" || userChoice == "Спок") && computerChoice == "Ножницы")
            || ((userChoice == "Бумага" || userChoice == "Спок") && computerChoice == "Камень")
            || ((userChoice == "Ножницы" || userChoice == "Ящерица") && computerChoice == "Бумага")
            || ((userChoice == "Камень" || userChoice == "Ножницы") && computerChoice == "Ящерица")
            || ((userChoice == "Бумага" || userChoice == "Ящерица") && computerChoice == "Спок")) {
            result =  "Вы победили"
        } else result =  "Вы проиграли"
        binding.infoTextView.text = result
        userChoice = null
    }

    fun rockBtn(view: View) {
        userChoice = options[0]
    }

    fun paperBtn(view: View) {
        userChoice = options[2]
    }

    fun scissorsBtn(view: View) {
        userChoice = options[1]
    }

    fun lihzardBtn(view: View) {
        userChoice = options[3]
    }

    fun spokBtn(view: View) {
        userChoice = options[4]
    }



    private fun getComouterChoice(): String {
        return options.random();
    }
}