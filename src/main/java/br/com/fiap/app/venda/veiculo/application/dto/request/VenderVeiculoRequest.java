package br.com.fiap.app.venda.veiculo.application.dto.request;

import br.com.fiap.app.venda.veiculo.application.dto.VeiculoBaseRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VenderVeiculoRequest extends VeiculoBaseRequest {

    public VenderVeiculoRequest(VeiculoBaseRequest veiculoBaseRequest) {
        super(veiculoBaseRequest);
    }
}
