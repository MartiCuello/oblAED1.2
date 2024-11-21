/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pesce
 */
public class IObligatorioTest {
    
    private Sistema miSistema;
    
    public IObligatorioTest() {
    }
    
    @Before
    public void setUp() {
        miSistema = new Sistema();
        miSistema.crearSistemaDeGestion();
    }

    @Test
    public void testCrearSistemaDeGestion() {
        //Completar para primera entrega
    }
    
    
     @Test
    public void testAgregarEstudianteOk() {
        Retorno ret = miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
     @Test
    public void testAgregarEstudianteError1() {
        Retorno ret = miSistema.agregarEstudiante("", "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante(null, "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", null, 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("", "", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante(null, null, 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

    }
    
    @Test
    public void testAgregarEstudianteError2() {
        Retorno ret = miSistema.agregarEstudiante("Nombre", "Apellido", 0);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", -5);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", 500001);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", 500050);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }

    
    @Test
    public void testAgregarEstudianteError3() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
    }
    
    @Test
    public void testObtenerEstudianteOk() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.obtenerEstudiante(1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Estudiante{Nombre=Nombre, Apellido=Apellido, Numero=1111}", ret.valorString);
    }

     @Test
    public void testObtenerEstudianteError1() {
        Retorno ret = miSistema.obtenerEstudiante(-2);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(0);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(500001);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(500500);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
     @Test
    public void testObtenerEstudianteError2() {
        Retorno ret = miSistema.obtenerEstudiante(1111);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.obtenerEstudiante(1);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.obtenerEstudiante(49000);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }


    
    @Test
    public void testEliminarEstudianteOk() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.eliminarEstudiante(1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
    @Test
    public void testEliminarEstudianteError1() {
        Retorno ret = miSistema.eliminarEstudiante(-2);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
        
        ret = miSistema.eliminarEstudiante(60000);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    @Test
    public void testEliminarEstudianteError2() {
        Retorno ret = miSistema.eliminarEstudiante(2000);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
        
        ret = miSistema.eliminarEstudiante(40000);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }

    

    @Test
    public void testAgregarLibroOk() {
        Retorno ret = miSistema.agregarLibro("Nombre", "ISBN", "Categoria", 10);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
     @Test
    public void testAgregarLibroError1() {
        Retorno ret = miSistema.agregarLibro("Nombre", null, "Categoria", 10);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
        
        ret = miSistema.agregarLibro(null, "ISBN", "Categoria", 10);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
        
        ret = miSistema.agregarLibro("Nombre", "ISBN", null, 10);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
           
    }
    
    @Test
    public void testAgregarLibroError2() {
        Retorno ret = miSistema.agregarLibro("Nombre", "ISBN", "Categoria", 10);
        ret = miSistema.agregarLibro("Nombre2", "ISBN", "Categoria2", 102);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);   
    }
    
    @Test
    public void testAgregarLibroError3() {
        Retorno ret = miSistema.agregarLibro("Nombre", "ISBN", "Categoria", 0);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
        
        ret = miSistema.agregarLibro("Nombre2", "ISBN2", "Categoria2", -2);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
    }

    
    @Test
    public void testListarEstudiantesOk() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    

       @Test
    public void testListarLibros() {
        miSistema.agregarLibro("Nombre", "ISBN", "Categoria", 10);
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
    @Test
    public void testListarLibrosXCategoriaOk() {
        miSistema.agregarLibro("Nombre", "ISBN", "Categoria", 10);
        miSistema.agregarLibro("Nombre22", "ISBN22", "Categoria", 102);
        Retorno ret = miSistema.listarLibros("Categoria");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
    @Test
    public void testListarLibrosXCategoriaError1() {
        Retorno ret = miSistema.listarLibros(null);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    
    @Test
    public void prestarLibroOk(){
        miSistema.agregarLibro("Nombre", "abcdefg1", "Categoria", 10);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        Retorno ret = miSistema.prestarLibro("abcdefg1", 123);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
    
    @Test
    public void testPrestarLibroError1() {
        Retorno ret = miSistema.prestarLibro("", 123);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.prestarLibro(null, 123);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    @Test
    public void testPrestarLibroError2() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        Retorno ret = miSistema.prestarLibro("ISBN_inexistente", 123);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }
    
    @Test
    public void testPrestarLibroError3() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 10);

        Retorno ret = miSistema.prestarLibro("ISBN123", 0);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);

        ret = miSistema.prestarLibro("ISBN123", -1);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);

        ret = miSistema.prestarLibro("ISBN123", 500001);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
    }
    
    @Test
    public void testPrestarLibroError4() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 10);

        Retorno ret = miSistema.prestarLibro("ISBN123", 123);
        assertEquals(Retorno.Resultado.ERROR_4, ret.resultado);
    }
    
    
    @Test
    public void testPrestarLibroError5() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 1);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        miSistema.prestarLibro("ISBN123", 123);
        miSistema.agregarEstudiante("Nombre", "Apellido", 456);


        Retorno ret = miSistema.prestarLibro("ISBN123", 456);
        assertEquals(Retorno.Resultado.ERROR_5, ret.resultado);
    }
    
  
    
