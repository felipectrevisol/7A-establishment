package br.com.sev7aura.establishment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    
    @Column(name = "uf")
    private String state;
    
    @Column(name = "cep")
    private String zipCode;

    @Column(name = "numero")
    private String number;

    @Column(name = "municipio")
    private String city;

    @Column(name = "logradouro")
    private String street;
    
    @Column(name = "complemento")
    private String complement;
    
    @Column(name = "bairro")
    private String neighborhood;
    
    public String state() {
        return state;
    }
    
    public String city() {
        return city;
    }
 
    public String number() {
        return number;
    }
    
    public String street() {
        return street;
    }
    
    public String zipCode() {
        return zipCode;
    }
    
    public String complement() {
        return complement;
    }
    
    public String neighborhood() {
        return neighborhood;
    }
    
    private Address() {}
}