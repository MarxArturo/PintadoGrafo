
package tarea3;

import java.util.Vector;


public class Pintor {
   
    private Vector nodos;    
    private Vector colores; 
    private boolean fallo;
    private long tiempoInicio;
    private long duracion;
    
       public Pintor(Vector nodos, Vector colores){
        
        this.nodos    = (Vector)nodos.clone();
        this.colores  = (Vector)colores.clone();
        this.fallo=false;
        this.tiempoInicio=System.currentTimeMillis();
    }
    
    public Vector colorVegas(){ // ESTE MÉTODO SOLO REPRESENTA UNA CORRIDA DEL ALGORITMO VEGAS
        
        Vector nodosLocal = (Vector)nodos.clone();
        Vector betados = new Vector();
        Vector resultado = new Vector();
        
        boolean fin = false;
        int posicion;
        Vector posiblesColores;
        
        
        while (!fin){
            
            posiblesColores=(Vector)colores.clone();            
            
            if(nodosLocal.size()==0){
                posicion=generador(0,nodosLocal.size()); //Generación del random para escoger los nodos disponibles
            }else{
                posicion=generador(0,nodosLocal.size()-1); //Generación del random para escoger los nodos disponibles
            }
            
            Nodo tmp = (Nodo) nodosLocal.elementAt(posicion);
            nodosLocal.removeElementAt(posicion);
            
            for (int i=0; i<betados.size();i++){    // Analizando la lista de colores betados para descartar los colores
                                                    // de la lista de colores posibles
               
                Vector betadosTemp = (Vector) betados.elementAt(i);
                              
                if((int)betadosTemp.elementAt(0)==tmp.getId()){
                    
                    int col = (int)betadosTemp.elementAt(1);
                    
                    for(int k=0;k<posiblesColores.size();k++){
                        
                        if((int)posiblesColores.elementAt(k)==col){
                            
                            posiblesColores.removeElementAt(k);
                            
                        }
                        
                    }
                }
                           
            }
            
            
            //System.out.println("colores Posibles: "+posiblesColores);
            posicion=generador(0,posiblesColores.size()-1); //Generación del random para escoger el color
            
            if(posiblesColores.size()==0){
                posiblesColores=(Vector)colores.clone();
                System.out.println("LA RESPUESTA NO ES CORRECTA");
                fallo=true;
            }
            
            int pintarColor = (int) posiblesColores.elementAt(posicion);
            Vector pintado = new Vector();
            pintado.add((int)tmp.getId());
            pintado.add(pintarColor);
            resultado.add(pintado); // SE AGREGA EL NODO PINTADO A LA SOLUCIÓN
            Vector adyacentes = tmp.getAdyacentes();
            for(int r=0;r<adyacentes.size();r++){ // Agregar a la lista de betados los nodos aadyacentes del mismo color
                
                int idAdyacente = (int)adyacentes.elementAt(r);
                Vector nuevoBetado = new Vector();
                nuevoBetado.add(idAdyacente);
                nuevoBetado.add(pintarColor);
                betados.add(nuevoBetado);
                
            }
            //System.out.println("Betados: "+betados);
            //System.out.println("Resultado: "+resultado);
            if (nodosLocal.size()==0){
                
                fin=true;
                duracion=System.currentTimeMillis()-tiempoInicio;
                //System.out.println("El tiempo de ejecución fue de "+duracion);
            }
            
            
        }
        
        return resultado;       
    }
    
    private int generador(int limInf, int limSup){
        
        int numero=0;
        numero = limInf + Double.valueOf(Math.random()*(limSup-limInf)).intValue();
        return numero;
    }

    public Vector getNodos() {
        return nodos;
    }

    public void setNodos(Vector nodos) {
        this.nodos = nodos;
    }

    public Vector getColores() {
        return colores;
    }

    public void setColores(Vector colores) {
        this.colores = colores;
    }
    
     public boolean isFallo() {
        return fallo;
    }

    public void setFallo(boolean fallo) {
        this.fallo = fallo;
    }

    public long getDuracion() {
        return duracion;
    }
    
    
}
