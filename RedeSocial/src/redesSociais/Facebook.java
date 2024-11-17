package redesSociais;

import interfaces.Compartilhamento;
import interfaces.VideoConferencia;

public class Facebook extends RedeSocial implements Compartilhamento, VideoConferencia {

    public Facebook(String senha, int numAmigos) {
        super(senha, numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Nova foto postada no Facebook!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Novo video postado no Facebook!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Comentário postado no Facebook!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhamento no Facebook!");
    }

    @Override
    public void fazStreaming() {
        System.out.println("Fazendo streaming no Facebook!");
    }
}
