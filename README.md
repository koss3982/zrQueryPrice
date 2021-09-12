# zrQueryPrice
Prueba técnica SpringBoot consulta rest de precios.

## Arquitectura y plataforma

Se ha implementado la solución haciendo uso de Spring Boot en su última versión en la fecha de desarrollo (2.5.4), así como el último JDK estable: JDK 16.
Durante este mes de septiembre se publicará el JDK 17, que al ser LTS puede ser un buen candidato para futuros desarrollos.

Se ha implementado un único microservicio (classe **QueryController**), el cual tiene un único método **getPrice**.

En el código hay comentarios

## Simplificaciones realizadas

Para la prueba técnica, se ha simplificado la implementación con las siguientes premisas:

- Se ha obviado la securización. Se debería optar por securizar cada llamada al microservicio con JWT (JSON Web Token) o similar.
- Se ha optado por catch-all en los métodos, en lugar de capturar cada una de las excepciones que pueden ser lanzadas,
