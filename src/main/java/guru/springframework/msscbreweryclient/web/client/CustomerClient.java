package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;


@Component
@ConfigurationProperties(value = "sfg.customer", ignoreUnknownFields = false)
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;

    @Setter
    private String apihost;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID id) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + id, CustomerDto.class);
    }

    public URI createCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID id, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + id, customerDto);
    }

    public void deleteCustomer(UUID id) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + id);
    }
}
