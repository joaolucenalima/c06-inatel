package redesSociais;

public class Instagram extends RedeSocial {

    public Instagram(String senha, int numAmigos) {
        super(senha, numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Nova foto postada no Instagram!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Novo video postado no Instagram!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Comentário postado no Instagram!");
    }
}
