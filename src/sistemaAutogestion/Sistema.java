package sistemaAutogestion;

import dominio.Reserva;
import dominio.Estudiante;
import dominio.Libro;
import dominio.Prestamo;
import tads.Cola.Cola;
import tads.ListaDoble.ListaDoble;
import tads.ListaSimple;
import tads.Nodo;
import tads.Pila.Pila;

public class Sistema implements IObligatorio {
    private ListaDoble<Estudiante> listaEstudiantes;
    private ListaSimple<Libro> listaLibros;
    private ListaSimple<Prestamo> listaPrestamos;
    private Pila<Libro> pilaEliminados;
    
    
    //otros metodos
    public boolean ExisteEstudiante(int num){
        Estudiante est = new Estudiante("", "", num);
        return listaEstudiantes.existeElemento(est);
    }
    
    public boolean EstudianteConPrestamo(int num){
        Prestamo presBuscado = new Prestamo("", num, true);
        return listaPrestamos.existe(presBuscado);
    }
    
    
    
        
    
    
    // 2.1
    @Override
    public Retorno crearSistemaDeGestion() {
        listaEstudiantes = new ListaDoble<>();
        listaLibros = new ListaSimple<>();
        listaPrestamos = new ListaSimple<>();
        pilaEliminados = new Pila<>();

        return Retorno.ok();
    }

    //2.2
    @Override
    public Retorno agregarEstudiante(String nombre, String apellido, int numero) {
        Estudiante estudianteNuevo = new Estudiante(nombre, apellido, numero);
        
        if(ExisteEstudiante(numero)){
        return Retorno.error3();
        }
        if(nombre == null || apellido == null || nombre == "" || apellido == ""){
            return Retorno.error1();
        }
        if(estudianteNuevo.getNumero() <= 0 || estudianteNuevo.getNumero() > 500000){
        return Retorno.error2();
        }       
        
        listaEstudiantes.agregar(estudianteNuevo);
        return Retorno.ok();
        
    }

    //2.3
    @Override
    public Retorno obtenerEstudiante(int numero) {
        Estudiante estBuscado = null;
        boolean encontrado = false;
        
        if(numero <= 0 || numero > 50000){
            return Retorno.error1();
        }
        
        for(int i = 0; i < listaEstudiantes.largo() && encontrado == false; i++){
            Estudiante est = listaEstudiantes.obtenerPorIndice(i);
            if(est.getNumero() == numero){
                estBuscado = est;
                encontrado = true;
            }    
        }
        
        if(!listaEstudiantes.existeElemento(estBuscado)){
            return Retorno.error2();
        }
                   
        
        
        //if(!listaEstudiantes.existe(estBuscado) || estBuscado == null){
            //return Retorno.error2();
        //}
     
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = estBuscado.toString();
        return r;
    }

    //2.4 
    @Override
    public Retorno eliminarEstudiante(int numero) {
        Estudiante aEliminar = null;
        boolean encontrado = false;
        
         if(numero <= 0 || numero > 50000){
            return Retorno.error1();
        }
         
        for(int i = 0; i < listaEstudiantes.largo() && encontrado == false; i++){
            Estudiante est = listaEstudiantes.obtenerPorIndice(i);
            if(est.getNumero() == numero){
                aEliminar = est;
                encontrado = true;
            }    
        }
  
        if(!listaEstudiantes.existeElemento(aEliminar)){
            return Retorno.error2();
        }
       
        if(EstudianteConPrestamo(numero)){
        return Retorno.error3();
        }
        
        listaEstudiantes.borrarElemento(aEliminar);
        return Retorno.ok();
    }

    //2.5
    @Override
    public Retorno agregarLibro(String nombre, String ISBN, String categoría, int cantidad) {
        Libro aAgregar = new Libro(nombre, ISBN, categoría, cantidad);
        if(aAgregar.getNombre() == null  || aAgregar.getISBN() == (null) || 
           aAgregar.getCategoria() == (null)){
            return Retorno.error1();
        }     
        
        if(cantidad <= 0) {
        return Retorno.error3();
        }
        
        if(listaLibros.existe(aAgregar)){
            return Retorno.error2();
        }
        
        listaLibros.agregar(aAgregar);
        return Retorno.ok(); 
        
    }
    
