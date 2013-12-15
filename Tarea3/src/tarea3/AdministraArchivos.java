package tarea3;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class AdministraArchivos
{
    private Integer estadoInicial;
    private Vector estadosFinales; //vector de enteros
    private Vector simbolos; // vector de chars
    private Vector[] estados; // arreglo de vectores de enteros
    private Vector allNodos;
    private Nodo[] nodos;
    
    
    public AdministraArchivos()
    {
        estadoInicial = 0;
        estadosFinales = new Vector(1,1); //vector de enteros
        simbolos = new Vector(1,1); // vector de chars
        allNodos=new Vector();
    }
    
    public boolean leerAutomata(String nombre)
    {
        try
        {
            FileInputStream fstream = new FileInputStream(nombre);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String linea;
            StringTokenizer separador;
            Vector vector;
            int indice;
            int cont;
            String[] strEstados;

            estadoInicial = Integer.parseInt(br.readLine());

            linea = br.readLine();
            separador = new StringTokenizer(linea);
            while (separador.hasMoreTokens())
            {
                  estadosFinales.add(Integer.parseInt(separador.nextToken()));
            }

            
            linea = br.readLine();
            separador = new StringTokenizer(linea);

            while (separador.hasMoreTokens())
            {
                  simbolos.add(separador.nextToken().charAt(0));
            }

            estados = new Vector[simbolos.size()];
            nodos = new Nodo[simbolos.size()];

            for(int i = 0; i < simbolos.size();i++)
            {
                estados[i] = new Vector(1,1);
                
            }

            while ((linea = br.readLine()) != null)
            {
                indice = 0;
                cont = 0;
                separador = new StringTokenizer(linea);
                strEstados = new String[separador.countTokens()];

                while (separador.hasMoreTokens())
                {
                  strEstados[cont] = separador.nextToken();
                  cont++;
                }

                for(int i = 0; i < strEstados.length; i++)//por nodo
                {
                    vector = new Vector(1,1);
                    separador = new StringTokenizer(strEstados[i], ",");
                    Vector adyacente=new Vector();
                    
                    while (separador.hasMoreTokens())//conectados a
                    {
                        String dato = separador.nextToken();
                        if(!dato.equals("#")){
                            adyacente.add(Integer.parseInt(dato));
                            
                        }
                        try
                        {
                            vector.add(Integer.parseInt(dato));
                        }
                        catch(NumberFormatException e)
                        {
                            vector.add(dato);
                        }
                    }
                    Nodo nodo=new Nodo(i, adyacente);
                    
                    estados[indice].add(vector);
                    nodos[indice]=nodo;
                    indice++;
                }

            }
            for(int r=0;r<nodos.length;r++){
                allNodos.add(nodos[r]);
            }
//            for(int y=0;y<allNodos.size();y++){
//            Nodo n=(Nodo)allNodos.elementAt(y);    
//            System.out.println(n.getId());}
            in.close();
            
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public Vector leerCadenas(String nombre)
    {
        Vector cadenas = new Vector(1,1);
         try
        {
            FileInputStream fstream = new FileInputStream(nombre);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String linea;

            while ((linea = br.readLine()) != null)
            {
               cadenas.add(linea);
            }
            in.close();
        }
        catch (Exception e)
        {
			return null;
        }
        return cadenas;
    }
    
    public void guardar(String[] salida) 
    {
        String ruta = JOptionPane.showInputDialog(null, "Nombre de Salida");
         try
         {
            // Create file
            FileWriter fstream = new FileWriter(ruta+".txt");
            BufferedWriter out = new BufferedWriter(fstream);
             for(int i = 0; i < salida.length;i++)
             {
                    out.write(salida[i]);
                    out.newLine();
             }
             out.close();
             JOptionPane.showMessageDialog(null, "Las cadenas fueron verificadas Correctamente");
         }
         catch (Exception e)
         {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
         }
    }

    public void guardarAFD(Integer estadoInicial, Vector estadosFinales, Vector simbolos, Vector[] estados)
    {
        try
         {
            // Create file
            String ruta = JOptionPane.showInputDialog(null, "Nombre de Salida");
            if(ruta==null) return;
            FileWriter fstream = new FileWriter(ruta + ".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(""+estadoInicial);
            out.newLine();
            for(int i = 0; i < estadosFinales.size();i++)
            {
                out.write(estadosFinales.get(i) + " ");
            }
            out.newLine();
            for(int i = 0; i < simbolos.size();i++)
            {
                out.write(simbolos.get(i) + " ");
            }
            out.newLine();

            for(int i = 0; i < estados[0].size();i++)
            {
                for(int j = 0; j< estados.length;j++)
                {
                    out.write(estados[j].get(i) + " ");
                }
                out.newLine();
            }
            out.close();
            JOptionPane.showMessageDialog(null, "El AFD a sido guardado");
         }
         catch (Exception e)
         {//Catch exception if any
            e.printStackTrace();
         }
    }

    public int getEstadoInicial() {
        return estadoInicial;
    }
    public Vector getEstadosFinales() {
        return estadosFinales;
    }    
    public Vector getSimbolos() {
        return simbolos;
    }
    public Vector[] getEstados(){
        return estados;
    }

    public Vector getAllNodos() {
        return allNodos;
    }

}
