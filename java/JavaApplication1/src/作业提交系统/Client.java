/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 作业提交系统;

import java.io.*;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Client extends javax.swing.JFrame {

    Login login = new Login();

    public Client(Login login) {
        initComponents();
        this.login = login;
    }
    Socket mysocket = null;

    /**
     * Creates new form Client
     */
    public Client(Socket mysocket1) {
        initComponents();
        mysocket = mysocket1;
            new Thread(new Runnable() {
                public void run() {
                    while(true){
                    DataOutputStream out = null;
                    DataInputStream in = null;
                    try {
                        //SeverThread tt = new SeverThread(socket);
                        in = new DataInputStream(mysocket.getInputStream());
                        //out = new DataOutputStream(mysocket.getOutputStream());

                        String s = in.readUTF();
                        //in.close();
                        
                        jTextArea1.setText(s);
                        JOptionPane.showMessageDialog(jTextArea1, "来自服务器的消息！", "提示!", JOptionPane.WARNING_MESSAGE);
                        
                        // }
                    } catch (IOException ex) {
                        Logger.getLogger(Sever.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                }
            }).start();
        }

    public Client() {
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("请选择发送的文件：");

        jLabel2.setText("传输进度：");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("选择文件");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("发送");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addGap(45, 45, 45)
                                        .addComponent(jButton2))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfchooser = new JFileChooser();
        jfchooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfchooser.showDialog(new JLabel(), "选择");
        File file = jfchooser.getSelectedFile();
        if (file.isDirectory()) {
            System.out.println("文件夹:" + file.getAbsolutePath());
        } else if (file.isFile()) {
            System.out.println("文件:" + file.getAbsolutePath());
        }
        jTextField1.setText(file.getAbsolutePath());


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            new Thread(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(100);
                        String filepath = jTextField1.getText();
                        //System.out.println(filepath);
                        String location = filepath.replaceAll("\\\\", "/");
                        //System.out.println(location);

                        File sendfile = new File(location);

                        FileInputStream fis = null;
                        byte[] buffer = new byte[1024];
                        OutputStream os = null;

                        if (!sendfile.exists()) {
                            int n;
                            n = JOptionPane.showConfirmDialog(jTextField1, "文件不存在!", "确认对话框", JOptionPane.YES_OPTION);
                            if (n == JOptionPane.YES_OPTION) {
                                jTextField1.setText("");
                            }
                            return;
                        }

                        try {
                            fis = new FileInputStream(sendfile);
                        } catch (FileNotFoundException e1) {
                            System.out.println("输入流处出错!");
                        }

                        try {
                            PrintStream ps = new PrintStream(mysocket.getOutputStream());
                            ps.println("111/#" + sendfile.getName() + "/#" + fis.available());
                            ps.flush();
                        } catch (IOException e) {
                            System.out.println("服务器连接中断");
                        }
                        try {

                            /**
                             * 获取socket的OutputStream，以便向其中写入数据包
                             */
                            os = mysocket.getOutputStream();

                            /**
                             * size 用来记录每次读取文件的大小
                             */
                            int size = 0;

                            /**
                             * 使用while循环读取文件，直到文件读取结束
                             */
                            long sizefile = sendfile.length();
                            //System.out.println(sizefile);
                            double count = 0;
                            int nbsp;
                            while ((size = fis.read(buffer)) != -1) {
                                System.out.println("客户端发送数据包，大小为" + size);
                                count = size + count;
                                nbsp = (int) ((count / sizefile) * 100);
                                //System.out.println("   " + nbsp);
                                jProgressBar1.setValue(nbsp);
                                //int i = jProgressBar1.getValue();
                                //System.out.println(i);
                                Thread.sleep(50);
                                os.write(buffer, 0, size);

                                os.flush();
                            }

                            //jProgressBar1.setValue(0);
                        } catch (FileNotFoundException e) {
                            System.out.println("客户端读取文件出错");
                        } catch (IOException e) {
                            System.out.println("客户端输出文件出错");
                        } //        catch (InterruptedException ex) {
                        //            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        //        } 
                        finally {

                            try {
                                if (fis != null) {
                                    fis.close();
                                }
                            } catch (IOException e) {
                                System.out.println("客户端文件关闭出错");
                            }//catch (IOException e)
                        }
                    } catch (InterruptedException ie) {
                    }
                }
            }).start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Client().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
