package emely.lovo.myapplicationaos

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

        val txtNum1 = findViewById<EditText>(R.id.txtnum1)
        val txtedad = findViewById<TextView>(R.id.txtedad)
        val btnrestar = findViewById<Button>(R.id.btnrestar)

        val objNacimiento = Nacimiento()
        btnrestar.setOnClickListener {
            val result = objNacimiento.edad(txtNum1.text.toString().toInt())
            Toast.makeText(this, "Este es el resultado $result", Toast.LENGTH_SHORT).show()
            txtedad.text = result.toString()
        }



    }

}

