package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.adapter.out.feign.RegistraVeiculoClient;
import br.com.fiap.app.venda.veiculo.application.dto.VeiculoDto;
import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaStatusVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.port.BuscaVendaVeiculoUseCasePort;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVeiculoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuscaVendaVeiculoUseCase implements BuscaVendaVeiculoUseCasePort {

    private final RegistraVeiculoClient registraVeiculoClient;
    private final ModelMapper modelMapper;


    @Override
    public List<BuscaStatusVeiculoResponse> buscaVeiculosAVendaPorMenorPreco() throws Exception {
       try{
           List<VeiculoDto> veiculos = registraVeiculoClient.buscaTodosVeiculos().stream()
                   .filter(entity -> entity.getStatus().equals(StatusVeiculoEnum.DISPONIVEL))
                   .sorted(Comparator.comparing(VeiculoDto::getPreco))
                   .toList();


        return veiculos.stream()
                .map(entity -> modelMapper.map(entity,BuscaStatusVeiculoResponse.class))
                .toList();
       } catch (Exception e) {
           log.error("Error while executing findAllVehicles: ", e);
           throw new Exception(e);
       }
    }

    @Override
    public List<BuscaStatusVeiculoResponse> buscaVeiculosVendidosPorMenorPreco() {
       List<VeiculoDto> veiculos = registraVeiculoClient.buscaTodosVeiculos().stream()
               .filter(entity -> entity.getStatus().equals(StatusVeiculoEnum.VENDIDO) || entity.getStatus().equals(StatusVeiculoEnum.RESERVADO))
               .sorted(Comparator.comparing(VeiculoDto::getPreco))
               .toList();
       return veiculos.stream().map(entity -> modelMapper.map(entity, BuscaStatusVeiculoResponse.class)).toList();
    }
}
