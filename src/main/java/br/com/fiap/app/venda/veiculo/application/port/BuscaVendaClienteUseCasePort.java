package br.com.fiap.app.venda.veiculo.application.port;

import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaVendaClienteResponse;

import java.util.List;

public interface BuscaVendaClienteUseCasePort {

    List<BuscaVendaClienteResponse> buscaTodasVendasCliente();
}
