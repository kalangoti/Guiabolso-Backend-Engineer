package br.com.guiabolsobackend.dto;

import java.io.Serializable;

import br.com.guiabolsobackend.entities.Transacao;

public class TransacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String descricao;

    private Long data;

    private Integer valor;

    private Boolean duplicated;

    public TransacaoDTO() {
        super();
    }

    public TransacaoDTO(Transacao entity) {
        super();
        this.descricao = entity.getDescricao();
        this.data = entity.getData();
        this.valor = entity.getValor();
        this.duplicated = entity.getDuplicated();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Boolean getDuplicated() {
        return duplicated;
    }

    public void setDuplicated(Boolean duplicated) {
        this.duplicated = duplicated;
    }

}
