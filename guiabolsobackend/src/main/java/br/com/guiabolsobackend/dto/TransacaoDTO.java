package br.com.guiabolsobackend.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.guiabolsobackend.entities.Transacao;
import br.com.guiabolsobackend.utils.DateTimeUtil;

public class TransacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String descricao;

    private Long data;

    private Integer valor;

    private Boolean duplicated;

    private Date dataInformada;

    public TransacaoDTO() {
        super();
    }

    public TransacaoDTO(Transacao entity) {
        super();
        this.descricao = entity.getDescricao();
        this.data =
                DateTimeUtil.setDate(entity.getDia(), entity.getMes(), entity.getAno()).getTime();
        this.valor = entity.getValor();
        this.duplicated = entity.getDuplicated();
        this.dataInformada = new Date(data);
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

    public Date getDataInformada() {
        return dataInformada;
    }

}