    @Override
    public Retorno eliminarLibro(String ISBN) {
        Libro libro = new Libro("",ISBN, "", 0);
        
        if( ISBN == null || ISBN.isEmpty())
        {
            return Retorno.error1();
        }
        
        for(int i = 0; i < listaPrestamos.largo(); i++){           
            Prestamo prestamo = listaPrestamos.obtenerPorIndice(i);
            if(prestamo.getISBN().equals(ISBN)){
                return Retorno.error2();             
            }
        }
        
        for(int i = 0; i < listaLibros.largo(); i++){
            Libro aEliminar = listaLibros.obtenerPorIndice(i);
            if(aEliminar.equals(libro)){
                listaLibros.eliminar(aEliminar);
                pilaEliminados.insertar(aEliminar);
                return Retorno.ok();          
            }           
        }             
        return Retorno.noImplementada();
    }

    @Override
    public Retorno prestarLibro(String ISBN, int numero) {
        Prestamo nuevoPrestamo = new Prestamo(ISBN, numero, true);
        boolean encontrado = false;
        
        if( ISBN == null || ISBN.isEmpty())
        {
            return Retorno.error1();
        }
        
        
        
        Libro libroPrestado = new Libro("",ISBN,"",0);
        
        
        if(!listaLibros.existe(libroPrestado)){
            return Retorno.error2();
        }
        
        for(int i = 0; i < listaLibros.largo() && encontrado == false; i++){           
            Libro libro = listaLibros.obtenerPorIndice(i);
                if(libro.getISBN().equals(ISBN)){
                    encontrado = true;
                    libroPrestado = libro;
                    if(libroPrestado.getCantidad() == 0){
                        return Retorno.error5();
                    }
                    libroPrestado.setCantidad(libroPrestado.getCantidad()-1);
                }
                
        }
                      
        if(numero <= 0 || numero > 500000){
            return Retorno.error3();
        }
        
        Estudiante estudiante = new Estudiante("", "", numero);
        
        if(listaEstudiantes.obtenerElemento(estudiante) == null){
            return Retorno.error4();
        }
        
        int cantidadPrestamos = 0;
        
        for(int i = 0; i < listaPrestamos.largo(); i++){
            Prestamo prestamo = listaPrestamos.obtenerPorIndice(i);
                if(prestamo.equals(nuevoPrestamo)){
                    return Retorno.error6();
                }          
                if(prestamo.getNumero() == numero){
                    cantidadPrestamos++;
                    if(cantidadPrestamos == 8){
                        return Retorno.error6();
                    }
                }                                   
        }
        
        
        
        listaPrestamos.agregar(nuevoPrestamo);
        return Retorno.ok();
    }


   @Override
    public Retorno reservarLibro(String ISBN, int numero) {
        
        Libro libro = new Libro("",ISBN, "", 0);
        Estudiante est = new Estudiante("","",numero);
        
        if(ISBN == null || ISBN.isEmpty()){
            return Retorno.error1();
        }
        
        if(!listaLibros.existe(libro)){
            return Retorno.error2();
        }
        
        if(numero <= 0 || numero > 500000){
            return Retorno.error3();
        }
        
        if(!listaEstudiantes.existeElemento(est)){
            return Retorno.error4();
        }
                   
        for(int i = 0; i < listaLibros.largo(); i++){
            Libro buscado = listaLibros.obtenerPorIndice(i);
            if(buscado.equals(libro)){
                if(buscado.getCantidad() > 0){
                    return Retorno.error5();
                }
                else
                {
                    buscado.getReserva().Adicionar(new Reserva(ISBN, numero));
                    return Retorno.ok();
                }
            }
        }
     
        return Retorno.noImplementada();
    }
    


