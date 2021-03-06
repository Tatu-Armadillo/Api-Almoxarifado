package br.com.faculdade.almoxarifado.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_responsaveis")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsavel")
    private Long idResponsavel;

    @Column(name = "Nome")
    private String nomeResponsavel;

    @Column(name = "Numero_Contato")
    private String numeroContato;

    public Responsavel() {
    }

    public Responsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public Responsavel(String nomeResponsavel, String numeroContato) {
        this.nomeResponsavel = nomeResponsavel;
        this.numeroContato = numeroContato;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

}
