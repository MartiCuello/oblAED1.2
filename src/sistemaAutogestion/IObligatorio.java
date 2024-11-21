package sistemaAutogestion;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre:      post:
    public Retorno crearSistemaDeGestion();
     //pre:      post:
    public Retorno agregarEstudiante(String nombre, String apellido, int numero);
     //pre:      post:
    public Retorno obtenerEstudiante(int numero);
     //pre:      post:
    public Retorno eliminarEstudiante(int numero);
    //pre:      post:
    public Retorno agregarLibro(String nombre, String ISBN, String categoría, int cantidad);
    //pre:      post:
    public Retorno eliminarLibro(String ISBN);
   
      /*
    **************** GESTIÓN DE PRESTAMOS **************************************
    */
    
     //pre:      post:
    public Retorno prestarLibro(String ISBN, int numero);
     //pre:      post:
    public Retorno reservarLibro(String ISBN, int numero);
    //pre:      post:
    Retorno devolverLibro(String ISBN, int numero);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    
   //pre:      post:
   public Retorno listarEstudiantes();
   //pre:      post: 
   public Retorno listarLibros();
   //pre:      post: 
   public Retorno listarLibros(String categoria);
   //pre:      post: 
   public Retorno listarPrestamos(int numero);
    //pre:      post: 
   public Retorno librosMasPrestados();
    //pre:      post: 
   public Retorno deshacerEliminaciones(int n);
   //pre:      post:
   public Retorno cantidadPrestamosActivos(String ISBN);
    //pre:      post:
   public Retorno prestamosXCategoría();
}
