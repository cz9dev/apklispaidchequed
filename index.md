<<<<<<< HEAD
# Check app is paid in [Apklis](https://www.apklis.cu/es/)
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
   // It has not been tested in java yet, if you test it tell me the results
```
### Contributing
All contributions are welcome!!!

### Developers
[cz9dev](https://github.com/cz9dev)
=======
## apklispaidchequed

Liberia para comprobar si la app a sido comprada en apklis

>>>>>>> a29bbd3 (Subiendo archivo index)
