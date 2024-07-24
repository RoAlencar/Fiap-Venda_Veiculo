package br.com.fiap.app.venda.veiculo.application.port;

import br.com.fiap.app.venda.veiculo.application.dto.request.GetStatusPagamentoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.GetStatusPagamentoResponse;
import br.com.fiap.app.venda.veiculo.infrastructure.exception.custom.PagamentoNotFoundException;

public interface GetStatusPagamentoUseCasePort {

    GetStatusPagamentoResponse getStatusPagamento(GetStatusPagamentoRequest codigoPagamento) throws PagamentoNotFoundException;
}
