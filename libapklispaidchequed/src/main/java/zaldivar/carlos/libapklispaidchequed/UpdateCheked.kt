package zaldivar.carlos.libapklispaidchequed

import android.os.Process
import androidx.lifecycle.MutableLiveData
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.SocketException
import java.net.URL
import java.net.UnknownHostException

/**
 * Clase para comprobar el pago de una aplicación en apklis
 * @author cz9dev by Carlos Zaldívar
 */
class UpdateCheked(val versionCode: Int, val packageId: String): Thread() {

    var result = MutableLiveData(HasUpdate(false,null))

    override fun run() {
        var api_apklis_json = ""
        var update_exist = false
        var apklis_version_code = 0
        var apklis_version_name = ""

        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)
        var url: URL? = null
        try {
            url = URL("https://api.apklis.cu/v1/application/?package_name=$packageId")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        try {
            val api_apklis = BufferedReader(
                InputStreamReader(
                    url!!.openStream()
                )
            )

            api_apklis.readLine().also {
                api_apklis_json = it
            }
             
        } catch (e: UnknownHostException) {
        } catch (se: SocketException) {
        } catch (e: IOException) {
            e.printStackTrace()
        }
        if (api_apklis_json != "") {
            var apklis_version_code_tem = ""
            val version_code = "\"version_code\":"
            val cd_Index = api_apklis_json.indexOf(version_code)
            if (cd_Index != -1) {
                var code = api_apklis_json[cd_Index + version_code.length].toString()
                var i = version_code.length
                while (code != ",") {
                    apklis_version_code_tem = apklis_version_code_tem + code
                    code = api_apklis_json[cd_Index + i + 1].toString()
                    i++
                }
            } else apklis_version_code_tem = ""
            if (apklis_version_code_tem != "") {
                apklis_version_code = apklis_version_code_tem.toInt()
                if (apklis_version_code > versionCode) {
                    update_exist = true
                    val vn_index = api_apklis_json.indexOf("\"version_name\":")
                    var vname = api_apklis_json[vn_index + 16].toString()
                    var i = 17
                    while (vname != "\"") {
                        apklis_version_name = apklis_version_name + vname
                        vname = api_apklis_json[vn_index + i].toString()
                        i++
                    }
                }
            }
        }

        result.postValue(HasUpdate(update_exist,apklis_version_name))
    }
}