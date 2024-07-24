package br.com.fiap.app.venda.veiculo.adapter.out.jpa;

import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities.ClienteEntity;
import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.repositories.VendaClienteJpaRepository;
import br.com.fiap.app.venda.veiculo.application.port.VendaClienteRepositoryPort;
import br.com.fiap.app.venda.veiculo.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteJpaRepositoryAdapter implements VendaClienteRepositoryPort {

    private final VendaClienteJpaRepository vendaClienteJpaRepository;

    @Override
    public List<Cliente> findAll() {
        return vendaClienteJpaRepository.findAll().stream().map(ClienteEntity::toDomain).toList();
    }

    @Override
    public Optional<Cliente> findByIdVeiculo(Long id) {
        return vendaClienteJpaRepository.findByidVeiculo(id)
                .map(ClienteEntity::toDomain);
    }

    @Override
    public Optional<Cliente> findByCodigoPagamento(String codigoPagamento) {
        return vendaClienteJpaRepository.findByCodigoPagamento(codigoPagamento)
                .map(ClienteEntity::toDomain);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return vendaClienteJpaRepository.save(cliente.toEntity()).toDomain();
    }
}
