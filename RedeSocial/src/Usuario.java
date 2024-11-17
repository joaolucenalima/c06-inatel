import exceptions.UsuarioInvalido;
import redesSociais.RedeSocial;

import java.util.Set;

public class Usuario {
    private String nome;
    private String email;
    private Set<RedeSocial> redesSociais;

    public Usuario(String nome, String email, Set<RedeSocial> redesSociais) throws UsuarioInvalido {
        if (redesSociais.size() != 2 || nome.isEmpty() || email.isEmpty()) {
            throw new UsuarioInvalido("Usuário inválido! A senha e o email não podem estar vazios e ele deve ter duas redes sociais.");
        }

        this.nome = nome;
        this.email = email;
        this.redesSociais = redesSociais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RedeSocial> getRedesSociais() {
        return redesSociais;
    }
}
