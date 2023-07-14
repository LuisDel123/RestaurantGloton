package Vistas;

import Modelo.Producto;
import Controlador.ProductoDao;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MenuPrincipal extends javax.swing.JFrame {

    List<Producto> productosMP = new ArrayList<>();
    String categoria;
    String dni;
    ProductoDao p = new ProductoDao();

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public MenuPrincipal(String dniC) {
        initComponents();
        setDni(dniC);
        setResizable(false);

        lblPromoMP.setSize(890, 120);
        lblPollos.setSize(165, 135);
        lblcarnes.setSize(165, 135);
        lblPastas.setSize(165, 135);
        lblMariscos.setSize(165, 135);
        lblPostres.setSize(165, 135);
        lblBebidas.setSize(165, 135);
        setImageLabel(lblLogoMP, "src/Img/IconRes.png");
        btnCarrito.setIcon(setIcono(btnCarrito, "/Img/carrito.png"));
        setImageLabel(lblPromoMP, "src/Img/Promo.png");
        setImageLabel(lblPollos, "src/Img/Pollo Categoria.jpg");
        setImageLabel(lblcarnes, "src/Img/Carne Categoria.jpg");
        setImageLabel(lblPastas, "src/Img/Pasta Categoria.jpg");
        setImageLabel(lblMariscos, "src/Img/Ceviche Portada.jpg");
        setImageLabel(lblPostres, "src/Img/Postres Categoria.jpg");
        setImageLabel(lblBebidas, "src/Img/Bebidas.jpg");
        System.out.println("El DNI DEL CLIENTE ES pantalla mp: " + dni);

    }

    public MenuPrincipal() {
        initComponents();
    }

    public Icon setIcono(JButton boton, String url) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        // System.out.println("ancho "+ancho +" alto "+alto);
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
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

        jPanel1 = new javax.swing.JPanel();
        btnFavorito = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnCarrito = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLogoMP = new javax.swing.JLabel();
        lblPromoMP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPollos = new javax.swing.JLabel();
        btnCatPollos = new javax.swing.JButton();
        lblMariscos = new javax.swing.JLabel();
        btnCatMariscos = new javax.swing.JButton();
        lblcarnes = new javax.swing.JLabel();
        btnCatCarnes = new javax.swing.JButton();
        lblPostres = new javax.swing.JLabel();
        btnCatPostres = new javax.swing.JButton();
        lblPastas = new javax.swing.JLabel();
        btnCatPastas = new javax.swing.JButton();
        lblBebidas = new javax.swing.JLabel();
        btnCatBebidas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("El Glotón");
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(940, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 900));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFavorito.setText("Carta Preferencial");
        btnFavorito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoritoActionPerformed(evt);
            }
        });
        jPanel1.add(btnFavorito, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 120, 30));

        btnCategoria.setText("Categorias");
        btnCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 90, 30));

        btnCarrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(btnCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 50, 30));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 950, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("El Glotón");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        lblLogoMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        lblLogoMP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblLogoMP.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblLogoMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 2, 50, 50));

        lblPromoMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Promocion.png"))); // NOI18N
        lblPromoMP.setPreferredSize(new java.awt.Dimension(900, 120));
        jPanel1.add(lblPromoMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 828, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 200, 980, 20));

        lblPollos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Pollo Categoria.jpg"))); // NOI18N
        lblPollos.setToolTipText("");
        lblPollos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPollos.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblPollos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        btnCatPollos.setText("Pollos");
        btnCatPollos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatPollosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCatPollos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        lblMariscos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        lblMariscos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblMariscos.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblMariscos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        btnCatMariscos.setText("Mariscos");
        btnCatMariscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatMariscosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCatMariscos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, -1, -1));

        lblcarnes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Carne portada.jpg"))); // NOI18N
        lblcarnes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblcarnes.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblcarnes, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        btnCatCarnes.setText("Carnes");
        btnCatCarnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatCarnesActionPerformed(evt);
            }
        });
        jPanel1.add(btnCatCarnes, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, -1));

        lblPostres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Postres Categoria.jpg"))); // NOI18N
        lblPostres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPostres.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblPostres, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, -1, -1));

        btnCatPostres.setText("Postres");
        btnCatPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatPostresActionPerformed(evt);
            }
        });
        jPanel1.add(btnCatPostres, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, -1, -1));

        lblPastas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Pasta Portada.jpg"))); // NOI18N
        lblPastas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPastas.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblPastas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, -1, -1));

        btnCatPastas.setText("Pastas");
        btnCatPastas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatPastasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCatPastas, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, -1));

        lblBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bebidas.jpg"))); // NOI18N
        lblBebidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBebidas.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, -1, -1));

        btnCatBebidas.setText("Bebidas");
        btnCatBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatBebidasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCatBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoritoActionPerformed
        MenuBase me = new MenuBase(dni);
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFavoritoActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnCatPollosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatPollosActionPerformed
        productosMP = p.buscarProductosPorCat("POLLOS");
        MenuBase me = new MenuBase(dni, productosMP, "POLLOS");
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatPollosActionPerformed

    private void btnCatCarnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatCarnesActionPerformed
        productosMP = p.buscarProductosPorCat("CARNES");
        MenuBase me = new MenuBase(dni, productosMP, "CARNES");
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatCarnesActionPerformed

    private void btnCatPastasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatPastasActionPerformed
        productosMP = p.buscarProductosPorCat("PASTAS");
        MenuBase me = new MenuBase(dni, productosMP, "PASTAS");
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatPastasActionPerformed

    private void btnCatMariscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatMariscosActionPerformed
        productosMP = p.buscarProductosPorCat("MARISCOS");
        MenuBase me = new MenuBase(dni, productosMP, "MARISCOS");
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatMariscosActionPerformed

    private void btnCatPostresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatPostresActionPerformed
        productosMP = p.buscarProductosPorCat("POSTRES");
        MenuBase me = new MenuBase(dni, productosMP, "POSTRES");
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatPostresActionPerformed

    private void btnCatBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatBebidasActionPerformed
        productosMP = p.buscarProductosPorCat("BEBIDAS");
        MenuBase me = new MenuBase(dni, productosMP, "BEBIDAS");
        me.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatBebidasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnCatBebidas;
    private javax.swing.JButton btnCatCarnes;
    private javax.swing.JButton btnCatMariscos;
    private javax.swing.JButton btnCatPastas;
    private javax.swing.JButton btnCatPollos;
    private javax.swing.JButton btnCatPostres;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnFavorito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBebidas;
    private javax.swing.JLabel lblLogoMP;
    private javax.swing.JLabel lblMariscos;
    private javax.swing.JLabel lblPastas;
    private javax.swing.JLabel lblPollos;
    private javax.swing.JLabel lblPostres;
    private javax.swing.JLabel lblPromoMP;
    private javax.swing.JLabel lblcarnes;
    // End of variables declaration//GEN-END:variables

}
