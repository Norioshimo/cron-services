# Proyecto Spring Boot - Servicios Cron Dinámicos

Este proyecto está desarrollado en **Spring Boot** y permite gestionar tareas programadas (cron jobs) de manera dinámica mediante servicios REST. Los servicios habilitados permiten iniciar y detener tareas cron utilizando expresiones cron personalizadas. El proyecto está en desarrollo y se actualiza periódicamente.

## Funcionalidades Principales

- **Iniciar una tarea cron**: Puedes iniciar una tarea con una expresión cron personalizada.
- **Detener una tarea cron**: Es posible detener una tarea en ejecución.
- **Consultar el estado de una tarea**: Se puede verificar el estado actual de una tarea utilizando su taskId.

## Endpoints Disponibles

### 1. Consultar el estado de una tarea

- **Método**: GET
- **URL**: http://localhost:8080/cron/api/status?taskId=180
- **Descripción**: Consulta el estado actual de una tarea específica utilizando su taskId.

### 2. Detener una tarea cron

- **Método**: POST
- **URL**: http://localhost:8080/cron/api/stop?taskId=180
- **Descripción**: Detiene la ejecución de la tarea especificada por su taskId.

### 3. Iniciar una tarea cron

- **Método**: POST
- **URL**: http://localhost:8080/cron/api/start?taskId=180&cronExpression=0 * * * * ?
- **Descripción**: Inicia una tarea cron con una expresión cron proporcionada. En este ejemplo, la tarea se ejecuta cada 1 minuto (cronExpression=0 * * * * ?).

## Configuración del Proyecto
Este proyecto está configurado para ejecutarse en servidores de aplicaciones Glassfish o Wildfly.

## Pasos para Levantar el Proyecto en Wildfly o Glassfish

### **1. Compilar el proyecto**:
   Ejecuta el siguiente comando en el directorio raíz del proyecto para compilarlo:
   ./mvnw clean package

### **2. Desplegar en el servidor**:
   Copia el archivo .war generado en el directorio target al directorio de despliegue de tu servidor Glassfish o Wildfly.

### **3. Iniciar el servidor**:
   Asegúrate de que el servidor esté configurado correctamente y levántalo.

### **4. Consumir los servicios**:
   Utiliza herramientas como Postman o curl para consumir los servicios habilitados y gestionar las tareas cron.

## Ejemplo de Expresión Cron
Para iniciar una tarea que se ejecute cada minuto, puedes usar la siguiente expresión cron: 0 * * * * ?

0 * * * * ?: Esto indica que la tarea se ejecuta en el segundo 0 de cada minuto.

0: Segundo (en este caso, el segundo 0).

*: Cada minuto.

*: Cada hora.

*: Cada día del mes.

*: Cada mes.

?: Ignora el día de la semana.

## Repositorio
Este repositorio se encuentra en desarrollo activo y recibe actualizaciones periódicas. Se recomienda verificar frecuentemente para obtener las últimas mejoras y correcciones.
