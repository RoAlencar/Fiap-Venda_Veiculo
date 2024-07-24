package br.com.fiap.app.venda.veiculo.application.dto.response;

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
public class VenderVeiculoResponse {

    private Long idVenda;
    private Long idVeiculo;
    private String cpfCliente;
    private StatusVendaEnum statusVenda;
    private String codigoPagamento;
    private Date dataVenda;
}
