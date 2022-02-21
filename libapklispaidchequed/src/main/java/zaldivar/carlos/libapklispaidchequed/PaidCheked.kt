package zaldivar.carlos.libapklispaidchequed

import android.content.Context
import android.net.Uri
import android.os.RemoteException
import android.util.Log

/**
 * Clase para comprobar el pago de una aplicación en apklis
 */
class PaidCheked {
    companion object {

        private const val APKLIS_PROVIDER = "content://cu.uci.android.apklis.payment.provider/app/"
        private const val APKLIS_PAID = "paid"
        private const val APKLIS_USER_NAME = "user_name"
        private const val TAG = "user_name"

        /**
         * @author cz9dev
         * @return "result00" Si el movil no cuenta con la aplicacion Apklis instalada.
         * "result02" Si no hay usuario autenticado en la aplicaion Apklis.
         * "result03" Si no se ha conprado la aplicación en Apklis.
         * "result04" Si se ha comprado la apk en Apklis.
         */
        fun isPurchased(context: Context, packageId: String): String {
            val providerURI: Uri = Uri.parse("$APKLIS_PROVIDER$packageId")
            try {
                val contentResolver =
                    context.contentResolver.acquireContentProviderClient(providerURI)
                        ?: return "result00" // Si el movil no cuenta con Apklis instalada
                val cursor =
                    contentResolver.query(providerURI, null, null, null, null)
                        ?: return "result01"  //
                cursor?.let {
                    if (it.moveToFirst()) {
                        Log.d(TAG, "Cheked: " + it.getString(it.getColumnIndex(APKLIS_USER_NAME)))
                        if (it.getString(it.getColumnIndex(APKLIS_USER_NAME)) == null) {
                            return "result02" // Si no estas autenticado en Apklis
                        }
                        return if (it.getInt(it.getColumnIndex(APKLIS_PAID)) > 0) {
                            "result04" // Si se ha comprado la apk en Apklis
                        } else {
                            "result03" // Si no se ha comprado la aplicación en Apklis
                        }
                    }
                }
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    contentResolver?.close()
                } else {
                    contentResolver?.release()
                }
                cursor?.close()
            } catch (e: RemoteException) {
                e.printStackTrace()
                return "result05" //
            }
            return "result05" //
        }
    }
}