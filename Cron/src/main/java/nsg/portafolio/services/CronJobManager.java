package nsg.portafolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@Service
public class CronJobManager {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    public CronJobManager(ThreadPoolTaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    // Mapa para almacenar las tareas programadas y su identificador
    private Map<String, ScheduledFuture<?>> tasks = new HashMap<>();

    // Método para iniciar una tarea cron
    public void iniciarTareaCron(String taskId, String cronExpression, Runnable task) {
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(task, new CronTrigger(cronExpression));
        tasks.put(taskId, scheduledTask);  // Asignar la tarea al mapa con su ID
        System.out.println("Tarea cron " + taskId + " iniciada con la expresión: " + cronExpression);
    }

    // Método para detener una tarea cron específica
    public void detenerTareaCron(String taskId) {
        ScheduledFuture<?> scheduledTask = tasks.get(taskId);
        if (scheduledTask != null && !scheduledTask.isCancelled()) {
            scheduledTask.cancel(false);  // Cancelar la tarea
            tasks.remove(taskId);  // Eliminarla del mapa
            System.out.println("Tarea cron " + taskId + " detenida.");
        } else {
            System.out.println("No se encontró la tarea cron " + taskId + " o ya estaba detenida.");
        }
    }

    // Método para verificar si una tarea está en ejecución
    public boolean estaTareaActiva(String taskId) {
        ScheduledFuture<?> scheduledTask = tasks.get(taskId);
        return scheduledTask != null && !scheduledTask.isCancelled();
    }
}
