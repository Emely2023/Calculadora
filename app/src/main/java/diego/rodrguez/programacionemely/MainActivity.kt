

package diego.rodrguez.programacionemely

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar a todos los elementos
        val txtNum1 = findViewById<EditText>(R.id.txtNum1)
        val txtNum2 = findViewById<EditText>(R.id.txtNum2)
        val btnsumar = findViewById<Button>(R.id.btnsumar)
        val txtresultado = findViewById<TextView>(R.id.txtResultado)
        val btnrestar = findViewById<Button>(R.id.btnrestar)
        val btnmultiplicar = findViewById<Button>(R.id.btnmultiplicar)
        val btndividir = findViewById<Button>(R.id.btndividir)

        //Creo un objeto de la clase calculadora
        //para con ese objeto, al llamar al mètodo
        //de sumar
        val objCalculadora = Calculadora()

        //2- Programarlos
        btnsumar.setOnClickListener {
            val result = objCalculadora.sumar(txtNum1.text.toString().toInt(),txtNum2.text.toString().toInt())
            Toast.makeText(this,"este es el resultado,$result", Toast.LENGTH_LONG).show()

            txtresultado.text = result.toString()

        }
    }
}