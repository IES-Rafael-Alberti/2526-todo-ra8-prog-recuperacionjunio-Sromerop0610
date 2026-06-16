# Preguntas de evaluación por RA

Estas preguntas sirven para que expliques y defiendas la solución que has desarrollado, relacionando el código con los resultados de aprendizaje.

**IMPORTANTE**: Utiliza enlaces permanentes al código fuente. También puedes copiarlo y pegarlo en tu respuesta entre

```Kotlin
aquí el código
```

para que se vea mejor. No copies y pegues capturas de pantalla.

## UD1, RA1: Estructura de un programa informático

1. Identifica los bloques principales de tu solución (`Main`, parser de argumentos, aplicación, lector, procesador, escritor y modelos). Explica qué responsabilidad tiene cada bloque y por qué no debe estar todo el código dentro de `main`.

Respuesta a pregunta 1:

2. Localiza en tu solución ejemplos de variables, constantes o literales, operadores y conversiones de tipos. Explica para qué se usan en el procesamiento de nombres, fechas, contadores y rutas de fichero.

Respuesta a pregunta 2:

## UD2, RA3: Estructuras de control, depuración y excepciones

3. Explica qué estructuras de selección y repetición aparecen en tu solución para validar argumentos, recorrer listas de fotos, detectar formatos incorrectos y generar los comandos `mv`.

Respuesta a pregunta 3:

4. Describe qué excepciones o errores controla tu programa cuando el fichero de entrada no existe, tiene menos de tres líneas o contiene nombres de foto con formato incorrecto. Indica en qué clase gestionas cada caso.

Respuesta a pregunta 4:

## UD3, RA6: Tipos avanzados de datos y colecciones

5. Explica qué colecciones utilizas para almacenar las fotos de smartphone, las fotos réflex y la lista final de comandos. Justifica por qué usas la que usas y no otra.

Respuesta a pregunta 5:

6. Tu solución puede usar expresiones regulares para validar nombres como `IMG_20210613_104512.jpg` o `P130621_083827.jpg`. Escribe qué comprueba cada patrón y explica cómo se relaciona con la creación de objetos `SmartphonePhotoFile` y `ReflexPhotoFile`.

Respuesta a pregunta 6:

## UD4, RA2: Fundamentos de programación orientada a objetos

7. Explica qué objetos instancias durante la ejecución del programa y por qué usas un objeto y no un tipo primitivo/básico. Por ejemplo: `TripInput`, `PhotoFile`, `RenameCommand`, etc.

Respuesta a pregunta 7:

8. Elige una clase de tu solución y explica sus propiedades, sus métodos, su constructor y un ejemplo de llamada a uno de sus métodos desde otra clase.

Respuesta a pregunta 8:

## UD5, RA4: Programas organizados en clases

9. Justifica por qué tu solución está dividida en varias clases en lugar de resolverse con funciones sueltas. Relaciona tu respuesta con cohesión, separación de responsabilidades y mantenimiento.

Respuesta a pregunta 9:

10. Explica qué modificadores de visibilidad usas en las clases de tu solución. Indica qué miembros deben ser públicos y cuáles deben ser privados, por ejemplo en `PhotoProcessor`, `InputFileReader` o `ScriptWriter`.

Respuesta a pregunta 10:

## UD6, RA7: Herencia, polimorfismo e interfaces

11. Explica la jerarquía formada por `PhotoFile`, `SmartphonePhotoFile` y `ReflexPhotoFile`. Indica cuál es la superclase, cuáles son las subclases y qué comportamiento sobrescribe o especializa cada una.

Respuesta a pregunta 11:

12. Justifica por qué el procesador trabaja con una lista de `PhotoFile` y no con dos listas separadas todo el tiempo. Relaciona tu respuesta con polimorfismo y con la ordenación por la clave `YYYYMMDDHHMMSS`.

Respuesta a pregunta 12:

## UD7, RA5: Entrada y salida de información

13. Describe el flujo completo de entrada y salida: cómo recibes la ruta por consola, cómo lees el fichero `.in`, qué comprobaciones haces, cómo interpretas sus tres líneas, qué mensajes de resumen o error muestras por consola, cómo generas el fichero `<lugar>.sh` y qué tipos de ficheros usas.

Respuesta a pregunta 13:

El flujo del programa es el siguiente: el usuario introduce por consola una ruta path, en la que se encuentra el archivo a trabajar. Se comprueba que esta ruta path sea correcta desde ```ArgumentParser.kt```. Una vez se obtiene la ruta, con ```InputFileReader.kt``` se lee el archivo otorgado por la ruta y se realizan comprobaciones para ver que los datos dados por el archivo sean correctos (en mi programa esto último no está implementado. Lee el archivo pero no maneja errores), una vez esto, se crea ```TripInput.kt```, guardando el lugar y los nombres de las fotos de Smart y las de reflex por separado, como dos listas de stings distintas.

Posteriormente, pasamos los datos por el ```PhotoProcessor.kt```, donde se tratan los datos para:

1- Obtener las orderKey (año, mes, día, hora, minutos y segundos formateados para que tengan tanto reflex como smart el mismo formato).
2- Comprobar cuantos elementos fallan en cada uno de los tipos de imagen (no me ha dado tiempo a implementar esto)

Una vez se han pasado los datos por ````PhotoProcessor.kt````, pasamos ya al ```ScriptWriter.kt```, donde escribimos el fichero de salida .sh

Por último, se escribe por consola los datos finales sacados al procesar el archivo, donde se dicen el número de errores, procesados y archivos no errados.

Todo el programa ha hecho uso de modelos (data class) para facilitar el trato de la información y poder instanciar objetos de forma correcta. Alguno de estos modelos se enlazan para obtener un tratado de la información más optimo.


14. Indica qué alternativas ofrece Kotlin para leer y escribir ficheros. Compara opciones como `File`, `Path`, `readLines`, `bufferedReader`, `writeText` y `bufferedWriter`, y justifica cuál usarías en esta solución.

Respuesta a pregunta 14:

Para leer y escribir ficheros kotlin ofrece muchas opciones, siendo la principal el uso de ```java.nio.file.Files.readAllLines``` y ```java.nio.file.Path```, librerias que proporcionan métodos especificos de java que facilitan el tratado de archivos.

Para leerlo, utilizo opciones como ```readAllLines()```, que me sirve para poder leer todas las lineas de un archivo en un programa, y para escribir otras opciones como Files.write para escribir en ficheros utilizando el ```buildlist``` con el método ```add```. 

A nivel general, kotlin nos ofrece los métodos de File para trabajar directamente con un archivo, utilizando sus métodos como ```write```, ```move``` ... Que nos dota de una gran facilidad para el tratado de información en ficheros.

Por otro lado, también encontramos los métodos de ```Path```, que nos permite trabajar directamente con rutas.

## UD9, RA9: Bases de datos relacionales

15. Explica qué objetos importantes de la librería JDBC usas en el `insert` de esta ampliación y para qué sirve cada uno, por ejemplo `DriverManager`, `Connection` y `PreparedStatement`. Indica también para qué serviría `ResultSet` en una consulta.

Respuesta a pregunta 15:

16. Propón cómo completarías el resto del CRUD sobre la tabla `resumen_procesamiento`, sin implementarlo: consulta de resúmenes, modificación de un registro incorrecto y borrado de un resumen almacenado.

Respuesta a pregunta 16:
