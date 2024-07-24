package br.com.fiap.app.venda.veiculo.application.dto;

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
public class VeiculoBaseRequest {

    private Long idVeiculo;
    private String cpfCliente;

    public VeiculoBaseRequest(VeiculoBaseRequest veiculoBaseRequest) {
        this.idVeiculo = veiculoBaseRequest.getIdVeiculo();
        this.cpfCliente = veiculoBaseRequest.getCpfCliente();
    }
}
