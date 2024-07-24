package br.com.fiap.app.venda.veiculo.application.port;

import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaStatusVeiculoResponse;

import java.util.List;

public interface BuscaVendaVeiculoUseCasePort {

    List<BuscaStatusVeiculoResponse> buscaVeiculosAVendaPorMenorPreco() throws Exception;
    List<BuscaStatusVeiculoResponse> buscaVeiculosVendidosPorMenorPreco();
}
