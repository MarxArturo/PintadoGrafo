/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import java.awt.Color;
import java.util.Vector;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Marx
 */
public class Interfaz extends javax.swing.JFrame {
    private Grafo grafo;
    private Vector allnodes;
    private Color[] Colores;
    private Vector allcolor ;
    
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        grafo=new Grafo();
        allcolor=new Vector();
        allnodes=new Vector();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxRuta = new javax.swing.JTextField();
        BSelect = new javax.swing.JButton();
        BGraficar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Bcolores = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TxCantColores = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Coloreado de Grafos - Algoritmo Las Vegas");

        jLabel1.setText("Seleccione El Archivo Que Contiene El Grafo");

        TxRuta.setEditable(false);

        BSelect.setText("Seleccionar Archivo");
        BSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSelectActionPerformed(evt);
            }
        });

        BGraficar.setText("Graficar");
        BGraficar.setEnabled(false);
        BGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGraficarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarea3/11452_Universidad_del_Valle_Cali.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("COLOREADO DE GRAFOS - LAS VEGAS");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("TAREA 3 - SIMULACION COMPUTACIONAL");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ESTUDIANTES:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("JULIAN RODRIGUEZ - 1040598");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("MARX ARTURO ARIAS - 0840247");

        Bcolores.setText("Cargar Colores");
        Bcolores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcoloresActionPerformed(evt);
            }
        });

        jLabel8.setText("Cantidad de Colores:");

        TxCantColores.setText("4");
        TxCantColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxCantColoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(TxRuta)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxCantColores))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Bcolores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bcolores)
                    .addComponent(jLabel8)
                    .addComponent(TxCantColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BGraficar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGraficarActionPerformed
        //int contadorFallos=0;
        if (grafo.cargarAutomata(TxRuta.getText())) {
            
            //		botonConvertir.setEnabled(true);
           
          // for (int i=0;i<101;i++){
               
            allnodes=grafo.administrador.getAllNodos();
            Pintor pintor=new Pintor(allnodes, allcolor);
            //Grafico de automata entrante
            JFrame ventanaGrafico = new JFrame("Grafo de Entrada");
            ventanaGrafico.setSize(600, 600);
            ventanaGrafico.setLocationRelativeTo(null);
            ventanaGrafico.getContentPane().setLayout(null);

            Vector datosAutomata = grafo.getDatos(false);
            Graficador grafico = new Graficador(datosAutomata,pintor.colorVegas(),Colores);
            ventanaGrafico.getContentPane().add(grafico);

            ventanaGrafico.setResizable(false);
            ventanaGrafico.setVisible(true);
            /*if(pintor.isFallo()){
                contadorFallos = contadorFallos + 1;
            }*/
          // }//BGraficar.setEnabled(false);
        } else {
            
            //		botonConvertir.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Error leyendo el Archivo del Automata", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //System.out.println("Se obtuvo "+contadorFallos+" respuestas erróneas");
    }//GEN-LAST:event_BGraficarActionPerformed

    private void BSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSelectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            TxRuta.setText(fileChooser.getSelectedFile().getPath());
            
        }
    }//GEN-LAST:event_BSelectActionPerformed

    private void BcoloresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcoloresActionPerformed
        int x= Integer.parseInt(TxCantColores.getText());
        if(x<4){
         JOptionPane.showMessageDialog(this, "Deben ser minimo 4 colores");   
        }else{
        Colores = new Color[x];
        Color c;
        for(int d=0;d<x;d++){
        JColorChooser seleccionarColor=new JColorChooser();
        c=seleccionarColor.showDialog(null, "Seleccione un Color", Color.BLUE);
        Colores[d]=c;
        allcolor.add(d);
        }
        BGraficar.setEnabled(true);
        }
    }//GEN-LAST:event_BcoloresActionPerformed

    private void TxCantColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxCantColoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxCantColoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGraficar;
    private javax.swing.JButton BSelect;
    private javax.swing.JButton Bcolores;
    private javax.swing.JTextField TxCantColores;
    private javax.swing.JTextField TxRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
