package test;
import static org.junit.Assert.*;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Before;
import org.junit.Test;
import beans.HolaEJB;

public class HolaEJBTest {
    private static EJBContainer contenedor;
    private static Context contexto;
    private static HolaEJB ejb;
    
    @Before
    public void iniciarContenedor() throws Exception {
        System.out.println("Iniciando EJB Container");
        contenedor = EJBContainer.createEJBContainer();
        contexto = contenedor.getContext();
        ejb = (HolaEJB) contexto.lookup("java:global/classes/HolaEJB!beans.HolaEJB"); 
    }
    
    @Test 
    public void testAddNumbers() throws Exception { 
        int dato1 = 3; 
        int dato2 = 5; 
        int resultado = ejb.sumar(dato1, dato2); 
        assertEquals((dato1 + dato2), resultado); 
        System.out.println("\nOperacion terminada, resultado: " + resultado + "\n"); 
    }
}
