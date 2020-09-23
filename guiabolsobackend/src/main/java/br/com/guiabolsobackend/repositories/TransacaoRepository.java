package br.com.guiabolsobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guiabolsobackend.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
