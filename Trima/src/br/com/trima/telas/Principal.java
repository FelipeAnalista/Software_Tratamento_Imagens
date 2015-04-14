package br.com.trima.telas;

import br.com.trima.filtros.Filtro;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal extends JFrame {

       private JFileChooser escolherImagem;
       private File f;
       private String fileName;
       private String fileNameParam;
       private Integer width;
       private Integer height;
       private String caminhoFile;
       private BufferedImage imagem;
       private ImageIcon i;
       
       private int contador;
       private final Filtro filtro = new Filtro();

       FormImagem formImagem;

       public Principal() {

              initComponents();
           

              setTitle("Trima 1.0");
              i = new ImageIcon();

            
       }

       public void carregandoImagem() throws IOException {
              try {
                     escolherImagem = new JFileChooser();

                     FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagem", "jpg", "jpeg", "gif", "png");
                     escolherImagem.setFileFilter(filtro);

                     int resultado = escolherImagem.showOpenDialog(Principal.this);

                     if (resultado == JFileChooser.APPROVE_OPTION) {

                            double tempoInicial = System.currentTimeMillis();

                            // armazena o diretório da imagem.
                            caminhoFile = escolherImagem.getSelectedFile().getPath();

                            //jLabelImagem.setIcon(new ImageIcon(caminhoFile));
                            f = escolherImagem.getSelectedFile();

                            fileName = f.getAbsolutePath();
                            fileNameParam = f.getName();

                            //caminho.setText(fileName);
                            imagem = ImageIO.read(new File(fileName));

                            //Carregando o tamanho da imagem nas variáveis
                            this.width = imagem.getWidth();
                            this.height = imagem.getHeight();

                            //Fundo para imagens habilitada
                            // jLabelImagem.setVisible(true);
                            // jScrollPane.setVisible(true);
                            getCoodenadas(imagem);

                            // fn.setTamanho(imagem);
                            double tempoFinal = System.currentTimeMillis();
                            tempoExecucao.setText(String.valueOf((tempoFinal - tempoInicial) / 1000) + " Seg");

                            //Janela de imagem
                            formImagem = new FormImagem(width, height);
                            formImagem.carregarImagem(fileNameParam, caminhoFile);
                            //    LabelX_Y.setText(String.valueOf(formImagem.labelImagem()));
                     }
                     // ffn.setImagemFundo(jLabelImagem, imagem); // Ação da tela de informação do filtro negativo
                     // fn.setImagemFundo(jLabelImagem, caminhoFile);//Ação da tela de informação do filtro normal
                     // ffc.setImagemFundo(jLabelImagem, imagem);//Ação da tela de informação do filtro cinza

              } catch (IOException e) {
                     System.out.println(e.getMessage());
              }

       }

       private void getCoodenadas(BufferedImage imagem) {
              //  txtCoordenadas.setText(String.valueOf("Largura: " + imagem.getWidth() + " px | Altura: " + imagem.getHeight() + " px"));
       }

       public void transformaImagemCinza() throws IOException {
              imagem = ImageIO.read(new File(fileName));

              //Percorrendo os pixel da imagem
              //(Red + Green + blue) / 3 = para transformar em cinza
              Color c = null;
              for (int a = 0; a < imagem.getWidth(); a++) {
                     for (int b = 0; b < imagem.getHeight(); b++) {

                            c = new Color(imagem.getRGB(a, b));

                            int tomCinza = (c.getRed() + c.getGreen() + c.getBlue()) / 3; // Calculo para o tom de cinza

                            c = new Color(tomCinza, tomCinza, tomCinza);
                            imagem.setRGB(a, b, c.getRGB());

                     }
              }
              // ffc.getMostraCor(c.getRed(), c.getGreen(), c.getBlue());

              getCoodenadas(imagem);
              //  jLabelImagem.setIcon(new ImageIcon(imagem));
       }

       public void corFundo() {
              JColorChooser color = new JColorChooser();
              Color c = color.showDialog(this, "Selecione uma cor", Color.GREEN);

              // painelFundo.setBackground(c);
              // jLabelImagem.setBackground(c);
              // jLabelImagem.setBackground(Color.BLACK);
       }

       private void redimencinar() {
              if (caminhoFile == null) {
                     JOptionPane.showMessageDialog(this, "Escolha uma imagem primeiro: \n Dica: Ctrl+Shift+O");
              } else {

                     this.width = Integer.parseInt(JOptionPane.showInputDialog(this, "Largura:  ", String.valueOf(imagem.getWidth())));
                     this.height = Integer.parseInt(JOptionPane.showInputDialog(this, "Altura:  ", String.valueOf(imagem.getHeight())));

                     try {
                            double tempoInicial = System.currentTimeMillis();

                            i = redimensionaImagem(f, width, height);
                            formImagem.redimensionaImagem(i, width, height);

                            //   jLabelImagem.setIcon(i);
                            //   labelCoo.setVisible(true);
                            //  txtCoordenadas2.setText(String.valueOf("Largura: " + width + " px | Altura: " + height + " px"));
                            double tempoFinal = System.currentTimeMillis();
                            tempoExecucao.setText(String.valueOf((tempoFinal - tempoInicial) / 1000) + " Seg");

                     } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println(ex.getMessage());
                     }
              }
       }

       private void fecharTela() {
              int c = JOptionPane.showConfirmDialog(this, "Deseja realmente sair ?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
              if (c == JOptionPane.YES_OPTION) {
                     System.exit(0);
              }
       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              jLabel1 = new javax.swing.JLabel();
              tempoExecucao = new javax.swing.JLabel();
              jToolBar2 = new javax.swing.JToolBar();
              jButton2 = new javax.swing.JButton();
              jButton1 = new javax.swing.JButton();
              jSeparator2 = new javax.swing.JToolBar.Separator();
              jButton11 = new javax.swing.JButton();
              jButton10 = new javax.swing.JButton();
              jButton9 = new javax.swing.JButton();
              jButton8 = new javax.swing.JButton();
              jButton7 = new javax.swing.JButton();
              jSeparator3 = new javax.swing.JToolBar.Separator();
              jButton3 = new javax.swing.JButton();
              jButton6 = new javax.swing.JButton();
              jButton5 = new javax.swing.JButton();
              jButton4 = new javax.swing.JButton();
              jMenuBar1 = new javax.swing.JMenuBar();
              jMenu1 = new javax.swing.JMenu();
              jMenuItem1 = new javax.swing.JMenuItem();
              jMenuItem2 = new javax.swing.JMenuItem();
              jMenuItem3 = new javax.swing.JMenuItem();
              jMenuItem4 = new javax.swing.JMenuItem();
              jSeparator1 = new javax.swing.JPopupMenu.Separator();
              jMenuItem9 = new javax.swing.JMenuItem();
              jMenu6 = new javax.swing.JMenu();
              jMenuItem13 = new javax.swing.JMenuItem();
              jMenuItem14 = new javax.swing.JMenuItem();
              jMenuItem15 = new javax.swing.JMenuItem();
              jMenu2 = new javax.swing.JMenu();
              jMenu8 = new javax.swing.JMenu();
              jMenuItem21 = new javax.swing.JMenuItem();
              jMenuItem22 = new javax.swing.JMenuItem();
              jMenuItem23 = new javax.swing.JMenuItem();
              jMenuItem24 = new javax.swing.JMenuItem();
              jMenu7 = new javax.swing.JMenu();
              jMenuItem16 = new javax.swing.JMenuItem();
              jMenuItem17 = new javax.swing.JMenuItem();
              jMenuItem18 = new javax.swing.JMenuItem();
              jMenuItem19 = new javax.swing.JMenuItem();
              jMenuItem20 = new javax.swing.JMenuItem();
              jMenu4 = new javax.swing.JMenu();
              jMenuItem11 = new javax.swing.JMenuItem();
              jMenu5 = new javax.swing.JMenu();
              jMenuItem6 = new javax.swing.JMenuItem();
              jMenu3 = new javax.swing.JMenu();
              jMenuItem10 = new javax.swing.JMenuItem();
              jMenuItem12 = new javax.swing.JMenuItem();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
              addWindowListener(new java.awt.event.WindowAdapter() {
                     public void windowClosed(java.awt.event.WindowEvent evt) {
                            formWindowClosed(evt);
                     }
                     public void windowClosing(java.awt.event.WindowEvent evt) {
                            formWindowClosing(evt);
                     }
              });

              jLabel1.setText("Tempo de Execução:");

              tempoExecucao.setText("0");

              jToolBar2.setRollover(true);

              jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/application-resize.png"))); // NOI18N
              jButton2.setText(" ");
              jButton2.setToolTipText("Redimencionar Imagem");
              jButton2.setBorder(null);
              jButton2.setFocusable(false);
              jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jButton2.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton2ActionPerformed(evt);
                     }
              });
              jToolBar2.add(jButton2);

              jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/color.png"))); // NOI18N
              jButton1.setText(" ");
              jButton1.setToolTipText("Cor de Fundo");
              jButton1.setBorder(null);
              jButton1.setFocusable(false);
              jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jButton1.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                     }
              });
              jToolBar2.add(jButton1);
              jToolBar2.add(jSeparator2);

              jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-continue-180-top.png"))); // NOI18N
              jButton11.setText(" ");
              jButton11.setToolTipText("Inverter Horizontalmente");
              jButton11.setBorder(null);
              jButton11.setFocusable(false);
              jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jToolBar2.add(jButton11);

              jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-continue-270.png"))); // NOI18N
              jButton10.setText(" ");
              jButton10.setToolTipText("Inverter Verticalmente");
              jButton10.setBorder(null);
              jButton10.setFocusable(false);
              jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jToolBar2.add(jButton10);

              jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-circle-135.png"))); // NOI18N
              jButton9.setText(" ");
              jButton9.setToolTipText("Girar 180ª");
              jButton9.setBorder(null);
              jButton9.setFocusable(false);
              jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jToolBar2.add(jButton9);

              jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-180.png"))); // NOI18N
              jButton8.setText(" ");
              jButton8.setToolTipText("Girar 90º Esquerda");
              jButton8.setBorder(null);
              jButton8.setFocusable(false);
              jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jToolBar2.add(jButton8);

              jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow.png"))); // NOI18N
              jButton7.setText(" ");
              jButton7.setToolTipText("Girar 90ª Direita");
              jButton7.setBorder(null);
              jButton7.setFocusable(false);
              jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jButton7.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton7ActionPerformed(evt);
                     }
              });
              jToolBar2.add(jButton7);

              jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
              jToolBar2.add(jSeparator3);

              jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/layout.png"))); // NOI18N
              jButton3.setText(" ");
              jButton3.setToolTipText("Filtro Normal");
              jButton3.setBorder(null);
              jButton3.setFocusable(false);
              jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jToolBar2.add(jButton3);

              jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/spectrum-emission.png"))); // NOI18N
              jButton6.setText(" ");
              jButton6.setToolTipText("Filtro Threshold");
              jButton6.setBorder(null);
              jButton6.setFocusable(false);
              jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jButton6.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton6ActionPerformed(evt);
                     }
              });
              jToolBar2.add(jButton6);

              jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/contrast.png"))); // NOI18N
              jButton5.setText(" ");
              jButton5.setToolTipText("Filtro Negativo");
              jButton5.setBorder(null);
              jButton5.setFocusable(false);
              jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jToolBar2.add(jButton5);

              jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/contrast-low.png"))); // NOI18N
              jButton4.setText(" ");
              jButton4.setToolTipText("Filtro Cinza");
              jButton4.setBorder(null);
              jButton4.setFocusable(false);
              jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
              jToolBar2.add(jButton4);

              jMenu1.setText("Arquivo");

              jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
              jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/novo.png"))); // NOI18N
              jMenuItem1.setText("Novo");
              jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem1ActionPerformed(evt);
                     }
              });
              jMenu1.add(jMenuItem1);

              jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
              jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/folder-horizontal-open.png"))); // NOI18N
              jMenuItem2.setText("Abrir");
              jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem2ActionPerformed(evt);
                     }
              });
              jMenu1.add(jMenuItem2);

              jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
              jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/disk.png"))); // NOI18N
              jMenuItem3.setText("Salvar");
              jMenu1.add(jMenuItem3);

              jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/disks.png"))); // NOI18N
              jMenuItem4.setText("Salvar Como...");
              jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem4ActionPerformed(evt);
                     }
              });
              jMenu1.add(jMenuItem4);
              jMenu1.add(jSeparator1);

              jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/door-open-out.png"))); // NOI18N
              jMenuItem9.setText("Sair");
              jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem9ActionPerformed(evt);
                     }
              });
              jMenu1.add(jMenuItem9);

              jMenuBar1.add(jMenu1);

              jMenu6.setText("Editar");

              jMenuItem13.setText("Cortar");
              jMenu6.add(jMenuItem13);

              jMenuItem14.setText("Recortar");
              jMenu6.add(jMenuItem14);

              jMenuItem15.setText("Excluir");
              jMenu6.add(jMenuItem15);

              jMenuBar1.add(jMenu6);

              jMenu2.setText("Efeitos");

              jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/system-monitor--arrow.png"))); // NOI18N
              jMenu8.setText("Filtros");

              jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
              jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/layout.png"))); // NOI18N
              jMenuItem21.setText("Normal");
              jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem21ActionPerformed(evt);
                     }
              });
              jMenu8.add(jMenuItem21);

              jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
              jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/contrast-low.png"))); // NOI18N
              jMenuItem22.setText("Cinza");
              jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem22ActionPerformed(evt);
                     }
              });
              jMenu8.add(jMenuItem22);

              jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
              jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/contrast.png"))); // NOI18N
              jMenuItem23.setText("Negativo");
              jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem23ActionPerformed(evt);
                     }
              });
              jMenu8.add(jMenuItem23);

              jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
              jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/spectrum-emission.png"))); // NOI18N
              jMenuItem24.setText("Threshold");
              jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem24ActionPerformed(evt);
                     }
              });
              jMenu8.add(jMenuItem24);

              jMenu2.add(jMenu8);

              jMenuBar1.add(jMenu2);

              jMenu7.setText("Girar");

              jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow.png"))); // NOI18N
              jMenuItem16.setText("Girar 90º para a direita");
              jMenu7.add(jMenuItem16);

              jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-180.png"))); // NOI18N
              jMenuItem17.setText("Girar 90º para a esquerda");
              jMenu7.add(jMenuItem17);

              jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-circle-135.png"))); // NOI18N
              jMenuItem18.setText("Gira 180º");
              jMenu7.add(jMenuItem18);

              jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-continue-270.png"))); // NOI18N
              jMenuItem19.setText("Inverter verticamente");
              jMenu7.add(jMenuItem19);

              jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/arrow-continue-180-top.png"))); // NOI18N
              jMenuItem20.setText("Inverter Horizontalmente");
              jMenu7.add(jMenuItem20);

              jMenuBar1.add(jMenu7);

              jMenu4.setText(" Cores");

              jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/color.png"))); // NOI18N
              jMenuItem11.setText("Cor de Fundo");
              jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem11ActionPerformed(evt);
                     }
              });
              jMenu4.add(jMenuItem11);

              jMenuBar1.add(jMenu4);

              jMenu5.setText("Redimencionar");

              jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
              jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/application-resize.png"))); // NOI18N
              jMenuItem6.setText("Redimencionamento");
              jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem6ActionPerformed(evt);
                     }
              });
              jMenu5.add(jMenuItem6);

              jMenuBar1.add(jMenu5);

              jMenu3.setText("Ajuda");

              jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trima/imagens/information.png"))); // NOI18N
              jMenuItem10.setText("Sobre");
              jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem10ActionPerformed(evt);
                     }
              });
              jMenu3.add(jMenuItem10);

              jMenuItem12.setText("Informações de Desenvolvimento");
              jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem12ActionPerformed(evt);
                     }
              });
              jMenu3.add(jMenuItem12);

              jMenuBar1.add(jMenu3);

              setJMenuBar(jMenuBar1);

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tempoExecucao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tempoExecucao))
                     .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
              );

              setBounds(100, 5, 694, 85);
       }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
           try {
                  carregandoImagem();
           } catch (IOException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
           }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

           this.dispose();
           Principal p = new Principal();
           p.setVisible(true);

           p.setResizable(false);


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
           FormSobre fs = new FormSobre();
           fs.setVisible(true);
           fs.setLocationRelativeTo(null);
           fs.setResizable(false);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
           corFundo();


    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
           try {
                  escolherImagem = new JFileChooser();

                  int showOpenSave = escolherImagem.showSaveDialog(Principal.this);

                  if (showOpenSave == JFileChooser.APPROVE_OPTION) {

                         caminhoFile = escolherImagem.getSelectedFile().getPath();

                         try {
                                ImageIO.write(null, caminhoFile, new File(fileName));
                         } catch (IOException ex) {
                                JOptionPane.showMessageDialog(this, "ERRO 1: " + ex.getMessage());
                         }

                         JOptionPane.showMessageDialog(this, "" + caminhoFile);

                  }
           } catch (Exception e) {
                  JOptionPane.showMessageDialog(this, "ERRO 2: " + e.getMessage());
                  e.printStackTrace();
           }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
           redimencinar();

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
           FormInfor f = new FormInfor();
           f.setVisible(true);
           f.setLocationRelativeTo(null);
           f.setResizable(false);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
           fecharTela();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
           if (caminhoFile == null) {

           } else {
                  double tempoInicial = System.currentTimeMillis();

                  // jLabelImagem.setIcon(new ImageIcon(caminhoFile));
                 // i.setImage(new ImageIcon(caminhoFile));
                 // formImagem.getEfeito(i, width, height);
                  double tempoFinal = System.currentTimeMillis();

                  tempoExecucao.setText(String.valueOf((tempoFinal - tempoInicial) / 1000) + " Seg");
           }


    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
           if (caminhoFile == null) {

           } else {

                  try {
                         double tempoInicial = System.currentTimeMillis();

                         //i.setImage(Filtro.cinza(imagem, this.width, this.height));
                         BufferedImage b = Filtro.cinza(imagem, this.width, this.height);
                         formImagem.getEfeito(b, width, height);

                         // jLabelImagem.setIcon(i);
                         double tempoFinal = System.currentTimeMillis();

                         tempoExecucao.setText(String.valueOf((tempoFinal - tempoInicial) / 1000) + " Seg");

                  } catch (IOException ex) {
                         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                  }
           }
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
           if (caminhoFile == null) {

           } else {
                  double tempoInicial = System.currentTimeMillis();
                  //i.setImage(Filtro.negativo(imagem, this.width, this.height));
                   BufferedImage b = Filtro.negativo(imagem, this.width, this.height);
                  formImagem.getEfeito(b, width, height);

                  //jLabelImagem.setIcon(new ImageIcon(Filtro.negativo(imagem)));
                  double tempoFinal = System.currentTimeMillis();
                  tempoExecucao.setText(String.valueOf((tempoFinal - tempoInicial) / 1000) + " Seg");
           }
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
           if (caminhoFile == null) {

           } else {
                  try {
                         double tempoInicial = System.currentTimeMillis();
                         //i.setImage(Filtro.negativo(imagem));
                         //formImagem.getEfeito(i, width, height);

                         // jLabelImagem.setIcon(new ImageIcon(Filtro.threshold(imagem, fft.getValueSlider())));
                         double tempoFinal = System.currentTimeMillis();
                         tempoExecucao.setText(String.valueOf((tempoFinal - tempoInicial) / 1000) + " Seg");

                  } catch (Exception e) {
                         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, e);
                         JOptionPane.showMessageDialog(this, "ERRO: " + e.getMessage());
                  }
           }
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           corFundo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

       private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              redimencinar();
       }//GEN-LAST:event_jButton2ActionPerformed

       private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

       }//GEN-LAST:event_formWindowClosed

       private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

              //fecharTela();

       }//GEN-LAST:event_formWindowClosing

       public int getContador() {
              return this.contador++;
       }

       private ImageIcon redimensionaImagem(File image, Integer new_w, Integer new_h) throws IOException {
              try {

                     BufferedImage imagem = ImageIO.read(image);
                     BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);

                     Graphics2D g = new_img.createGraphics();
                     g.drawImage(imagem, 0, 0, new_w, new_h, null);

                     g.dispose();

                     return new ImageIcon(new_img);
              } catch (IOException ex) {
                     throw new RuntimeException(ex);
              }
       }

       // Variables declaration - do not modify//GEN-BEGIN:variables
       private javax.swing.JButton jButton1;
       private javax.swing.JButton jButton10;
       private javax.swing.JButton jButton11;
       private javax.swing.JButton jButton2;
       private javax.swing.JButton jButton3;
       private javax.swing.JButton jButton4;
       private javax.swing.JButton jButton5;
       private javax.swing.JButton jButton6;
       private javax.swing.JButton jButton7;
       private javax.swing.JButton jButton8;
       private javax.swing.JButton jButton9;
       private javax.swing.JLabel jLabel1;
       private javax.swing.JMenu jMenu1;
       private javax.swing.JMenu jMenu2;
       private javax.swing.JMenu jMenu3;
       private javax.swing.JMenu jMenu4;
       private javax.swing.JMenu jMenu5;
       private javax.swing.JMenu jMenu6;
       private javax.swing.JMenu jMenu7;
       private javax.swing.JMenu jMenu8;
       private javax.swing.JMenuBar jMenuBar1;
       private javax.swing.JMenuItem jMenuItem1;
       private javax.swing.JMenuItem jMenuItem10;
       private javax.swing.JMenuItem jMenuItem11;
       private javax.swing.JMenuItem jMenuItem12;
       private javax.swing.JMenuItem jMenuItem13;
       private javax.swing.JMenuItem jMenuItem14;
       private javax.swing.JMenuItem jMenuItem15;
       private javax.swing.JMenuItem jMenuItem16;
       private javax.swing.JMenuItem jMenuItem17;
       private javax.swing.JMenuItem jMenuItem18;
       private javax.swing.JMenuItem jMenuItem19;
       private javax.swing.JMenuItem jMenuItem2;
       private javax.swing.JMenuItem jMenuItem20;
       private javax.swing.JMenuItem jMenuItem21;
       private javax.swing.JMenuItem jMenuItem22;
       private javax.swing.JMenuItem jMenuItem23;
       private javax.swing.JMenuItem jMenuItem24;
       private javax.swing.JMenuItem jMenuItem3;
       private javax.swing.JMenuItem jMenuItem4;
       private javax.swing.JMenuItem jMenuItem6;
       private javax.swing.JMenuItem jMenuItem9;
       private javax.swing.JPopupMenu.Separator jSeparator1;
       private javax.swing.JToolBar.Separator jSeparator2;
       private javax.swing.JToolBar.Separator jSeparator3;
       private javax.swing.JToolBar jToolBar2;
       private javax.swing.JLabel tempoExecucao;
       // End of variables declaration//GEN-END:variables

       public void paintComponent(Graphics g) {
              AffineTransform at = AffineTransform.getTranslateInstance(100, 100);
              at.rotate(Math.toRadians(45));

              Graphics2D gr = (Graphics2D) g;
              gr.drawImage(imagem, at, null);

       }

       /*public class Evento implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
        int valor = slider.getValue();
        jLabelRed.setText("" + valor + "%");
        }

        }
        */
}
