package mx.edu.tecmm.moviles.spinner_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var lenguajes = arrayOf("Selecione Una Opcion","PHP", "JAVA", "JAVASCRIPT")
    lateinit var  spLneguajes :Spinner;
    lateinit var txtOpcionSelecionada : TextView
    lateinit var  txtDescripcion : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spLneguajes = findViewById(R.id.spLenguaje);
        txtOpcionSelecionada = findViewById(R.id.txtLenguaje);
        txtDescripcion = findViewById(R.id.txtDescripcion);

        spLneguajes.onItemSelectedListener = this;
        var adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lenguajes);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spLneguajes.adapter = adaptador;

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, posicion: Int, p3: Long) {
            var valor:String = lenguajes[posicion]
            txtOpcionSelecionada.text = valor

            if (valor == "PHP") {
                txtDescripcion.text = "Es un lenguaje para web"
            } else if (valor == "JAVA") {
                txtDescripcion.text = "Es el mejor lenguaje del mundo"
            } else if (valor == "JAVASCRIPT") {
                txtDescripcion.text = "Es el lunguaje para darle vida a la web"
            } else {
                txtDescripcion.text = ""
            }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}