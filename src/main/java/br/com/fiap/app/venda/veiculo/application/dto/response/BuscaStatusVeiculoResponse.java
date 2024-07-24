package br.com.fiap.app.venda.veiculo.application.dto.response;

import br.com.fiap.app.venda.veiculo.application.dto.VeiculoDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BuscaStatusVeiculoResponse extends VeiculoDto {

    public BuscaStatusVeiculoResponse(VeiculoDto dto){
        super(dto);
    }
}
