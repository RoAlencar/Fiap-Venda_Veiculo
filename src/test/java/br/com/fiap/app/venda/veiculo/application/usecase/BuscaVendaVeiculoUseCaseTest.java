package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.adapter.out.feign.RegistraVeiculoClient;
import br.com.fiap.app.venda.veiculo.application.dto.VeiculoDto;
import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaStatusVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaVendaClienteResponse;
import br.com.fiap.app.venda.veiculo.utils.ClienteTestUtils;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BuscaVendaVeiculoUseCaseTest {

    @MockBean
    private RegistraVeiculoClient registraVeiculoClient;

    @MockBean
    private ModelMapper modelMapper;

    private BuscaVendaVeiculoUseCase buscaVendaVeiculoUseCase;

    @BeforeEach
    void setUp(){
        buscaVendaVeiculoUseCase = new BuscaVendaVeiculoUseCase(registraVeiculoClient, modelMapper);
    }

    @Test
    void buscaVeiculoPorMenorPrecoDisponivel() throws Exception {
        VeiculoDto veiculodto = ClienteTestUtils.gerarVeiculoDtoDisponivel();
        List<VeiculoDto> veiculos = Arrays.asList(veiculodto);
        when(registraVeiculoClient.buscaTodosVeiculos()).thenReturn(veiculos);
        when(modelMapper.map(any(VeiculoDto.class),eq(BuscaStatusVeiculoResponse.class)))
                .thenAnswer(invocation -> new BuscaStatusVeiculoResponse((invocation.getArgument(0))));

        List<BuscaStatusVeiculoResponse> response = buscaVendaVeiculoUseCase.buscaVeiculosAVendaPorMenorPreco();

        assertEquals(1, response.size());
        assertEquals(1L, response.get(0).getId());
    }

    @Test
    void buscaVeiculoPorMenorPrecoListaVazia() throws Exception {
        when(registraVeiculoClient.buscaTodosVeiculos()).thenReturn(Arrays.asList());

        List<BuscaStatusVeiculoResponse> response = buscaVendaVeiculoUseCase.buscaVeiculosAVendaPorMenorPreco();

        assertTrue(response.isEmpty());
    }

    @Test
    void buscaVeiculoVendidoPorMenorPreco() {
        VeiculoDto veiculodto = ClienteTestUtils.gerarVeiculoDtoIndisponivel();
        List<VeiculoDto> veiculos = Arrays.asList(veiculodto);
        when(registraVeiculoClient.buscaTodosVeiculos()).thenReturn(veiculos);
        when(modelMapper.map(any(VeiculoDto.class),eq(BuscaStatusVeiculoResponse.class)))
                .thenAnswer(invocation -> new BuscaStatusVeiculoResponse((invocation.getArgument(0))));

        List<BuscaStatusVeiculoResponse> response = buscaVendaVeiculoUseCase.buscaVeiculosVendidosPorMenorPreco();

        assertEquals(1, response.size());
        assertEquals(1L, response.get(0).getId());
    }

    @Test
    void buscaVeiculoVendidoPorMenorPrecoListaVazia() {
        when(registraVeiculoClient.buscaTodosVeiculos()).thenReturn(Arrays.asList());

        List<BuscaStatusVeiculoResponse> response = buscaVendaVeiculoUseCase.buscaVeiculosVendidosPorMenorPreco();

        assertTrue(response.isEmpty());
    }

}
