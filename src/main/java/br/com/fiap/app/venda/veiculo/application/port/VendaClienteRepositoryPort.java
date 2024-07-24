package br.com.fiap.app.venda.veiculo.application.port;

import br.com.fiap.app.venda.veiculo.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface VendaClienteRepositoryPort {

    List<Cliente> findAll();
    Optional<Cliente> findByIdVeiculo(Long id);
    Optional<Cliente> findByCodigoPagamento(String codigoPagamento);
    Cliente save(Cliente cliente);
}
