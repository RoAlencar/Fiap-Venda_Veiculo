package br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo;

import br.com.fiap.app.venda.veiculo.adapter.out.jpa.ClienteJpaRepositoryAdapter;
import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities.ClienteEntity;
import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.repositories.VendaClienteJpaRepository;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteJpaRepositoryAdapterTest {

    @Mock
    private VendaClienteJpaRepository vendaClienteJpaRepository;

    @InjectMocks
    private ClienteJpaRepositoryAdapter clienteJpaRepositoryAdapter;

    @BeforeEach
    void setUp() {
        clienteJpaRepositoryAdapter = new ClienteJpaRepositoryAdapter(vendaClienteJpaRepository);
    }

    @Test
    void buscaTodosQuandoExisteERetornaListaCarros() {
        ClienteEntity cliente = mock(ClienteEntity.class);
        when(vendaClienteJpaRepository.findAll()).thenReturn(List.of(cliente, cliente));
        when(cliente.toDomain()).thenCallRealMethod();

        List<Cliente> resultado = clienteJpaRepositoryAdapter.findAll();

        assertEquals(2, resultado.size());
    }

    @Test
    void buscaTodosQuandoExisteERetornaListaVazia() {
        when(vendaClienteJpaRepository.findAll()).thenReturn(List.of());
        List<Cliente> resultado = clienteJpaRepositoryAdapter.findAll();
        assertTrue(resultado.isEmpty());
    }

    @Test
    void buscaVendasCliente() {
        Long veiculoId = 1L;
        ClienteEntity cliente = mock(ClienteEntity.class);
        when(vendaClienteJpaRepository.findByidVeiculo(veiculoId)).thenReturn(Optional.of(cliente));
        when(cliente.toDomain()).thenCallRealMethod();

        Optional<Cliente> resultado = clienteJpaRepositoryAdapter.findByIdVeiculo(veiculoId);
        assertTrue(resultado.isPresent());
    }

    @Test
    void buscaVeiculoQuandoNãoexisteERetronaVazio() {
        Long veiculoId = 1L;
        when(vendaClienteJpaRepository.findByidVeiculo(veiculoId)).thenReturn(Optional.empty());
        Optional<Cliente> resultado = clienteJpaRepositoryAdapter.findByIdVeiculo(veiculoId);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void buscaCodigoPagamento() {
        String codigo = "12345";
        ClienteEntity cliente = mock(ClienteEntity.class);
        when(vendaClienteJpaRepository.findByCodigoPagamento(codigo)).thenReturn(Optional.of(cliente));
        when(cliente.toDomain()).thenCallRealMethod();

        Optional<Cliente> resultado = clienteJpaRepositoryAdapter.findByCodigoPagamento(codigo);

        assertTrue(resultado.isPresent());
    }

    @Test
    void buscaCodigoPagamentoVazio() {
        String codigo = "12345";
        when(vendaClienteJpaRepository.findByCodigoPagamento(codigo)).thenReturn(Optional.empty());

        Optional<Cliente> resultado = clienteJpaRepositoryAdapter.findByCodigoPagamento(codigo);

        assertTrue(resultado.isEmpty());
    }


    @Test
    void salvaERetornaCliente() {
        Cliente cliente = mock(Cliente.class);
        ClienteEntity clienteEntity = mock(ClienteEntity.class);
        when(cliente.toEntity()).thenReturn(clienteEntity);
        when(vendaClienteJpaRepository.save(clienteEntity)).thenReturn(clienteEntity);
        when(clienteEntity.toDomain()).thenReturn(cliente);

        Cliente resultado = clienteJpaRepositoryAdapter.save(cliente);

        assertEquals(cliente, resultado);
    }
}
