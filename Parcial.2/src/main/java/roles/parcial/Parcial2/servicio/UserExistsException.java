package roles.parcial.Parcial2.servicio;

public class UserExistenteException extends Exception {
    public UserExistenteException(String message) {
        super(message);
    }
}