# Comprobar si la app ha sido comprada en [Apklis](https://www.apklis.cu/es/)
[![](https://jitpack.io/v/cz9dev/apklispaidchequed.svg)](https://jitpack.io/#cz9dev/apklispaidchequed)

### Instalando
* Paso 1. Agregue el repositorio de JitPack a su archivo de compilación
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
* Paso 2. Agrega la dependencia
```groovy

   implementation 'com.github.cz9dev:apklispaidchequed:$VERSION'
```

### Uso

* Cheque pago con Kotlin
```kotlin
    var paidCheked = PaidCheked.isPurchased(this, PACKAGE_ID)
    when (paidCheked){
        "result00" -> Toast.makeText(this,"El movil no cuenta con la aplicacion Apklis instalada.",Toast.LENGTH_LONG).show()
        "result02" -> Toast.makeText(this,"No se encuentra autenticado en Apklis.",Toast.LENGTH_LONG).show()
        "result03" -> Toast.makeText(this,"Usted no ha comprado la aplicación en Apklis.",Toast.LENGTH_LONG).show()
        "result04" -> Toast.makeText(this,"Compra verificada en Apklis.",Toast.LENGTH_LONG).show()
    }
```

* Cheque pago con Java
```java
   // Aun  no se ha probado en java, si la pruebas comentame los resultados
```
### Contribuyendo
Cualquier contribución a esta librería es bienvenida!!!
Espero sus comentarios

### Desarrolladores
[cz9dev](https://github.com/cz9dev)
