package br.com.sev7aura.establishment.task;

import org.springframework.context.ApplicationEvent;

public class TaskCard extends ApplicationEvent implements Comparable<TaskCard> {

    private boolean completed;
    private final String title;
    private final int priority;

    public String title() {
        return title;
    }

    public int priority() {
        return priority;
    }

    public void done() {
        this.completed = true;
    }

    public boolean isDone() {
        return completed;
    }

    public TaskCard(final String title, final int priority) {
        super(TaskCard.class);
        this.title = title;
        this.priority = priority;
    }

    @Override
    public int compareTo(final TaskCard otherCard) {
        return Integer.compare(this.priority, otherCard.priority);
    }
}