    @Test
    public void testPrestarLibroError6() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 10);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

    
        miSistema.prestarLibro("ISBN123", 123);

        Retorno ret = miSistema.prestarLibro("ISBN123", 123);
        assertEquals(Retorno.Resultado.ERROR_6, ret.resultado);

        for (int i = 0; i < 7; i++) {
            miSistema.agregarLibro("Libro" + i, "ISBN" + i, "Categoria", 10);
            miSistema.prestarLibro("ISBN" + i, 123);
        }

        miSistema.agregarLibro("NuevoLibro", "ISBN9", "Categoria", 10);
        ret = miSistema.prestarLibro("ISBN9", 123);
        assertEquals(Retorno.Resultado.ERROR_6, ret.resultado);
    }

    
    @Test
    public void testReservarLibroOk() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 1);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        miSistema.agregarEstudiante("Nombre1", "Apellido1", 456);
        miSistema.prestarLibro("ISBN123", 123);

        Retorno ret = miSistema.reservarLibro("ISBN123", 456);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
}
    
    @Test
    public void testReservarLibroError1() {
        Retorno ret = miSistema.reservarLibro("", 123);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.reservarLibro(null, 123);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    

    @Test
    public void testReservarLibroError2() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        Retorno ret = miSistema.reservarLibro("ISBN", 123);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }
    
    
    @Test
    public void testReservarLibroError3() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 1);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        miSistema.prestarLibro("ISBN123", 123);
        
        Retorno ret = miSistema.reservarLibro("ISBN123", 0);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);

        ret = miSistema.reservarLibro("ISBN123", -1);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);

        ret = miSistema.reservarLibro("ISBN123", 500001);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
    }
    
    @Test
    public void testReservarLibroError4() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 1);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        miSistema.prestarLibro("ISBN123", 123);
        
        Retorno ret = miSistema.reservarLibro("ISBN123", 456);
        assertEquals(Retorno.Resultado.ERROR_4, ret.resultado);
    }
    
    @Test
    public void testReservarLibroError5() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 5);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        Retorno ret = miSistema.reservarLibro("ISBN123", 123);
        assertEquals(Retorno.Resultado.ERROR_5, ret.resultado);
    }
    
    
    @Test
    public void testDevolverLibroOkk() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 5);        
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        miSistema.prestarLibro("ISBN123", 123);

        Retorno ret = miSistema.devolverLibro("ISBN123", 123);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
     
    }

    
    @Test
    public void testDevolverLibroError1() {
        Retorno ret = miSistema.devolverLibro("", 123);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.devolverLibro(null, 123);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    @Test
    public void testDevolverLibroError2() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        Retorno ret = miSistema.devolverLibro("ISBN", 123);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }
    
    @Test
    public void testDevolverLibroError3() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 5);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        Retorno ret = miSistema.devolverLibro("ISBN123", 0);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);

        ret = miSistema.devolverLibro("ISBN123", -1);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);

        ret = miSistema.devolverLibro("ISBN123", 500001);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
    }

    @Test
    public void testDevolverLibroError4() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 5);

        Retorno ret = miSistema.devolverLibro("ISBN123", 123);
        assertEquals(Retorno.Resultado.ERROR_4, ret.resultado);
    }
    
    @Test
    public void testDevolverLibroError5() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 5); 
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        miSistema.prestarLibro("ISBN123", 123);
        miSistema.devolverLibro("ISBN123", 123);

        Retorno ret = miSistema.devolverLibro("ISBN123", 123);
        assertEquals(Retorno.Resultado.ERROR_5, ret.resultado);
    }
    
    @Test
    public void testEliminarLibroOk() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 5);

        Retorno ret = miSistema.eliminarLibro("ISBN123");
        assertEquals(Retorno.Resultado.OK, ret.resultado);

    }
    
    @Test
    public void testEliminarLibroError1() {
        Retorno ret = miSistema.eliminarLibro("");
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.eliminarLibro(null);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    @Test
    public void testEliminarLibroError2() {
        miSistema.agregarLibro("Nombre", "ISBN123", "Categoria", 5);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        miSistema.prestarLibro("ISBN123", 123);

        Retorno ret = miSistema.eliminarLibro("ISBN123");
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }
    
    
    @Test
    public void testListarPrestamosOk() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);
        miSistema.agregarLibro("Libro1", "ISBN1", "Categoria", 5);
        miSistema.agregarLibro("Libro2", "ISBN2", "Categoria", 5);

        miSistema.prestarLibro("ISBN1", 123);
        miSistema.prestarLibro("ISBN2", 123);

        Retorno ret = miSistema.listarPrestamos(123);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
    @Test
    public void testListarPrestamosError1() {
        Retorno ret = miSistema.listarPrestamos(0);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.listarPrestamos(-1);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.listarPrestamos(500001);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    @Test
    public void testListarPrestamosError2() {
        Retorno ret = miSistema.listarPrestamos(123);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }
    
    @Test
    public void testLibrosMasPrestados() {
        miSistema.agregarLibro("Libro1", "ISBN1", "Categoria", 5);
        miSistema.agregarLibro("Libro2", "ISBN2", "Categoria", 5);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        miSistema.prestarLibro("ISBN1", 123); 
        miSistema.prestarLibro("ISBN1", 123); 

        Retorno ret = miSistema.librosMasPrestados();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
    
    @Test
    public void testDeshacerEliminacionesOkMenosEliminaciones() {
        miSistema.agregarLibro("Libro1", "ISBN1", "Categoria", 5);
        miSistema.agregarLibro("Libro2", "ISBN2", "Categoria", 5);

        miSistema.eliminarLibro("ISBN1");
        miSistema.eliminarLibro("ISBN2");

        Retorno ret = miSistema.deshacerEliminaciones(1);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
    @Test
    public void testDeshacerEliminacionesError1() {
        Retorno ret = miSistema.deshacerEliminaciones(0);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.deshacerEliminaciones(-1);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    @Test
    public void testCantidadPrestamosActivosOk() {
        miSistema.agregarLibro("Libro1", "ISBN1", "Categoria", 5);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        miSistema.prestarLibro("ISBN1", 123);

        Retorno ret = miSistema.cantidadPrestamosActivos("ISBN1");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals(1, ret.valorEntero);
    }
    
    @Test
    public void testCantidadPrestamosActivosError1() {
        Retorno ret = miSistema.cantidadPrestamosActivos("");
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.cantidadPrestamosActivos(null);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    
    @Test
    public void testPrestamosXCategoriaUnaCategoria() {
        miSistema.agregarLibro("Libro1", "ISBN1", "Categoria1", 5);
        miSistema.agregarLibro("Libro2", "ISBN2", "Categoria1", 5);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        miSistema.prestarLibro("ISBN1", 123);
        miSistema.prestarLibro("ISBN2", 123);

        Retorno ret = miSistema.prestamosXCategoría();
        assertEquals(Retorno.Resultado.OK, ret.resultado);

        assertEquals("Categoria1#2|", ret.valorString); 
    }
    
    @Test
    public void testPrestamosXCategoriaMultiplesCategorias() {
        miSistema.agregarLibro("Libro1", "ISBN1", "Categoria1", 5);
        miSistema.agregarLibro("Libro2", "ISBN2", "Categoria2", 5);
        miSistema.agregarLibro("Libro3", "ISBN3", "Categoria1", 5);
        miSistema.agregarEstudiante("Nombre", "Apellido", 123);

        miSistema.prestarLibro("ISBN1", 123);
        miSistema.prestarLibro("ISBN2", 123);
        miSistema.prestarLibro("ISBN3", 123);

        Retorno ret = miSistema.prestamosXCategoría();
        assertEquals(Retorno.Resultado.OK, ret.resultado);

        assertEquals("Categoria1#2|Categoria2#1|", ret.valorString);
    }    
    
}
