package br.com.sev7aura.establishment.task;

import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;

@Service
public class TaskCardAdder {
    
    private final ApplicationEventPublisher publisher;
    
    public TaskCardAdder(final ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void add(final TaskCard task) {
        publisher.publishEvent(task);
    }
}