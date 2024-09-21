package nsg.portafolio.controller;

import nsg.portafolio.services.CronJobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api"})
public class cronController {

    @Autowired
    private CronJobManager cronJobManager;

    @RequestMapping(value = {"", "/"}, method = {RequestMethod.GET})
    public ResponseEntity<String> findHolaMundo() {
        return (ResponseEntity<String>) new ResponseEntity("Bienvenido a hola", HttpStatus.OK);
    }

    // Iniciar una tarea cron
    @PostMapping("/start")
    public String iniciarTarea(@RequestParam String taskId, @RequestParam String cronExpression) {

        Runnable task = () -> System.out.println("Ejecutando tarea: " + taskId);//Aquí se define lo que hace la tarea

        cronJobManager.iniciarTareaCron(taskId, cronExpression, task);
        return "Tarea " + taskId + " iniciada con cron: " + cronExpression;
    }

    // Detener una tarea cron
    @PostMapping("/stop")
    public String detenerTarea(@RequestParam String taskId) {
        System.out.println("TaskId recibido: " + taskId);

        cronJobManager.detenerTareaCron(taskId);
        return "Tarea " + taskId + " detenida";
    }

    // Verificar si una tarea está activa
    @GetMapping("/status")
    public String estadoTarea(@RequestParam String taskId) {
        boolean activa = cronJobManager.estaTareaActiva(taskId);
        return activa ? "La tarea " + taskId + " está en ejecución." : "La tarea " + taskId + " no está activa.";
    }

}
