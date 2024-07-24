package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.application.dto.request.GetStatusPagamentoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.GetStatusPagamentoResponse;
import br.com.fiap.app.venda.veiculo.application.port.GetStatusPagamentoUseCasePort;
import br.com.fiap.app.venda.veiculo.application.port.VendaClienteRepositoryPort;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.infrastructure.exception.custom.PagamentoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStatusPagamentoUseCase implements GetStatusPagamentoUseCasePort {

    private final VendaClienteRepositoryPort vendaClienteRepositoryPort;

    @Override
    public GetStatusPagamentoResponse getStatusPagamento(GetStatusPagamentoRequest request) throws PagamentoNotFoundException {
       Cliente cliente = vendaClienteRepositoryPort.findByCodigoPagamento(request.getCodigoPagamento())
               .orElseThrow(() -> new PagamentoNotFoundException());
       return GetStatusPagamentoResponse.builder().codigoPagamento(cliente.getCodigoPagamento()).statusVenda(cliente.getStatusVenda()).build();
    }
}
