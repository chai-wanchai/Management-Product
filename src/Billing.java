
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Billing extends javax.swing.JFrame {

    public static DefaultTableModel model = new DefaultTableModel();

    public Billing() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.showDataInTable();
    }

    public void showDataInTable() {
        //String sql="SELECT * FROM products";
        String sql = "SELECT billing.billing_id,billing.billing_date,products.product_name,sale.amount,(sale.amount*products.product_price) as Total\n"
                + "FROM billing\n"
                + "INNER JOIN sale\n"
                + "ON billing.billing_id=sale.billing_id\n"
                + "INNER JOIN products\n"
                + "ON sale.product_id=products.product_id";
        model = ConnectDB.showDataTable(sql);
        tbBillList.setModel(model);

    }

    public void searchBilling(String id) {
        String sqlSearch = "SELECT billing.billing_id,billing.billing_date,products.product_name,sale.amount,(sale.amount*products.product_price) as Total\n"
                + "FROM billing INNER JOIN sale ON billing.billing_id=sale.billing_id\n"
                + "INNER JOIN products ON sale.product_id=products.product_id \n"
                + "WHERE billing.billing_id LIKE '" + id + "%'";

        model = ConnectDB.showDataTable(sqlSearch);

        tbBillSearch.setModel(model);
        ArrayList<String> numdata = new ArrayList<String>();
        String data[] = new String[100];

        for (int count = 0; count < model.getRowCount(); count++) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                numdata.add(model.getValueAt(count, i).toString());
                data[count] = model.getValueAt(count, i).toString();

            }

        }

    }

    public void saveToFile() {
        String bill_id = tbBillSearch.getValueAt(0, 0).toString();
        String bill_date = tbBillSearch.getValueAt(0, 1).toString();
        String product_name;
        String product_id;
        double product_total;
        double allTotal = 0.0;
        int product_amount;
        String sql;

        String fileDir = ".\\PrintReport";

        try {
            FileWriter save;

            new File(fileDir).mkdirs();
            save = new FileWriter(fileDir + "\\Billing#" + bill_id + ".txt");
            int i = 0;
            save.write("***************************************Billing ID# " + bill_id);
            save.write(System.getProperty("line.separator"));
            save.write("*********************Billing Date:" + bill_date);
            save.write(System.getProperty("line.separator"));
            save.write("******Products*****************************************");
            save.write(System.getProperty("line.separator"));
            save.write(System.getProperty("line.separator"));

            for (int count = 0; count < tbBillSearch.getRowCount(); count++) {

                product_name = tbBillSearch.getValueAt(count, 2).toString();
                product_amount = Integer.parseInt(tbBillSearch.getValueAt(count, 3).toString());
                product_total = Double.parseDouble(tbBillSearch.getValueAt(count, 4).toString());
                product_id = tbBillSearch.getValueAt(count, 1).toString();
                allTotal += product_total;

                save.write(System.getProperty("line.separator"));
                save.write("#" + (count+1) + "\t amount: " + product_amount + "\t total:" + product_total + "\t\t Name: " + product_name);
                save.write(System.getProperty("line.separator"));

            }
            save.write(System.getProperty("line.separator"));
            save.write("-------------Total Amount : " + allTotal + " Bath-----------------");
            save.write(System.getProperty("line.separator"));
            save.write("-------------------------------------------------------");

            save.close();
            JOptionPane.showMessageDialog(this, "Save to file complete\n" + fileDir);

        } catch (IOException ex) {
            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBilling = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBillList = new javax.swing.JTable();
        jBillingSearch = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBillSearch = new javax.swing.JTable();
        jBillingSearch1 = new javax.swing.JLabel();
        txtBillingID = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Billing Information");

        jBilling.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jBilling.setText("Billing List");

        tbBillList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbBillList);

        jBillingSearch.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jBillingSearch.setText("Billing ID");

        tbBillSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Billing Date", "Product Name", "Amount", "Total"
            }
        ));
        jScrollPane2.setViewportView(tbBillSearch);
        if (tbBillSearch.getColumnModel().getColumnCount() > 0) {
            tbBillSearch.getColumnModel().getColumn(0).setHeaderValue("Billing Date");
            tbBillSearch.getColumnModel().getColumn(1).setHeaderValue("Product Name");
            tbBillSearch.getColumnModel().getColumn(2).setHeaderValue("Amount");
        }

        jBillingSearch1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jBillingSearch1.setText("Billing Search");

        txtBillingID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBillingIDKeyPressed(evt);
            }
        });

        btnPrint.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jBillingSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBillingID)
                            .addGap(39, 39, 39)
                            .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jBillingSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(448, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBillingID, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBillingSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(274, Short.MAX_VALUE)
                    .addComponent(jBillingSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(264, 264, 264)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBillingIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillingIDKeyPressed
        String id = txtBillingID.getText();

        searchBilling(id);

    }//GEN-LAST:event_txtBillingIDKeyPressed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if (txtBillingID.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Billing ID");

        } else {

            saveToFile();
        }

    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jBilling;
    private javax.swing.JLabel jBillingSearch;
    private javax.swing.JLabel jBillingSearch1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tbBillList;
    public static javax.swing.JTable tbBillSearch;
    public static javax.swing.JTextField txtBillingID;
    // End of variables declaration//GEN-END:variables
}
