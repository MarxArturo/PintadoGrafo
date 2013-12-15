import java.util.Collections;
import java.util.Vector;

public class Grafo
{
    private Integer estadoInicial; //Estado donde incia el automata
    private int estadoFinal;       //ultimo estado en el que termino el algoritmo
    private Vector estadosFinales; //vector de enteros
    private Vector simbolos;       //vector de chars
    private Vector[] estados;      //arreglo de vectores de vectores de enteros (arreglo del tamaño del vector simbolos)
    AdministraArchivos administrador;
    private Vector cadenas;
    private boolean respuesta;

    //atributos para conversion en AFD
    private Integer estadoInicialConversion;
    private Vector estadosFinalesConversion;
    private Vector simbolosConversion;
    private Vector[] estadosAFD;
    private Vector[] estadosConversion;
    private Vector conjuntos;

    public Grafo()
    {
    }

    //ALGORITMOS PARA CONVERTIR AFN EN AFD

    public void convertirAFNenAFD(boolean guardar)
    {
        instanciar();
        conjuntos.add(epsilonCerradura(estadoInicial));
        estadosConversion[0].add(epsilonCerradura(estadoInicial));

        System.out.print("Conjunto Epsilon cerradura: ");
        for(int i = 0; i < epsilonCerradura(estadoInicial).size(); i++) System.out.print(" "+epsilonCerradura(estadoInicial).get(i));
        System.out.println();

        for(int i = 0; i < conjuntos.size(); i++ )//recorre todos los conjuntos ejecutando el algoritmo
        {
            Vector conjunto = (Vector)conjuntos.get(i);
            for(int j = 0; j < simbolosConversion.size(); j++ )//recorre todos los simbolos
            {
                Vector estadosAlcanzables = new Vector(1,1);
				char simbolo = (Character)simbolosConversion.get(j);
                for(int k = 0; k < conjunto.size(); k++ )//recorre todos los elementos del conjunto obtenido con la epsilon cerradura
                {
                    Vector vector = (Vector)estados[posicionSimbolo(simbolo)].get((Integer)conjunto.get(k));
                    for(int l = 0; l < vector.size(); l++ )//recorre los estados a los que llega el estado actual consumiendo el simbolo dado
                    {
                        if(!(vector.get(l).equals("#")))
                        {
                            estadosAlcanzables.add(vector.get(l));
                        }
                    }
                }

                System.out.print(yaEsta(formarConjunto(estadosAlcanzables)) +"  ");
                if(!yaEsta(formarConjunto(estadosAlcanzables)))
                {
                    conjuntos.add(formarConjunto(estadosAlcanzables));
                    estadosConversion[0].add(formarConjunto(estadosAlcanzables));
                }
                estadosConversion[j+1].add(formarConjunto(estadosAlcanzables));

                System.out.print("Conjunto Epsilon cerradura: ");
                for(int o = 0; o < formarConjunto(estadosAlcanzables).size(); o++) System.out.print(" "+ formarConjunto(estadosAlcanzables).get(o));
                System.out.println();
            }
        }

        estadosAFD = new Vector[simbolosConversion.size()];

        for(int i = 0; i < estadosAFD.length; i++)
        {
            estadosAFD[i]= new Vector(1,1);
            for(int o = 0; o < estadosConversion[0].size(); o++)
            {
                estadosAFD[i].add(getEstadoIndice((Vector)estadosConversion[i+1].get(o)));
            }
        }

        for(int j = 0; j < estadosConversion[0].size(); j++)
        {
            Vector vector = (Vector)estadosConversion[0].get(j);
            for(int k = 0; k < vector.size(); k++)
            {
                for(int i = 0; i < estadosFinales.size(); i++)
                {
                    if(estadosFinales.get(i) == vector.get(k))
                    {
                        estadosFinalesConversion.add(j);
                    }
                }
            }
        }

        if(guardar)
        {
            administrador.guardarAFD(estadoInicialConversion, estadosFinalesConversion, simbolosConversion, estadosAFD);
        }
            estadoInicial = estadoInicialConversion;
            estadosFinales = estadosFinalesConversion;
            simbolos = simbolosConversion;

            estados = new Vector[estadosAFD.length];
            for(int i = 0;i < estadosAFD.length; i++)
            {
                estados[i] = new Vector(1,1);
                for(int j = 0;j < estadosAFD[i].size(); j++)
                {
                    Vector a = new Vector(1,1);
                    a.add(estadosAFD[i].get(j));
                    estados[i].add(a);
                }
            }
        
    }

