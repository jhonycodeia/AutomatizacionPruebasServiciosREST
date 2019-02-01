# Automatizacion-pruebas-servicios-REST
Estas herramientas muy sencilla pueden ayudarnos a la automatización de pruebas de Web Servicies REST Utilizando la herramienta JMETER 3.1 o 5.0

[TOC]

### Preparación de data

Antes que nada para iniciar la preparacion de datos para las pruebas se debe abrir el documento "Generador.xmls",en el cual se encuentras 2 hojas,condiciones la cual es donde se configurar los parametros y la hoja data,donde se escribira los datos para las pruebas
> Nota: para que no haya inconvenientes a la hora de generar la data la hoja data,siempre debe estar limpia sin datos,preferiblemente eliminar todas las filas que tengan datos o algun style

Una vez abierto el documento en la hoja condiciones nos encontraremos con 2 tablas una para los parametros y otra para los criterion que se explicara que se debe hacer a continuacion:

![](picture/propiedades.png)

1. Indice que corresponde al contador de la propiedades `Ejemplo: 1,3,10`
2. Nombre del parametro `Ejemplo: Name,Apellido,Version`
3. Valor de la propiedad que es asignado cuando la peticion es valida `Ejemplo: BBS,es_CO`
4. Valores que puede tomar una propiedad,solo aplica para tipos de dato array cada valor es separado por coma  `Ejemplo: CC,CE,NI,TI`
5. Valor que corresponde al tamaño maximo de la propiedad un numero entero,si no tiene tamaño maximo dejar campo vacio `Ejemplo: 25,45,39` 
6. Valor que corresponden la propiedad de obligatoriedad de un campo si aplica se escribe `X` si no se deja el campo vacio
7.  Valores que corresponde al tipo de dato de la propiedad puede ser: `String,Integet,Number,Boolean,Date-time,Array` 
8.  Valores que corresponde al dato invalido simpre y cuando sea un tipo de dato array y tenga diferentes valores posibles
9.  Valores que corresponden al tipo de propiedad que puede ser: `Header,Body,Query,Path`

![](picture/criterios.png)

1. Contador de numero de propiedades y numero de criterios a evaluar,toma en cuenta los indeces para realizar esta operacion
2. Indice que corresponde al contador de los criterios `Ejemplo: 1,3,10` 
3. Valor correspondiente al tipo de validacion que desea realizar puede ser: `Peticion valida,Longitud,Tipo de dato,Obligatoriedad,Opcional,Valores validos`
4. Campo corresponde al tipo de pruebas que puede ser: `Valido para caso de prueba positiva o Invalida para caso de prueba negativa`
5. Campo que corresponde al tipo de agrupacion de los parametros que son: `General para que verifique todos los campos juntos o Especifico para que verifique un campo a la vez`
6. Corresponde al codigo que se espera con ese criterio en la respuesta del servicio
7. Corresponde al mensaje que se espera con el criterio que se evalua
8. Corresponde a la opcion si se desea generar la data para ese criterio puede ser: `Aplica o No Aplica`
9. Corresponde al boton que una vez realizado todos los pasos anteriores,se genera la correspondiente data para las pruebas

Una vez el archivo termina de ejecutarse tendremos algo similar en la hoja data del libro como lo siguiente:

![](picture/dataGenerada.png)


### Instalacion de herramientas

#### Jmeter

1.  Descargar la herramienta JMeter version 3.1 o 5, [Dowload](https://archive.apache.org/dist/jmeter/binaries/)
2.  Descargar la herramienta tika-app.jar, [Dowload](https://www-us.apache.org/dist/tika/)
3.  Una vez descargado las herramienta en la carpeta origen del jmeter mover el archivo `tika-app.jar` en la ruta `Jmeter/lib/`
4.  Ejecutar el archivo `Jmeter/bin/ApacheJMeter.jar`




### Documentacion Api JmeterExcel.jar

#### Class Workm  

###### Constructor

```
new Work(String ruta)
```
> Constructor de clase que recibe la ruta del archivo de datos el pathAbsolute,para instacias las sheet y leer los datos

###### Metodos

```
SheetWork getSheetParametros()
```
> Metodo que retorna un SheetWork,correspondiente a la hoja de parametros

```
SheetWork getSheetDatos()
```
> Metodo que retorna un SheetWork,correspondiente a la hoja de data

```
void close()
```
> Metodo encargado de cerrar el documento de datos

#### Class SheetWork

###### Metodos

```
ArrayList<Parametro> getListPropiedades()
```
> Metodo que retorna una lista de parametros correspondiente a los parametros en la sheet parametros, solo aplica con esta sheetParametro

```
ArrayList<Parametro> getListParametrosHeader(int row)
```
> Metodo que retorna una lista de parametros correspondientes a los tipo parametro header de la fila determinada,solo aplica para sheetData

```
ArrayList<Parametro> getListParametrosBody(int row)
```
> Metodo que retorna una lista de parametros correspondientes a los tipo parametro body de la fila determinada,solo aplica para sheetData

```
ArrayList<Parametro> getListParametrosPath(int row)
```
> Metodo que retorna una lista de parametros correspondientes a los tipo parametro path de la fila determinada,solo aplica para sheetData

```
ArrayList<Parametro> getListParametrosQuery(int row)
```
> Metodo que retorna una lista de parametros correspondientes a los tipo parametro query de la fila determinada,solo aplica para sheetData

```
public ArrayList<Parametro> getListParametrosCode(int row)
```
> Metodo que retorna una lista de parametros correspondientes a los tipo parametro code de la fila determinada,solo aplica para sheetData

```
ArrayList<Parametro> getListParametrosMessage(int row)
```
> Metodo que retorna una lista de parametros correspondientes a los tipo parametro message de la fila determinada,solo aplica para sheetData

#### Class Parametro

###### Constructor

```
new Parametro(String name, String value) 
```
> Constructor de clase recibe nombre propiedad y correspondiente valor


###### Metodos

```
String getValue()
```
> Metodo que retorna una cadena de caracteres con eñ valor de la propiedad

```
long getValueNumber()
```
> Metodo que retorna un valor entero correspondiente a la propiedad solo aplica para propiedades tipo integer o number

```
String getTipoDato()
```

> Metodo que retorna una cadena de caracteres con el tipo de dato correspondiente a la propiedad que puede ser: String,Date-time,Integer,Number,Boolean o Array

```
String getTipoParametro()
```
> Metodo que retorna una cadena de caracteres con el tipo de parametro correspondiente a la propiedad que puede ser: Header,Body,Path o Query

```
String getName()
```
> Metodo que retorna una cadena de caracteres con el nombre de la propiedad