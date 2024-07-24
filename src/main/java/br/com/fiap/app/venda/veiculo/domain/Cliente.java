package br.com.fiap.app.venda.veiculo.domain;

import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities.ClienteEntity;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    private Long idVenda;
    private Long idVeiculo;
    private String cpfCliente;
    private StatusVendaEnum statusVenda;
    private String codigoPagamento;
    private Date dataVenda;

    public Cliente(Cliente cliente) {
        this.idVenda = cliente.getIdVenda();
        this.idVeiculo = cliente.getIdVeiculo();
        this.cpfCliente = cliente.getCpfCliente();
        this.statusVenda = cliente.getStatusVenda();
        this.codigoPagamento = cliente.getCodigoPagamento();
        this.dataVenda = cliente.getDataVenda();
    }

    public ClienteEntity toEntity(){
        return ClienteEntity.builder()
                .idVenda(this.idVenda)
                .idVeiculo(this.idVeiculo)
                .cpfCliente(this.cpfCliente)
                .statusVenda(this.statusVenda)
                .codigoPagamento(this.codigoPagamento)
                .dataVenda(this.dataVenda)
                .build();
    }
}
