package me.app.customers.service;

import me.app.customers.domain.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente HTTP, cliado via OpenFeign para o consumo da API do ViaCEP
 *
 * @See <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud
 *      Feign</a>
 * @See <a href="https://viacep.com.br">ViaCEP</a>
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

        @GetMapping("/{cep}/json/")
        Address getCep(@PathVariable("cep") String cep);

}
