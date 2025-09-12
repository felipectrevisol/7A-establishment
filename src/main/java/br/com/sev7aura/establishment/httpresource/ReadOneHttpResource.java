package br.com.sev7aura.establishment.httpresource;

import org.springframework.web.bind.annotation.GetMapping;
import br.com.sev7aura.establishment.DaoEstablishmentTable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/establishment")
public class ReadOneHttpResource {
    
    private final DaoEstablishmentTable dao;

    @GetMapping
    public HttpBody get() {
        var establishment = dao.findOneByFantasyName("DROPSPORTS");

        return HttpBody.builder()
            .id(establishment.id())
            .city(establishment.address().city())
            .state(establishment.address().state())
            .fantasyName(establishment.fantasyName())
            .street(establishment.address().street())
            .number(establishment.address().number())
            .zipCode(establishment.address().zipCode())
            .complement(establishment.address().complement())
            .neighborhood(establishment.address().neighborhood())
            .contacts(establishment.contacts().stream().map(contact -> new ContactHttpBodyPart(contact.phone(), contact.areaCode())).toList())
            .digitalContacts(establishment.digitalContacts().stream().map(digitalContact -> new DigitalContactHttpBodyPart(digitalContact.isWhatsApp(), digitalContact.phone(), digitalContact.areaCode(), digitalContact.email())).toList())
            .build();
    }

    public ReadOneHttpResource(final DaoEstablishmentTable dao) {
        this.dao = dao;
    }
}