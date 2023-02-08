package co.edu.unicauca.distribuidos.interface_usuarios.views;

import co.edu.unicauca.distribuidos.interface_usuarios.models.ProductoDTO;
import co.edu.unicauca.distribuidos.interface_usuarios.services.ProductoServices;
import javax.swing.JOptionPane;

public class servicio5 extends javax.swing.JPanel {

    /**
     * Creates new form servicio5Cerrar
     */
    public servicio5() {
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

        jLabeltitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelAbrir = new javax.swing.JLabel();
        jTextFieldAbrir = new javax.swing.JTextField();
        jButtonGuardarAbrir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelCerrar = new javax.swing.JLabel();
        jTextFieldCerrar = new javax.swing.JTextField();
        jButtonGuardarCerrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabeltitulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabeltitulo.setForeground(new java.awt.Color(51, 153, 255));
        jLabeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltitulo.setText("Abrir Subasta/Cerrar Subasta");
        add(jLabeltitulo, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Abrir Subasta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 0, 18), new java.awt.Color(51, 153, 255))); // NOI18N

        jLabelAbrir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabelAbrir.setText("Codigo Produto");

        jTextFieldAbrir.setBackground(new java.awt.Color(247, 247, 247));
        jTextFieldAbrir.setForeground(new java.awt.Color(51, 153, 255));
        jTextFieldAbrir.setPreferredSize(new java.awt.Dimension(64, 20));
        jTextFieldAbrir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAbrirKeyTyped(evt);
            }
        });

        jButtonGuardarAbrir.setBackground(new java.awt.Color(0, 153, 255));
        jButtonGuardarAbrir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarAbrir.setText("Aplicar Cambios");
        jButtonGuardarAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGuardarAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAbrir)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jTextFieldAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jButtonGuardarAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabelAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonGuardarAbrir)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cerrar Subasta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 0, 18), new java.awt.Color(51, 153, 255))); // NOI18N

        jLabelCerrar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabelCerrar.setText("Codigo Producto");

        jTextFieldCerrar.setBackground(new java.awt.Color(247, 247, 247));
        jTextFieldCerrar.setForeground(new java.awt.Color(51, 153, 255));
        jTextFieldCerrar.setPreferredSize(new java.awt.Dimension(64, 20));
        jTextFieldCerrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCerrarKeyTyped(evt);
            }
        });

        jButtonGuardarCerrar.setBackground(new java.awt.Color(0, 153, 255));
        jButtonGuardarCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarCerrar.setText("Aplicar Cambios");
        jButtonGuardarCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGuardarCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCerrar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jTextFieldCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jButtonGuardarCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabelCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonGuardarCerrar)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarAbrirActionPerformed
        try {
            if (!jTextFieldAbrir.getText().equals(jTextFieldCerrar.getText())) {
                if (!jTextFieldAbrir.getText().equals("")) {
                    ProductoServices objProductoServices = new ProductoServices();
                    ProductoDTO objProducto = null;
                    objProducto = objProductoServices.consultarProducto(jTextFieldAbrir.getText());
                    if (objProducto != null) {
                        Boolean repuesta = objProductoServices.cambiarProductoASubastados(objProducto, jTextFieldAbrir.getText());
                        if (repuesta) {
                            JOptionPane.showMessageDialog(null, "PRODUCTO SUBASTADO CON EXITO!!!");
                            
                            jTextFieldAbrir.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "EL PRODUCTO YA SE ENCUENTRA EN SUBASTA!!!",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO EL PRODUCTO PARA ABRIR SU SUBASTA!!!",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    }
                }else{ JOptionPane.showMessageDialog(null, "NO HAY NIGUN CODIGO EN EL CAMPO SOLICITADO",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "LOS CAMPOS NO PUEDEN TENER EL MISMO CODIGO!!!",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception NullException) {
            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE APLICAR CAMBIOS!!!","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarAbrirActionPerformed

    private void jButtonGuardarCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarCerrarActionPerformed
        try {
            if (!jTextFieldAbrir.getText().equals(jTextFieldCerrar.getText())) {
                if (!jTextFieldCerrar.getText().equals("")) {
                    ProductoServices objProductoServices = new ProductoServices();
                    ProductoDTO objProducto = null;
                    objProducto = objProductoServices.consultarProducto(jTextFieldCerrar.getText());
                    if (objProducto != null) {
                        Boolean repuesta = objProductoServices.cambiarProductoNOSubastados(objProducto, jTextFieldCerrar.getText());
                        if (repuesta) {
                            JOptionPane.showMessageDialog(null, "SUBASTA QUITADA CON EXITO!!!");
                            
                            jTextFieldCerrar.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "EL PRODUCTO TIENE LA SUBASTA CERRADA!!!",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO EL PRODUCTO PARA CERRAR SU SUBASTA!!!",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    }
                }else{ JOptionPane.showMessageDialog(null, "NO HAY NIGUN CODIGO EN EL CAMPO SOLICITADO",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "LOS CAMPOS NO PUEDEN TENER EL MISMO CODIGO!!!",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception NullException) {
            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE APLICAR CAMBIOS!!!","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarCerrarActionPerformed

    private void jTextFieldAbrirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAbrirKeyTyped

    }//GEN-LAST:event_jTextFieldAbrirKeyTyped

    private void jTextFieldCerrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCerrarKeyTyped
     
    }//GEN-LAST:event_jTextFieldCerrarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardarAbrir;
    private javax.swing.JButton jButtonGuardarCerrar;
    private javax.swing.JLabel jLabelAbrir;
    private javax.swing.JLabel jLabelCerrar;
    private javax.swing.JLabel jLabeltitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldAbrir;
    private javax.swing.JTextField jTextFieldCerrar;
    // End of variables declaration//GEN-END:variables
}
