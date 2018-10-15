package Persistencia;

/**
 * Una clase usada para grabar objetos de la clase TSBSimpleList 
 * mediante Serializacion.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Septiembre de 2017.
 */
import Clases.Pedido;
import java.io.*;
public class Writer
{
      // nombre del archivo serializado...
      private String arch = "lista.dat";
    
      /**
       * Crea un objeto SimpleListWriter. Supone que el nombre del archivo a grabar 
       * sera "lista.dat".
       */
      public Writer()
      {
      }
      
      /**
       * Crea un objeto SimpleListWriter. Fija el nombre del archivo que se graba con 
       * el nombre tomado como parametro.
       * @param nom el nombre del archivo a grabar.
       */
      public Writer(String nom)
      {
            arch = nom;
      }
      
      /**
       * Graba la lista tomada como parametro.
       * @param sl la lista a serializar.
       * @throws TSBSimpleListIOException si se encuentra un error de IO.
       */
      public void write (Pedido sl) throws IOException
      {
           try
           {
             FileOutputStream ostream = new FileOutputStream(arch);
             ObjectOutputStream p = new ObjectOutputStream(ostream);
      
             p.writeObject(sl);
      
             p.flush(); 
             ostream.close();
           }
           catch ( IOException e )
           {
             throw new IOException("No se pudo grabar...");
           }
      }
}
