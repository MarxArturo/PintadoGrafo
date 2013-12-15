/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import java.util.Vector;

/**
 *
 * @author Marx
 */
public class Nodo {
    private int id;
    private Vector adyacentes = new Vector(); 
    
    public Nodo(int id, Vector adyacentes) {
        this.id = id;
        this.adyacentes=adyacentes;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
        
    }

    public Vector getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(Vector adyacentes) {
        this.adyacentes = adyacentes;
    }
}
