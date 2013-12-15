package tarea3;

import java.io.*;
import java.awt.*;
import java.util.Vector;

public class Vertice
{
	private int radio;
	private boolean estadoFinal;
	private Point coords1, coordsCentro, dimensiones;
        
	
	public Vertice(Point inCoords, boolean inEstadoFinal)
	{
		radio=5;
		coordsCentro=inCoords;
		estadoFinal=inEstadoFinal;
		coords1=new Point(inCoords.x-radio, inCoords.y-radio);                
	}
	
	public boolean isEstadoFinal()
	{
		return estadoFinal;
	}
	
	public Point getCoords1()
	{
		return coords1;
	}
	
	public Point getCoordsCentro()
	{
		return coordsCentro;
	}
	
	public int getRadio()
	{
		return radio;
	}    
}
