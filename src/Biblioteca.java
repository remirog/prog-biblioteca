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
     * @return el libro encontrado o null si no lo encuentra
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

    /**
     * Metodo privado que busca la primera posición libre en el cátalogo
     * @return -1 si no hay hueco libre o la posición libre
     */
    private int buscarPrimerHuecoLibre(){
        int posicionLibre = -1;
        boolean seguirBuscando = true;

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if (catalogo[i] == null) {
                posicionLibre = i;
                seguirBuscando = false;
            }
        }

        return posicionLibre;
    }

    /**
     * Recibe y añade el libro no duplicado siempre que haya hueco
     * @param libro Libro recibido
     * @return true si se ha añadido y false si no se ha podido añadirlo
     */

    public boolean addLibro(Libro libro){
        boolean libroAnadido = false;
        int posicion;

        // comprobamos si existe
            // buscar hueco
                // no hay -> libroAnadido = false
                // si hay ->
                    // añadimos
                    // Libroanadido = true

        if (findLibro(libro.getId()) == null) { // no lo ha encontrado. no está duplicado
            posicion = buscarPrimerHuecoLibre();
            if (posicion >= 0 ){
                catalogo[posicion] = libro;
                libroAnadido = true;
            }
        }

        return libroAnadido;
    }

    /**
     * Recibe un id de un libro y lo borra y devuelve el libro eliminado o null si no lo encuentra
     * @param id Identificador de líbro
     * @return el libro eliminado o null en caso de no encontrado
     */
    public Libro deleteLibro(int id){
        Libro libroEncontrado = null;
        boolean seguirBuscando = true;

        // comrpobar que existe. Necesitamos el libro y la posición

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if (catalogo[i] != null && catalogo[i].getId() == id) {
                libroEncontrado = catalogo[i]; // guardo el libro
                catalogo[i] = null;            // vacíamos la posicion
                seguirBuscando = false;        // para que no siga recorriendo
            }
        }

        return libroEncontrado;
    }

    /**
     * Acrualiza el número de páginas del líbro con el id recibido
     * @param idLibro id del líbro a actualizar
     * @param numPaginas número de páginas actualizado
     * @return true si se puede cambiar, false si no puede
     */
    public boolean updateNumPaginass(int idLibro, int numPaginas){
        boolean numPaginasActualizado = false;
        Libro libro;

        libro = findLibro(idLibro);

        if (libro != null) {
            numPaginasActualizado = libro.updateNumPaginas(numPaginas);
        }

        return numPaginasActualizado;
    }


}