    @Override
    public Retorno devolverLibro(String ISBN, int numero) {
        Libro libro = new Libro("",ISBN, "", 0);
        Estudiante est = new Estudiante("","",numero);
        Prestamo pres = new Prestamo(ISBN, numero, true);
        
        if(ISBN == null || ISBN.isEmpty()){
            return Retorno.error1();
        }
        if(!listaLibros.existe(libro)){
            return Retorno.error2();
        }
        if(numero <= 0 || numero > 500000){
            return Retorno.error3();
        }
        if(!listaEstudiantes.existeElemento(est)){
            return Retorno.error4();
        }
        
        for(int j = 0; j < listaLibros.largo(); j++){
            Libro lib = listaLibros.obtenerPorIndice(j);
            if(lib.equals(libro)){
                libro = lib;
            }
        }
        
              
        for(int i = 0; i < listaPrestamos.largo(); i++){
            Prestamo buscado = listaPrestamos.obtenerPorIndice(i);
            if(buscado.equals(pres)){
                if(buscado.isActivo() == false){
                    return Retorno.error5();
                }
                else
                {
                    if(!libro.getReserva().Vacia()){
                        Reserva reserva = libro.getReserva().Frente();
                        Prestamo nuevoPrestamo = new Prestamo(reserva.getISBN(), reserva.getNumero(), true);
                        listaPrestamos.agregar(nuevoPrestamo);
                        libro.getReserva().Desencolar();
                        return Retorno.ok();
                    }
                    
                    buscado.setActivo(false);
                    return Retorno.ok();
                }
            }
        }       
        return Retorno.noImplementada();
    }

    // 3.1
    @Override
    public Retorno listarEstudiantes() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = "";
        
