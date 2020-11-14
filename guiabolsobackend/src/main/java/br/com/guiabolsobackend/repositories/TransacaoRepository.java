package br.com.guiabolsobackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guiabolsobackend.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    public List<Transacao> findByData(Long data);
    
}
