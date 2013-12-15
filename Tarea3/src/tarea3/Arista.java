import java.io.*;
import java.awt.*;
import java.lang.Math;

public class Arista
{
	private Point coords1, coords2, coordsMedias;
	//private Point [] coordsFlecha;
	//private String simbolo;
	
	public Arista(Point inCoords1, Point inCoords2)
	{
		coords1=inCoords1;
		coords2=inCoords2;
		//simbolo=inSimbolo;
		
		//cambiar a simbolo de epsilon
//		if(simbolo.equals("_"))
//		{
//			simbolo="E";
//		}
		
		//coordsMedias (punto para que la arista no sea una linea recta)
		int diferenciaX=(int)(Math.random()*41-20);//para que se diferencien visualmente las aristas
		int diferenciaY=(int)(Math.random()*41-20);//para que se diferencien visualmente las aristas
		
		coordsMedias=new Point(((coords1.x-coords2.x)/2)*-1+coords1.x+diferenciaX, ((coords1.y-coords2.y)/2)*-1+coords1.y+diferenciaY);
		
		//Longitud de la arista desde coordsMedias
		double longitud=Math.sqrt(Math.pow(coordsMedias.x-coords2.x, 2)+Math.pow(coordsMedias.y-coords2.y, 2));
		
		//Puntos de la flecha
		//coordsFlecha=new Point [2];
		int longitudFlecha=18;//longitud de la flecha
		double diferenciaAngulos=0.04;//para la anchura de la flecha
		double teta;//angulo
		
		try
		{
			teta=Math.atan2(coords2.y-coordsMedias.y, coords2.x-coordsMedias.x);
		}
		catch(ArithmeticException e)
		{
			teta=Math.PI/2;
		}
		
		//coordsFlecha[0]=new Point((int)Math.round(coordsMedias.x+(Math.cos(teta+diferenciaAngulos)*(longitud-longitudFlecha))), (int)Math.round(coordsMedias.y+(Math.sin(teta+diferenciaAngulos)*(longitud-longitudFlecha))));//calculo del punto1 de la flecha
		//coordsFlecha[1]=new Point((int)Math.round(coordsMedias.x+(Math.cos(teta-diferenciaAngulos)*(longitud-longitudFlecha))), (int)Math.round(coordsMedias.y+(Math.sin(teta-diferenciaAngulos)*(longitud-longitudFlecha))));//calculo del punto2 de la flecha
	}
	
//	public Point [] getCoordsFlecha()
//	{
//		return coordsFlecha;
//	}
	
	public Point getCoords1()
	{
		return coords1;
	}
	
	public Point getCoords2()
	{
		return coords2;
	}
	
	public Point getCoordsMedias()
	{
		return coordsMedias;
	}
	
//	public String getSimbolo()
//	{
//		return simbolo;
//	}
}
