package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.adapter.out.feign.RegistraVeiculoClient;
import br.com.fiap.app.venda.veiculo.application.dto.request.ReservaVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.request.VenderVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.ReservaVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.VenderVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.port.VendaClienteRepositoryPort;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import br.com.fiap.app.venda.veiculo.utils.ClienteTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VendaVeiculoUseCaseTest {

    @MockBean
    private RegistraVeiculoClient registraVeiculoClient;

    @MockBean
    private VendaClienteRepositoryPort vendaClienteRepositoryPort;

    @MockBean
    private ModelMapper modelMapper;

    private VendaVeiculoUseCase vendaVeiculoUseCase;

    @BeforeEach
    void setUp() {
        vendaVeiculoUseCase = new VendaVeiculoUseCase(registraVeiculoClient, vendaClienteRepositoryPort, modelMapper);
    }

    @Test
    void vendeVeiculoAtualizaStatusECriaVendaCompleta(){
        VenderVeiculoRequest request = ClienteTestUtils.gerarVenderVeiculoRequest();
        Cliente cliente = ClienteTestUtils.gerarCliente();
        VenderVeiculoResponse responseEsperado = ClienteTestUtils.gerarVenderVeiculoResponse();

        when(vendaClienteRepositoryPort.findByIdVeiculo(1L)).thenReturn(Optional.empty());
        when(vendaClienteRepositoryPort.save(any(Cliente.class))).thenReturn(cliente);
        when(modelMapper.map(any(Cliente.class), eq(VenderVeiculoResponse.class))).thenReturn(responseEsperado);

        VenderVeiculoResponse response = vendaVeiculoUseCase.vendaVeiculo(request);

        assertEquals(StatusVendaEnum.CONCLUIDO,response.getStatusVenda());
        verify(registraVeiculoClient).atualizaVeiculo(any());
    }

    @Test
    void vendeVeiculoAtualizaStatusECriaReserva(){
        ReservaVeiculoRequest request = ClienteTestUtils.gerarReservaVeiculoRequest();
        Cliente cliente = ClienteTestUtils.gerarCliente();
        ReservaVeiculoResponse responseEsperado = ClienteTestUtils.gerarReservaVeiculoResponse();

        when(vendaClienteRepositoryPort.findByIdVeiculo(1L)).thenReturn(Optional.empty());
        when(vendaClienteRepositoryPort.save(any(Cliente.class))).thenReturn(cliente);
        when(modelMapper.map(any(Cliente.class), eq(ReservaVeiculoResponse.class))).thenReturn(responseEsperado);

        ReservaVeiculoResponse response = vendaVeiculoUseCase.reservaVeiculo(request);

        assertEquals(StatusVendaEnum.PENDENTE,response.getStatusVenda());
        verify(registraVeiculoClient).atualizaVeiculo(any());
    }
}
