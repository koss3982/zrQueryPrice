# zrQueryPrice
Prueba técnica SpringBoot consulta rest de precios.

## Arquitectura y plataforma

Se ha implementado la solución haciendo uso de Spring Boot en su última versión en la fecha de desarrollo (2.5.4), así como el último JDK estable: JDK 16.
Durante este mes de septiembre se publicará el JDK 17, que al ser LTS puede ser un buen candidato para futuros desarrollos.

Se ha implementado un único microservicio (classe **QueryController**), el cual tiene un único método **getPrice**.

En el código hay comentarios sobre alguna decisión de diseño.

## Simplificaciones realizadas

Para la prueba técnica, se ha simplificado la implementación con las siguientes premisas:

- Se ha obviado la securización. Se debería optar por securizar cada llamada al microservicio con JWT (JSON Web Token) o similar.
- Solo se ha creado una excepción: NoPriceFoundException. Se podría hacer más control sobre el paso de parámetros del microservicio, etc.

## Ejecución

Para la comprobación de los resultados de los precios con diferentes parámetros de fecha/hora:

- En la compilación se ejecutan automáticamente los tests de integración.
- Se puede levantar el microservicio y realizar las pruebas con Postman, u otro programa para realizar llamadas REST (se incluye exportación de llamadas Postman).
- Se puede levantar con un contenedor tipo Docker (y realizar llamadas REST de igual forma que punto anterior):
    - docker build -t zr-query-price .
    - docker run -d -p 8080:8080 zr-query-price
