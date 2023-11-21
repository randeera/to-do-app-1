package lk.ijse.dep11.todo.api;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lk.ijse.dep11.todo.to.TaskTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskHttpController {

    /*
        The schema object defines the content of the request and response. In other words,
        it refers to the definition and set of rules (validation rules) for representing
        the structure of API data
    */

    private final HikariDataSource pool;

    public TaskHttpController() {
        HikariConfig config = new HikariConfig();
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.setJdbcUrl("jdbc:postgresql://localhost:15000/dep11_todo_app");
        config.setDriverClassName("org.postgresql.Driver");
        config.addDataSourceProperty("maximumPoolSize", 10);
        pool = new HikariDataSource(config);
    }

    @PreDestroy
    public void destroy(){
        pool.close();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public TaskTO createTask(@RequestBody TaskTO task) {
        System.out.println("createTask()");
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{id}", consumes = "application/json")
    public void updateTask(@PathVariable String id,
                           @RequestBody TaskTO task) {
        System.out.println("updateTask()");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") String taskId) {
        System.out.println("deleteTask()");
    }

    /* @ResponseStatus(HttpStatus.OK) */
    @GetMapping(produces = "application/json")
    public List<TaskTO> getAllTasks() {
        System.out.println("getAllTasks()");
        return null;
    }
}
