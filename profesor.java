/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.DBAcademia;

import vista.TBBANCO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Menu;

/**
 *
 * @author usuario
 */
public class profesor extends javax.swing.JFrame {
      connection conn=new connection();
    Connection cu=conn.conexiondb();
    PreparedStatement ps=null;
    ResultSet re=null;
    /**
     * Creates new form profesor
     */
    public profesor() {
        initComponents();
         cargartablas();
    }
 public void cargartablas(){
        DefaultTableModel tabla=new DefaultTableModel();
        tabla.addColumn("Documento");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Categoria");
        tabla.addColumn("Salario");
        
        tablaconsulta.setModel(tabla);
        String datos[]=new String[6];
        try{
            ps=cu.prepareStatement("SELECT*FROM profesor");
            re=ps.executeQuery();
            while(re.next()){
                datos[0]=re.getString(1);
                datos[1]=re.getString(2);
                datos[2]=re.getString(3);
                datos[3]=re.getString(4);
                datos[4]=re.getString(5);
                tabla.addRow(datos);
                
            }
        }
        catch (Exception e){
            System.out.print(e);
            
        }
    }
 
    public void Registrar(){
    try{
    
    ps=cu.prepareStatement("INSERT INTO profesor(doc_prof,nom_prof,ape_prof,cate_prof,sal_prof) values (?,?,?,?,?)");
    ps.setInt(1,Integer.parseInt(jTexDoc.getText()));
    ps.setString(2,jTextNom.getText());
    ps.setString(3,jTextAp.getText());
    ps.setInt(4,Integer.parseInt(jTextCat.getText()));
    ps.setInt(5,Integer.parseInt(jTextSal.getText()));
    
  
    
   
    ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos guardados");
    }
    catch (Exception e){
    System.out.print("es " + e);
    }
}
    public void Eliminar(String dat){
        try{
        ps=cu.prepareStatement("DELETE FROM profesor where  doc_prof='"+dat+"' ");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos eliminados");
        }
            catch(Exception e){
                    System.out.print(e);
                    }
        }
      public void Modificar(String doc,String nom,String  ap,String cat,String sal){
        try{
            ps=cu.prepareStatement("UPDATE profesor SET  nom_prof='"+nom  +"' ,ape_prof='" +ap+"',cate_prof='"+cat+"',sal_prof='"+sal+"' where doc_prof='" +doc+"' ");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados");
        }
        catch(Exception e){
            
            System.out.print( e);
        }
        
        
    } 
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsulta = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextSal = new javax.swing.JTextField();
        jTexDoc = new javax.swing.JTextField();
        jTextNom = new javax.swing.JTextField();
        jTextAp = new javax.swing.JTextField();
        jTextCat = new javax.swing.JTextField();
        jBuMod = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        tablaconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaconsulta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 780, 220));

        jButton7.setText("Registrar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Salario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 70, 30));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento profesor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 110, 20));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 90, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 80, 20));
        getContentPane().add(jTextSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 140, 30));
        getContentPane().add(jTexDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 140, 30));
        getContentPane().add(jTextNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 140, 30));
        getContentPane().add(jTextAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, 30));
        getContentPane().add(jTextCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 140, 30));

        jBuMod.setText("Modificar");
        jBuMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuModActionPerformed(evt);
            }
        });
        getContentPane().add(jBuMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profesor.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-330, 0, 1110, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu m=new Menu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Registrar();
        cargartablas();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String dat=jTexDoc.getText();
        Eliminar(dat);
        cargartablas();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTexDoc.setText(null);
        jTextNom.setText(null);
        jTextAp.setText(null);
        jTextCat.setText(null);
        jTextSal.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jBuModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuModActionPerformed
        String doc,nom,ap,cat,sal;
        doc=jTexDoc.getText();
        nom=jTextNom.getText();
        ap=jTextAp.getText();
        cat=jTextCat.getText();
        sal=jTextSal.getText();

        Modificar(doc, nom, ap, cat, sal);
        cargartablas();
    }//GEN-LAST:event_jBuModActionPerformed

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
            java.util.logging.Logger.getLogger(profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBuMod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTexDoc;
    private javax.swing.JTextField jTextAp;
    private javax.swing.JTextField jTextCat;
    private javax.swing.JTextField jTextNom;
    private javax.swing.JTextField jTextSal;
    private javax.swing.JTable tablaconsulta;
    // End of variables declaration//GEN-END:variables
}
