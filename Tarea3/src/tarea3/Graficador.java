package tarea3;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.Vector;
import java.awt.geom.Line2D;
import java.lang.Math;

public class Graficador extends Canvas
{
	private int estadoInicial;
	private Vertice [] vertices;
	private Vector aristas;
	private Point [] coords;
        private Vector colores;
        private Color[] colorss;
        private Vector aristasActuales;
	
	public Graficador(Vector datosAutomata, Vector colores, Color[] colorss)
	{
                this.colores=colores;
                this.colorss=colorss;
		setBounds(0, 0, 600, 600);
		setBackground(Color.WHITE);
		int altura=20;
		
		//Separar datos
		estadoInicial=(Integer)datosAutomata.get(0);
		Vector estadosFinales=(Vector)datosAutomata.get(1);
		Vector simbolos=(Vector)datosAutomata.get(2);
		Vector [] estados=(Vector[])datosAutomata.get(3);
				
		int totalVertices=estados[0].size();
		vertices=new Vertice [totalVertices];
		coords=new Point [totalVertices];
		
		for(int i=0; i<totalVertices; i++)
		{
			coords[i]=new Point(-50, -50);
		}
		
		//Generar puntos aleatorios para los vertices
		int x, y;
		int margen=50;
		int rango=30;//diferencia minima de pixeles entre vertices
		boolean repetido=false;
		
		for(int i=0; i<totalVertices; i++)
		{
			do
			{
				repetido=false;
				x=(int)(Math.random()*(getWidth()-margen-margen+1)+margen);
				y=(int)(Math.random()*(getHeight()-margen-margen+1)+margen);
				
				for(int n=0; n<totalVertices; n++)
				{
					if((x>coords[n].x-rango && x<coords[n].x+rango) && (y>coords[n].y-rango && y<coords[n].y+rango))
					{
						repetido=true;
						break;
					}
				}
			}
			while(repetido);
			
			coords[i]=new Point(x, y);
		}
		
		for(int i=0; i<totalVertices; i++)
		{
			boolean esFinal=false;
			for(int n=0; n<estadosFinales.size(); n++)
			{
				if((Integer)estadosFinales.get(n)==i)
				{
					esFinal=true;
					break;
				}
			}
			vertices[i]=new Vertice(coords[i], esFinal);
		}
		
		//Crear aristas
		aristas=new Vector(1, 1);
		boolean aristaigual=false;
		//aristas.add(new Arista(new Point(vertices[estadoInicial].getCoordsCentro().x -60, vertices[estadoInicial].getCoordsCentro().y-40), vertices[estadoInicial].getCoordsCentro(), ""));//arista estado inicial
                aristasActuales=new Vector();
		for(int i=0; i<estados.length; i++)
		{
			for(int n=0; n<estados[i].size(); n++)
			{
				for(int c=0; c<((Vector)estados[i].get(n)).size(); c++)
				{
					try
					{
						System.out.println("Vertice "+n+" va conectado con el vertice "+(Integer)((Vector)estados[i].get(n)).get(c)+" con el simbolo "+simbolos.get(i));
                                                for(int u=0;u<aristasActuales.size();u++){
                                                    Arista aris=(Arista)aristas.elementAt(u);
                                                    if(aris.getCoords1()==vertices[(Integer)((Vector)estados[i].get(n)).get(c)].getCoordsCentro() &&aris.getCoords2()==vertices[n].getCoordsCentro()){
                                                        aristaigual=true;
                                                        
                                                    }
                                                            
                                                }
                                                if(aristaigual==false){
						aristas.add(new Arista(vertices[n].getCoordsCentro(), vertices[(Integer)((Vector)estados[i].get(n)).get(c)].getCoordsCentro()));
                                                }
					}
					catch(ClassCastException e)
					{
					}
				}
                                
			}
		}
	}
	
	public void paint(Graphics g)
	{
		//Dibujar Aristas
		for(int i=0; i<aristas.size(); i++)
		{
			Arista aristaActual=(Arista)aristas.get(i);
			
			g.setColor(Color.BLUE);//Color predeterminado aristas
			
			//Verificar si es arista hacia si mismo
			if(aristaActual.getCoords1().x==aristaActual.getCoords2().x)
			{
				int aleatorio=(int)(Math.random()*10);
				int orientacionX=25;
				int orientacionY=25;
				int sentidoX=-1;
				int sentidoY=-1;
				for(int n=0; n<aleatorio; n++)
				{
					if(orientacionX==25)
					{
						orientacionX=5;
						sentidoX=1;
					}
					else
					{
						orientacionX=25;
						sentidoX=-1;
					}
				}
				
				aleatorio=(int)(Math.random()*10);
				for(int n=0; n<aleatorio; n++)
				{
					if(orientacionY==25)
					{
						orientacionY=5;
						sentidoY=1;
					}
					else
					{
						orientacionY=25;
						sentidoY=-1;
					}
				}
				
				g.drawOval(aristaActual.getCoords1().x-orientacionX, aristaActual.getCoords1().y-orientacionY, 30, 30);
				g.setColor(Color.BLUE);
//				g.drawString(aristaActual.getSimbolo(), aristaActual.getCoords1().x+25*sentidoX, aristaActual.getCoords2().y+25*sentidoY);
			}
			else
			{
				/*
				if(i==0)
				{
					g.setColor(Color.BLACK);//color arista inicial
				}*/
				g.drawLine(aristaActual.getCoords1().x, aristaActual.getCoords1().y, aristaActual.getCoordsMedias().x, aristaActual.getCoordsMedias().y);
				g.drawLine(aristaActual.getCoordsMedias().x, aristaActual.getCoordsMedias().y, aristaActual.getCoords2().x, aristaActual.getCoords2().y);
				
				//Flecha de la arista
				int [] puntosFlechaX=new int [3];
				int [] puntosFlechaY=new int [3];
//				puntosFlechaX[0]=aristaActual.getCoords2().x;
//				puntosFlechaX[1]=aristaActual.getCoordsFlecha()[0].x;
//				puntosFlechaX[2]=aristaActual.getCoordsFlecha()[1].x;
//				puntosFlechaY[0]=aristaActual.getCoords2().y;
//				puntosFlechaY[1]=aristaActual.getCoordsFlecha()[0].y;
//				puntosFlechaY[2]=aristaActual.getCoordsFlecha()[1].y;
				
//				g.setColor(new Color(200, 200, 255));
//				g.fillPolygon(puntosFlechaX, puntosFlechaY, 3);
//				
//				g.setColor(Color.BLUE);
//				g.drawPolygon(puntosFlechaX, puntosFlechaY, 3);
				
				//Simbolo de la arista
				g.setColor(Color.BLUE);
				//g.drawString(aristaActual.getSimbolo(), aristaActual.getCoordsMedias().x+5, aristaActual.getCoordsMedias().y+5);
			}
		}
		
		//Dibujar vertices
		for(int i=0; i<vertices.length; i++)
		{
                        Vector vert=(Vector)colores.elementAt(i);
                        Color s=colorss[(int)vert.elementAt(1)];
			g.setColor(s);//color predeterminado vertices
//			if(i==estadoInicial)
//			{
//				g.setColor(new Color(180, 0, 0));//color vertice inicial
//			}
			
			g.fillOval(vertices[i].getCoords1().x, vertices[i].getCoords1().y, vertices[i].getRadio()*2, vertices[i].getRadio()*2);
						
//			if(vertices[i].isEstadoFinal())//vertices finales
//			{
//				g.setColor(Color.BLACK);
//				g.drawOval(vertices[i].getCoords1().x-3, vertices[i].getCoords1().y-3, vertices[i].getRadio()*2+5, vertices[i].getRadio()*2+5);
//			}
			
			g.setColor(Color.RED);
			g.drawString("q"+i, vertices[i].getCoords1().x-10, vertices[i].getCoords1().y-2);
		}
	}
}
