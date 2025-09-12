package br.com.sev7aura.establishment.task.httpresource;

import java.util.List;
import br.com.sev7aura.establishment.DaoEstablishmentTable;
import br.com.sev7aura.establishment.Establishment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/establishment")
public class ReadTaskCardsHttpResource {
    
    private final DaoEstablishmentTable dao;

    public ReadTaskCardsHttpResource(final DaoEstablishmentTable dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Establishment> get() {
        return dao.findByFantasyName("DROPSPORTS");
    }
}