package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testCreateCustomer() {
        //given
        var newCustomer = CustomerDto.builder().name("New Customer").build();

        URI uri = client.createCustomer(newCustomer);

        assertNotNull(uri);
    }

    @Test
    void testUpdateUser() {
        var customerToUpdate = CustomerDto.builder().name("New Customer").build();

        client.updateCustomer(UUID.randomUUID(), customerToUpdate);
    }

    @Test
    void testDeleteUser() {
        client.deleteCustomer(UUID.randomUUID());
    }
}