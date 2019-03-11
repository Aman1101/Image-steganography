package visualsteganography;

import beans.dto.LogMaster;
import connection.service.HibernateUtil;
import filechooser.classes.ImageFilter;
import filechooser.classes.ImagePreview;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import logic.Encode_Decode_Image;
import logic.GreyCode_Binary_Bridge;
import logic.Message_Binary_Bridge;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import words.library.WordLib;

public class EncodeSection extends javax.swing.JFrame {

    int imgHEIGHT;
    int imgWIDTH;
    BufferedImage inputImage;
    BufferedImage encodedImage;
    SessionFactory sessionFactory;
    LogMaster log;

    public EncodeSection() {
        initComponents();
        log = new LogMaster();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
        } catch (ExceptionInInitializerError ei) {
            JOptionPane.showMessageDialog(rootPane, "Database Connectivity Error...!!!");
        }
        jPanel2.setEnabled(false);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea111 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Upload Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cover Image"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );

        jButton2.setText("NEXT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea111.setEditable(false);
        jTextArea111.setColumns(20);
        jTextArea111.setLineWrap(true);
        jTextArea111.setRows(5);
        jTextArea111.setText("INSTRUCTIONS:-\n\n-> Input path of COVER IMAGE in Text Field and Click on 'Upload Image'\n\n-> Selected Image would be uploaded automatiacally and would be validated.\n\n-> If image gets validated successfully, It would be shown under Cover Image Panel.\n\n-> After Image gets painted Click on NEXT to go to next TAB.");
        jScrollPane1.setViewportView(jTextArea111);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Image Upload Section", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setText("Input Message");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SAVE AND PROCESS");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Binary Operations Panel"));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Binary Data"));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Grey Coded Data "));

        jScrollPane3.setEnabled(false);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Secret Message"));

        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText("INSTRUCTIONS:-\n\n-> Click ok 'INPUT MESSAGE' Button below to enter SECRET MESSAGE which user want to encode into Cover Image.\n\n->Click ok 'SAVE AND PROCESS' to process message\n\n-> Click ok NEXT Button to complete encoding process.\n\nNOTE: Process input would consist of only Lower case alphabets and numbers other characters would be filtered. ");
        jScrollPane5.setViewportView(jTextArea5);

        jButton5.setText("START ENCODING");
        jButton5.setDoubleBuffered(true);
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Secret Message Section", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cover Text"));
        jScrollPane6.setViewportView(jTextArea4);

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Initial Image"));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Encoded Image"));

        jButton6.setText("SAVE ENCODED IMAGE AND COVER MESSAGE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(100, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Encode Operation Section", jPanel3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Encode Operation Section");

        jMenu1.setText("Operations");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Home");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Encode");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Decode");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About Us");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String fileName = jTextField1.getText();
        Boolean token = false;
        File imageFile = null;
        if (fileName.isEmpty()) {
            JFileChooser jfc = new JFileChooser();
            jfc.addChoosableFileFilter(new ImageFilter());
            jfc.setAcceptAllFileFilterUsed(false);
            jfc.setAccessory(new ImagePreview(jfc));
            jfc.setVisible(true);
            int returnVal = jfc.showDialog(this, "Attach");
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                imageFile = jfc.getSelectedFile();
                fileName = imageFile.getAbsolutePath();
                jTextField1.setText(imageFile.getAbsolutePath());
                token = true;
            } else {
                token = false;
            }
        } else {
            imageFile = new File(fileName);
            if (!imageFile.exists()) {
                JOptionPane.showMessageDialog(rootPane, "File Not Found...!!!");
                token = false;
            } else {
                token = true;
            }
        }
        if (token == true) {
            Boolean imageCheck = imageCheck(fileName);
            if (imageCheck) {
                //                JOptionPane.showMessageDialog(rootPane, "Image Attached Successfully...!!!");
                ImageIcon tmpIcon = new ImageIcon(imageFile.getPath());
                ImageIcon thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(jLabel1.getWidth(),
                        jLabel1.getHeight(), Image.SCALE_DEFAULT));
                jLabel1.setIcon(thumbnail);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Selected Image Does Not Meet Requirements Criteria...!!!\n\n"
                        + "Refer To Image Upload Instructions for more Details...!!!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (inputImage != null) {
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Plese Input Cover Image before Continuing...!!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextArea1.setEnabled(true);
        jTextArea1.setBackground(Color.WHITE);
        jTextArea1.requestFocus();
        jButton4.setEnabled(true);
        jButton3.setEnabled(false);
        jButton5.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String msg = jTextArea1.getText();
        if (msg.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please Attach Message Before Saving it...!!!");
        } else {
            jButton4.setEnabled(false);
            jButton3.setEnabled(true);
            jTextArea1.setEnabled(false);
            String msgArr[] = msg.toLowerCase().split("\\s+");
            String newMsg = "";
            for (String string : msgArr) {
                newMsg += string.replaceAll("\\W", "") + " ";
            }
            if (newMsg.length() <= (imgHEIGHT * imgWIDTH)) {
                jTextArea1.setText(newMsg);
                Message_Binary_Bridge message_Binary_Bridge = new Message_Binary_Bridge();
                String binary = message_Binary_Bridge.convertMessageToBinary(newMsg);
                jTextArea2.setText(binary);
                String tempMsg[] = binary.split("\\s");
                GreyCode_Binary_Bridge gbb = new GreyCode_Binary_Bridge();
                String greyCode = gbb.binaryStringToGreyString(binary);
                jTextArea3.setText(greyCode);
                jButton5.setEnabled(true);
                JOptionPane.showMessageDialog(rootPane, "Message Saved and Altered Successfully...!!!");
                try {
                    log.setSecretMessage_Rendered(newMsg);
                    log.setSecretMessage_Orignal(msg);
                } catch (Exception e) {
                    System.err.print("Database Connection Problem");
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Cover Image Size is not big enough to fit secret text...!!!\n"
                        + "Please either input bigger cover image or reduce secret message size...!!!");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String greyEncodedMessage = jTextArea3.getText();
        if (!greyEncodedMessage.isEmpty()) {
            if (inputImage != null) {
                String tmpCoord;
                String tempMsg = jTextArea1.getText();//Removed Code to replace space with blank
                System.out.println("TEMP MSG: " + tempMsg);
                System.out.println("SIZE: " + tempMsg.length());
                ArrayList<Integer> xCoord = new ArrayList<>();
                ArrayList<Integer> yCoord = new ArrayList<>();
                ArrayList<String> coord = new ArrayList<>();
                int x, y;
                for (int i = 0; i < tempMsg.length(); i++) {
                    x = (int) (Math.random() * imgWIDTH);
                    y = (int) (Math.random() * imgHEIGHT);
                    tmpCoord = "" + x + "," + y;
                    if (coord.contains(tmpCoord)) {
                        i = i - 1;
                        System.out.println("loop 1 step back");
                        //Take loop 1 step backwards
                    } else {
                        coord.add(tmpCoord);
                        xCoord.add(x);
                        yCoord.add(y);
                    }
                }
                for (int i = 0; i < xCoord.size(); i++) {
                    System.out.println("X: " + xCoord.get(i) + ", Y: " + yCoord.get(i));
                }
                try {
                    Encode_Decode_Image edi = new Encode_Decode_Image(inputImage);
                    encodedImage = edi.encodeData_Image(greyEncodedMessage, xCoord, yCoord);
                    if (encodedImage != null) {
                        JOptionPane.showMessageDialog(rootPane, "Data Successfully Encoded In Image....!!!");
                        WordLib wordLib = new WordLib();
                        String coverText = wordLib.generateCoverMessage(xCoord, yCoord);
                        //setting image and text for next tab here
                        jLabel3.setIcon(new ImageIcon(inputImage.getScaledInstance(jLabel3.getWidth(),
                                jLabel3.getHeight(), Image.SCALE_DEFAULT)));
                        jLabel4.setIcon(new ImageIcon(encodedImage.getScaledInstance(jLabel4.getWidth(),
                                jLabel4.getHeight(), Image.SCALE_DEFAULT)));
                        jTextArea4.setText(coverText);
                        //Enabling next tab here
                        jTabbedPane1.setEnabledAt(2, true);
                        jTabbedPane1.setSelectedIndex(2);
                        try {
                            log.setCoordinates_xy(coord);
                            log.setParaphrase(coverText);
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            ImageIO.write(encodedImage, "png", bos);
                            log.setEncodedImage(bos.toByteArray());
                        } catch (Exception e) {
                            System.err.println("Database Connectivity Problem");
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error Encoding Image...!!!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Error Encoding Image...!!!, " + e);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Select Image To Be Encoded Before Continuing...!!!");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Please Input Secret Message and Process it before continuing...!!!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            log.setDateCreated(new Date());
            Session s = sessionFactory.openSession();
            Transaction tx = s.beginTransaction();
            s.save(log);
            tx.commit();
            s.close();
        } catch (Exception e) {
            System.err.println("Database Connectivity Problem");
            e.printStackTrace();
        }
        if (encodedImage != null) {
            JFileChooser jfc = new JFileChooser();
            jfc.setAcceptAllFileFilterUsed(false);
            jfc.setVisible(true);
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = jfc.showSaveDialog(this);
            File imageFile;
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                imageFile = jfc.getSelectedFile();
                String pathName = imageFile.getAbsolutePath();
                System.out.println(pathName);
                String name = JOptionPane.showInputDialog("File Name: ");
                if (name == null) {
                    JOptionPane.showMessageDialog(rootPane, "Save Operation Interrupted...!!!\nFile Not Saved...!!!");
                } else {
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "No File Name is Entered...!!!\nFile Not Saved...!!!");
                    } else {
                        String destinationImageFileName = name + ".png";
                        String destinationTextFileName = name + ".txt";
                        File destinationImageFile = new File(pathName, destinationImageFileName);
                        File destinationTextFile = new File(pathName, destinationTextFileName);
                        int save = saveImage(encodedImage, destinationImageFile);
                        if (save == 1) {
                            try {
                                String coverText;
                                if (!destinationTextFile.exists()) {
                                    destinationTextFile.createNewFile();
                                    coverText = jTextArea4.getText();
                                } else {
                                    coverText = "\n\n" + jTextArea4.getText();
                                }
                                try (FileWriter fileWriter = new FileWriter(destinationTextFile, true)) {
                                    fileWriter.write(coverText);
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(rootPane, "Error Saving Data to File...!!!, " + e.getMessage());
                            }
                            JOptionPane.showMessageDialog(rootPane, "Encoded Image and Cover Text Saved Successfully...!!!\n"
                                    + "Location of Encoded Image: " + destinationImageFile.getAbsolutePath()
                                    + "\nLocation of Cover Text: " + destinationTextFile.getAbsolutePath());
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Error Saving Encoded Image...!!!");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please Encode Image Before Saving...!!!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        DecoderSection decoderSection = new DecoderSection();
        decoderSection.setVisible(true);
        decoderSection.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        EncodeSection encodeSection = new EncodeSection();
        encodeSection.setVisible(true);
        encodeSection.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        StartFrame startFrame = new StartFrame();
        startFrame.setVisible(true);
        startFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public int saveImage(BufferedImage bi, File f) {
        try {
            ImageIO.write(bi, "png", f);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Boolean imageCheck(String IMG) {
        try {
            inputImage = ImageIO.read(new File(IMG));

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(inputImage, "png", bos);
            log.setInputImage(bos.toByteArray());

            imgWIDTH = inputImage.getWidth();
            imgHEIGHT = inputImage.getHeight();
            if ((imgHEIGHT >= 1000 && imgHEIGHT <= 9999) && (imgWIDTH >= 1000 && imgWIDTH <= 9999)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Exception Occurred...!!!, " + e);
        }
        return false;
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncodeSection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea111;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
