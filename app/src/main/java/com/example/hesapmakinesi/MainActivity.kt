package com.example.hesapmakinesi

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.hesapmakinesi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonClickNumberOperator()
        deleteNumber()
        percent()
        equals()
        deleteResult()
    }

    private fun buttonClickNumberOperator(){
        var result=binding.resultTextView
        binding.buttonSifir.setOnClickListener {
            result.append("0")
        }
        binding.buttonBir.setOnClickListener {
            result.append("1")
        }
        binding.buttonIki.setOnClickListener {
            result.append("2")
        }
        binding.buttonUc.setOnClickListener {
            result.append("3")
        }
        binding.buttonDort.setOnClickListener {
            result.append("4")
        }
        binding.buttonBes.setOnClickListener {
            result.append("5")
        }
        binding.buttonAlti.setOnClickListener {
            result.append("6")
        }
        binding.buttonYedi.setOnClickListener {
            result.append("7")
        }
        binding.buttonSekiz.setOnClickListener {
            result.append("8")
        }
        binding.buttonDokuz.setOnClickListener {
            result.append("9")
        }
        binding.buttonNokta.setOnClickListener {
            result.append(".")
        }
        binding.buttonToplama.setOnClickListener {
            result.append("+")
        }
        binding.buttonCikarma.setOnClickListener {
            result.append("-")
        }
        binding.buttonBolme.setOnClickListener {
            result.append("/")
        }
        binding.buttonCarpma.setOnClickListener {
            result.append("*")
        }

    }

    private fun deleteNumber(){
        binding.buttonBack.setOnClickListener {
            val deleteNumber=binding.resultTextView.text.toString().dropLast(1)
            binding.resultTextView.text = deleteNumber
        }
    }

    private fun percent(){
        binding.buttonYuzde.setOnClickListener {
            val percentResult:Double=binding.resultTextView.text.toString().toDouble()/100
            binding.resultTextView.text= percentResult.toString()
        }
    }

    private fun equals(){
        binding.buttonEsittir.setOnClickListener {
            try {
                val expression=ExpressionBuilder(binding.resultTextView.text.toString()).build()
                val result=expression.evaluate()
                val longResult=result.toLong()

                if (result==longResult.toDouble()){
                    binding.resultTextView.text=DecimalFormat("0.###").format(longResult).toString()
                }else {
                    binding.resultTextView.text=DecimalFormat("0.###").format(result).toString()
                }
            }catch (e:Exception){
                e.printStackTrace()
            }

        }

    }

    private fun deleteResult(){
        binding.buttonAC.setOnClickListener {
            binding.resultTextView.text=""
        }
    }



}



