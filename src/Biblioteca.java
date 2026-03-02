public class Biblioteca {

    private Libro[] catalogo;
    private final int CANT_MAX_LIBROS;

    public Biblioteca(int cantidad_maxima_libros) {
        CANT_MAX_LIBROS = cantidad_maxima_libros;

        catalogo = new Libro[CANT_MAX_LIBROS];
    }

    /**
     * Busca el primer libro que encuentre con el id recibido
     * @param idlibro
     * @return
     */
    public Libro findLibro(int idlibro){
        boolean seguirBuscnado = true;
        Libro libroencontrado = null;

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscnado; i++) {
            if (catalogo[i] != null && catalogo[i].getId() == idlibro) {
                seguirBuscnado = false;
                libroencontrado = catalogo[i];
            }
        }

        return libroencontrado;
    }





}
