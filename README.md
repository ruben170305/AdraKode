
# AdraKode

## **Integrantes: Ainhoa Blanca, Adrián Arcones, Daniel Correa y Rubén Peña**

AdraKode es una aplicación desarrollada para el Club de Rol de la UEM que permite a los miembros gestionar sus personajes y partidas de rol de manera eficiente y organizada. Este proyecto sigue una arquitectura MVC y se ha desarrollado utilizando Java, Eclipse, Git y MySQL.

## Índice

1. [Descripción](#descripción)
2. [Requisitos](#requisitos)
   - [Software](#software)
   - [Hardware](#hardware)
3. [Instalación](#instalación)
4. [Uso](#uso)
   - [Pantalla de Login](#pantalla-de-login)
   - [Gestión de Personajes](#gestión-de-personajes)
   - [Gestión de Partidas](#gestión-de-partidas)
5. [Contribuir](#contribuir)

## Descripción

AdraKode es una herramienta diseñada para facilitar la gestión de personajes y partidas de rol. Permite a los miembros del club crear, modificar y consultar personajes, así como gestionar partidas, con diferentes permisos para jugadores y Game Masters.

## Requisitos

### Software

- **Java**: Usado para codificar la aplicación y permitir la implementación del sistema CRUD para consultas SQL desde la aplicación.
- **Eclipse**: Utilizado para implementar las clases encargadas de la interfaz gráfica y la lógica de la aplicación.
- **Git**: Para el control de versiones del proyecto y la gestión colaborativa del desarrollo.
- **MySQL**: Para la creación y gestión de la base de datos de la aplicación.

### Hardware

| Especificación         | Requisitos Mínimos                       | Requisitos Recomendados             |
|------------------------|------------------------------------------|-------------------------------------|
| **Procesador (CPU)**   | Intel Core i3 o AMD Ryzen 3, 2.0 GHz     | Intel Core i5 o AMD Ryzen 5, 2.5 GHz|
| **Memoria RAM**        | 4 GB                                     | 8 GB o más                          |
| **Espacio en Disco**   | 500 MB de espacio disponible             | 1 GB de espacio libre               |
| **Conexión a Internet**| 10 Mbps                                  | 20 Mbps o superior                  |
| **Sistema Operativo**  | Windows 10, macOS Mojave, Ubuntu 20.04   | Windows 10 o posterior, macOS Catalina o posterior, Ubuntu 20.04 LTS o posterior |
| **Resolución de Pantalla** | 1280 x 720 píxeles                   | 1920 x 1080 píxeles o superior      |
| **Periféricos**        | Teclado y ratón                          | Teclado y ratón                     |

## Instalación

1. Clona el repositorio desde GitHub:
   ```bash
   git clone https://github.com/ruben170305/AdraKode.git

2. Abre el proyecto en Eclipse, IntelliJ IDEA o Visual Studio Code

3. Configura la conexión a la base de datos MySQL en el archivo de configuración correspondiente.

4. Ejecuta la aplicación

## Uso

### Pantalla de Login

    Los miembros pueden acceder con su usuario y contraseña o crearse una cuenta nueva.
    Diferentes permisos para jugadores y Game Masters.

### Gestión de Personajes

    Crear, ver, modificar y borrar personajes.
    Los jugadores pueden gestionar solo sus propios personajes.
    Los Game Masters pueden ver y gestionar todos los personajes.

### Gestión de Partidas

    Consultar, crear y modificar partidas.
    Los jugadores pueden consultar cualquier partida.
    Los Game Masters pueden gestionar las partidas que están dirigiendo.

## Contribuir

    Haz un fork del repositorio.
    Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
    Realiza tus cambios y haz commit de los mismos (git commit -am 'Añadir nueva funcionalidad').
    Sube tus cambios a tu repositorio (git push origin feature/nueva-funcionalidad).
    Crea un nuevo Pull Request.
