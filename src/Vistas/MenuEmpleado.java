package Vistas;

import Controlador.PedidoDao;
import Modelo.Producto;
import Controlador.ProductoDao;
import Modelo.Pedido;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuEmpleado extends javax.swing.JFrame {

    List<Producto> productosMP = new ArrayList<>();
    List<Pedido> pedidosME = new ArrayList<>();
    String dni;
    Producto p = new Producto();
    Pedido pe = new Pedido();
    PedidoDao pedao = new PedidoDao();
    ProductoDao pdao = new ProductoDao();
    DefaultTableModel modelProd = new DefaultTableModel();
    DefaultTableModel modelPedid = new DefaultTableModel();

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public MenuEmpleado(String dniC) {
        initComponents();
        setDni(dniC);
        setResizable(false);
        modelPedid = (DefaultTableModel) TablePedido.getModel();
        ListarPedidos();
        setImageLabel(lblLogoME, "src/Img/IconRes.png");
    }

    public MenuEmpleado() {
        initComponents();
    }

    public void LimpiarTablePed() {
        int rowCount = modelPedid.getRowCount();
        for (int i = rowCount-1; i >=0; i--) {
            modelPedid.removeRow(i);
        }
       
    }

    public void LimpiarTableProd() {
        for (int i = 0; i < modelProd.getRowCount(); i++) {
            modelProd.removeRow(i);
            i = i - 1;
        }
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

    public void ListarProductos() {
        List<Producto> listarprod = pdao.listarProductos();
        modelProd = (DefaultTableModel) TableProducto.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < listarprod.size(); i++) {
            ob[0] = listarprod.get(i).getId_Producto();
            ob[1] = listarprod.get(i).getNombre_Producto();
            ob[2] = listarprod.get(i).getPrecio_Unitario();
            ob[3] = listarprod.get(i).getDescripcion_Producto();
            ob[4] = listarprod.get(i).getTiempo_entregaBase();

            switch (listarprod.get(i).getId_Categoria()) {
                case 1:
                    ob[5] = "POLLOS";
                    break;
                case 2:
                    ob[5] = "CARNES";
                    break;
                case 3:
                    ob[5] = "MARISCOS";
                    break;
                case 4:
                    ob[5] = "PASTAS";
                    break;
                case 5:
                    ob[5] = "BEBIDAS";
                    break;
                case 6:
                    ob[5] = "POSTRES";
                    break;
                default:
                    System.out.println("Opción no válida: " + listarprod.get(i).getId_Categoria());
                    break;
            }
            modelProd.addRow(ob);
        }
        TableProducto.setModel(modelProd);
    }

    public void ListarPedidos() {
        List<Pedido> listarped = pedao.ListarTodosPedidos();
        modelPedid = (DefaultTableModel) TablePedido.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < listarped.size(); i++) {
            ob[0] = listarped.get(i).getId_Pedido();
            ob[1] = listarped.get(i).getProducto_Pedido();
            ob[2] = listarped.get(i).getCantidad();
            ob[3] = listarped.get(i).getCostoTotal();
            ob[4] = listarped.get(i).getHoraRegistro();
            ob[5] = listarped.get(i).getHoraEntrega();
            ob[6] = listarped.get(i).getEstado_Pedido();
            modelPedid.addRow(ob);
        }
        TablePedido.setModel(modelPedid);
    }

    private void limpiarText() {
        txtNombreProducto.setText("");
        txtDescripcionProducto.setText("");
        txtCostoProducto.setText("");
        txtTiempoProducto.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnPedidos = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        lblLogoME = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePedido = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Costo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCostoPedido = new javax.swing.JTextField();
        txtHoraRegistro = new javax.swing.JTextField();
        txtCantidadPedido = new javax.swing.JTextField();
        txtdniPedido = new javax.swing.JTextField();
        txtProductoPedido = new javax.swing.JTextField();
        txtHoraEntrega = new javax.swing.JTextField();
        btnEntrega = new javax.swing.JButton();
        txtEstadoPedido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtDescripcionProducto = new javax.swing.JTextField();
        txtCostoProducto = new javax.swing.JTextField();
        cbxCat = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableProducto = new javax.swing.JTable();
        btnIngresarProducto = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTiempoProducto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Empleado");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("El Glotón");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(444, 444, 444))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1030, 120));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        btnPedidos.setText("Pedidos");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        lblLogoME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ceviche Portada.jpg"))); // NOI18N
        lblLogoME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblLogoME.setPreferredSize(new java.awt.Dimension(165, 135));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoME, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnPedidos))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblLogoME, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnPedidos)
                .addGap(18, 18, 18)
                .addComponent(btnProductos)
                .addContainerGap(424, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 640));

        TablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pedido", "Producto", "Cantidad", "Costo", "Hora Registro", "Hora Entrega", "Estado"
            }
        ));
        jScrollPane1.setViewportView(TablePedido);

        jLabel5.setText("Producto:");

        jLabel6.setText("Cantidad:");

        jLabel7.setText("Dni:");

        Costo.setText("Costo:");

        jLabel9.setText("Hora Registro:");

        jLabel10.setText("Hora Entrega:");

        txtCostoPedido.setEnabled(false);

        txtHoraRegistro.setEnabled(false);

        txtCantidadPedido.setEnabled(false);

        txtdniPedido.setEnabled(false);

        txtProductoPedido.setEnabled(false);

        txtHoraEntrega.setEnabled(false);

        btnEntrega.setText("Entregado");
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        jLabel11.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidadPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(txtdniPedido)
                                    .addComponent(txtProductoPedido)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(Costo)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoraEntrega)
                                    .addComponent(txtCostoPedido)
                                    .addComponent(txtHoraRegistro)
                                    .addComponent(txtEstadoPedido, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnEntrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdniPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProductoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCantidadPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Costo)
                    .addComponent(txtCostoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHoraRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(36, 36, 36)
                .addComponent(btnEntrega)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Descripcion:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Costo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Categoria:");

        cbxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POLLOS", "CARNES", "MARISCOS", "PASTAS", "BEBIDAS", "POSTRES" }));

        TableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Costo", "Descripcion", "Tiempo de entrega(min)", "Categoria"
            }
        ));
        jScrollPane2.setViewportView(TableProducto);
        if (TableProducto.getColumnModel().getColumnCount() > 0) {
            TableProducto.getColumnModel().getColumn(4).setResizable(false);
            TableProducto.getColumnModel().getColumn(5).setResizable(false);
        }

        btnIngresarProducto.setText("Ingresar");
        btnIngresarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarProductoActionPerformed(evt);
            }
        });

        btnActualizarProducto.setText("Actualizar");

        btnEliminarProducto.setText("Eliminar");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Tiempo de entrega en min.:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreProducto))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbxCat, javax.swing.GroupLayout.Alignment.LEADING, 0, 82, Short.MAX_VALUE)
                        .addComponent(txtCostoProducto, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnIngresarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarProducto))
                    .addComponent(btnEliminarProducto)
                    .addComponent(jLabel12)
                    .addComponent(txtTiempoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCostoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTiempoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizarProducto)
                            .addComponent(btnIngresarProducto))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarProducto)
                        .addGap(45, 45, 45))))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 1040, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntregaActionPerformed

    private void btnIngresarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarProductoActionPerformed
        if (!"".equals(txtNombreProducto) || !"".equals(txtDescripcionProducto) || !"".equals(txtCostoProducto) || !"".equals(txtTiempoProducto)) {
            p.setNombre_Producto(txtNombreProducto.getText());
            p.setDescripcion_Producto(txtDescripcionProducto.getText());
            p.setPrecio_Unitario(Double.parseDouble(txtCostoProducto.getText()));
            p.setTiempo_entregaBase(Integer.parseInt(txtTiempoProducto.getText()));
            switch (cbxCat.getSelectedItem().toString()) {
                case "POLLOS":
                    p.setId_Categoria(1);
                    break;
                case "CARNES":
                    p.setId_Categoria(2);
                    break;
                case "MARISCOS":
                    p.setId_Categoria(3);
                    break;
                case "PASTAS":
                    p.setId_Categoria(4);
                    break;
                case "BEBIDAS":
                    p.setId_Categoria(5);
                    break;
                case "POSTRES":
                    p.setId_Categoria(6);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            pdao.crearProducto(p);
            limpiarText();
            JOptionPane.showMessageDialog(null, "Producto Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan incompletos ");
        }

    }//GEN-LAST:event_btnIngresarProductoActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed

        LimpiarTableProd();
        jTabbedPane1.setSelectedIndex(1);
        ListarProductos();
        
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        LimpiarTablePed();
        jTabbedPane1.setSelectedIndex(0); 
    }//GEN-LAST:event_btnPedidosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Costo;
    private javax.swing.JTable TablePedido;
    private javax.swing.JTable TableProducto;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnIngresarProducto;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JComboBox<String> cbxCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblLogoME;
    private javax.swing.JTextField txtCantidadPedido;
    private javax.swing.JTextField txtCostoPedido;
    private javax.swing.JTextField txtCostoProducto;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtEstadoPedido;
    private javax.swing.JTextField txtHoraEntrega;
    private javax.swing.JTextField txtHoraRegistro;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtProductoPedido;
    private javax.swing.JTextField txtTiempoProducto;
    private javax.swing.JTextField txtdniPedido;
    // End of variables declaration//GEN-END:variables

}
