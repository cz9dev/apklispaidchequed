# Comprobar si la app ha sido comprada en [Apklis](https://www.apklis.cu/es/)
[![](https://jitpack.io/v/cz9dev/apklispaidchequed.svg)](https://jitpack.io/#cz9dev/apklispaidchequed)

### Installing
* Step 1. Add the JitPack repository to your build file
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
* Step 2. Add the dependency
```groovy

   implementation 'com.github.cz9dev:apklispaidchequed:$VERSION'
```

### Usage

* It is necessary to have the Apklis application installed and a section started to check, otherwise the user would be null and the payment would be false.

* Check paid Kotlin
```kotlin
    var paidCheked = PaidCheked.isPurchased(this, PACKAGE_ID)
    when (paidCheked){
        "result00" -> Toast.makeText(this,"El movil no cuenta con la aplicacion Apklis instalada.",Toast.LENGTH_LONG).show()
        "result02" -> Toast.makeText(this,"No se encuentra autenticado en Apklis.",Toast.LENGTH_LONG).show()
        "result03" -> Toast.makeText(this,"Usted no ha comprado la aplicación en Apklis.",Toast.LENGTH_LONG).show()
        "result04" -> Toast.makeText(this,"Compra verificada en Apklis.",Toast.LENGTH_LONG).show()
    }
```

* Check paid Java
```java
   // Aun  no se ha probado en java, si la pruebas comentame los resultados
```
### Contributing
Cualquier contribución a esta librería es bienvenida!!!
Espero sus comentarios

### Developers
[cz9dev](https://github.com/cz9dev)
