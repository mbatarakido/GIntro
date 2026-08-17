
import java.io.*;
import java.net.*;

public class GetUrl {

   public static void main (String[] args) {

      URL u;
      InputStream is = null;
      DataInputStream dis;
      String s;
      
      try {

          u = new URL("https://docs.nexcess.net/doc-1563.html");
          is = u.openStream();         
          dis = new DataInputStream(new BufferedInputStream(is));

          while ((s = dis.readLine()) != null) {
             System.out.println(s);
          }

       } catch (MalformedURLException mue) {

          System.out.println("Ouch - a MalformedURLException happened.");
          mue.printStackTrace();
          System.exit(1);

       } catch (IOException ioe) {

          System.out.println("Oops- an IOException happened.");
          ioe.printStackTrace();
          System.exit(1);

       } finally {

    	   try {
               is.close();
            } catch (IOException ioe) {
           }
         } 
      }  
   }