package Vistas;

import Modelo.Producto;
import Controlador.ProductoDao;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class PanelListarFavorito extends javax.swing.JPanel {

    List<Producto> platosFavoritos = new ArrayList<>();
    String dniPlF;
    ProductoDao p = new ProductoDao();

    public String getDniPlF() {
        return dniPlF;
    }

    public void setDniPlF(String dniPlF) {
        this.dniPlF = dniPlF;
    }

    public PanelListarFavorito() {
        initComponents();

    }

    public PanelListarFavorito(String Dni) {
        initComponents();

        setDniPlF(Dni);
        OcultarElementos();
        lblCategoria.setText("CARTA PREFERENCIAL");
        platosFavoritos = p.buscarProductosFavoritos(Dni);

        //configurar nombre de platos
        configurarNombrePlatos(platosFavoritos);
        //configurar descripcion de platos
        configurarDescripcionPlatos(platosFavoritos);
        //configurar imagenes de platos
        congirarImagenesPlatos(platosFavoritos);
        //configurar imagenes de platos
        configurarCostoPlatos(platosFavoritos);
        //configurar imagenes de platos
        configurarTiempoEntrega(platosFavoritos);
    }

    public String agregarSaltosLinea(String texto, int caracteresPorLinea) {
        String regex = "(.{" + caracteresPorLinea + "})";
        String textoFormateado = texto.replaceAll(regex, "$1\n");
        return textoFormateado;
    }

    private void setImageLabel(JLabel lblname, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblname.getWidth(), lblname.getHeight(), Image.SCALE_DEFAULT));
        lblname.setIcon(icon);
        this.repaint();
    }

    public void configurarNombrePlatos(List<Producto> Lispr) {
        JLabel[] lblNombreplatos = {lblNombrePlato1, lblNombrePlato2, lblNombrePlato3, lblNombrePlato4};
        ArrayList<String> datosNomPlatos = new ArrayList<>();
        for (Producto nmbPlatos : Lispr) {
            datosNomPlatos.add(nmbPlatos.getNombre_Producto());
        }
        for (int i = 0; i <= datosNomPlatos.size() - 1; i++) {
            lblNombreplatos[i].setText(datosNomPlatos.get(i));
            lblNombreplatos[i].setVisible(true);

        }
    }

    public void configurarDescripcionPlatos(List<Producto> Lispr) {
        JLabel[] lblDescripcionPlatos = {lblDetallePlato1, lblDetallePlato2, lblDetallePlato3, lblDetallePlato4};
        ArrayList<String> descripcionPlatos = new ArrayList<>();
        for (Producto descPlatos : Lispr) {
            descripcionPlatos.add(descPlatos.getDescripcion_Producto());
        }
        for (int i = 0;  i <= descripcionPlatos.size() - 1; i++) {
            lblDescripcionPlatos[i].setText("<html>" + agregarSaltosLinea(descripcionPlatos.get(i), 40) + "</html>");
            lblDescripcionPlatos[i].setVisible(true);
        }
    }

    public void congirarImagenesPlatos(List<Producto> Lispr) {
        JLabel[] lblImagenPlatos = {lblPlato1, lblPlato2, lblPlato3, lblPlato4};
        ArrayList<String> imagPlatos = new ArrayList<>();
        for (Producto imgPlatos : Lispr) {
            imagPlatos.add(imgPlatos.getNombre_Producto());
        }
        for (int i = 0;i <= imagPlatos.size() - 1; i++) {
            lblImagenPlatos[i].setSize(165, 135);
            setImageLabel(lblImagenPlatos[i], "src/Img/" + imagPlatos.get(i) + ".PNG");
            lblImagenPlatos[i].setVisible(true);
        }
    }

    public void configurarCostoPlatos(List<Producto> Lispr) {
        JLabel[] lblCostoplatos = {lblcostoPlato1, lblcostoPlato2, lblcostoPlato3, lblcostoPlato4};
        ArrayList<Double> costoPlatos = new ArrayList<>();
        for (Producto ctPlatos : Lispr) {
            costoPlatos.add(ctPlatos.getPrecio_Unitario());
        }
        for (int i = 0; i <= costoPlatos.size() - 1; i++) {
            lblCostoplatos[i].setText("S/" + costoPlatos.get(i) + "0");
            lblCostoplatos[i].setVisible(true);
        }
    }

    public void configurarTiempoEntrega(List<Producto> Lispr) {
        JLabel[] lblTiempoplatos = {lblTE1, lblTE2, lblTE3, lblTE4};
        ArrayList<Double> TiempoEBasePlatos = new ArrayList<>();
        ArrayList<Double> TiempoEPromPlatos = new ArrayList<>();
        for (Producto tePlatos : Lispr) {
            ProductoDao pdao = new ProductoDao();
            double teBase = 0.0;
            double teProm = 0.0;
            teBase = (double) tePlatos.getTiempo_entregaBase();
            TiempoEBasePlatos.add(teBase);
            teProm = pdao.ObtenerPromedio(tePlatos.getId_Producto());
            TiempoEPromPlatos.add(teProm);
        }
        for (int i = 0; i <= TiempoEBasePlatos.size() - 1; i++) {
            if (TiempoEPromPlatos.get(i) == 0.0) {
                int teTotal = (int) Math.ceil(TiempoEBasePlatos.get(i));
                lblTiempoplatos[i].setText(teTotal + " min aprox.");
            } else {
                System.out.println("Base " + TiempoEBasePlatos.get(i));
                System.out.println("Promedio " + TiempoEPromPlatos.get(i));
                double teintTotal = (TiempoEBasePlatos.get(i) + TiempoEPromPlatos.get(i)) / 2;
                int teTotal = (int) Math.ceil(teintTotal);
                lblTiempoplatos[i].setText(teTotal + " min aprox.");
                lblTiempoplatos[i].setVisible(true);
            }
        }
    }

    public void OcultarElementos() {
        lblNombrePlato1.setVisible(false);
        lblNombrePlato2.setVisible(false);
        lblNombrePlato3.setVisible(false);
        lblNombrePlato4.setVisible(false);
        lblPlato1.setVisible(false);
        lblPlato2.setVisible(false);
        lblPlato3.setVisible(false);
        lblPlato4.setVisible(false);
        lblDetallePlato1.setVisible(false);
        lblDetallePlato2.setVisible(false);
        lblDetallePlato3.setVisible(false);
        lblDetallePlato4.setVisible(false);
        lblcostoPlato1.setVisible(false);
        lblcostoPlato2.setVisible(false);
        lblcostoPlato3.setVisible(false);
        lblcostoPlato4.setVisible(false);
        lblTE1.setVisible(false);
        lblTE2.setVisible(false);
        lblTE3.setVisible(false);
        lblTE4.setVisible(false);
        btnPedirPlato1.setVisible(false);
        btnPedirPlato2.setVisible(false);
        btnPedirPlato3.setVisible(false);
        btnPedirPlato4.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContentListar = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        lblPlato1 = new javax.swing.JLabel();
        lblPlato3 = new javax.swing.JLabel();
        btnPedirPlato1 = new javax.swing.JButton();
        lblDetallePlato1 = new javax.swing.JLabel();
        lblNombrePlato1 = new javax.swing.JLabel();
        lblPlato4 = new javax.swing.JLabel();
        btnPedirPlato2 = new javax.swing.JButton();
        lblPlato2 = new javax.swing.JLabel();
        lblDetallePlato2 = new javax.swing.JLabel();
        lblNombrePlato2 = new javax.swing.JLabel();
        btnPedirPlato3 = new javax.swing.JButton();
        btnPedirPlato4 = new javax.swing.JButton();
        lblNombrePlato3 = new javax.swing.JLabel();
        lblNombrePlato4 = new javax.swing.JLabel();
        lblDetallePlato3 = new javax.swing.JLabel();
        lblDetallePlato4 = new javax.swing.JLabel();
        lblcostoPlato1 = new javax.swing.JLabel();
        lblcostoPlato2 = new javax.swing.JLabel();
        lblcostoPlato3 = new javax.swing.JLabel();
        lblcostoPlato4 = new javax.swing.JLabel();
        lblTE1 = new javax.swing.JLabel();
        lblTE2 = new javax.swing.JLabel();
        lblTE3 = new javax.swing.JLabel();
        lblTE4 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(930, 540));
        setPreferredSize(new java.awt.Dimension(930, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContentListar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(102, 0, 0));
        lblCategoria.setText("Categoria");
        panelContentListar.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblPlato1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1.jpg"))); // NOI18N
        lblPlato1.setToolTipText("");
        lblPlato1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPlato1.setPreferredSize(new java.awt.Dimension(165, 135));
        panelContentListar.add(lblPlato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lblPlato3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/3.png"))); // NOI18N
        lblPlato3.setToolTipText("");
        lblPlato3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPlato3.setPreferredSize(new java.awt.Dimension(165, 135));
        panelContentListar.add(lblPlato3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btnPedirPlato1.setText("Pedir");
        btnPedirPlato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirPlato1ActionPerformed(evt);
            }
        });
        panelContentListar.add(btnPedirPlato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        lblDetallePlato1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblDetallePlato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 280, 110));

        lblNombrePlato1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombrePlato1.setForeground(new java.awt.Color(0, 0, 204));
        lblNombrePlato1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblNombrePlato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 280, 20));

        lblPlato4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/4.png"))); // NOI18N
        lblPlato4.setToolTipText("");
        lblPlato4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPlato4.setPreferredSize(new java.awt.Dimension(165, 135));
        panelContentListar.add(lblPlato4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        btnPedirPlato2.setText("Pedir");
        panelContentListar.add(btnPedirPlato2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        lblPlato2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/2.png"))); // NOI18N
        lblPlato2.setToolTipText("");
        lblPlato2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPlato2.setPreferredSize(new java.awt.Dimension(165, 135));
        panelContentListar.add(lblPlato2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        lblDetallePlato2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblDetallePlato2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 240, 110));

        lblNombrePlato2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombrePlato2.setForeground(new java.awt.Color(0, 0, 204));
        lblNombrePlato2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblNombrePlato2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 240, 20));

        btnPedirPlato3.setText("Pedir");
        panelContentListar.add(btnPedirPlato3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        btnPedirPlato4.setText("Pedir");
        panelContentListar.add(btnPedirPlato4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 480, -1, -1));

        lblNombrePlato3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombrePlato3.setForeground(new java.awt.Color(0, 0, 204));
        lblNombrePlato3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblNombrePlato3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 250, 20));

        lblNombrePlato4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombrePlato4.setForeground(new java.awt.Color(0, 0, 204));
        lblNombrePlato4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblNombrePlato4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 230, 20));

        lblDetallePlato3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblDetallePlato3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 250, 90));

        lblDetallePlato4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblDetallePlato4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 230, 90));

        lblcostoPlato1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcostoPlato1.setForeground(new java.awt.Color(255, 0, 0));
        lblcostoPlato1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblcostoPlato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 60, 30));

        lblcostoPlato2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcostoPlato2.setForeground(new java.awt.Color(255, 0, 0));
        lblcostoPlato2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblcostoPlato2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 60, 30));

        lblcostoPlato3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcostoPlato3.setForeground(new java.awt.Color(255, 0, 0));
        lblcostoPlato3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblcostoPlato3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 60, 30));

        lblcostoPlato4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcostoPlato4.setForeground(new java.awt.Color(255, 0, 0));
        lblcostoPlato4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblcostoPlato4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 60, 30));

        lblTE1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTE1.setForeground(new java.awt.Color(204, 0, 0));
        lblTE1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 150, 30));

        lblTE2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTE2.setForeground(new java.awt.Color(204, 0, 0));
        lblTE2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblTE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 130, 30));

        lblTE3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTE3.setForeground(new java.awt.Color(204, 0, 0));
        lblTE3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblTE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 140, 30));

        lblTE4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTE4.setForeground(new java.awt.Color(204, 0, 0));
        lblTE4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContentListar.add(lblTE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 130, 30));

        add(panelContentListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedirPlato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirPlato1ActionPerformed

    }//GEN-LAST:event_btnPedirPlato1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedirPlato1;
    private javax.swing.JButton btnPedirPlato2;
    private javax.swing.JButton btnPedirPlato3;
    private javax.swing.JButton btnPedirPlato4;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDetallePlato1;
    private javax.swing.JLabel lblDetallePlato2;
    private javax.swing.JLabel lblDetallePlato3;
    private javax.swing.JLabel lblDetallePlato4;
    private javax.swing.JLabel lblNombrePlato1;
    private javax.swing.JLabel lblNombrePlato2;
    private javax.swing.JLabel lblNombrePlato3;
    private javax.swing.JLabel lblNombrePlato4;
    private javax.swing.JLabel lblPlato1;
    private javax.swing.JLabel lblPlato2;
    private javax.swing.JLabel lblPlato3;
    private javax.swing.JLabel lblPlato4;
    private javax.swing.JLabel lblTE1;
    private javax.swing.JLabel lblTE2;
    private javax.swing.JLabel lblTE3;
    private javax.swing.JLabel lblTE4;
    private javax.swing.JLabel lblcostoPlato1;
    private javax.swing.JLabel lblcostoPlato2;
    private javax.swing.JLabel lblcostoPlato3;
    private javax.swing.JLabel lblcostoPlato4;
    private javax.swing.JPanel panelContentListar;
    // End of variables declaration//GEN-END:variables
}