    private int getEstadoIndice(Vector conjunto)
    {
        int indice = -1;
        boolean bool = true;
        Collections.sort(conjunto);
        for(int i = 0; i < estadosConversion[0].size(); i++)
        {
            Vector vector = (Vector)estadosConversion[0].get(i);
            Collections.sort(vector);
            if(vector.size() == conjunto.size())
            {
                for(int j = 0; j <  conjunto.size(); j++)
                {
                    bool = true;
                    if(!(vector.get(j)==conjunto.get(j)))
                    {
                        bool = false;
                    }
                }
                if(bool)
                {
                    indice = i;
                    return indice;
                }
            }
        }
        return indice;
    }

    private boolean yaEsta(Vector conjunto)
    {
        boolean bool = false;
        boolean result = false;
        
        Collections.sort(conjunto);
        for(int i = 0; i < conjuntos.size(); i++)
        {
            Vector vector = (Vector)conjuntos.get(i);

            if(conjunto.isEmpty() && vector.isEmpty())
            {
                return true;
            }
            Collections.sort(vector);
            if(vector.size() == conjunto.size())
            {
                for(int j = 0; j <  conjunto.size(); j++)
                {
                    bool = true;
                    if(!(vector.get(j)==conjunto.get(j)))
                    {
                        bool = false;
                    }
                }
                if(bool)
                {
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    private void instanciar()
    {
        conjuntos = new Vector(1,1);
        simbolosConversion = new Vector(1,1);
        estadosFinalesConversion = new Vector(1,1);
        estadoInicialConversion = 0;
        for(int i = 0; i < simbolos.size(); i++ )
        {
            if(((Character)simbolos.get(i))!= '_')
            {
                simbolosConversion.add(simbolos.get(i));
            }
        }

        estadosConversion = new Vector[simbolosConversion.size()+1];

        for(int i = 0; i < estadosConversion.length; i++ )
        {
            estadosConversion[i] = new Vector(1,1);
        }

        System.out.println("los atributos han sido instanciados");
    }

    private Vector formarConjunto(Vector estadosAlcanzables)
    {
        Vector conjunto = new Vector(1,1);

        for(int i = 0; i < estadosAlcanzables.size(); i++)
        {
            conjunto = unirConjuntos(conjunto, epsilonCerradura((Integer)estadosAlcanzables.get(i)));
        }

        return conjunto;
    }

    private Vector epsilonCerradura(int estado)
    {
        Vector conjunto = new Vector(1,1);
        conjunto.add(estado);
        if(haceParte('_'))
        {
            int posicionEpsilon = posicionSimbolo('_');

            for(int i = 0; i < conjunto.size(); i++)
            {
                Vector vector = (Vector)estados[posicionEpsilon].get((Integer)conjunto.get(i));
                for(int j = 0; j < vector.size(); j++)
                {
                    if(!(vector.get(j).equals("#")))
                    {
                        conjunto.add(vector.get(j));
                    }
                }
            }

        }
        return conjunto;
    }

    private boolean haceParte(Character simbolo)
    {
        boolean bool = false;
        
        for(int i = 0; i < simbolos.size(); i++ )
        {
            if(((Character)simbolos.get(i)) == simbolo)
            {
                bool = true;
            }
        }
        return bool;
    }

    private Vector unirConjuntos(Vector primerVector, Vector segundoVector)
    {
        Vector vector = new Vector(1,1);

        for(int i = 0; i < (primerVector.size() + segundoVector.size()); i++)
        {
            if(i < primerVector.size())
            {
                if(!segundoVector.contains(primerVector.get(i)))
                {
                    vector.add(primerVector.get(i));
                }
            }
            else
            {
                vector.add(segundoVector.get(i-primerVector.size()));
            }
        }

        return vector;
    }

    //ALGORITMOS DE CARGAR Y LECTURA DE CADENAS Y DEMAS

    public boolean cargarAutomata(String ruta)
    {
        respuesta = false;
        administrador = new AdministraArchivos();
        
        if(!administrador.leerAutomata(ruta))
        {
			return false;
		}

        estadoInicial = administrador.getEstadoInicial();
        estadosFinales = administrador.getEstadosFinales(); //vector de enteros
        simbolos = administrador.getSimbolos(); // vector de chars
        estados = administrador.getEstados();
        
        return true;
    }
    
    //Datos del Autómata de entrada
    public Vector getDatos(boolean salida)
    {
		Vector datos=new Vector(1, 1);
		
		if(!salida)
		{
			datos.add(estadoInicial);
			datos.add(estadosFinales);
			datos.add(simbolos);
			datos.add(estados);
		}
		else
		{
			datos.add(estadoInicial);
			datos.add(estadosFinales);
			datos.add(simbolos);
			datos.add(estados);
		}
		
		return datos;
	}

    //Indica en que posicion esta el simbolo
    private int posicionSimbolo(Character simbolo)
    {
        int posicion = -1;
        for(int indice = 0; indice < simbolos.size();indice++)
        {
            if(simbolo.equals((Character)simbolos.get(indice)))
            {
                posicion = indice;
                break;
            }
        }
        return posicion;
    }

    //determina si el estado ingresado es estado final
    private boolean esEstadoFinal(Integer estado)
    {
        boolean variable = false;
        for(int indice = 0; indice < estadosFinales.size();indice++)
        {
            if(estado.equals((Integer)estadosFinales.get(indice)))
            {
                variable = true;
                break;
            }
        }
        return variable;
    }

    //algoritmo de recorrido del automata para comprobar la cadena, es una recursion cuyo caso trivial es que se alla recorrido
    //el automata con cada simbolo hasta que no quede ninguno.
    private void recursion(String cadena, Integer estadoActual)
    {
        if(cadena.length() == 0)
        {
            estadoFinal = estadoActual;
            if(esEstadoFinal(estadoFinal))
            {
                respuesta = true;
            }
        }
        else
        {
            char simbolo = cadena.charAt(0);
            int posicion = posicionSimbolo(simbolo);
            if(posicion == -1)
            {
                respuesta = false;
                return;
            }

            Vector vector = (Vector)estados[posicion].get(estadoActual);
            for(int i = 0; i < vector.size();i++)
            {
                try
                {
                    estadoActual = (Integer)vector.get(i);
                    recursion(cadena.substring(1), estadoActual);
                }
                catch(Exception e)
                {
                    System.out.println("Vacio");                    
                }
            }
        }

    }

    public boolean comprobarCadena(String cadena)
    {
        respuesta = false;
        if(cadena.equals("_"))
        {
            if(esEstadoFinal(estadoInicial))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {
            recursion(cadena, estadoInicial);
            return respuesta;
        }
    }
    
    public boolean verificarCadenas(String nombreArchivo) 
    {
        convertirAFNenAFD(false);
        cadenas = administrador.leerCadenas(nombreArchivo);
        
        if(cadenas==null)
        {
			return false;
		}
		
        String salida[] = new String[cadenas.size()];

        for(int indice = 0; indice < cadenas.size();indice++)
        {
            if(comprobarCadena((String)cadenas.get(indice)))
            {
                salida[indice] = "SI";
            }
            else
            {
                salida[indice] = "NO";
            }
        }

        administrador.guardar(salida);
        
        return true;
    }

}
