package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testCreateBeer() {
        //given
        var newBeer = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.createBeer(newBeer);

        assertNotNull(uri);
    }

    @Test
    void testUpdateUser() {
        var beerToUpdate = BeerDto.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(), beerToUpdate);
    }

    @Test
    void testDeleteUser() {
        client.deleteBeer(UUID.randomUUID());
    }
}