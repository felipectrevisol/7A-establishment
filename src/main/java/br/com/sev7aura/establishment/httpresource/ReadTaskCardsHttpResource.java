package br.com.sev7aura.establishment.httpresource;

import br.com.sev7aura.establishment.Establishment;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.sev7aura.establishment.DaoEstablishmentTable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/establishment")
public class ReadTaskCardsHttpResource {
    
    private final DaoEstablishmentTable dao;

    @GetMapping
    public HttpBody get() {
        var establishments = dao.findByFantasyName("DROPSPORTS");
        final Establishment establishment = establishments.get(0);

        return HttpBody.builder()
            .id(establishment.id())
            .city(establishment.address().city())
            .state(establishment.address().state())
            .fantasyName(establishment.fantasyName())
            .street(establishment.address().street())
            .number(establishment.address().number())
            .zipCode(establishment.address().zipCode())
            .complement(establishment.address().complement())
            .neighborhood(establishment.address().neighborhood()).build();
    }

    public ReadTaskCardsHttpResource(final DaoEstablishmentTable dao) {
        this.dao = dao;
    }
}