package br.com.fiap.app.venda.veiculo.application.usecase;

import br.com.fiap.app.venda.veiculo.adapter.out.feign.RegistraVeiculoClient;
import br.com.fiap.app.venda.veiculo.application.dto.VeiculoBaseRequest;
import br.com.fiap.app.venda.veiculo.application.dto.request.AtualizaStatusVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.request.ReservaVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.request.VenderVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.ReservaVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.VenderVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.port.VendaClienteRepositoryPort;
import br.com.fiap.app.venda.veiculo.application.port.VendaVeiculoUseCasePort;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVeiculoEnum;
import br.com.fiap.app.venda.veiculo.domain.enums.StatusVendaEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class VendaVeiculoUseCase implements VendaVeiculoUseCasePort {

    private final RegistraVeiculoClient registraVeiculoClient;
    private final VendaClienteRepositoryPort vendaClienteRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public VenderVeiculoResponse vendaVeiculo(VenderVeiculoRequest request) {
        atualizaStatusVeiculo(request.getIdVeiculo(), StatusVeiculoEnum.VENDIDO);
        Cliente cliente = criarVendaCliente(request, StatusVendaEnum.CONCLUIDO);
        return modelMapper.map(cliente, VenderVeiculoResponse.class);
    }

    @Override
    public ReservaVeiculoResponse reservaVeiculo(ReservaVeiculoRequest request) {
        atualizaStatusVeiculo(request.getIdVeiculo(), StatusVeiculoEnum.RESERVADO);
        Cliente cliente = criarVendaCliente(request, StatusVendaEnum.PENDENTE);
        return modelMapper.map(cliente, ReservaVeiculoResponse.class);
    }


    private Cliente criarVendaCliente(VeiculoBaseRequest request, StatusVendaEnum statusVenda) {
        Cliente cliente = vendaClienteRepositoryPort.findByIdVeiculo(request.getIdVeiculo())
                .map(clienteExiste -> Cliente.builder()
                        .idVenda(clienteExiste.getIdVenda())
                        .idVeiculo(request.getIdVeiculo())
                        .cpfCliente(request.getCpfCliente())
                        .statusVenda(statusVenda)
                        .codigoPagamento(gerarCodigoPagamento())
                        .dataVenda(new Date())
                        .build())
                .orElseGet(() -> Cliente.builder()
                        .idVeiculo(request.getIdVeiculo())
                        .cpfCliente(request.getCpfCliente())
                        .statusVenda(statusVenda)
                        .codigoPagamento(gerarCodigoPagamento())
                        .dataVenda(new Date())
                        .build());
        return vendaClienteRepositoryPort.save(cliente);
    }
    private void atualizaStatusVeiculo(Long idVeiculo, StatusVeiculoEnum statusVeiculo) {
        registraVeiculoClient.atualizaVeiculo(
                AtualizaStatusVeiculoRequest.builder()
                        .id(idVeiculo)
                        .status(statusVeiculo)
                        .build());

    }

    public static String gerarCodigoPagamento(){
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder base64Encoder = Base64.getEncoder();
        byte[] randomBytes = new byte[12];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
