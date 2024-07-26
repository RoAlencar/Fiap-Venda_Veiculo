package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.application.dto.request.GetStatusPagamentoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.GetStatusPagamentoResponse;
import br.com.fiap.app.venda.veiculo.application.port.VendaClienteRepositoryPort;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import br.com.fiap.app.venda.veiculo.infrastructure.exception.custom.PagamentoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetStatusPagamentoUseCaseTest {

    @MockBean
    private VendaClienteRepositoryPort clienteRepositoryPort;

    private GetStatusPagamentoUseCase getStatusPagamentoUseCase;

    @BeforeEach
    public void setUp() {
        getStatusPagamentoUseCase = new GetStatusPagamentoUseCase(clienteRepositoryPort);
    }

    @Test
    void getStatusPagamento() throws PagamentoNotFoundException {
        GetStatusPagamentoRequest request = new GetStatusPagamentoRequest("Pagamento1234");
        Cliente cliente = new Cliente();
        cliente.setCodigoPagamento("Pagamento1234");
        cliente.setStatusVenda(StatusVendaEnum.CONCLUIDO);
        when(clienteRepositoryPort.findByCodigoPagamento("Pagamento1234")).thenReturn(Optional.of(cliente));

        GetStatusPagamentoResponse response = getStatusPagamentoUseCase.getStatusPagamento(request);

        assertEquals("Pagamento1234", response.getCodigoPagamento());
        assertEquals(StatusVendaEnum.CONCLUIDO, response.getStatusVenda());
    }

    @Test
    void getStatusPagamentoNotFound() throws PagamentoNotFoundException {
        GetStatusPagamentoRequest request = new GetStatusPagamentoRequest("Pagamento1234");
        when(clienteRepositoryPort.findByCodigoPagamento("Pagamento1234")).thenReturn(Optional.empty());

        assertThrows(PagamentoNotFoundException.class, () -> getStatusPagamentoUseCase.getStatusPagamento(request));
    }
}
