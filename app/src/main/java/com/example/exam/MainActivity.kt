package com.example.exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exam.ui.theme.ExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamTheme {
                Pregunta01()


            }
        }
    }
}



@Composable
fun Pregunta01() {
    var nro by remember { mutableIntStateOf(0) }

    Button(
        onClick = {
            for (i in 0 until 10) {
                nro += (i + 1000)
            }
        }
    ) {
        Text("$nro")
    }
}


@Composable
fun pregunta02() {
    var lista = arrayListOf<String>("uno", "dos", "tres", "cuatro")
    var msg: String by remember { mutableStateOf("click me") }

    Button(
        onClick = {
            msg = lista[lista.size - 3].substring(1)
        }
    ) { Text(msg) }
}

open class A (var a: Int){
    open fun pget():Int { return 3 * a}
}

class B(a:Int , var b: Int):A(a){
    override fun pget():Int{return super.pget()+ b}
}

@Composable
fun pregunta03(){
    var w: A =B(3, 4)
    Text("${w.pget()}")
}


@Composable
fun Pregunta06(){
    var valor by remember { mutableIntStateOf(25)}
    Column {
        Spacer(Modifier.height(30.dp))
        Boton6 (valor , {rpta: Int  -> valor = rpta})
        Etiqueta6(valor)
    }
}

@Composable
fun Boton6(dato: Int , evento:(Int)-> Unit){
    Button(onClick = { evento((dato + 123456)%5 )}
    ) {Text("click me")

    }
}
@Composable
fun Etiqueta6(k:Int)=Text("$k")

