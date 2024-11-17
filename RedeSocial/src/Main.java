import redesSociais.Facebook;
import redesSociais.Twitter;

import exceptions.UsuarioInvalido;
import exceptions.ErroInterno;
import redesSociais.RedeSocial;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            Set<RedeSocial> redes = new HashSet<>();

            Facebook facebook = new Facebook("senhafacebook", 386);
            Twitter twitter = new Twitter("senhatwitter", 683);

            redes.add(facebook);
            redes.add(twitter);

            Usuario usuario = new Usuario("João Lucena", "joao.vl@ges.inatel.br", redes);
            System.out.println(usuario);

            for (RedeSocial redeSocial : usuario.getRedesSociais()) {
                if (redeSocial instanceof Twitter) {
                    ((Twitter) redeSocial).compartilhar();
                    redeSocial.postarFoto();
                    redeSocial.postarComentario();
                }
                if (redeSocial instanceof Facebook) {
                    ((Facebook) redeSocial).fazStreaming();
                    redeSocial.postarVideo();
                    redeSocial.curtirPublicacao();
                }
            }

        } catch (UsuarioInvalido e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (ErroInterno e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}