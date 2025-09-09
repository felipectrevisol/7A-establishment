package br.com.sev7aura.establishment.task.httpresource;

import br.com.sev7aura.establishment.task.TaskCard;

record HttpBody(String title, int priority) {
    final TaskCard payload() {
        return new TaskCard(title, priority);
    }
}