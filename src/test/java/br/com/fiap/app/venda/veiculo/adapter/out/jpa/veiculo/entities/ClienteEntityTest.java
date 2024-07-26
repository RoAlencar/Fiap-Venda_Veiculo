package br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities;

import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import br.com.fiap.app.venda.veiculo.utils.ClienteTestUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClienteEntityTest {

    @Test
    void setClienteEntity() {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setIdVenda(1L);
        cliente.setIdVeiculo(1L);
        cliente.setCpfCliente("12345678");
        cliente.setStatusVenda(StatusVendaEnum.CONCLUIDO);
        cliente.setCodigoPagamento("1qazxsw2");
        cliente.setDataVenda(new Date());

        assertThat(cliente.getIdVenda()).isEqualTo(1L);
        assertThat(cliente.getIdVeiculo()).isEqualTo(1L);
        assertThat(cliente.getCpfCliente()).isEqualTo("12345678");
        assertThat(cliente.getStatusVenda()).isEqualTo(StatusVendaEnum.CONCLUIDO);
        assertThat(cliente.getCodigoPagamento()).isEqualTo("1qazxsw2");
        assertThat(cliente.getDataVenda()).isNotNull();
    }

    void setClienteEntityBuilder() {
        Long idVenda = 1L;
        Long idVeiculo = 1L;
        String cpfCliente = "12345678";
        StatusVendaEnum statusVenda = StatusVendaEnum.CONCLUIDO;
        String codigoPagamento = "1qazxsw2";
        Date dataVenda = new Date(1630440000000L);

        ClienteEntity cliente = ClienteTestUtils.gerarClienteEntity();

        assertThat(cliente.getIdVenda()).isEqualTo(idVenda);
        assertThat(cliente.getIdVeiculo()).isEqualTo(idVeiculo);
        assertThat(cliente.getCpfCliente()).isEqualTo(cpfCliente);
        assertThat(cliente.getStatusVenda()).isEqualTo(statusVenda);
        assertThat(cliente.getCodigoPagamento()).isEqualTo(codigoPagamento);
        assertThat(cliente.getDataVenda()).isEqualTo(dataVenda);
    }
}
