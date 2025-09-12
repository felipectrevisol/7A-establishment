package br.com.sev7aura.establishment;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "estabelecimentos")
public final class Establishment {

    @Embedded
    private Address address;

    @Column(name = "nome_fantasia")
    private String fantasyName;
    
    @OneToMany(mappedBy = "establishment")
    private List<Contact> contacts;
    
    @OneToMany(mappedBy = "establishment")
    private List<DigitalContact> digitalContact;
    
    @Id
    @Column(columnDefinition = "binary(16)") private UUID id;

    public UUID id() {
        return id;
    }

    public Address address() {
        return address;
    }

    public String fantasyName() {
        return fantasyName;
    }

    public List<Contact> contacts() {
        return contacts;
    }

    public List<DigitalContact> digitalContact() {
        return digitalContact;
    }

    protected Establishment() {}
}