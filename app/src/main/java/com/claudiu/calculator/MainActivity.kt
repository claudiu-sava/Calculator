package com.claudiu.calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.nav_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.nav_menuAdd -> println("HEY")
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstNumber: String = ""
        var secondNumber: String = ""

        val numbersList: MutableList<String> = mutableListOf()

        val equalButton: Button = findViewById(R.id.buttonEqual)

        val plusButton: Button = findViewById(R.id.buttonPlus)
        val minusButton: Button = findViewById(R.id.buttonMinus)
        val multiplyButton: Button = findViewById(R.id.buttonMultiply)
        val divButton: Button = findViewById(R.id.buttonDiv)

        val arithmeticButtonList: List<Button> = listOf(plusButton, minusButton, multiplyButton, divButton)

        val buttonC: Button = findViewById(R.id.buttonC)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)

        val resultTextView: TextView = findViewById(R.id.resultTextView)

        var isPlus: Boolean = false
        var isMinus: Boolean = false
        var isMultiply: Boolean = false
        var isDiv: Boolean = false

        var clean = false

        buttonC.setOnClickListener {
            cButton(numbersList, resultTextView, arithmeticButtonList)
            firstNumber = ""
            secondNumber = ""
        }


        equalButton.setOnClickListener {
            secondNumber = getFirstNumber(numbersList)

            try {
                println("$firstNumber $secondNumber")

                if (isPlus) {
                    println("+")
                    plus(firstNumber.toInt(), secondNumber.toInt(), resultTextView)
                } else if (isMinus) {
                    println("-")
                    minus(firstNumber.toInt(), secondNumber.toInt(), resultTextView)
                } else if (isMultiply) {
                    println("*")
                    multiply(firstNumber.toInt(), secondNumber.toInt(), resultTextView)
                } else if (isDiv) {
                    println("/")
                    division(firstNumber.toInt(), secondNumber.toInt(), resultTextView)
                }

                for (i: Button in arithmeticButtonList) {
                    i.isClickable = true
                    i.setBackgroundColor(Color.parseColor("#595858"))
                }

                numbersList.clear()

                firstNumber = ""
                secondNumber = ""
            } catch(e: Exception) {
                cButton(numbersList, resultTextView, arithmeticButtonList)
                firstNumber = ""
                secondNumber = ""
            }
        }


        plusButton.setOnClickListener {
            isPlus = true
            isMinus = false
            isDiv = false
            isMultiply = false

            firstNumber = getFirstNumber(numbersList)
            if (firstNumber == "") {
                cButton(numbersList, resultTextView, arithmeticButtonList)
            } else {
                for (i in arithmeticButtonList) {
                    i.isClickable = false
                    i.setBackgroundColor(Color.parseColor("#595858"))
                }
                plusButton.setBackgroundColor(Color.parseColor("#424242"))

                println("firstNumber: $firstNumber")
                numbersList.add(" + ")
                updateCalculView(numbersList)
                clean = true
            }
        }


        minusButton.setOnClickListener {
            isMinus = true
            isPlus = false
            isDiv = false
            isMultiply = false

            firstNumber = getFirstNumber(numbersList)
            if (firstNumber == "") {
                cButton(numbersList, resultTextView, arithmeticButtonList)
            } else {
                for (i in arithmeticButtonList) {
                    i.isClickable = false
                    i.setBackgroundColor(Color.parseColor("#595858"))
                }
                minusButton.setBackgroundColor(Color.parseColor("#424242"))

                println(firstNumber)
                numbersList.add(" - ")
                updateCalculView(numbersList)
                clean = true
            }
        }


        multiplyButton.setOnClickListener {
            isPlus = false
            isDiv = false
            isMinus = false
            isMultiply = true

            firstNumber = getFirstNumber(numbersList)
            if (firstNumber == "") {
                cButton(numbersList, resultTextView, arithmeticButtonList)
            } else {
                for (i in arithmeticButtonList) {
                    i.isClickable = false
                    i.setBackgroundColor(Color.parseColor("#595858"))
                }
                multiplyButton.setBackgroundColor(Color.parseColor("#424242"))

                println(firstNumber)
                numbersList.add(" X ")
                updateCalculView(numbersList)
                clean = true
            }
        }


        divButton.setOnClickListener {
            isPlus = false
            isDiv = true
            isMinus = false
            isMultiply = false

            firstNumber = getFirstNumber(numbersList)
            if (firstNumber == "") {
                cButton(numbersList, resultTextView, arithmeticButtonList)
            } else {
                for (i in arithmeticButtonList) {
                    i.isClickable = false
                    i.setBackgroundColor(Color.parseColor("#595858"))
                }
                divButton.setBackgroundColor(Color.parseColor("#424242"))

                println(firstNumber)
                numbersList.add(" / ")
                updateCalculView(numbersList)
                clean = true
            }
        }


        button1.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("1")
            updateCalculView(numbersList)
        }

        button2.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("2")
            updateCalculView(numbersList)
        }

        button3.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("3")
            updateCalculView(numbersList)
        }

        button4.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("4")
            updateCalculView(numbersList)
        }

        button5.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("5")
            updateCalculView(numbersList)
        }

        button6.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("6")
            updateCalculView(numbersList)
        }

        button7.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("7")
            updateCalculView(numbersList)
        }

        button8.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("8")
            updateCalculView(numbersList)
        }

        button9.setOnClickListener {
            if (clean) {
                numbersList.clear()
                println("List cleaned")
                clean = false
            }
            numbersList.add("9")
            updateCalculView(numbersList)
        }

    }


    fun cButton(numbers: MutableList<String>, resultTextView: TextView, buttons: List<Button>){
        numbers.clear()
        updateCalculView(numbers)
        resultTextView.text = ""
        for (i in buttons) {
            i.setBackgroundColor(Color.parseColor("#595858"))
            i.isClickable = true
        }
    }

    fun getFirstNumber(numbersList: MutableList<String>): String {
        var number: String = ""

        for (i in numbersList) {
            number += i
        }
        return number
    }

    fun updateCalculView(numbers: MutableList<String>) {
        val calculTextView: TextView = findViewById(R.id.calculTextView)

        var textToPrint: String = ""

        for (i in numbers) {
            textToPrint += i
        }

        calculTextView.text = textToPrint
    }


    fun plus(firstNumber: Int, secondNumber: Int, resultTextView: TextView) {
        resultTextView.text = (firstNumber.toFloat() + secondNumber.toFloat()).toString()
    }

    fun minus(firstNumber: Int, secondNumber: Int, resultTextView: TextView) {
        resultTextView.text = (firstNumber.toFloat() - secondNumber.toFloat()).toString()
    }

    fun division(firstNumber: Int, secondNumber: Int, resultTextView: TextView) {
        resultTextView.text = (firstNumber.toFloat() / secondNumber.toFloat()).toString()
    }

    fun multiply(firstNumber: Int, secondNumber: Int, resultTextView: TextView) {
        resultTextView.text = (firstNumber.toFloat() * secondNumber.toFloat()).toString()
    }
}