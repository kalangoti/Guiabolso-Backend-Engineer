package br.com.guiabolsobackend.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guiabolsobackend.dto.TransacaoDTO;
import br.com.guiabolsobackend.dto.TransacaoRequisicaoDTO;
import br.com.guiabolsobackend.entities.Transacao;
import br.com.guiabolsobackend.repositories.TransacaoRepository;
import br.com.guiabolsobackend.utils.DateTimeUtil;
import br.com.guiabolsobackend.utils.IntegerUtil;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Transactional(readOnly = true)
    public List<TransacaoDTO> findAll() {
        List<Transacao> list = repository.findAll();
        return list.stream().map(x -> new TransacaoDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TransacaoDTO> findByAnoMes(TransacaoRequisicaoDTO requisicaoDTO) {
        List<Transacao> list =
                repository.findByAnoMes(requisicaoDTO.getMes(), requisicaoDTO.getAno());
        return list.stream().map(x -> new TransacaoDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public void removeAll() {
        repository.deleteAll();
    }

    @Transactional
    public void createTransacoes(TransacaoRequisicaoDTO requisicaoDTO) {

        for (int i = 1; i <= 12; i++) {

            Date dataInformada = DateTimeUtil.setDateRandom(i, requisicaoDTO.getAno());

            int valor = Integer.parseInt(IntegerUtil.aleatorioNaFaixa(-9999999, 9999999).toString()
                    + IntegerUtil.aleatorioNaFaixa(0, 9).toString()
                    + IntegerUtil.aleatorioNaFaixa(0, 9).toString());

            Transacao entity = new Transacao("descricao", dataInformada.getTime(), valor, false,
                    requisicaoDTO.getIdUsuario());

            repository.saveAndFlush(entity);

            for (int j = 1; j <= IntegerUtil.somarDigitos(i); j++) {

                entity = new Transacao("descricao", dataInformada.getTime(), valor, true,
                        requisicaoDTO.getIdUsuario());

                repository.saveAndFlush(entity);
            }
        }
    }

}
