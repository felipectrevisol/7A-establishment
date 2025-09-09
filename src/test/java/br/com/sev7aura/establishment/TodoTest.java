package br.com.sev7aura.establishment;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import br.com.sev7aura.establishment.task.TaskCard;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    
    private static final int A_PRIORITY = 1;
    private static final int HIGH_PRIORITY = 0;
    private static final String TITLE = "A Card Title.";

    @Test void addTaskCardsInHightOrder() {
        final Establishment establishment = new Establishment();
        establishment.add(new TaskCard(TITLE, A_PRIORITY));
        establishment.add(new TaskCard(TITLE, HIGH_PRIORITY));

        final Iterator<TaskCard> iterator = establishment.tasks().iterator();
        final TaskCard card = iterator.next();
        {
            assertEquals(TITLE, card.title());
            assertEquals(HIGH_PRIORITY, card.priority());
            assertEquals(2, establishment.tasks().size());
            assertEquals(A_PRIORITY, iterator.next().priority());
        }
    }
}