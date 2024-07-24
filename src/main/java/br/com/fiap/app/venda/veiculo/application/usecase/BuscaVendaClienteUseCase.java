package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaVendaClienteResponse;
import br.com.fiap.app.venda.veiculo.application.port.BuscaVendaClienteUseCasePort;
import br.com.fiap.app.venda.veiculo.application.port.VendaClienteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaVendaClienteUseCase implements BuscaVendaClienteUseCasePort {

    private final VendaClienteRepositoryPort vendaClienteRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public List<BuscaVendaClienteResponse> buscaTodasVendasCliente() {
        return vendaClienteRepositoryPort.findAll().stream()
                .map(entity -> modelMapper.map(entity,BuscaVendaClienteResponse.class))
                .toList();
    }
}
