package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

import kotlin.math.pow
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity(), OnClickListener {
    //Variables aqui
    private lateinit var binding: ActivityMainBinding
    private var textContador: String = ""
    private var textResultado: String = ""
    private var operandoUno: Double? = null
    private  var operandoDos: Double? = null
    private var operador: String? = null


    //Inicio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        binding.textoContador.text = textContador
        binding.textoContador1.text = textResultado

        //botones númericos
        binding.btnUno.setOnClickListener(this)
        binding.btnDos.setOnClickListener(this)
        binding.btnTres.setOnClickListener(this)
        binding.btnCuatro.setOnClickListener(this)
        binding.btnCinco.setOnClickListener(this)
        binding.btnSeis.setOnClickListener(this)
        binding.btnSiete.setOnClickListener(this)
        binding.btnOcho.setOnClickListener(this)
        binding.btnNueve.setOnClickListener(this)
        binding.btnCero.setOnClickListener(this)
        //botones operadores
        binding.btnDivision.setOnClickListener(this)
        binding.btnMultiplicacion.setOnClickListener(this)
        binding.btnResta.setOnClickListener(this)
        binding.btnSuma.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
        binding.btnRestart.setOnClickListener(this)
        binding.btnPotencia?.setOnClickListener(this)
        binding.btnLog?.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnUno.id -> textContador += "1"
            binding.btnDos.id -> textContador += "2"
            binding.btnTres.id -> textContador += "3"
            binding.btnCuatro.id -> textContador += "4"
            binding.btnCinco.id -> textContador += "5"
            binding.btnSeis.id -> textContador += "6"
            binding.btnSiete.id -> textContador += "7"
            binding.btnOcho.id -> textContador += "8"
            binding.btnNueve.id -> textContador += "9"
            binding.btnCero.id -> textContador += "0"

            //operadores
            binding.btnDivision.id -> {
                operandoUno = textContador.toDoubleOrNull()
                operador = "/"
                textContador= ""
                binding.textoContador.text = textContador
            }

            binding.btnMultiplicacion.id -> {
                operandoUno = textContador.toDouble()
                operador = "*"
                textContador = ""
                binding.textoContador.text = textContador
            }

            binding.btnResta.id -> {
                operandoUno = textContador.toDouble()
                operador = "-"
                textContador = ""
                binding.textoContador.text = textContador
            }

            binding.btnSuma.id -> {
                operandoUno = textContador.toDouble()
                operador = "+"
                textContador = ""
                binding.textoContador.text = textContador
            }
            binding.btnLog?.id -> {
                operandoUno = textContador.toDouble()
                operador = "log"
                textContador = ""
                binding.textoContador.text = textContador
            }
            binding.btnPotencia?.id -> {
                operandoUno = textContador.toDouble()
                operador = "^"
                textContador = ""
                binding.textoContador.text = textContador
            }

            binding.btnIgual.id -> {
               if(operandoUno != null && textContador.isNotEmpty()){
                   operandoDos = textContador.toDoubleOrNull() ?: 0.0

                   val resultado = when(operador){
                       "+" -> (operandoUno!!+operandoDos!!).roundToInt()
                       "-" -> (operandoUno!!-operandoDos!!).roundToInt()
                       "*" -> (operandoUno!!*operandoDos!!).roundToInt()
                       "/" -> if(operandoDos != 0.0)(operandoUno!!/operandoDos!!).roundToInt() else "No se puede dividir entre cero"
                       "^" -> if(operandoDos != 0.0)(operandoUno!!.pow(operandoDos!!)).roundToInt() else "Operador invalido"
                       "log" -> if(operandoUno!! > 0 && operandoDos!! > 0) {
                           kotlin.math.ln(operandoUno!!) / kotlin.math.ln(operandoDos!!)
                       }else{
                           "Número invalido"
                       }
                       else -> "Error"
                   }
                   textResultado = resultado.toString()
                   textContador = ""
                   binding.textoContador.text = ""
                   binding.textoContador1.text = textResultado
               }

            }

            binding.btnRestart.id -> {
                reiniciar()
            }

        }
        binding.textoContador1.text = textResultado
        binding.textoContador.text = textContador

    }

    private fun reiniciar() {
        textContador = ""
        textResultado = ""
        operador = null
        operandoUno = null
        operandoDos = null
        //actualizar

        binding.textoContador.text = textContador
        binding.textoContador1.text = textResultado
    }
}
