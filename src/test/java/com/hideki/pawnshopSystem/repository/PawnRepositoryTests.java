package com.hideki.pawnshopSystem.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PawnRepositoryTests {

    @Autowired
    private PawnRepository pawnRepository;

    @Test
    public void shouldReturnLatestPawnTicketID_whenMethodCalled(){
        pawnRepository.findLatestPawnTicketID();

    }
}
