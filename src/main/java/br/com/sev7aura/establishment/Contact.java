package br.com.sev7aura.establishment;

import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "contatos")
public final class Contact {

    @Column(name = "numero")
    private String phone;
    
    @Column(name = "ddd")
    private String areaCode;

    @ManyToOne
    @JoinColumn(name = "estabelecimento")
    private Establishment establishment;

    @Id
    @Column(columnDefinition = "binary(16)") private UUID id;
    
    public String phone() {
        return phone;
    }

    public String areaCode() {
        return areaCode;
    }

    private Contact() {}
}