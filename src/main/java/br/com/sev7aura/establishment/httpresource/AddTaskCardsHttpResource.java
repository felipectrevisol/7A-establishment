package br.com.sev7aura.establishment.httpresource;

import org.springframework.http.HttpStatus;
import br.com.sev7aura.establishment.task.TaskCardAdder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
public class AddTaskCardsHttpResource {

    private TaskCardAdder adder;

    public AddTaskCardsHttpResource(final TaskCardAdder adder) {
        this.adder = adder;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody HttpBody httpBody) {
        // this.adder.add(httpBody.payload());
    }
}