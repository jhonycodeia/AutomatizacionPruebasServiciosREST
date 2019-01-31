# Automatizacion-pruebas-servicios-REST
Estas herramientas muy sencilla pueden ayudarnos a la automatización de pruebas de Web Servicies REST

[TOC]





### Documentacion Api JmeterExcel.jar

#### Class Work

###### Constructor
###### Metodos

#### Class SheetWork

###### Metodos

```
ArrayList<Parametro> getListPropiedades()```
> Metodo que retorna una lista de parametros correspondiente a los parametros en la sheet parametros, solo aplica con esta sheet 

```
ArrayList<Parametro> getListParametrosHeader(int row)```
> Metodo que retorna una lista de parametros correspondiente a las parametros solo a la sheet parametros solo aplioca con esta sheet

```
ArrayList<Parametro> getListParametrosBody(int row)```
> Metodo que retorna una lista de parametros correspondiente a las parametros solo a la sheet parametros solo aplioca con esta sheet

```
ArrayList<Parametro> getListParametrosPath(int row)```
> Metodo que retorna una lista de propiedade correspondiente a las parametros solo a la sheet parametros solo aplioca con esta sheet

```
ArrayList<Parametro> getListParametrosQuery(int row)```
> Metodo que retorna una lista de parametros correspondiente a las parametros solo a la sheet parametros solo aplioca con esta sheet

```
public ArrayList<Parametro> getListParametrosCode(int row)```
> Metodo que retorna una lista de parametros correspondiente a las parametros solo a la sheet parametros solo aplioca con esta sheet

```
ArrayList<Parametro> getListParametrosMessage(int row)```
> Metodo que retorna una lista de parametros correspondiente a las parametros solo a la sheet parametros solo aplioca con esta sheet

#### Class Parametro

###### Constructor

```
new Parametro(String name, String value) 
```
> Constructor de clase recibe nombre propiedad y correspondiente valor


###### Metodos
```
String getValue()```
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