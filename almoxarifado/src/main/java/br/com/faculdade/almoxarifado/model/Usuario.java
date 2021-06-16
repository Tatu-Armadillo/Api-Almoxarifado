// package br.com.faculdade.almoxarifado.model;

// import java.util.*;

// import javax.persistence.*;

// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.security.core.userdetails.UserDetails;

// @Entity
// @Table(name = "tb_usuarios")
// public class Usuario  {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id_adm")
//     private Long idAdm;

//     private String login;
//     private String senha;

//     @ManyToMany(fetch = FetchType.EAGER)
//     @JoinTable(name = "tb_perfil")
//     private List<Perfil> perfis = new ArrayList<>();

//     public Long getIdAdm() {
//         return idAdm;
//     }

//     public void setIdAdm(Long idAdm) {
//         this.idAdm = idAdm;
//     }

//     public String getLogin() {
//         return login;
//     }

//     public void setLogin(String login) {
//         this.login = login;
//     }

//     public String getSenha() {
//         return senha;
//     }

//     public void setSenha(String senha) {
//         this.senha = senha;
//     }

//     // @Override
//     // public Collection<? extends GrantedAuthority> getAuthorities() {
//     //     return this.perfis;
//     // }

//     // @Override
//     // public String getPassword() {
//     //     return this.senha;
//     // }

//     // @Override
//     // public String getUsername() {
//     //     return this.login;
//     // }

//     // // Habilitar usuario
//     // @Override
//     // public boolean isAccountNonExpired() {
//     //     return true;
//     // }

//     // @Override
//     // public boolean isAccountNonLocked() {
//     //     return true;
//     // }

//     // @Override
//     // public boolean isCredentialsNonExpired() {
//     //     return true;
//     // }

//     // @Override
//     // public boolean isEnabled() {
//     //     return true;
//     // }

// }
