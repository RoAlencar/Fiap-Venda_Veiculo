package br.com.fiap.app.venda.veiculo.application.dto.request;

import br.com.fiap.app.venda.veiculo.application.dto.VeiculoBaseRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReservaVeiculoRequest extends VeiculoBaseRequest {

    public ReservaVeiculoRequest(VeiculoBaseRequest veiculoBaseRequest) {
        super(veiculoBaseRequest);
    }
}
