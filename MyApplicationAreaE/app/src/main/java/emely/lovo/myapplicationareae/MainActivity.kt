package emely.lovo.myapplicationareae

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

        val txtbase = findViewById<EditText>(R.id.txtbase)
        val txtaltura = findViewById<EditText>(R.id.txtAltura)
        val btncalcular = findViewById<Button>(R.id.btnCalcular)
        val txtarea = findViewById<TextView>(R.id.txtArea)

        val objArea = Area()
        btncalcular.setOnClickListener {
            val result = objArea.calcular(txtbase.text.toString().toInt(),txtaltura.text.toString().toInt())
            Toast.makeText(this, "Su area es, $result", Toast.LENGTH_SHORT).show()

            txtarea.text = result.toString()
        }
    }
}