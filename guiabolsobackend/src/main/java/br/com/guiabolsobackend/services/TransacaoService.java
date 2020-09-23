package br.com.guiabolsobackend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guiabolsobackend.dto.TransacaoDTO;
import br.com.guiabolsobackend.entities.Transacao;
import br.com.guiabolsobackend.repositories.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Transactional(readOnly = true)
    public List<TransacaoDTO> findAll() {
        List<Transacao> list = repository.findAll();
        return list.stream().map(x -> new TransacaoDTO(x)).collect(Collectors.toList());
    }

}
