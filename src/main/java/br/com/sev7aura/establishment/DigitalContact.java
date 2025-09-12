package br.com.sev7aura.establishment;

import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "contatos_digitais")
public final class DigitalContact {

    @Column(name = "email")
    private String email;

    @Column(name = "ddd")
    private String areaCode;

    @Column(name = "numero")
    private String phone;

    @Column(name = "whatsapp")
    private boolean isWhatsApp;

    @ManyToOne
    @JoinColumn(name = "estabelecimento")
    private Establishment establishment;

    @Id
    @Column(columnDefinition = "binary(16)") private UUID id;

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public String areaCode() {
        return areaCode;
    }

    public boolean isWhatsApp() {
        return isWhatsApp;
    }

    private DigitalContact() {}
}