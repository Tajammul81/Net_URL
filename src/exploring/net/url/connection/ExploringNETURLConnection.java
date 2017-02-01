/*URLConnection is a general-purpose class for accessing the attributes of a remote
resource. Once you make a connection to a remote server, you can use URLConnection
to inspect the properties of the remote object before actually transporting it locally.
These attributes are exposed by the HTTP protocol specification and, as such, only
make sense for URL objects that are using the HTTP protocol. We’ll examine the most
useful elements of URLConnection here.
In the following example, we create a URLConnection using the openConnection( )
method of a URL object and then use it to examine the document’s properties and content:
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exploring.net.url.connection;

/**
 *
 * @author tajoo
 */
import java.io.*;
import java.net.*;
import java.util.Date;
public class ExploringNETURLConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int c;
        URL hp= new URL("http://www.internic.net");
        URLConnection hpcon= hp.openConnection();
        
        // getting Date
        long d=hpcon.getDate();
        if(d==0)
            System.out.print("no date information");
        else
            System.out.println("Date: " +new Date(d));
        
        //getting content type
        System.out.println("Content Type: " +hpcon.getContentType());
        
        //getting expiration date
        d=hpcon.getExpiration();
        if(d==0)
            System.out.println("No Expiration Information");
        else
            System.out.println("Expires: " +new Date(d));
        
        //getting last modified
        d=hpcon.getLastModified();
        if(d==0)
            System.out.println("No last-modification Infomration");
        else
            System.out.println("Last-Modified: " +new Date(d));
        
        //getting content length
        int len;
        len= hpcon.getContentLength();
        if(len==-1)
            System.out.println("Content length unavailable");
        else
            System.out.println("Content Length: " +len);
        
        if(len!=0)
        {
            System.out.println("=== Content===");
        InputStream input= hpcon.getInputStream();
        int i= len;
        while(((c=input.read())!=-1))
        {
            // &&(--i>0))
            
            System.out.print((char)c);
        }
            input.available();
        }
        else
    {
        System.out.println("No content available");
    }
    }
}

