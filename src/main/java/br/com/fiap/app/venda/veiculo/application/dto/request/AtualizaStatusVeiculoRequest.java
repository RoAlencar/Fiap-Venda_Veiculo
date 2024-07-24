package br.com.fiap.app.venda.veiculo.application.dto.request;

import br.com.fiap.app.venda.veiculo.domain.enums.StatusVeiculoEnum;
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
public class AtualizaStatusVeiculoRequest {

    private Long id;
    private StatusVeiculoEnum status;
}
