package br.com.fiap.app.venda.veiculo.application.dto.response;

import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStatusPagamentoResponse {

    private String codigoPagamento;
    private StatusVendaEnum statusVenda;
}
