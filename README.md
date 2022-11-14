# Introducción

El objetivo de este ejercicio es la refactorización de este simple proyecto Java incluyendo aquellas buenas prácticas
de programación y tecnologías que simplifiquen su uso y mantenimiento.

Se trata de una clase con un método público que devuelve la previsión del tiempo de una ciudad en una fecha concreta.

Para ello, esta clase utiliza una API externa (requiere conexión a internet): [www.open-meteo.com](https://www.open-meteo.com) 

Ejemplo:

```java
WeatherForecast weatherForecast = new WeatherForecast();
weatherForecast.getCityWeather("Madrid", new Date());
```


# Ejercicio

El ejercicio consiste en **refactorizar** el código para hacerlo más **mantenible**, ya que el código existente, aunque **funciona**, es muy difícil de entender. 
  
Para ello se pueden realizar múltiples modificaciones siempre que se mantenga el API público. Ejemplos de modificaciones: incluir tests automáticos, extraer métodos, renombrar variables, modificar tipos de datos, crear nuevas clases, añadir librerías, etc. 


# Documentación

La solución debería contener un fichero README donde se respondan estas preguntas:
- ¿Qué has empezado implementando y por qué?

   Tras subir el proyecto a un repositorio de GitHub, lo primero que he hecho es instalar la librería Lombok y después he modificado los test tratando de cubrir un par de casos más, intuyendo cómo funciona la aplicación a falta de requisitos. Teniendo estos casos en cuenta, también he modificado ligeramente el comportamiento de la función principal para corresponder y he alterado los métodos.
   
- ¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?

   He necesitado repasar algunos conceptos pero ya conocía JUnit y las aserciones aunque no las haya usado mucho en la práctica. He tratado de ser directo con ejemplos concretos y mantener la simpleza con los casos.

- ¿Qué componentes has creado y por qué?

   He realizado principalmente extracciones de métodos para hacer que la clase principal fuese más modular e inteligible, además de legible renombrando variables y comentando el código. Para un proyecto más grande, trataría de dividir las clases entre controlador, servicio, repositorio, y otros, pero dada la complejidad de la tarea no he visto necesario extenderme a ese punto, o no sé si sería adecuado.

- Si has utilizado dependencias externas, ¿por qué has escogido esas dependencias?

   He introducido lombok porque en mi experiencia resulta útil en la práctica y también ahorra código con notaciones como @Data para no tener que declarar los getter & setter en los POJO o VO, aunque en este caso he visto que no se puede utilizar en un enumerado.

- ¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?

   En este caso no los he utilizado, pero sí los conozco y los he utilizado bastante en mi experiencia este último año. No tengo del todo claro las ventajas que presentan, salvo que en ocasiones permite hacer el código más sencillo a la vista. Por otro lado, a veces me ha resultado más dificil debuggear código debido a estas estructuras, por lo que no sé si siempre son mejores. Necesito indagar más sobre sus ventajas y usos.

- ¿Qué piensas del rendimiento de la aplicación? 

   No estoy muy concienciado sobre cómo debe ser el rendimiento de una aplicación en cuando a milisegundos o cómo funciona del todo, me faltan referencias y comprensión. Seguramente se pueda mejorar el rendimiento aunque para las operaciones simples que he probado me parezca bueno.

- ¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?

   Tengo entendido que aspectos como las estructuras de control que se utilizan y quizás el tipo de datos por la precisión puede influir en el rendimiento de una operación. También considero que sería importante reducir el número de llamadas entre métodos y mejorar el diseño de las capas de la aplicación, pudiendo implementar un modelo como el MVC. El uso de microservicios e imágenes duplicadas también podría ayudar a repartir la carga de las peticiones durante las ejecuciones.

- ¿Cuánto tiempo has invertido para implementar la solución? 

   He necesitado algo de tiempo de antemano para instalar los programas necesarios y refrescar, pero estimo que luego he empleado alrededor de 2h modificando el proyecto, haciendo subidas, etc.

- ¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?

   Sí, considero que siempre que el tiempo lo permita resulta valioso dedicar esfuerzos a hacer un código más eficiente, modular y amistoso, ya sea para uno mismo o para quien lo pueda encontrar más adelante.


# A tener en cuenta

- Se valorará positivamente el uso de TDD, se revisarán los commits para comprobar su uso.
- Se valorará positivamente la aplicación de los principios SOLID y "código limpio".
- La aplicación ya tiene un API público: un método público que devuelve el tiempo en un String. No es necesario crear nuevas interfaces: REST, HTML, GraphQL, ni nada por el estilo.


# Entrega

La solución debe ser comprimida (incluyendo el directorio .git) en un fichero .zip/.tar.gz y enviarlo por email.
