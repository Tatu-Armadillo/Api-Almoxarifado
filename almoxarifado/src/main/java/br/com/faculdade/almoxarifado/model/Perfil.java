// package br.com.faculdade.almoxarifado.model;

// import javax.persistence.*;

// import org.springframework.security.core.GrantedAuthority;

// @Entity
// @Table(name = "tb_perfil")
// public class Perfil implements GrantedAuthority {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long idPerfil;
//     private String nome;

//     public Long getIdPerfil() {
//         return idPerfil;
//     }

//     public void setIdPerfil(Long idPerfil) {
//         this.idPerfil = idPerfil;
//     }

//     public void setNome(String nome) {
//         this.nome = nome;
//     }

//     public String getNome() {
//         return nome;
//     }

//     @Override
//     public String getAuthority() {
//         return this.nome;
//     }

// }
