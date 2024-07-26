package br.com.fiap.app.venda.veiculo.domain;

import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities.ClienteEntity;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import br.com.fiap.app.venda.veiculo.utils.ClienteTestUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ClienteTest {

    @Test
    void setCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdVenda(1L);
        cliente.setIdVeiculo(1L);
        cliente.setCpfCliente("String");
        cliente.setCodigoPagamento("1qazxssw2");
        cliente.setDataVenda(new Date());
        cliente.setStatusVenda(StatusVendaEnum.CONCLUIDO);

        assertThat(cliente.getIdVenda()).isEqualTo(1L);
        assertThat(cliente.getIdVeiculo()).isEqualTo(1L);
        assertThat(cliente.getCpfCliente()).isEqualTo("String");
        assertThat(cliente.getCodigoPagamento()).isEqualTo("1qazxssw2");
        assertThat(cliente.getDataVenda()).isNotNull();
        assertThat(cliente.getStatusVenda()).isEqualTo(StatusVendaEnum.CONCLUIDO);

    }

    @Test
    void clienteBuilder() {
        Long idVenda = 1L;
        Long idVeiculo = 1L;
        String cpfCliente = "12345678";
        StatusVendaEnum statusVenda = StatusVendaEnum.CONCLUIDO;
        String codigoPagamento = "1qazxsw2";
        Date dataVenda = new Date(1630440000000L);

        Cliente cliente = ClienteTestUtils.gerarCliente();

        assertThat(cliente.getIdVenda()).isEqualTo(idVenda);
        assertThat(cliente.getIdVeiculo()).isEqualTo(idVeiculo);
        assertThat(cliente.getCpfCliente()).isEqualTo(cpfCliente);
        assertThat(cliente.getCodigoPagamento()).isEqualTo(codigoPagamento);
        assertThat(cliente.getDataVenda()).isEqualTo(dataVenda);
        assertThat(cliente.getStatusVenda()).isEqualTo(statusVenda);
    }

    @Test
    void testToEntity() {
        // Dado
        Cliente cliente = Cliente.builder()
                .idVenda(1L)
                .idVeiculo(2L)
                .cpfCliente("12345678900")
                .statusVenda(StatusVendaEnum.CONCLUIDO)
                .codigoPagamento("ABC123")
                .dataVenda(new Date(1630440000000L))
                .build();

        // Quando
        ClienteEntity clienteEntity = cliente.toEntity();

        // Então
        assertThat(clienteEntity).isNotNull();
        assertThat(clienteEntity.getIdVenda()).isEqualTo(cliente.getIdVenda());
        assertThat(clienteEntity.getIdVeiculo()).isEqualTo(cliente.getIdVeiculo());
        assertThat(clienteEntity.getCpfCliente()).isEqualTo(cliente.getCpfCliente());
        assertThat(clienteEntity.getStatusVenda()).isEqualTo(cliente.getStatusVenda());
        assertThat(clienteEntity.getCodigoPagamento()).isEqualTo(cliente.getCodigoPagamento());
        assertThat(clienteEntity.getDataVenda()).isEqualTo(cliente.getDataVenda());
    }

    @Test
    void testClienteCopyConstructor() {
        // Dado
        Cliente originalCliente = Cliente.builder()
                .idVenda(1L)
                .idVeiculo(2L)
                .cpfCliente("12345678900")
                .statusVenda(StatusVendaEnum.CONCLUIDO)
                .codigoPagamento("ABC123")
                .dataVenda(new Date(1630440000000L))
                .build();

        // Quando
        Cliente copiedCliente = new Cliente(originalCliente);

        // Então
        assertThat(copiedCliente).isNotNull();
        assertThat(copiedCliente.getIdVenda()).isEqualTo(originalCliente.getIdVenda());
        assertThat(copiedCliente.getIdVeiculo()).isEqualTo(originalCliente.getIdVeiculo());
        assertThat(copiedCliente.getCpfCliente()).isEqualTo(originalCliente.getCpfCliente());
        assertThat(copiedCliente.getStatusVenda()).isEqualTo(originalCliente.getStatusVenda());
        assertThat(copiedCliente.getCodigoPagamento()).isEqualTo(originalCliente.getCodigoPagamento());
        assertThat(copiedCliente.getDataVenda()).isEqualTo(originalCliente.getDataVenda());
    }
}
