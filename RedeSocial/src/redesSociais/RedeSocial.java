package redesSociais;

abstract public class RedeSocial {
    private String senha;
    private int numAmigos;

    public RedeSocial(String senha, int numAmigos) {
        this.senha = senha;
        this.numAmigos = numAmigos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumAmigos() {
        return numAmigos;
    }

    public void setNumAmigos(int numAmigos) {
        this.numAmigos = numAmigos;
    }

    public abstract void postarFoto();
    public abstract void postarVideo();
    public abstract void postarComentario();
    public void curtirPublicacao() {
        System.out.println("Publicação curtida!!");
    };
}
