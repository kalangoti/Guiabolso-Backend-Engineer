package br.com.guiabolsobackend.controller;

import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.guiabolsobackend.dto.TransacaoDTO;
import br.com.guiabolsobackend.dto.TransacaoRequisicaoDTO;
import br.com.guiabolsobackend.services.TransacaoService;

@RestController
@Validated // class level
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping(value = "/{id}/transacoes/{ano}/{mes}")
    public ResponseEntity<List<TransacaoDTO>> findByAnoMes(
            @PathVariable("id") @Range(min = 1000, max = 100000000,
                    message = "{id.usuario.not.valid}") Integer id,
            @PathVariable("ano") @Range(min = 1000, max = 9999,
                    message = "{ano.not.valid}") Integer ano,
            @PathVariable("mes") @Range(min = 1, max = 12,
                    message = "{mes.not.valid}") Integer mes) {

        try {

            TransacaoRequisicaoDTO requisicaoDTO = new TransacaoRequisicaoDTO(id, ano, mes);

            service.removeAll();

            service.createTransacoes(requisicaoDTO);

            List<TransacaoDTO> list = service.findAll();

            list = service.findByAnoMes(requisicaoDTO);

            if (Objects.isNull(list) || list.isEmpty()) {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Nenhuma transação encontrada");
            }

            return ResponseEntity.ok().body(list);

        } catch (Exception ex) {

            ex.printStackTrace();

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),
                    ex);
        }
    }
}
