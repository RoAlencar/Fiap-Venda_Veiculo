package br.com.fiap.app.venda.veiculo.application.port;

import br.com.fiap.app.venda.veiculo.application.dto.request.ReservaVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.request.VenderVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.ReservaVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.VenderVeiculoResponse;

public interface VendaVeiculoUseCasePort {

    VenderVeiculoResponse vendaVeiculo(VenderVeiculoRequest request);
    ReservaVeiculoResponse reservaVeiculo(ReservaVeiculoRequest request);
}
