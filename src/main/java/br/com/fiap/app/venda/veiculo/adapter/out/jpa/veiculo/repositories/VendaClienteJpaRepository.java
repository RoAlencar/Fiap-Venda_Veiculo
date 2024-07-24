package br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.repositories;

import br.com.fiap.app.venda.veiculo.adapter.out.jpa.veiculo.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendaClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByidVeiculo(Long idVeiculo);
    Optional<ClienteEntity> findByCodigoPagamento(String codigoPagamento);

}
