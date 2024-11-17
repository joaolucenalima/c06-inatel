package redesSociais;

import interfaces.Compartilhamento;

public class Twitter extends RedeSocial implements Compartilhamento {

    public Twitter(String senha, int numAmigos) {
        super(senha, numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Nova foto postada no Twitter!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Novo video postado no Twitter!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Comentário postado no Twitter!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhando publicação no Twitter!");
    }
}
