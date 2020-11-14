package br.com.guiabolsobackend.dto;

import java.io.Serializable;

public class TransacaoRequisicaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuario;

    private Integer ano;

    private Integer mes;

    public TransacaoRequisicaoDTO() {
        super();
    }

    public TransacaoRequisicaoDTO(Integer idUsuario, Integer ano, Integer mes) {
        super();
        this.idUsuario = idUsuario;
        this.ano = ano;
        this.mes = mes;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

}
