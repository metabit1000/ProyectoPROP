package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Àlex
 */
public class CtrlDatosUsuarios {
    File archivo;
    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    String path = "UsuariosRegistrados.txt";
    
     public CtrlDatosUsuarios(){
        archivo = null;
        fr = null;
        br = null;
        abrirArchivo();
    }
    
    public void abrirArchivo() {
        archivo = new File(path);
        if (!archivo.exists()) try {
            archivo.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Función que cierra el archivo
     * @throws java.io.IOException
     */
    public void cerrarArchivo() throws IOException {
        archivo = null;
        if (null != fr) fr.close();
        if (null != fw) fw.close();

    }
    
    public void escribirUsuario(String nombre, String password) {
        System.out.println(nombre + password);
        if (archivo == null) {
            throw new IllegalArgumentException("Error: No hay ningun archivo abierto.");
        }
        try {
            fw = new FileWriter(archivo,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            if (archivo.length() == 0) out.write(nombre+" "+ password); //en caso de estar vacio...
            else {
                bw.newLine(); //salto de linea en fichero
                out.append(nombre +" "+ password);
            }
            fw.close();
            out.close();
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void introducirProblemaCreado(String nombre, int id) {
        File nuevo = new File("random.txt"); //fichero auxiliar
        String cambiar = null;
        try {
            if (archivo.exists()) {
                br = new BufferedReader(new FileReader(archivo));
                String linea;
                while((linea = br.readLine()) != null) {
                    String[] lineaDivididaId = linea.split(" ");
                    if(lineaDivididaId[0].equals(nombre)) {
                        for (int i = 0; i < lineaDivididaId.length; ++i) {
                            if (i == 0) cambiar = lineaDivididaId[0];
                            else cambiar = cambiar +" "+ lineaDivididaId[i];
                        }
                        cambiar = cambiar + " " + id;
                        Escribir(nuevo,cambiar);
                    }
                    else Escribir(nuevo,linea);    
                }
                br.close(); 
                borrar(archivo); //borro archivo anterior
                nuevo.renameTo(archivo); //Renombro el archivo con el anterior
            }
            else System.out.println("No existe el fichero");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Integer> getProblemasCreados(String nombre) {
        ArrayList<Integer> res = new ArrayList();
        if (archivo == null) {
            throw new IllegalArgumentException("Error: No hay ningun archivo abierto.");
        }
        try {
            if (archivo.exists()) {
                br = new BufferedReader(new FileReader(archivo));
                String linea;
                while((linea = br.readLine()) != null) {
                    String[] lineaDivididaId = linea.split(" ");
                    if(lineaDivididaId[0].equals(nombre)) {
                        for (int i = 2; i < lineaDivididaId.length; ++i) {
                            res.add(Integer.parseInt(lineaDivididaId[i]));
                        }
                    }
                }
                br.close();
            }
        }catch(IOException | NumberFormatException e) {
            System.out.println(e);
        }
        return res;
    } 
    
    public boolean usuarioRegistrado(String nombre, String password)  {
        boolean b = false;
        try {
            if (archivo.exists()) {
                br = new BufferedReader(new FileReader(archivo));
                String linea;
                while((linea = br.readLine()) != null) {
                   String[] lineaDividida = linea.split(" ");
                   if(lineaDividida[0].equals(nombre) && lineaDividida[1].equals(password)) b = true;
                }
                br.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return b;
    }
    
    public boolean existeNombre(String nombre)  {
        boolean b = false;
        try {
            if (archivo.exists()) {
                br = new BufferedReader(new FileReader(archivo));
                String linea;
                while((linea = br.readLine()) != null) {
                   String[] lineaDividida = linea.split(" ");
                   if(lineaDividida[0].equals(nombre)) b = true;
                }
                br.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return b;
    }
    
    public void modificarPassword(String nombre, String password, String newPassword) {
        File nuevo = new File("random.txt"); //fichero auxiliar
        String cambiar = null;
        try {
            if (archivo.exists()) {
                br = new BufferedReader(new FileReader(archivo));
                String linea;
                while((linea = br.readLine()) != null) {
                    String[] lineaDividida = linea.split(" ");
                    if(lineaDividida[0].equals(nombre) && lineaDividida[1].equals(password)) {
                        for (int i = 0; i < lineaDividida.length; ++i) {
                            switch (i) {
                                case 0:
                                    cambiar = lineaDividida[0];
                                    break;
                                case 1:
                                    cambiar = cambiar + " " + newPassword;
                                    break;
                                default:
                                    cambiar = cambiar + " " + lineaDividida[i];
                                    break;
                            }
                        }
                        Escribir(nuevo,cambiar);
                    }
                    else Escribir(nuevo,linea);    
                }
                br.close(); 
                borrar(archivo); //borro archivo anterior
                nuevo.renameTo(archivo); //Renombro el archivo con el anterior                 
            }
            else System.out.println("No existe el fichero");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    private void borrar(File Ffichero){
        try {
            if(Ffichero.exists()){
                Ffichero.delete();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private void Escribir(File fFichero,String cadena)
    {
        // Declaramos un buffer de escritura
        BufferedWriter bw;
        try
        {
            // Comprobamos si el archivo no existe y si es asi creamos uno nuevo.
         if(!fFichero.exists())
         {
             fFichero.createNewFile();
         }
           // Luego de haber creado el archivo procedemos a escribir dentro de el.
            bw = new BufferedWriter(new FileWriter(fFichero,true));
            if (fFichero.length() == 0) bw.write(cadena);
            else {
                bw.newLine(); //salto de linea en fichero
                bw.write(cadena);
            }
            bw.close();

        }catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
