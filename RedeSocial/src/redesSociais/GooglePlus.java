package redesSociais;

import interfaces.Compartilhamento;
import interfaces.VideoConferencia;

public class GooglePlus extends RedeSocial implements Compartilhamento, VideoConferencia {

    public GooglePlus(String senha, int numAmigos) {
        super(senha, numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Nova foto postada no Google+!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Novo video postado no Google+!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Comentário postado no Google+!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhando no Google+!");
    }

    @Override
    public void fazStreaming() {
        System.out.println("Fazendo streaming no Google+!");
    }
}
