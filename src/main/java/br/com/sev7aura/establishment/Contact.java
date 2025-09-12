package br.com.sev7aura.establishment;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "contatos")
public final class Contact {

    @Column(name = "telefone")
    private String phone;
    
    @Column(name = "ddd")
    private String areaCode;

    @ManyToOne
    @JoinColumn(name = "estabelecimento")
    private Establishment establishment;

    @Embedded
    private Address address;
    
    public String areaCode() {
        return areaCode;
    }
    
    public String phone() {
        return phone;
    }

    private Contact() {}
}