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
public class estudiante extends javax.swing.JFrame {
   connection conn=new connection();
    Connection cu=conn.conexiondb();
    PreparedStatement ps=null;
    ResultSet re=null;
    public estudiante() {
        initComponents();
        cargartablas();
    }

    public void cargartablas(){
        DefaultTableModel tabla=new DefaultTableModel();
        tabla.addColumn("Documento");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Edad");
       
        
        tablaconsulta.setModel(tabla);
        String datos[]=new String[5];
        try{
            ps=cu.prepareStatement("SELECT*FROM estudiante");
            re=ps.executeQuery();
            while(re.next()){
                datos[0]=re.getString(1);
                datos[1]=re.getString(2);
                datos[2]=re.getString(3);
                datos[3]=re.getString(4);
                tabla.addRow(datos);
                
            }
        }
        catch (Exception e){
            System.out.print(e);
            
        }
    }
    
    public void Registrar(){
    try{
    
    ps=cu.prepareStatement("INSERT INTO estudiante(doc_est,nom_est,ape_est,edad_est) values (?,?,?,?)");
    ps.setInt(1,Integer.parseInt(jTexDoc.getText()));
    ps.setString(2,jTextFNom.getText());
    ps.setString(3,jTextFApell.getText());
    ps.setInt(4,Integer.parseInt(jTextFEdad.getText()));
    
    
    ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos guardados");
    }
    catch (Exception e){
    System.out.print("es " + e);
    }
}
    public void Eliminar(String dat){
        try{
        ps=cu.prepareStatement("DELETE FROM estudiante where  doc_est='"+dat+"' ");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos eliminados");
        }
            catch(Exception e){
                    System.out.print(e);
                    }
        }
     public void Modificar(String  doc,String nom,String ap,String ed){
        try{
            ps=cu.prepareStatement("UPDATE estudiante SET  nom_est='"+ nom +"', ape_est='"+ap+"' , edad_est='"+ ed+ "' where doc_est='"+doc+"' ");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFEdad = new javax.swing.JTextField();
        jTexDoc = new javax.swing.JTextField();
        jTextFNom = new javax.swing.JTextField();
        jTextFApell = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaconsulta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 630, 160));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));
        getContentPane().add(jTextFEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 150, 30));
        getContentPane().add(jTexDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 150, 30));
        getContentPane().add(jTextFNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 150, 30));
        getContentPane().add(jTextFApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 150, 30));

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        jButton5.setText("ATRAS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jButton6.setText("Modificar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tablero.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Registrar();
        cargartablas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String dat=jTexDoc.getText();
        Eliminar(dat);
        cargartablas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTexDoc.setText(null);
        jTextFNom.setText(null);
        jTextFApell.setText(null);
        jTextFEdad.setText(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Menu m=new Menu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String doc,nom,ape,ed;
        doc=jTexDoc.getText();
        nom=jTextFNom.getText();
        ape=jTextFApell.getText();
        ed=jTextFEdad.getText();
        Modificar(doc, nom, ape, ed);
        cargartablas();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new estudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTexDoc;
    private javax.swing.JTextField jTextFApell;
    private javax.swing.JTextField jTextFEdad;
    private javax.swing.JTextField jTextFNom;
    private javax.swing.JTable tablaconsulta;
    // End of variables declaration//GEN-END:variables
}
