/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problemabanco;

import java.util.Stack;

/**
 *
 * @author maraes
 */

public class SimularBanco {
    hello!!
    Stack<Object> ListadoEventos;
    boolean[] CajeroOcupado;
    double Tiempollegada,TiempoAtencion;
    Cliente cliente;
    int Cola;
    int ClientePerdido;
    int ClienteAtendido;
    int NumCajeroLibre=0;
    double totalTiempoAtencion;
    
    public void inicializarSimulacion(int CantidadCajeros){
        CajeroOcupado=new boolean[CantidadCajeros];
        for(int i=0;i<CajeroOcupado.length;i++){
            CajeroOcupado[i]=false;
        }
    }
    
    public  void eventollegada(){
        double timeAtencion;
        generarLlegada();
        if(Cola>7){
            ClientePerdido++;
        }else{
            if(haycajerolibre()==true){
                if(Cola>0&&Cola<=7){
                    Cola++;
                }else{
                    ClienteAtendido++;
                    CajeroOcupado[NumCajeroLibre]=true;              
                   
                }
            }
        }
    }
    public void eventoSalida(){
        
    }
    public void generarLlegada(){
        Tiempollegada=(-1)*Math.log(Math.random());
        TiempoAtencion=(10-2)*Math.random()+2;
        cliente=new Cliente(Tiempollegada,TiempoAtencion);
    //    ListadoEventos.push(cliente);        
    }
    

    private boolean haycajerolibre() {
       boolean libre=false;
        for(int i=0;i<CajeroOcupado.length;i++){
           if(CajeroOcupado[i]==false){
               NumCajeroLibre=i;
               libre=true;
           }
       }
        return libre;
    }
}
