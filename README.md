# Leer variables de ambiente de un archivo de propiedades

Cuando un archivo de propiedades tiene variables de ambiente como por ejemplo:

    com.something.one=AAA1
    com.something.two=${MyEnvVar}
    com.something.url=http://${myhost}:${myport}/xxx/yyy/zzz

Leerlo directamente y que considere el reemplazo de las variables de propiedades no parece ser tan sencillo y que ademas sea del tipo java.util.properties, por lo que en este codigo se implementa una clase que sobreescribe un metodo de PropertiesFactoryBean y reemplaza los valores de las variables de ambiente obteniendose un resultado como:

    Propertie normal

    var one = AAA1
    var two = ${MyEnvVar}
    var url = http://${myhost}:${myport}/xxx/yyy/zzz

    Propertie con Env:

    var one = AAA1
    var two = Algo
    var url = http://localhost:443/xxx/yyy/zzz