        for(int i = 0; i < listaEstudiantes.largo(); i++){
            Estudiante e = listaEstudiantes.obtenerPorIndice(i);
            r.valorString += e.toString();
        }
        return r;
    }
    
    
    //3.2
    @Override
    public Retorno listarLibros() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = "";
        
        for(int i = 0; i < listaLibros.largo(); i++){
            Libro l = listaLibros.obtenerPorIndice(i);
            r.valorString += l.toString();
        }
        return r;
    }
    
    // 3.3
   @Override
    public Retorno listarLibros(String categoria) {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = "";

        if(categoria == null){
            return Retorno.error1();
        }

        return listarLibrosRec(categoria, 0, r);
    }

    public Retorno listarLibrosRec(String categoria, int indice, Retorno r) {
        if (indice >= listaLibros.largo()) {
            return r;
        }

        Libro libro = listaLibros.obtenerPorIndice(indice);

        if (libro.getCategoria().equals(categoria)) {
            r.valorString += libro.toString();
        }

        return listarLibrosRec(categoria, indice + 1, r);
}
   
        
    
    /*
    Si listan todos los préstamos del estudiante 
    1. Si no existe un estudiante con ese nombre.
    */
    
    @Override
    public Retorno listarPrestamos(int numero) {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = "";
        
        Estudiante est = new Estudiante("", "", numero);
        
        if(numero <= 0 || numero > 500000){
            return Retorno.error1();
        }
        
        
        if(!listaEstudiantes.existeElemento(est)){
            return Retorno.error2();
        }
        
        for(int i = 0; i < listaPrestamos.largo(); i++){
            Prestamo pres = listaPrestamos.obtenerPorIndice(i);
            if(pres.getNumero() == numero){
                for(int j = 0; j < listaLibros.largo(); j++){
                    Libro libro = listaLibros.obtenerPorIndice(j);
                    if(libro.getISBN().equals(pres.getISBN())){
                        r.valorString += libro.toString() + "|"+ pres.isActivo();
                    }
                }             
            }
        }
        
        return r;
    }

    /*
    Firma: Retorno librosMásPrestados(); 
 
    Descripción: Se deben listar el/los libros más prestados ordenado por ISBN, cargando el resultado en el valor String del retorno. En 
    caso de existir libros con la misma cantidad “máxima de préstamos”, se deberán mostrar todos.
    Retornos posibles 
    OK Si listan los n libros más reservados 
    
    */
    
    @Override
    public Retorno librosMasPrestados() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = ""; // Inicializar el valor

        if (listaLibros.esVacia()) {
            r.valorString = "No hay libros disponibles.";
            return r;
        }

        if (listaPrestamos.esVacia()) {
            r.valorString = "No hay préstamos registrados.";
            return r;
        }

        int maxPrestamos = 0;
        ListaSimple<Libro> librosMasPrestados = new ListaSimple<>();

        for (int i = 0; i < listaLibros.largo(); i++) {
            Libro libro = listaLibros.obtenerPorIndice(i);
            int prestamosPorISBN = 0;
        
            for (int j = 0; j < listaPrestamos.largo(); j++) {
                if (listaPrestamos.obtenerPorIndice(j).getISBN().equals(libro.getISBN())) {
                    prestamosPorISBN++;
                }
            }

            if (prestamosPorISBN > maxPrestamos) {
                maxPrestamos = prestamosPorISBN;
                librosMasPrestados = new ListaSimple<>();
                librosMasPrestados.agregar(libro);
            } else if (prestamosPorISBN == maxPrestamos) {
                librosMasPrestados.agregar(libro);
            }
        }

        listaLibros.ordenarLibrosPorISBN(librosMasPrestados);

        if (librosMasPrestados.esVacia()) {
            r.valorString = "No hay libros más prestados.";
        } else {
            for (int i = 0; i < librosMasPrestados.largo(); i++) {
                Libro libro = librosMasPrestados.obtenerPorIndice(i);
                r.valorString += libro.getNombre() + " - ISBN: " + libro.getISBN();
                if (i < librosMasPrestados.largo() - 1) {
                    r.valorString += "\n";
                }
            }
        }

        return r;
    }
    
    
    @Override
    public Retorno deshacerEliminaciones(int n) {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = "";

    
        if (n <= 0) {
            return Retorno.error1(); 
        }

        int contador = 0;

    
        while (contador < n && !pilaEliminados.esVacia()) {
            Libro libroRecuperado = pilaEliminados.eliminar();
            listaLibros.agregar(libroRecuperado); 
            r.valorString += libroRecuperado.toString() + "|";
            contador++;
        }

        

        return r;
        }

    /*
    Descripción: Se debe retornar en valor entero la cantidad de préstamos activos del libro indicado.
    Retornos posibles
    OK Si se retorna la cantidad de préstamos activos.
    ERROR 1.- Si el ISBN es vacío o null
    */
    
    @Override
    public Retorno cantidadPrestamosActivos(String ISBN) {
        
        if(ISBN == null || ISBN.isEmpty()){
            return Retorno.error1();
        }  
        
        Libro libro = new Libro("",ISBN, "", 0);
        
        Retorno r = new Retorno(Retorno.Resultado.OK);
        
        r.valorEntero = 0; 
        for(int i = 0; i < listaPrestamos.largo(); i++){
            Prestamo aux = listaPrestamos.obtenerPorIndice(i);
            if(aux.getISBN().equals(libro.getISBN()) && aux.isActivo()){
                r.valorEntero++;
            }
        }
        return r;
    }
    
    /*
    Descripción: Se deberán listar la cantidad de libros prestados (activos y finalizados) 
    por cada categoría en orden alfabético,
    cargando el resultado de los libros en el valor string del retorno
    */

    @Override
    public Retorno prestamosXCategoría() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
        r.valorString = "";

        ListaSimple<String[]> categorias = new ListaSimple<>();

        for (int i = 0; i < listaPrestamos.largo(); i++) {
            Prestamo prestamo = listaPrestamos.obtenerPorIndice(i);

            for (int j = 0; j < listaLibros.largo(); j++) {
                Libro libro = listaLibros.obtenerPorIndice(j);

                if (libro.getISBN().equals(prestamo.getISBN())) {
                    String categoria = libro.getCategoria();

                    boolean encontrada = false;
                    for (int k = 0; k < categorias.largo(); k++) {
                        String[] cat = categorias.obtenerPorIndice(k);
                        if (cat[0].equals(categoria)) {
                            cat[1] = String.valueOf(Integer.parseInt(cat[1]) + 1);
                            encontrada = true;
                            break;
                        }
                    }

                if (!encontrada) {
                    categorias.agregar(new String[]{categoria, "1"});
                }
                break;
                }
            }
        }
    

        ordenarCategorias(categorias);

        for (int i = 0; i < categorias.largo(); i++) {
            String[] categoria = categorias.obtenerPorIndice(i);
            r.valorString += categoria[0] + "#" + categoria[1] + "|";
        }      
        
        return r;
    }
    
    


    private void ordenarCategorias(ListaSimple<String[]> categorias) {
        int n = categorias.largo();
        boolean desordenado = true;

        while (desordenado) {
            desordenado = false;
            for (int i = 0; i < n - 1; i++) {
                String[] actual = categorias.obtenerPorIndice(i);
                String[] siguiente = categorias.obtenerPorIndice(i + 1);

                if (actual[0].compareTo(siguiente[0]) > 0) {
                    // Intercambio seguro
                    String[] temp = actual;
                    categorias.eliminar(actual);
                    categorias.eliminar(siguiente);
                    categorias.agregarEnIndice(i, siguiente);
                    categorias.agregarEnIndice(i + 1, temp);
                    desordenado = true;
                }
            }
        }
    }
   
    


}
