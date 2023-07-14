package Vistas;

import Modelo.Producto;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MenuBase extends javax.swing.JFrame {

    String categoriaMB;
    String dniMB;

    public String getCategoriaMB() {
        return categoriaMB;
    }

    public void setCategoriaMB(String categoriaMB) {
        this.categoriaMB = categoriaMB;
    }

    public String getDniMB() {
        return dniMB;
    }

    public void setDniMB(String dniMB) {
        this.dniMB = dniMB;
    }

    public MenuBase() {
        initComponents();
        setResizable(false);

    }

    public MenuBase(String dni, String productoElegido) {
        initComponents();
        setResizable(false);
        System.out.println("estoy mb linea 40");

    }

    public MenuBase(String dni) {
        initComponents();
        setResizable(false);
        setDniMB(dni);
        PanelListarFavorito plfl = new PanelListarFavorito(dni);
        plfl.setSize(925, 535);
        panelContet.setLayout(null);
        panelContet.setSize(930, 540);
        plfl.setLocation(0, 0);
        panelContet.add(plfl);
        panelContet.revalidate();
        panelContet.repaint();

        //lblCategoria.setSize(new Dimension(200, 100));
        setResizable(false);
        setImageLabel(lblLogo, "src/Img/IconRes.png");
        btnCarrito.setIcon(setIcono(btnCarrito, "/Img/carrito.png"));
    }

    public MenuBase(String dni, List<Producto> productoMB, String cat) {
        initComponents();
        setDniMB(dni);
        setCategoriaMB(cat);
        PanelListarProductos1 plp1 = new PanelListarProductos1(productoMB, cat, dni);
        plp1.setSize(925, 535);
        panelContet.setLayout(null);
        panelContet.setSize(930, 540);
        plp1.setLocation(0, 0);
        panelContet.add(plp1);
        panelContet.revalidate();
        panelContet.repaint();

        //lblCategoria.setSize(new Dimension(200, 100));
        setResizable(false);
        setImageLabel(lblLogo, "src/Img/IconRes.png");
        btnCarrito.setIcon(setIcono(btnCarrito, "/Img/carrito.png"));

    }

    //Para acomodar icono
    public Icon setIcono(JButton boton, String url) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        // System.out.println("ancho "+ancho +" alto "+alto);
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
    // Para acomodar imagen

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
        btnCaegoria = new javax.swing.JButton();
        btnFavorito = new javax.swing.JButton();
        btnCarrito = new javax.swing.JButton();
        panelContet = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("El Glotón");
        setPreferredSize(new java.awt.Dimension(930, 650));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(940, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 900));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCaegoria.setText("Carta Preferencial");
        btnCaegoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCaegoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaegoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCaegoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 120, 30));

        btnFavorito.setText("Categorias");
        btnFavorito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoritoActionPerformed(evt);
            }
        });
        jPanel1.add(btnFavorito, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 90, 30));

        btnCarrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(btnCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 50, 30));

        panelContet.setBackground(new java.awt.Color(153, 153, 153));
        panelContet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(panelContet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 540));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 950, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("El Glotón");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        lblLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblLogo.setPreferredSize(new java.awt.Dimension(165, 135));
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 2, 50, 50));

        jButton1.setText("jButton1");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 630, -1, -1));

        jButton2.setText("jButton2");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCaegoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaegoriaActionPerformed

    }//GEN-LAST:event_btnCaegoriaActionPerformed

    private void btnFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoritoActionPerformed
        MenuPrincipal mp = new MenuPrincipal(dniMB);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFavoritoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaegoria;
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnFavorito;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelContet;
    // End of variables declaration//GEN-END:variables

    void setDni(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
