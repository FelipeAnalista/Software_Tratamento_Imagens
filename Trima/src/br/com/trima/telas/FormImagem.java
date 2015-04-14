package br.com.trima.telas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class FormImagem extends javax.swing.JFrame {

       private String fileName;
       private JLabel LabelX_Y;
       private int width;
       private int height;

       public FormImagem() {
              initComponents();

       }

       public FormImagem(int width, int height) {
              this();
              setVisible(true);
              setResizable(false);
              setSize(width, height);

              this.width = width;
              this.height = height;

              setLocationRelativeTo(null);
       }

       public JLabel labelImagem() {
              return this.LabelX_Y;
       }

       public void carregarImagem(String fileName, String caminhoFile) {

              this.fileName = fileName;

              setTitle(this.fileName);

              jlabelImagem.setIcon(new ImageIcon(caminhoFile));

       }

       /*private void mouseMoved() {

        this.imagem.addMouseMotionListener(new MouseMotionAdapter() {

        @Override
        public void mouseMoved(MouseEvent evt) {

        LabelX_Y.setText("X:" + evt.getX() + "| Y:" + evt.getY());
        }

        });
        }
        */
       public void getEfeito(BufferedImage imageIcon, int width, int height) {
              setSize(width, height);

              this.width = width;
              this.height = height;

              jlabelImagem.setIcon(new ImageIcon(imageIcon));
              jLabelWH.setText("Largura: " + this.width + " px | Altura: " + this.height + " px");
       }

       public void redimensionaImagem(ImageIcon i, int width, int height) {
              setSize(width, height);

              this.width = width;
              this.height = height;

              jlabelImagem.setIcon(i);
              jLabelWH.setText("Largura: " + this.width + " px | Altura: " + this.height + " px");
       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              jPanel1 = new javax.swing.JPanel();
              jlabelImagem = new javax.swing.JLabel();
              jTextX_Y = new javax.swing.JLabel();
              jLabelWH = new javax.swing.JLabel();

              setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
              addWindowFocusListener(new java.awt.event.WindowFocusListener() {
                     public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                            formWindowGainedFocus(evt);
                     }
                     public void windowLostFocus(java.awt.event.WindowEvent evt) {
                            formWindowLostFocus(evt);
                     }
              });
              addWindowListener(new java.awt.event.WindowAdapter() {
                     public void windowActivated(java.awt.event.WindowEvent evt) {
                            formWindowActivated(evt);
                     }
              });
              addWindowStateListener(new java.awt.event.WindowStateListener() {
                     public void windowStateChanged(java.awt.event.WindowEvent evt) {
                            formWindowStateChanged(evt);
                     }
              });

              jlabelImagem.setText(" ");
              jlabelImagem.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
                     public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                            jlabelImagemMouseWheelMoved(evt);
                     }
              });
              jlabelImagem.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mousePressed(java.awt.event.MouseEvent evt) {
                            jlabelImagemMousePressed(evt);
                     }
              });
              jlabelImagem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                     public void mouseMoved(java.awt.event.MouseEvent evt) {
                            jlabelImagemMouseMoved(evt);
                     }
              });

              jTextX_Y.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jTextX_Y.setText(" ");

              jLabelWH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabelWH.setText(" ");

              javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
              jPanel1.setLayout(jPanel1Layout);
              jPanel1Layout.setHorizontalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextX_Y, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelWH, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 381, Short.MAX_VALUE))
                     .addComponent(jlabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              );
              jPanel1Layout.setVerticalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jTextX_Y)
                                   .addComponent(jLabelWH))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
              );

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

       private void jlabelImagemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelImagemMouseMoved
              jTextX_Y.setText(" x:" + evt.getX() + " y:" + evt.getY());
              jTextX_Y.setForeground(Color.red);
              jLabelWH.setText("Largura: " + width + " px | Altura: " + height + " px");
              
            
             
              
             
       }//GEN-LAST:event_jlabelImagemMouseMoved

       private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

       }//GEN-LAST:event_formWindowGainedFocus

       private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

       }//GEN-LAST:event_formWindowStateChanged

       private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

       }//GEN-LAST:event_formWindowLostFocus

       private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

       }//GEN-LAST:event_formWindowActivated

       private void jlabelImagemMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jlabelImagemMouseWheelMoved
           
       }//GEN-LAST:event_jlabelImagemMouseWheelMoved

       private void jlabelImagemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelImagemMousePressed
             
             
       }//GEN-LAST:event_jlabelImagemMousePressed


       // Variables declaration - do not modify//GEN-BEGIN:variables
       private javax.swing.JLabel jLabelWH;
       private javax.swing.JPanel jPanel1;
       private javax.swing.JLabel jTextX_Y;
       private javax.swing.JLabel jlabelImagem;
       // End of variables declaration//GEN-END:variables
}
