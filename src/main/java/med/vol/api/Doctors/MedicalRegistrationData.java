package med.vol.api.Doctors;

import med.vol.api.Address.Address;

public record MedicalRegistrationData(String name, String email, String crm, Specialty specialty, Address address) {

}

// o Record é um recurso que permite representar uma classe imutável, contendo
// apenas atributos, construtor e métodos de leitura, de uma maneira muito
// simples e enxuta
