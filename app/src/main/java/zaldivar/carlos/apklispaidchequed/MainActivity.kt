package zaldivar.carlos.apklispaidchequed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import zaldivar.carlos.libapklispaidchequed.PaidCheked

const val PAKAGE_ID = "zaldivar.carlos.apklispaidchequed"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var paidCheked = PaidCheked.isPurchased(this, PAKAGE_ID)
        when (paidCheked){
            "result00" -> Toast.makeText(this,"El movil no cuenta con la aplicacion Apklis instalada.",Toast.LENGTH_LONG).show()
            "result02" -> Toast.makeText(this,"No se encuentra autenticado en Apklis.",Toast.LENGTH_LONG).show()
            "result03" -> Toast.makeText(this,"Usted no ha comprado la aplicación en Apklis.",Toast.LENGTH_LONG).show()
            "result04" -> Toast.makeText(this,"Compra verificada en Apklis.",Toast.LENGTH_LONG).show()
        }
    }
}