/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.LoginDao;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {
    public String dni;

    Empleado emp = new Empleado();
    LoginDao login = new LoginDao();
    Cliente cli = new Cliente();

    public Login() {
        initComponents();
        //this.setLocationRelativeTo(this);
        setImageLabel(jLabel1, "src/Img/Ceviche Portada.jpg");
        setImageLabel(jLabel2, "src/Img/Bebida portada2.jpg");
        setImageLabel(jLabel3, "src/Img/Carne portada.jpg");
        setImageLabel(jLabel4, "src/Img/Pollo Portada.jpg");
        setImageLabel(jLabel5, "src/Img/Limonada Portada.jpg");
        setImageLabel(jLabel6, "src/Img/Pasta Portada.jpg");
        setImageLabel(jLabel9, "src/Img/Logon Login.png");
        lblContralogin.setVisible(false);
        txtcontraLogin.setVisible(false);
        setResizable(false);

    }

    public void validarEmpleado() {
        String dniE = txtDni.getText();
        String pwdE = txtcontraLogin.getText();
        if (!"".equals(dniE) || !"".equals(pwdE)) {
            emp = login.Logueo(dniE, pwdE);
            System.out.println("Punto 2");
            System.out.println("Dni:" + emp.getDni_emp());
            System.out.println("contra :" + emp.getPwd_emp());
            if (emp.getDni_emp() != null && emp.getPwd_emp() != null) {
                MenuEmpleado me = new MenuEmpleado();
                me.setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Correo o contraseña erronea");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar datos correctos");
        }

    }

    public void ingresoCliente() {
        String dniC = txtDni.getText();
        if (dniC.length() == 8) {
            int exCli = login.existeCliente(dniC);
            if (exCli == 1) {
                //ya exist
                dni=login.buscaCliente(dniC).getDni_cli();
               MenuPrincipal mp = new MenuPrincipal(dni);
                mp.setVisible(true);
                dispose();
            } else {
                //no existe se crea
                Cliente nCli=new Cliente (dniC);
                login.crearCliente(nCli);
                dni=login.buscaCliente(dniC).getDni_cli();
                //  System.out.println("telf: +"+cli.getTelf_cli());
                MenuPrincipal mp = new MenuPrincipal(dni);
                mp.setVisible(true);
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Dni debe contar con 8 digitos");
        }

    }

    private void setImageLabel(JLabel lblname, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblname.getWidth(), lblname.getHeight(), Image.SCALE_DEFAULT));
        lblname.setIcon(icon);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblDNI = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        cheBEmpleado = new javax.swing.JCheckBox();
        lblEmpleado = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblContralogin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcontraLogin = new javax.swing.JPasswordField();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new java.awt.Dimension(870, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDNI.setText("Dni:");
        getContentPane().add(lblDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 80, -1));

        cheBEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cheBEmpleadoMouseClicked(evt);
            }
        });
        cheBEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheBEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(cheBEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        lblEmpleado.setText("¿Empleado?");
        getContentPane().add(lblEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));
        lblEmpleado.getAccessibleContext().setAccessibleName("");

        btnLogin.setText("INGRESAR");
        btnLogin.setAlignmentX(922.0F);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setPreferredSize(new java.awt.Dimension(165, 135));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));

        lblContralogin.setText("Contraseña:");
        getContentPane().add(lblContralogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setPreferredSize(new java.awt.Dimension(165, 135));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setPreferredSize(new java.awt.Dimension(165, 135));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 320, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setPreferredSize(new java.awt.Dimension(165, 135));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setPreferredSize(new java.awt.Dimension(165, 135));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setPreferredSize(new java.awt.Dimension(165, 135));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Bienvenido");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("El Glotón");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 94, 190, 110));

        txtcontraLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraLoginActionPerformed(evt);
            }
        });
        getContentPane().add(txtcontraLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void cheBEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheBEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cheBEmpleadoActionPerformed

    private void cheBEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cheBEmpleadoMouseClicked
        if (cheBEmpleado.isSelected()) {
            lblContralogin.setVisible(true);
            txtcontraLogin.setVisible(true);
        } else {
            lblContralogin.setVisible(false);
            txtcontraLogin.setVisible(false);
        }
    }//GEN-LAST:event_cheBEmpleadoMouseClicked

    private void txtcontraLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraLoginActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (cheBEmpleado.isSelected()) {
            validarEmpleado();
        } else {
            ingresoCliente();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        if (txtDni.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cheBEmpleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblContralogin;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JTextField txtDni;
    private javax.swing.JPasswordField txtcontraLogin;
    // End of variables declaration//GEN-END:variables
}
