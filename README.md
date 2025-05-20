
# 🛒 Tienda Online - Proyecto TeamCoders

Este proyecto corresponde a la cuarta entrega del caso práctico **"Online Store"** del módulo de Programación Orientada a Objetos con Acceso a Bases de Datos. En esta fase se ha implementado una aplicación de consola que utiliza **persistencia JPA (Hibernate)**, manteniendo la arquitectura **MVC** y aplicando los patrones **DAO** y **Factory**.

---

## 🧰 Tecnologías utilizadas

- **Java 17**
- **MySQL 8**
- **Hibernate JPA**
- **Maven**
- **Visual Studio Code**
- **JavaFX 17**

---

## 📁 Estructura del proyecto

```
TeamCoders/
├── modelo/
│   ├── Articulo.java
│   ├── Cliente.java
│   ├── ClienteEstandar.java
│   ├── ClientePremium.java
│   └── Pedido.java
├── dao/
│   ├── interfaces/
│   ├── mysql/
│   └── jpa/
├── factory/
│   ├── DAOFactory.java
│   └── JPADAOFactory.java
├── controlador/
├── vista/
│   ├── fx/
│   │   ├── inicio.fxml
│   │   ├── clientes/
│   │   │   ├── clientes_menu.fxml
│   │   │   ├── clientes_anadir.fxml
│   │   │   └── clientes_mostrar.fxml
│   │   ├── articulos/
│   │   │   ├── articulos_menu.fxml
│   │   │   ├── articulos_anadir.fxml
│   │   │   └── articulos_mostrar.fxml
│   │   └── pedidos/
│   │       ├── pedidos_menu.fxml
│   │       ├── pedidos_anadir.fxml
│   │       └── pedidos_mostrar.fxml
├── utils/
│   └── JpaUtil.java
└── Main.java
```

---

## ✅ Funcionalidades implementadas

### 🖥️ Consola

- Alta y listado de **Clientes Estándar** y **Clientes Premium**
- Alta y listado de **Artículos**
- Alta y visualización de **Pedidos**
- Uso de **entidades JPA** con relaciones `@ManyToOne`
- Acceso a datos con **DAO + Factory**
- Persistencia con **Hibernate** y configuración a través de `persistence.xml`

### 🖼️ Interfaz Gráfica (JavaFX)

Se ha incorporado una **interfaz gráfica de usuario (GUI)** mediante **JavaFX**, manteniendo la arquitectura MVC y la lógica de negocio existente en consola.

- Navegación completa mediante **ventanas FXML** diseñadas con Scene Builder.
- Interfaz gráfica para:
  - Añadir, listar y filtrar **clientes estándar y premium**
  - Añadir y mostrar **artículos**
  - Añadir, listar, filtrar y eliminar **pedidos**
- **Compatibilidad total** con las funcionalidades previamente implementadas en consola.
- Ventanas adaptadas para **usabilidad y experiencia de usuario**, incluyendo maximización automática y navegación fluida.

---

## 📚 Documentación

Todas las clases nuevas incorporan documentación **JavaDoc** siguiendo el mismo estándar que las clases anteriores (por ejemplo: `ArticuloDAOMySQL`). Esta documentación incluye:

- Descripción general de la clase
- Comentarios detallados en cada método
- Parámetros (`@param`), valor de retorno (`@return`) y excepciones (`@throws`) documentados

---

## ▶️ Ejecución del programa

1. Asegúrate de tener la base de datos `TeamCodersBD` creada y configurada correctamente.
2. Compila el proyecto con Maven o desde VS Code.
3. Ejecuta `Main.java` para la versión de consola o utiliza el comando `mvn clean javafx:run` para la versión con interfaz gráfica.
4. Interactúa con el menú de consola o la interfaz gráfica para gestionar clientes, artículos y pedidos.

---

## 📝 Notas

- Se utiliza una base de datos **MySQL local** con credenciales indicadas en `persistence.xml`.
- La validación de tipos y estructuras se realiza al inicio mediante `hibernate.hbm2ddl.auto=validate`.
- El proyecto incluye una interfaz gráfica implementada con JavaFX. Para que funcione correctamente en todos los entornos, es importante seguir estas indicaciones:

### ✅ Versión del JDK

- Puedes usar **JDK 17** (recomendado) o **JDK 21**.
- Es importante que la versión del **JavaFX SDK** coincida con la del JDK utilizado.

### JavaFX SDK

- El proyecto utiliza **JavaFX 17**, y el SDK se incluye en la carpeta local `javafx-sdk-17` dentro del proyecto.
- Si prefieres usar JavaFX 21, deberás cambiar la ruta en tu archivo `launch.json` por tu SDK local compatible con la versión.

---

## 👥 Autores

**TeamCoders**

---

## 👤 Integrantes del grupo

- Alejandro Arévalo Rojas
- Ignacio Borrell Román
- Marc Soler Fortó
- Xavi Miró Carrera
