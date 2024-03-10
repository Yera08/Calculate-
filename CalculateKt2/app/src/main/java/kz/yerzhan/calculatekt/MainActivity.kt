package kz.yerzhan.calculatekt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.btn_0
import kotlinx.android.synthetic.main.activity_main.btn_1
import kotlinx.android.synthetic.main.activity_main.btn_2
import kotlinx.android.synthetic.main.activity_main.btn_3
import kotlinx.android.synthetic.main.activity_main.btn_4
import kotlinx.android.synthetic.main.activity_main.btn_5
import kotlinx.android.synthetic.main.activity_main.btn_6
import kotlinx.android.synthetic.main.activity_main.btn_7
import kotlinx.android.synthetic.main.activity_main.btn_8
import kotlinx.android.synthetic.main.activity_main.btn_9
import kotlinx.android.synthetic.main.activity_main.btn_addition
import kotlinx.android.synthetic.main.activity_main.btn_bracket_left
import kotlinx.android.synthetic.main.activity_main.btn_bracket_right
import kotlinx.android.synthetic.main.activity_main.btn_clear
import kotlinx.android.synthetic.main.activity_main.btn_division
import kotlinx.android.synthetic.main.activity_main.btn_dot
import kotlinx.android.synthetic.main.activity_main.btn_equals
import kotlinx.android.synthetic.main.activity_main.btn_multiply
import kotlinx.android.synthetic.main.activity_main.btn_subtraction
import kotlinx.android.synthetic.main.activity_main.input
import kotlinx.android.synthetic.main.activity_main.output
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_clear.setOnClickListener{
            input.text = ""
            output.text = ""
        }
        btn_bracket_left.setOnClickListener{
            input.text = addToInputText("(")
        }
        btn_bracket_right.setOnClickListener{
            input.text = addToInputText(")")
        }
        btn_0.setOnClickListener{
            input.text = addToInputText("0")
        }
        btn_1.setOnClickListener{
            input.text = addToInputText("1")
        }
        btn_2.setOnClickListener{
            input.text = addToInputText("2")
        }
        btn_3.setOnClickListener{
            input.text = addToInputText("3")
        }
        btn_4.setOnClickListener{
            input.text = addToInputText("4")
        }
        btn_5.setOnClickListener{
            input.text = addToInputText("5")
        }
        btn_6.setOnClickListener{
            input.text = addToInputText("6")
        }
        btn_7.setOnClickListener{
            input.text = addToInputText("7")
        }
        btn_8.setOnClickListener{
            input.text = addToInputText("8")
        }
        btn_9.setOnClickListener{
            input.text = addToInputText("9")
        }
        btn_dot.setOnClickListener{
            input.text = addToInputText(".")
        }
        btn_division.setOnClickListener{
            input.text = addToInputText("÷") // alt + 0247
        }
        btn_multiply.setOnClickListener{
            input.text = addToInputText("×") // alt + 0215
        }
        btn_subtraction.setOnClickListener{
            input.text = addToInputText("-")
        }
        btn_addition.setOnClickListener{
            input.text = addToInputText("+")
        }


        btn_equals.setOnClickListener{
            showResult()
        }

    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
//                //Show Error Message
//                output.text = "Error"
//                output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }else{
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.white))
            }
        }catch (e: Exception){
//            //Show Error Message
//            output.text = "Error"
//            output.setTextColor(ContextCompat.getColor(this,R.color.red))
        }
    }
    private fun getInputExpression(): String{
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun addToInputText(buttonValue: String): String{
        return "${input.text}$buttonValue"
    }
}