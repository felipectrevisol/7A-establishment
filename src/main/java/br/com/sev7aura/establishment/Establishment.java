package br.com.sev7aura.establishment;

import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Entity
@Table(name = "estabelecimentos")
public final class Establishment {

    @Embeddable
    public static class Contact {
        private String email;
    
        @Column(name = "telefone")
        private String phone;
    
        @Column(name = "ddd")
        private String areaCode;
        
        public Contact() {}
        
        public String getEmail() {
            return email;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public String getPhone() {
            return phone;
        }
    }

    @Embeddable
    public static class Address {
        
        @Column(name = "cep")
        private char zipCode;
        
        @Column(name = "bairro")
        private String neighborhood;
        
        @Column(name = "complemento")
        private String unitDescription;
        
        @Column(name = "logradouro")
        private String address;
        
        @Column(name = "numero")
        private String number;
        
        public Address() {}
        
        public String getAddress() {
            return address;
        }
        
        public String getNumber() {
            return number;
        }
        
        public String getNeighborhood() {
            return neighborhood;
        }

        public String getUnitDescription() {
            return unitDescription;
        }
        
        public char getZipCode() {
            return zipCode;
        }
    }

    @Embedded
    private Contact contact;

    @Embedded
    private Address address;

    @Column(name = "nome_fantasia")
    private String fantasyName;

    @Id
    @Column(columnDefinition = "binary(16)")
    private UUID id;

    public String getFantasyName() {
        return fantasyName;
    }

    public UUID getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }

    protected Establishment() {}
}