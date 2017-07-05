/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 作业提交系统;

//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static java.sql.JDBCType.NULL;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Sever extends javax.swing.JFrame {

    /**
     * Creates new form Sever
     */
    String savepath;
    int numover = 0;

    int socketnum = 0;
    //List list = new ArrayList()
    Socket socket[] = new Socket[1000];

    public Sever() {
        initComponents();

       new Thread(new Runnable() {
            public void run() {
                while(true){
                    InetAddress ia = null;
                    //InetAddress ia=null;
                    try {
                        ia = ia.getLocalHost();
                        String localip = ia.getHostAddress();
                        jTextField1.setText(localip);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    ServerSocket serverForClient = null;
                    Socket socketOnServer = null;
                    //DataOutputStream out = NULL;
                    //DataInputStream in = NULL;
                    //String  idcount = rs.getString(1);

                    //int port1;
                    //String port2 = rs.getString(4);
                    //port1 = Integer.parseInt(port2);
                    try {
                        serverForClient = new ServerSocket(6666);
                        socketOnServer = serverForClient.accept();
//                        for (int i = 0; i <= socketnum; i++) {
//                            if (socket[socketnum] == socketOnServer) {
//                                JOptionPane.showMessageDialog(jTextField1, "你已经完成提交", "警告!", JOptionPane.WARNING_MESSAGE);
//                            }
//                        }

                        socket[socketnum] = socketOnServer;
                        socketnum++;
                        System.out.println("+"+socketnum+"+");
                        if(socketOnServer.isConnected()){
                        
        
                                    File file = null;
                        FileOutputStream fos = null;

                        InputStream is = null;

             
                        byte[] buffer = new byte[1024];

                        String comm = null;
                
                        try {
                            InputStreamReader isr = new InputStreamReader(socketOnServer.getInputStream());
                            BufferedReader br = new BufferedReader(isr);
                            comm = br.readLine();
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(jTextField1, "服务器与客户端断开连接", "注意!", JOptionPane.WARNING_MESSAGE);
                        }

                        /**
                         * 开始解析客户端发送过来的请求命令
                         */
                        int index = comm.indexOf("/#");

                        /**
                         * 判断协议是否为发送文件的协议
                         */
                        String xieyi = comm.substring(0, index);
                        if (!xieyi.equals("111")) {
                            JOptionPane.showMessageDialog(jTextField1, "服务器收到的协议码不正确", "注意!", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        /**
                         * 解析出文件的名字和大小
                         */
                        comm = comm.substring(index + 2);
                        index = comm.indexOf("/#");
                        String filename = comm.substring(0, index).trim();
                        String filesize = comm.substring(index + 2).trim();
                        /**
                         * 创建空文件，用来进行接收文件
                         */
                        //System.out.println(savepath);
                        file = new File(savepath + filename);

                        if (!file.exists()) {
                            file.createNewFile();
                        } else {
                            JOptionPane.showMessageDialog(jTextField1, "本路径已存在相同文件，进行覆盖", "注意!", JOptionPane.WARNING_MESSAGE);
                        }
                        try {
                            /**
                             * 将文件包装到文件输出流对象中
                             */
                            fos = new FileOutputStream(file);
                            //System.out.println("sdfaskefhaskkl" + sever.savepath + file.getName() + "flaskfskhskejhfkawhfasjkd");
                            long file_size = Long.parseLong(filesize);
                            is = socketOnServer.getInputStream();
                            int size = 0;
                            int count = 0;
                            while (count < file_size) {
                                /**
                                 * 从输入流中读取一个数据包
                                 */
                                size = is.read(buffer);

                                fos.write(buffer, 0, size);
                                fos.flush();

                                count += size;
                                System.out.println("服务器端接收到数据包，大小为" + size);
                            }
//                            String addr = request.getRemoteAddr();
                            serverForClient.getInetAddress();
                            numover++;
                            jTextField3.setText("客户端提交情况:" + "(" + numover + "人)");

                        } catch (FileNotFoundException e) {
                            JOptionPane.showMessageDialog(jTextField1, "服务器写文件失败", "错误!", JOptionPane.WARNING_MESSAGE);
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(jTextField1, "服务器：客户端断开连接", "注意!", JOptionPane.WARNING_MESSAGE);
                        } 
                        
                        finally {
                            try {
                                if (fos != null) {
                                    fos.close();
                                }
                            } catch (IOException e) {
                            }//catch (IOException e)

                        }
                                
                           
                        
                        //System.out.println();

                        /**
                         * 定义用于在接收后在本地创建的文件对象和文件输出流对象
                         */
                        
                        }      //前面的if
                    } catch (IOException ex) {
                        ;
                    }
                    
                }
            }
        }).start(); }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("服务器IP：");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("请选择文件存储路径：");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("消息通知：");

        jButton1.setText("清空");
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

        jButton3.setText("录入学生名单");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "软工151", "软工152", "软工153", "信管151", "信管152", "信管153", "计科151", "计科152", "计科153" }));

        jButton4.setText("名单查询");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton5.setText("选择目录");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("打开目录");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jTextField3.setForeground(new java.awt.Color(255, 0, 0));
        jTextField3.setText("客户端提交情况:(0人)");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jMenu1.setText("设置");
        jMenuBar1.add(jMenu1);

        jMenu2.setText(" ");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jTextField3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    class Getfile(Socket m,Socket n) implements Runnable{
//    public void run(){
//        
//    }
//}
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea3.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showDialog(new JLabel(), "选择");
        File file = chooser.getSelectedFile();

        jTextField2.setText(file.getAbsolutePath() + "\\");
        String location = jTextField2.getText().replaceAll("\\\\", "/");
        savepath = location;

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //JFileChooser chooser=new JFileChooser();  
        //chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );

        try {
            //System.out.println("this" + savepath + "this");
            //Runtime.getRuntime().exec("rundll32"+"shell32.dll"+"ShellExec_RunDLL"+savepath);
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "", savepath});
        } catch (IOException ex) {
            Logger.getLogger(Sever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

//    class SeverThread {
//
//        private Socket so;
//
//        public SeverThread(Socket s) {
//            this.so = s;
//        }
//
//        public void send() {
//
//        }
//
//        public void run() {
//
//        }
//    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                    for (int j = 0; j < socketnum; j++) {
                        DataOutputStream out = null;
                        DataInputStream in = null;
                        try {
                            //SeverThread tt = new SeverThread(socket);
                            
                            System.out.println(socket[j]);
                            in = new DataInputStream(socket[j].getInputStream());
                            out = new DataOutputStream(socket[j].getOutputStream());
//                String [] mess = {jTextArea3.getText()};
//                
//                for(int m = 0; m < mess.length; m++){
                            out.writeUTF(jTextArea3.getText());
                            out.flush();
                            jTextArea3.setText("");
                            // }
                        } catch (IOException ex) {
                            Logger.getLogger(Sever.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
    }//GEN-LAST:event_jButton2ActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //ServerSocket NULL;
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*catch (InterruptedException ex) {
           
        }*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sever().setVisible(true);

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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
