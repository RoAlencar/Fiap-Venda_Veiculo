package br.com.fiap.app.venda.veiculo.adapter.out.feign;

import br.com.fiap.app.venda.veiculo.application.dto.VeiculoDto;
import br.com.fiap.app.venda.veiculo.application.dto.request.AtualizaStatusVeiculoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Component
@FeignClient(value = "registra-veiculo", url = "https://registra-veiculo-f268b20c9e70.herokuapp.com/api/v1")
public interface RegistraVeiculoClient {

    @GetMapping("/veiculo")
    List<VeiculoDto> buscaTodosVeiculos();

    @PutMapping("/veiculo")
    VeiculoDto atualizaVeiculo(AtualizaStatusVeiculoRequest dto);
}


