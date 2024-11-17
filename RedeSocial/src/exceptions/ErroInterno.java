package exceptions;

public class ErroInterno extends RuntimeException {
    public ErroInterno(String message) {
        super(message);
    }
}
