import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class GUI extends JFrame implements ActionListener
{
        private JButton botonArchivoGrafo, botonConvertir, botonArchivoCadena, botonVerificasCadenas, aceptarCadenas, aceptarGrafo;
        private JTextField textRutaGrafo,  textRutaCadenas;
        private JLabel labelGrafo, labelCadenas;
        private Container contenedor;
        private Automata automata;
        private boolean boolCadenas = false;
        private boolean boolAutomata = false;

        public GUI()
        {
              this.setTitle("Coloreado de Grafos");
              automata = new Automata();

              botonArchivoGrafo = new JButton("...");
              //botonConvertir =new JButton("Convertir a AFD");
              //botonArchivoCadena = new JButton("...");
              //botonVerificasCadenas = new JButton("Verificar Cadenas");
              //aceptarCadenas = new JButton("Cargar");
              aceptarGrafo = new JButton("Cargar");

              labelGrafo = new JLabel("Grafo");
              //labelCadenas= new JLabel("Cadenas");

              textRutaGrafo = new JTextField();
              textRutaCadenas = new JTextField();

              aceptarGrafo.setMargin(new Insets(0,0,0,0));
              //aceptarCadenas.setMargin(new Insets(0,0,0,0));

              labelGrafo.setBounds(10,50,80,30);
              //labelCadenas.setBounds(10,100,80,30);

              botonArchivoGrafo.setBounds(370,50,30,30);
              //botonArchivoCadena.setBounds(370,100,30,30);
              aceptarGrafo.setBounds(410,50,80,30);
              //aceptarCadenas.setBounds(410,100,80,30);
              //botonConvertir.setBounds(300,200, 150,30);
              //botonVerificasCadenas.setBounds(100,200, 150,30);

              botonArchivoGrafo.addActionListener(this);
              //botonArchivoCadena.addActionListener(this);
              //botonConvertir.addActionListener(this);
              //botonVerificasCadenas.addActionListener(this);
              aceptarGrafo.addActionListener(this);
              //aceptarCadenas.addActionListener(this);

              //botonConvertir.setEnabled(false);
              //botonVerificasCadenas.setEnabled(false);

              textRutaGrafo.setBounds(80,50 ,280 , 30);
              //textRutaCadenas.setBounds(80,100 ,280 , 30);

              contenedor = this.getContentPane();
              contenedor.setLayout(null);

              contenedor.add(botonArchivoGrafo);
              
              contenedor.add(aceptarGrafo);
              
              contenedor.add(labelGrafo);
              
              contenedor.add(textRutaGrafo);
              

              this.setSize(520,300);
              this.setDefaultCloseOperation(EXIT_ON_CLOSE);
              this.setResizable(false);
              this.setLocationRelativeTo(null);
        }


        public void actionPerformed(ActionEvent e)
        {
                if(e.getSource()== botonArchivoGrafo)
                {
                        JFileChooser fileChooser = new JFileChooser();
                        int seleccion = fileChooser.showOpenDialog(this);
                        
                        if(seleccion == JFileChooser.APPROVE_OPTION)
                        {
                            textRutaGrafo.setText(fileChooser.getSelectedFile().getPath());
                            aceptarGrafo.setEnabled(true);
                        }
                }
                if(e.getSource()== botonConvertir)
                {
                    automata.convertirAFNenAFD(true);
					//Grafico de automata entrante
					JFrame ventanaGrafico=new JFrame("Grafo de Salida");
					ventanaGrafico.setSize(600, 600);
					ventanaGrafico.setLocationRelativeTo(null);
					ventanaGrafico.getContentPane().setLayout(null);
					
					Vector datosAutomata=automata.getDatos(true);
					Graficador grafico=new Graficador(datosAutomata);
					ventanaGrafico.getContentPane().add(grafico);
					
					ventanaGrafico.setResizable(false);
					ventanaGrafico.setVisible(true);
                }
                if(e.getSource()== botonArchivoCadena)
                {
                        JFileChooser fileChooser = new JFileChooser();
                        int seleccion = fileChooser.showOpenDialog(this);
                        
                        if(seleccion == JFileChooser.APPROVE_OPTION)
                        {
                           aceptarCadenas.setEnabled(true);
                           textRutaCadenas.setText(fileChooser.getSelectedFile().getPath());
                        }
                }
                if(e.getSource()== botonVerificasCadenas)
                {
                        if(!automata.verificarCadenas(textRutaCadenas.getText()))
                        {
							boolCadenas = false;
							botonVerificasCadenas.setEnabled(false);
							JOptionPane.showMessageDialog(this, "Error con el Archivo de Cadenas", "Error", JOptionPane.ERROR_MESSAGE);
						}
                }
                if(e.getSource()== aceptarCadenas)
                {
                        boolCadenas = true;
                        if(boolAutomata && boolCadenas)
                        {
                                 botonVerificasCadenas.setEnabled(true);
                        }
                }
                if(e.getSource()==aceptarGrafo)
                {
                        if(automata.cargarAutomata(textRutaGrafo.getText()))
                        {
							boolAutomata = true;
					//		botonConvertir.setEnabled(true);
							
							//Grafico de automata entrante
							JFrame ventanaGrafico=new JFrame("Automata de Entrada");
							ventanaGrafico.setSize(600, 600);
							ventanaGrafico.setLocationRelativeTo(null);
							ventanaGrafico.getContentPane().setLayout(null);
							
							Vector datosAutomata=automata.getDatos(false);
							Graficador grafico=new Graficador(datosAutomata);
							ventanaGrafico.getContentPane().add(grafico);
							
							ventanaGrafico.setResizable(false);
							ventanaGrafico.setVisible(true);
						}
						else
						{
							boolAutomata = false;
					//		botonConvertir.setEnabled(false);
							JOptionPane.showMessageDialog(this, "Error leyendo el Archivo del Automata", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
                        if(boolAutomata && boolCadenas)
                        {
					//		botonVerificasCadenas.setEnabled(true);
							JOptionPane.showMessageDialog(this, "Automata Cargado con Exito", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
        }
        
        public static void main(String args[])
        {
                GUI ventana = new GUI();
                ventana.setVisible(true);
        }
	}
