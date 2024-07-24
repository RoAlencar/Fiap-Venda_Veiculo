package br.com.fiap.app.venda.veiculo.application.dto;

import br.com.fiap.app.venda.veiculo.domain.enums.NumeroPortasEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVeiculoEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.TipoCombustivelEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.TipoVeiculoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeiculoDto {

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private BigDecimal preco;
    private TipoVeiculoEnum tipo;
    private Integer quilometragem;
    private TipoCombustivelEnum tipoCombustivel;
    private NumeroPortasEnum numeroPortas;
    private String placa;
    private String descricao;
    private StatusVeiculoEnum status;
    private Date dataCadastro;

    public VeiculoDto(VeiculoDto dto){
        this.id = dto.getId();
        this.marca = dto.getMarca();
        this.modelo = dto.getModelo();
        this.ano = dto.getAno();
        this.cor = dto.getCor();
        this.preco = dto.getPreco();
        this.tipo = dto.getTipo();
        this.quilometragem = dto.getQuilometragem();
        this.tipoCombustivel = dto.getTipoCombustivel();
        this.numeroPortas = dto.getNumeroPortas();
        this.placa = dto.getPlaca();
        this.descricao = dto.getDescricao();
        this.status = dto.getStatus();
        this.dataCadastro = dto.getDataCadastro();
    }
}
