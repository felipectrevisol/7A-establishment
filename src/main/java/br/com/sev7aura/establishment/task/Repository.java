package br.com.sev7aura.establishment.task;

import java.util.Set;
import org.springframework.stereotype.Component;
import br.com.sev7aura.establishment.Establishment;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@Component
public class Repository {
 
    private Establishment establishment;

    @Async
    @EventListener
    public void add(final TaskCard task) {
        // establishment.add(task);
    }

    public Set<TaskCard> all() {
        // return establishment.tasks();
        return null;
    }
}