package br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities;

import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "CORE_VENDA")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENDA")
    private Long idVenda;

    @Column(name = "ID_VEICULO")
    private Long idVeiculo;

    @Column(name = "CPF_CLIENTE")
    private String cpfCliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_VENDA")
    private StatusVendaEnum statusVenda;

    @Column(name = "CODIGO_PAGAMENTO")
    private String codigoPagamento;

    @Column(name = "DATA_VENDA")
    private Date dataVenda;

    public Cliente toDomain(){
        return Cliente.builder()
                .idVenda(this.idVenda)
                .idVeiculo(this.idVeiculo)
                .cpfCliente(this.cpfCliente)
                .statusVenda(this.statusVenda)
                .codigoPagamento(this.codigoPagamento)
                .dataVenda(this.dataVenda)
                .build();
    }
}
