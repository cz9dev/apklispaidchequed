package zaldivar.carlos.apklispaidchequed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import zaldivar.carlos.libapklispaidchequed.*

var PAKAGE_ID = "zaldivar.carlos.apklispaidchequed"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Comprobar estado de compra de la app en Apklis
        //PAKAGE_ID = BuildConfig.APPLICATION_ID
        val paidCheked = PaidCheked.isPurchased(this, PAKAGE_ID)
        when (paidCheked){
            "result00" -> Toast.makeText(this,"El movil no cuenta con la aplicacion Apklis instalada.",Toast.LENGTH_LONG).show()
            "result02" -> Toast.makeText(this,"No se encuentra autenticado en Apklis.",Toast.LENGTH_LONG).show()
            "result03" -> Toast.makeText(this,"Usted no ha comprado la aplicación en Apklis.",Toast.LENGTH_LONG).show()
            "result04" -> Toast.makeText(this,"Compra verificada en Apklis.",Toast.LENGTH_LONG).show()
        }

        //Comprobar si la app puede ser actualizada en Apklis
        var versionCode = BuildConfig.VERSION_CODE
        val updateCheked = UpdateCheked(versionCode, PAKAGE_ID)
        updateCheked.start()

        //Comprobar si Apklis tiene alguna actualizacion de la app
        updateCheked.result.observe(this){hasUpdate ->
            if (hasUpdate.update_exist)
            // TODO: Implementas tu código para si hay actualización en Apklist
                Toast.makeText(this, "Actualiza tu Apps a la version: ${hasUpdate.version_name}", Toast.LENGTH_SHORT).show()
        }


    }
}