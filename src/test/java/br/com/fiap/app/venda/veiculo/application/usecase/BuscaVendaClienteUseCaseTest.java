package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaVendaClienteResponse;
import br.com.fiap.app.venda.veiculo.application.port.VendaClienteRepositoryPort;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.utils.ClienteTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class BuscaVendaClienteUseCaseTest {

    @Mock
    private VendaClienteRepositoryPort vendaCliente;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    private BuscaVendaClienteUseCase buscaVendaCliente;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void buscaVendaClienteComSucesso() {
        Cliente cliente = ClienteTestUtils.gerarCliente();
        List<Cliente> clientes = Arrays.asList(cliente);
        BuscaVendaClienteResponse response = ClienteTestUtils.gerarBuscaVendaResponse();

        when(vendaCliente.findAll()).thenReturn(clientes);
        when(modelMapper.map(cliente, BuscaVendaClienteResponse.class)).thenReturn(response);

        List<BuscaVendaClienteResponse> responses = buscaVendaCliente.buscaTodasVendasCliente();

        assertEquals(1, responses.size());
        verify(vendaCliente).findAll();
        verify(modelMapper, times(1)).map(any(Cliente.class), eq(BuscaVendaClienteResponse.class));
    }

    @Test
    void buscaVendaClienteComErro() {
        when(vendaCliente.findAll()).thenReturn(Arrays.asList());

        List<BuscaVendaClienteResponse> responses = buscaVendaCliente.buscaTodasVendasCliente();

        assertEquals(0, responses.size());
        verify(vendaCliente).findAll();
    }


}
