package Persistencia;

/**
 *  Clase que permite recuperar desde un archivo externo un objeto de
 *  la clase TSBSimpleList que haya sido grabado por Serializacion.
 *  @author Ing. Valerio Frittelli.
 *  @version Septiembre de 2017.
 */
import Clases.Pedido;
import java.io.*;
public class Reader 
{
      private String arch = "lista.dat";
    
      /**
       * Crea un objeto SimpleListReader. Asume que el nombre del archivo desde el 
       * cual se recupera es "lista.dat".
       */
      public Reader()
      {
      }
      
      /**
       * Crea un objeto SimpleListReader. Fija el nombre del archivo desde el cual 
       * se recupera con el nombre tomado como parametro.
       * @param nom el nombre del archivo a abrir para iniciar la recuperacion.
       */
      public Reader(String nom)
      {
          arch = nom;
      }
      
      
      /**
       * Recupera una SimpleList desde un archivo serializado.
       * @throws TSBSimpleListIOException si se encuentra un error de IO.
       * @return una referencia al objeto recuperado.
       */
      public Pedido read() throws IOException
      {
           Object sl = null;
           
           try
           {
                 FileInputStream istream = new FileInputStream(arch);
                 ObjectInputStream p = new ObjectInputStream(istream);
          
                 sl =  (Pedido) p.readObject();
                 
                 p.close();
                 istream.close();
           }
           catch (Exception e)
           {
             throw new IOException("No se pudo recuperar la lista");
           }
           
           return (Pedido) sl;
       }
}