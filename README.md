# Programación de Servicios y Procesos - 03 - Ejercicios - 2021-2022
Programación de Servicios y Procesos - 03 Programación Multihilo. 2DAM. Ejercicios realizados por el alumnado. Curso 2021-2022


![imagen](https://antarestrade.world/wp-content/uploads/2020/08/Blockcain-Seo.png)

## ¿Cómo Colaborar?
Estos ejercicios están resueltos por el alumnado y están basados en la relación de la [Unidad 2: Programación Multihilo](https://github.com/joseluisgs/ProgServiciosProcesos-02-2021-2022).

Para subir tu ejercicio a GitHub, **POR FAVOR SIGUE ESTAS NORMAS**:

- Hazte un fork de este repositorio
- Trabaja con GitFlow
- Crea una reama feature con tu Iniciales y apellido y el nombre del problema realizado por el profesor, por ejemplo: /feature/JLGonzalez/cajas-executor
- Crea un directorio dentro del directorio del problema del repositorio con tu Iniciales y Apellido, por ejemplo cajas-executor/JLGonzalez. 
- Copia tu proyecto de IntellIJ creado y gestionado con Maven a tu directorio creado. Debes tener en cuenta que el gitignore de ese proyecto debe evitar subir el directorio /out y /target de Intellij.
- Cierra la Feature siguiendo el flujo de GitFlow, fusionando los cambios a Develop, pero no borres esa rama por si la vuelves a necesitar.
- Confirma los cambios y sube los cambios a tu repositorio GitHub.
- Hazme un pull request para que acepte los cambios y explícame dichos cambios en la rama **Develop** en tu commit.
- Aplica las acciones oportunas para tener todo sincronizado.
- **SI NO SE SIGUEN ESTAS NORMAS SE TE INVALIDARÁ EN PULL REQUEST. PIENSA QUE ES POR EL BIEN DE TODOS/AS Y TU EJERCICIO CONSTARÁ COMO NO ENTREGADO.**
- **ESTE REPOSITORIO SIRVE PARA TENER DISTINTOS PUNTOS DE VISTA, PUEDEN QUE FALLEN SI LOS PRUEBAS O QUE UN ERROR PERJUDIQUE A OTROS FICHEROS.** Te aconsejo que los pruebes en un proyecto vació con la estructuras de directorios propuesta, llamándolo main.ts y usando el módulo que necesite para que no arrastre errores a otros ficheros o problemas. Cualquier duda usa Discord o pregunta en clase.

!!! FIN !!! 😀 🤝

## Problemas

### Cajas y Colas. Multihilo con Executer
Nos van a contratar para simular el sistema de atención al cliente en un supermercado, para eso queremos obtener los tiempos de ejecución en determinadas situaciones. Vamos a crear una aplicación llamada super.jar, donde la llamaremos con los parámetros nº de cajas y número de clientes. Por ejemplo java -jar super.ja3 3 21


Gestionaremos con un Pool de Hilos Workers que serán nuestras cajas disponibles. Tendremos una COLA de objetos del tipo Clientes que a su vez tiene un Carro con un máximo de 1 a 30 Productos. Cada Producto tiene asociado un tiempo de procesamiento en la caja de 1 a 5 segundos.

Programa este ejemplo usando programación concurrente. Echa un ojo al tiempo que se tardaría y compáralo con el mismo ejemplo usando programación secuencial. Lo ideal es que crees antes todos los datos y hagas dos métodos (para que trabajen con los mismos datos de número de productos 
y tiempos de productos) y los ejecutes en dos métodos, uno secuencia y otro concurrente. Repite varias veces.

Pista: Debéis tener Caja ,Clientes que es una Cola, El Cliente, El Cliente tiene un Carro y el Carro está compuesto de Productos

Entrega 14/10/2021


## Autor

Codificado con :sparkling_heart: por [José Luis González Sánchez](https://twitter.com/joseluisgonsan)

[![Twitter](https://img.shields.io/twitter/follow/joseluisgonsan?style=social)](https://twitter.com/joseluisgonsan)
[![GitHub](https://img.shields.io/github/followers/joseluisgs?style=social)](https://github.com/joseluisgs)

### Contacto
<p>
  Cualquier cosa que necesites házmelo saber por si puedo ayudarte 💬.
</p>
<p>
    <a href="https://twitter.com/joseluisgonsan" target="_blank">
        <img src="https://i.imgur.com/U4Uiaef.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://github.com/joseluisgs" target="_blank">
        <img src="https://cdn.iconscout.com/icon/free/png-256/github-153-675523.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://www.linkedin.com/in/joseluisgonsan" target="_blank">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://joseluisgs.github.io/" target="_blank">
        <img src="https://joseluisgs.github.io/favicon.png" 
    height="30">
    </a>
</p>
