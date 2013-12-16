
package tarea3;

import java.util.Vector;


public class Pintor {
   
    Vector nodos;    
    Vector colores; 
    
    
    
    public Pintor(Vector nodos, Vector colores){
        
        this.nodos    = new Vector();
        this.colores  = new Vector();
        //this.betados  = new Vector();
        
        for(int i=0;i<nodos.size();i++){
            
            this.nodos.add(nodos.elementAt(i));
            
        }
        
        for(int k=0;k<colores.size();k++){
            
            this.colores.add(colores.elementAt(k));
            
        }
    }
    
    public Vector colorVegas(){ // ESTE MÉTODO SOLO REPRESENTA UNA CORRIDA DEL ALGORITMO VEGAS
        
        Vector nodosLocal = nodos;
        Vector coloresLocal = colores;
        Vector betados = new Vector();
        Vector resultado = new Vector();
        
        boolean fin = false;
        int posicion;
        
        
        while (!fin){
            
                        
            if(nodosLocal.size()==0){
                posicion=generador(0,nodosLocal.size()); //Generación del random para escoger los nodos disponibles
            }else{
                posicion=generador(0,nodosLocal.size()-1); //Generación del random para escoger los nodos disponibles
            }
            
            Nodo tmp = (Nodo) nodosLocal.elementAt(posicion);
            nodosLocal.removeElementAt(posicion);
            
            Vector posiblesColores = coloresLocal;
            
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
            //ADICIONAR RESTRICCIÓN SI LA LISTA DE POSIBLES COLORES ES 0
            posicion=generador(0,posiblesColores.size()-1); //Generación del random para escoger el color
            System.out.println("posicion: "+posicion);
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
            
            if (nodosLocal.size()==0){
                
                fin=true;
                
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
    
       
}
