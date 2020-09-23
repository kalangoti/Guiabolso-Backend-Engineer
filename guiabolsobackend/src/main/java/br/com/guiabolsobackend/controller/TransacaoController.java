package br.com.guiabolsobackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guiabolsobackend.dto.TransacaoDTO;
import br.com.guiabolsobackend.services.TransacaoService;

@RestController
@RequestMapping(value = "/{id}/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping(value = "/{ano}/{mes}")
    public ResponseEntity<List<TransacaoDTO>> findAll() {

        try {

            List<TransacaoDTO> list = service.findAll();

            return ResponseEntity.ok().body(list);

        } catch (Exception ex) {

            ex.printStackTrace();

            return ResponseEntity.unprocessableEntity().body(new ArrayList<>());
        }
    }
}
