package br.com.guisfco.onlineshopping.fixture;

import br.com.guisfco.onlineshopping.domain.CustomerRequest;
import com.google.common.collect.ImmutableList;

import java.time.Instant;
import java.util.List;

import static br.com.guisfco.onlineshopping.util.RandomUtils.nextInt;

public class CustomerRequestFixture {

    private final List<String> names = ImmutableList.of(
            "Ana",
            "Eduarda",
            "Fernanda",
            "Guilherme",
            "João",
            "Jéssica",
            "Larissa",
            "Leonardo",
            "Pedro",
            "Rodrigo"
    );

    private final CustomerRequest fixture = new CustomerRequest();

    public static CustomerRequestFixture get() {
        return new CustomerRequestFixture();
    }

    public CustomerRequest build() {
        return fixture;
    }

    public CustomerRequestFixture random() {

        fixture.setBlacklist(false);
        fixture.setName(names.get(nextInt(0, names.size())));
        fixture.setBirthDateInMillis(Instant.now().toEpochMilli());
        fixture.setPhoneNumber("(99) 9 9999-9999");

        return this;
    }
}
