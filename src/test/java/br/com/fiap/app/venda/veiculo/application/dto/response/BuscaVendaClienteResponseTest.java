package br.com.fiap.app.venda.veiculo.application.dto.response;

import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuscaVendaClienteResponseTest {

    private BuscaVendaClienteResponse vendaClienteResponse;

    @BeforeEach
    public void setUp() {
        vendaClienteResponse = new BuscaVendaClienteResponse(1L, 2L, "12345678900",
                StatusVendaEnum.CONCLUIDO, "ABC123", new Date(1630440000000L));
    }

    @Test
    public void testGetters() {
        assertEquals(1L, vendaClienteResponse.getIdVenda());
        assertEquals(2L, vendaClienteResponse.getIdVeiculo());
        assertEquals("12345678900", vendaClienteResponse.getCpfCliente());
        assertEquals(StatusVendaEnum.CONCLUIDO, vendaClienteResponse.getStatusVenda());
        assertEquals("ABC123", vendaClienteResponse.getCodigoPagamento());
        assertEquals(new Date(1630440000000L), vendaClienteResponse.getDataVenda());
    }

    @Test
    public void testSetters() {
        vendaClienteResponse.setIdVenda(3L);
        vendaClienteResponse.setIdVeiculo(4L);
        vendaClienteResponse.setCpfCliente("98765432100");
        vendaClienteResponse.setStatusVenda(StatusVendaEnum.CANCELADO);
        vendaClienteResponse.setCodigoPagamento("XYZ456");
        Date newDataVenda = new Date();
        vendaClienteResponse.setDataVenda(newDataVenda);

        assertEquals(3L, vendaClienteResponse.getIdVenda());
        assertEquals(4L, vendaClienteResponse.getIdVeiculo());
        assertEquals("98765432100", vendaClienteResponse.getCpfCliente());
        assertEquals(StatusVendaEnum.CANCELADO, vendaClienteResponse.getStatusVenda());
        assertEquals("XYZ456", vendaClienteResponse.getCodigoPagamento());
        assertEquals(newDataVenda, vendaClienteResponse.getDataVenda());
    }

    @Test
    public void testBuilder() {
        BuscaVendaClienteResponse response = BuscaVendaClienteResponse.builder()
                .idVenda(5L)
                .idVeiculo(6L)
                .cpfCliente("11122233344")
                .statusVenda(StatusVendaEnum.PENDENTE)
                .codigoPagamento("DEF789")
                .dataVenda(new Date())
                .build();

        assertEquals(5L, response.getIdVenda());
        assertEquals(6L, response.getIdVeiculo());
        assertEquals("11122233344", response.getCpfCliente());
        assertEquals(StatusVendaEnum.PENDENTE, response.getStatusVenda());
        assertEquals("DEF789", response.getCodigoPagamento());
        assertEquals(new Date(), response.getDataVenda());
    }
}
