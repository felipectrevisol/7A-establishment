package br.com.sev7aura.establishment.httpresource;

import java.util.UUID;
import lombok.Builder;

@Builder
record HttpBody(UUID id, String fantasyName, String street, String number, String complement, String neighborhood,
        String zipCode, String state, String city) {

}