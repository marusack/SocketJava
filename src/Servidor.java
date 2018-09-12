

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Socket Servidor
 * @author mariel.sack@globant.com
 *
 */
public class Servidor {

    public static void main(String[] args) throws InterruptedException {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        //asigno el num de puerto segun recomendaciones de internet
        final int PUERTO = 5000;

        try {
            //se crea el socket q va a actuar como servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Server RDD2018 listening: ...");

            //esperando por clientes 
            while (true) {
            	//espera a que una coneccion se realice y cuando lo hace crea el socket
            	sc = servidor.accept();

                
                in = new DataInputStream(sc.getInputStream());//para escuchar a los clientes
                out = new DataOutputStream(sc.getOutputStream());

                //Leo el mensaje que me envia
                String mensaje = in.readUTF();
                System.out.println("Cliente conectado..... escuchando mensaje");
                Thread.sleep(1000);
                System.out.println("******************************************");
                Thread.sleep(1000);
                System.out.println(mensaje);
                Thread.sleep(1000);
                System.out.println("******************************************");
                Thread.sleep(1000);
                //Le envio un mensaje
                out.writeUTF("Mensaje desde el Servidor al Cliente ! Ya lo mostre.");
                
                //Cierro el socket cliente
                sc.close();
                System.out.println("cerrando conexion. Cliente desconectado");

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
