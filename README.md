# Gestor de Cobranza

## Resumen Ejecutivo

### Descripción
Este proyecto es un sistema de gestión de cobranza que permite a una empresa registrar promesas de pago de sus clientes, realizar un seguimiento de las promesas vencidas y crear promesas de pago nuevas.

### Problema Identificado
Las empresas de cobranza a menudo enfrentan dificultades para gestionar y hacer un seguimiento efectivo de las promesas de pago de los clientes, lo que puede llevar a pérdidas financieras. Este sistema aborda ese problema proporcionando una plataforma centralizada para el registro y seguimiento de las promesas de pago.

### Solución
La solución propuesta es un sistema de software que permite a los usuarios autenticarse, registrar nuevas promesas de pago, visualizar las promesas vencidas y realizar otras operaciones relacionadas con la gestión de cobranza.

### Arquitectura
La aplicación está desarrollada en Java y utiliza una arquitectura de consola simple. La información se almacena en archivos CSV para facilitar la accesibilidad y la simplicidad.

## Tabla de Contenidos

- [Requerimientos](#requerimientos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
- [Contribución](#contribución)
- [Roadmap](#roadmap)

## Requerimientos

### Servidores de Aplicación, Web, Bases de Datos, etc.
- No se requiere un servidor de aplicación o web.
- El sistema utiliza archivos CSV para almacenar datos, por lo que no es necesario un servidor de base de datos.

### Paquetes Adicionales
- No se requieren paquetes adicionales. El sistema utiliza las bibliotecas estándar de Java.

### Versión de Java
- Se requiere Java 8 o superior.

## Instalación

### Cómo instalar el Ambiente de Desarrollo
1. Clone el repositorio: `git clone https://github.com/mrojasdi/GestorCobranza.git
2. Abra el proyecto en su entorno de desarrollo preferido (Eclipse, IntelliJ, etc.).

### Cómo Ejecutar Pruebas Manualmente
1. Ejecute la aplicación desde su entorno de desarrollo.
2. Siga las instrucciones en la consola para interactuar con el sistema.

### Cómo Implementar la Solución en Producción
1. Construya el proyecto.
2. Despliegue el archivo JAR resultante en un servidor.

## Configuración

### Configuración del Producto (Archivos de Configuración)
- La configuración se realiza a través de la interfaz de línea de comandos y archivos CSV.

### Configuración de Requerimientos
- No se requiere configuración adicional.

## Uso

### Sección de Referencia para Usuario Final
- Consulte la [Wiki](/wiki) para obtener información detallada sobre cómo utilizar el sistema como usuario final.

### Sección de Referencia para Usuario Administrador
- Consulte la [Wiki](/wiki) para obtener información detallada sobre cómo administrar y configurar el sistema.

## Contribución

### Guía de Contribución para Usuarios
1. Clone el repositorio: `git clone https://github.com/mrojasdi/GestorCobranza.git`
2. Cree un nuevo branch: `git checkout -b nombre-branch`
3. Realice sus cambios y haga commit: `git commit -m "Describa sus cambios"`
4. Envíe un pull request.

### Roadmap

- Implementar funcionalidad de informes.
- Mejorar la interfaz de usuario.
- Agregar soporte para diferentes formatos de almacenamiento.

