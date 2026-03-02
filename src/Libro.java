public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int numPaginas;

    /**
     * Metodo constructor de Libros
     * @param id identificador del líbro
     * @param titulo título del líbro
     * @param autor autor del líbro
     * @param numPaginas número de páginas del líbro
     */
    public Libro(int id, String titulo, String autor, int numPaginas) {
        int numHojas;

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;

        numHojas = numPaginas/2;
    }

    /**
     * Devuelve el id del líbro
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el título del líbro
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el Autor del líbro
     * @return
     */
    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Libro: {");

        sb.append(String.format("\n id: %d; ", id));
        sb.append(String.format(" titulo: %s; ", titulo));
        sb.append(String.format(" autor: %s; ", autor));
        sb.append(String.format(" numPaginas: %d; ", numPaginas));
        sb.append("}");

        return sb.toString();
    }

    /**
     * Actualiza el número de páginas que tiene ele libro. COmprueba que el número recibido sea mayor que 0
     * @param numPaginas nueva cantidad de páginas
     * @return true si ha podido cambiarse, false si no ha podidio cambiarse
     */
    public boolean updateNumPaginas(int numPaginas) {
        boolean resultado;
        if (numPaginas <= 0) {
            resultado = false;
        } else {
            this.numPaginas = numPaginas;
            resultado = true;
        }
        return resultado;
    }
}
