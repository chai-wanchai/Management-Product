
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        if (ConnectDB.connectDB() == null) {
            JOptionPane.showMessageDialog(null, "Can not connect to Database\n"+ConnectDB.test());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sale = new javax.swing.JButton();
        Biling = new javax.swing.JButton();
        ProductInfor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management Product and Dealing Program");
        setBackground(new java.awt.Color(255, 255, 255));

        Sale.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dollar-symbol.png"))); // NOI18N
        Sale.setText("Sale");
        Sale.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleActionPerformed(evt);
            }
        });

        Biling.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        Biling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bars-chart.png"))); // NOI18N
        Biling.setText("Billing Information");
        Biling.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Biling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BilingActionPerformed(evt);
            }
        });

        ProductInfor.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        ProductInfor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packing.png"))); // NOI18N
        ProductInfor.setText("Products Information");
        ProductInfor.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ProductInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductInforActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online-shop.png"))); // NOI18N
        jLabel1.setText("Management Product and Dealing ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Sale, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProductInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Biling, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(ProductInfor)
                .addGap(18, 18, 18)
                .addComponent(Sale)
                .addGap(18, 18, 18)
                .addComponent(Biling)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ProductInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductInforActionPerformed
        if (ConnectDB.connectDB() == null) {
            JOptionPane.showMessageDialog(null, "Can not connect to Database\n"+ConnectDB.test());

        } else {
            Products_list product = new Products_list();
            product.setVisible(true);
        }

    }//GEN-LAST:event_ProductInforActionPerformed

    private void SaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleActionPerformed
        if (ConnectDB.connectDB() == null) {
            JOptionPane.showMessageDialog(null, "Can not connect to Database\n"+ConnectDB.test());

        } else {
            Sale sale = new Sale();
            sale.setVisible(true);
        }

    }//GEN-LAST:event_SaleActionPerformed

    private void BilingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BilingActionPerformed
        if (ConnectDB.connectDB() == null) {
            JOptionPane.showMessageDialog(null, "Can not connect to Database\n"+ConnectDB.test());

        } else {
            Billing bill = new Billing();
            bill.setVisible(true);
        }
        
    }//GEN-LAST:event_BilingActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Biling;
    public javax.swing.JButton ProductInfor;
    private javax.swing.JButton Sale;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
