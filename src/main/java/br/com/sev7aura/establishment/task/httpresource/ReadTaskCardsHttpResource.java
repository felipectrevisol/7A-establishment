package br.com.sev7aura.establishment.task.httpresource;

import java.util.List;
import br.com.sev7aura.establishment.task.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
public class ReadTaskCardsHttpResource {
    
    private final Repository tasks;

    public ReadTaskCardsHttpResource(final Repository tasks) {
        this.tasks = tasks;
    }

    @GetMapping
    public List<HttpBody> get() {
        var task = tasks.all().iterator().next();
        return List.of(new HttpBody(task.title(), task.priority()));
    }
}