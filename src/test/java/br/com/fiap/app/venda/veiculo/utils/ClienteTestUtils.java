package br.com.fiap.app.venda.veiculo.utils;

import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities.ClienteEntity;
import br.com.fiap.app.venda.veiculo.application.dto.VeiculoBaseRequest;
import br.com.fiap.app.venda.veiculo.application.dto.VeiculoDto;
import br.com.fiap.app.venda.veiculo.application.dto.request.ReservaVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.request.VenderVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaVendaClienteResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.ReservaVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.VenderVeiculoResponse;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.domain.enums.NumeroPortasEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVeiculoEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.TipoCombustivelEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.TipoVeiculoEnum;

import java.math.BigDecimal;
import java.util.Date;

public class ClienteTestUtils {

    private ClienteTestUtils() {}

    public static Cliente gerarCliente() {
        return Cliente.builder()
                .idVenda(1L)
                .idVeiculo(1L)
                .cpfCliente("12345678")
                .dataVenda(new Date(1630440000000L))
                .codigoPagamento("1qazxsw2")
                .statusVenda(StatusVendaEnum.CONCLUIDO)
                .build();
    }

    public static ReservaVeiculoRequest gerarReservaVeiculoRequest() {
        return new ReservaVeiculoRequest(VeiculoBaseRequest.builder().idVeiculo(1L).cpfCliente("0987654321").build());
    }

    public static VenderVeiculoRequest gerarVenderVeiculoRequest() {
        return new VenderVeiculoRequest(VeiculoBaseRequest.builder().idVeiculo(1L).cpfCliente("0987654321").build());
    }

    public static VenderVeiculoResponse gerarVenderVeiculoResponse() {
        return VenderVeiculoResponse.builder()
                .idVenda(1L)
                .idVeiculo(1L)
                .cpfCliente("String")
                .dataVenda(new Date(1630440000000L))
                .codigoPagamento("String")
                .statusVenda(StatusVendaEnum.CONCLUIDO)
                .build();
    }

    public static ReservaVeiculoResponse gerarReservaVeiculoResponse() {
        return ReservaVeiculoResponse.builder()
                .idVenda(1L)
                .idVeiculo(1L)
                .cpfCliente("String")
                .dataVenda(new Date(1630440000000L))
                .codigoPagamento("String")
                .statusVenda(StatusVendaEnum.PENDENTE)
                .build();
    }

    public static ClienteEntity gerarClienteEntity(){
        return ClienteEntity.builder()
                .idVenda(1L)
                .idVeiculo(1L)
                .cpfCliente("12345678")
                .statusVenda(StatusVendaEnum.CONCLUIDO)
                .codigoPagamento("1qazxsw2")
                .dataVenda(new Date(1630440000000L))
                .build();
    }

    public static VeiculoDto gerarVeiculoDtoDisponivel(){
        return VeiculoDto.builder()
                .id(1L)
                .marca("String")
                .modelo("String")
                .ano(1999)
                .cor("String")
                .preco(BigDecimal.valueOf(10000))
                .tipo(TipoVeiculoEnum.HATCH)
                .quilometragem(1000000)
                .tipoCombustivel(TipoCombustivelEnum.GASOLINA)
                .numeroPortas(NumeroPortasEnum.QUATRO)
                .placa("123456")
                .descricao("String")
                .status(StatusVeiculoEnum.DISPONIVEL)
                .dataCadastro(new Date(1630440000000L))
                .build();
    }

    public static VeiculoDto gerarVeiculoDtoIndisponivel(){
        return VeiculoDto.builder()
                .id(1L)
                .marca("String")
                .modelo("String")
                .ano(1999)
                .cor("String")
                .preco(BigDecimal.valueOf(10000))
                .tipo(TipoVeiculoEnum.HATCH)
                .quilometragem(1000000)
                .tipoCombustivel(TipoCombustivelEnum.GASOLINA)
                .numeroPortas(NumeroPortasEnum.QUATRO)
                .placa("123456")
                .descricao("String")
                .status(StatusVeiculoEnum.VENDIDO)
                .dataCadastro(new Date(1630440000000L))
                .build();
    }

    public static BuscaVendaClienteResponse gerarBuscaVendaResponse() {
        return BuscaVendaClienteResponse.builder()
                .idVenda(1L)
                .idVeiculo(1L)
                .cpfCliente("String")
                .dataVenda(new Date())
                .codigoPagamento("String")
                .statusVenda(StatusVendaEnum.PENDENTE)
                .dataVenda(new Date(1630440000000L))
                .build();
    }
}
