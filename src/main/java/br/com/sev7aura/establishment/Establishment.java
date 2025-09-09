package br.com.sev7aura.establishment;

import java.util.Set;
import java.util.TreeSet;
import br.com.sev7aura.establishment.task.TaskCard;

public final class Establishment {

    private final Set<TaskCard> cards = new TreeSet<>();

    public Set<TaskCard> tasks() {
        return Set.copyOf(cards);
    }

    public void add(final TaskCard card) {
        cards.add(card);
    }
}