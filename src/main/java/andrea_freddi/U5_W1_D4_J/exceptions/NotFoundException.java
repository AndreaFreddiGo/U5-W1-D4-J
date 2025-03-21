package andrea_freddi.U5_W1_D4_J.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("La risorsa con id " + id + " non è stata trovata!");
    }
}
