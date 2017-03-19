
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sale extends javax.swing.JFrame {

    static DefaultTableModel model = new DefaultTableModel();
    Date date = new Date();

    public double totalAmount;

    public Sale() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jDate.setText(date.toString());

    }
    
    public void deleteDataInTable(){
        int row = model.getRowCount() - 1;
        while (row > -1) {
            model.removeRow(row);
            row--;
        }
        txtChange.setText("");
    
    }
    
    public void clearTxt(){
        txtChange.setText("");
        txtPay.setText("");
        txtTotalAmount.setText("");
        txtAmount.setText("");
        searchTxt.setText("");
        jBarcode.setText("");
        jID.setText("");
        jName.setText("");
        jBarcode.setText("");
        jPrice.setText("");
    
    }
    
    public void saveToDB(){
        int product_id;
        int amount;
        int randomID = (int) (Math.random() * 10000);
        if(tbSale.getRowCount()!=0){
        for (int i = 0; i < model.getRowCount(); i++) {

            product_id = (int) model.getValueAt(i, 0);
            amount = (int) model.getValueAt(i, 3);
            String sqlBilling = "INSERT INTO billing (billing_id) VALUE (" + randomID + ")";
            String sqlInsertSale = "INSERT INTO sale VALUE (" + randomID + "," + product_id + "," + amount + ")";
            String updateAmount = "UPDATE products SET products.product_amount=(products.product_amount-"
                    + amount + ") WHERE products.product_id=" + product_id;
            ConnectDB.insertData(sqlInsertSale);
            ConnectDB.insertData(sqlBilling);
            ConnectDB.updateData(updateAmount);

        }
        
        JOptionPane.showMessageDialog(this,"Save Complete");
        
        }else{JOptionPane.showMessageDialog(this,"Plese insert product information");}
        
    
    }
    
    public void addToTable() {
        model = (DefaultTableModel) tbSale.getModel();

        if (txtAmount.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input amount");

        } else {
            try {
                double totalPrice = Double.parseDouble(jPrice.getText()) * Integer.parseInt(txtAmount.getText());
                Object data[] = new Object[]{Integer.parseInt(jID.getText()), jBarcode.getText(),
                    jName.getText(), Integer.parseInt(txtAmount.getText()), jPrice.getText(), totalPrice};

                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).toString().equals(jID.getText())) {
                        JOptionPane.showMessageDialog(this, "Duplicate product!!! \n Please delete old product if you want to add new amount");
                        model.removeRow(i);

                    }

                }
                model.addRow(data);
                totalAmount = 0;

                for (int i = 0; i < model.getRowCount(); i++) {

                    totalAmount += (double) model.getValueAt(i, 5);

                }
                txtTotalAmount.setText(Double.toString(totalAmount));

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        productIDRadio = new javax.swing.JRadioButton();
        searchTxt = new javax.swing.JTextField();
        productBarcodeRadio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jID = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBarcode = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        jChange = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPay = new javax.swing.JLabel();
        txtPay = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAddToTable = new javax.swing.JButton();
        btnDelFromTable = new javax.swing.JButton();
        btnClearAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sale");

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sale Products");

        buttonGroup1.add(productIDRadio);
        productIDRadio.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        productIDRadio.setText("Enter Products ID");

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTxtKeyPressed(evt);
            }
        });

        buttonGroup1.add(productBarcodeRadio);
        productBarcodeRadio.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        productBarcodeRadio.setText("Enter Barcode");

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setText("Amount");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel4.setText("ID");

        jID.setBackground(new java.awt.Color(51, 255, 255));
        jID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jID.setText("....");
        jID.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel10.setText("Name");

        jName.setBackground(new java.awt.Color(51, 255, 255));
        jName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jName.setText("....");
        jName.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel9.setText("Barcode");

        jBarcode.setBackground(new java.awt.Color(51, 255, 255));
        jBarcode.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBarcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBarcode.setText("....");
        jBarcode.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel11.setText("Price");

        jPrice.setBackground(new java.awt.Color(51, 255, 255));
        jPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPrice.setText("....");
        jPrice.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jName)
                    .addComponent(jLabel10)
                    .addComponent(jID)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jBarcode)
                    .addComponent(jPrice))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productIDRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productBarcodeRadio))
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIDRadio)
                    .addComponent(productBarcodeRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbSale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Barcode", "Product name", "Amount", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSale);
        if (tbSale.getColumnModel().getColumnCount() > 0) {
            tbSale.getColumnModel().getColumn(0).setResizable(false);
            tbSale.getColumnModel().getColumn(1).setResizable(false);
            tbSale.getColumnModel().getColumn(2).setResizable(false);
            tbSale.getColumnModel().getColumn(3).setResizable(false);
            tbSale.getColumnModel().getColumn(4).setResizable(false);
            tbSale.getColumnModel().getColumn(5).setResizable(false);
        }

        jChange.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jChange.setText("Change");

        txtChange.setEditable(false);
        txtChange.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        txtChange.setForeground(new java.awt.Color(204, 0, 0));
        txtChange.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel6.setText("Bath");

        btnSave.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnSave.setText("Save bill");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jDate.setBackground(new java.awt.Color(255, 255, 255));
        jDate.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDate.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel5.setText("Total Amount");

        txtTotalAmount.setEditable(false);
        txtTotalAmount.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        txtTotalAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel7.setText("Bath");

        jPay.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jPay.setText("Pay");

        txtPay.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        txtPay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel13.setText("Bath");

        btnAddToTable.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnAddToTable.setText("Add");
        btnAddToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToTableActionPerformed(evt);
            }
        });

        btnDelFromTable.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnDelFromTable.setText("Del");
        btnDelFromTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFromTableActionPerformed(evt);
            }
        });

        btnClearAll.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnClearAll.setText("Clear");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddToTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelFromTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddToTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelFromTable, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 29, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPay)
                                    .addComponent(jChange))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPay, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(txtChange)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5)
                                .addGap(33, 33, 33)
                                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalAmount)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPay)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtChange)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed

        String sql;
        String search = searchTxt.getText();

        try {
            if (productIDRadio.isSelected()) {
                sql = "SELECT * FROM products WHERE product_id LIKE '" + search + "%'";
                ConnectDB.showData(sql);
            } else {
                sql = "SELECT * FROM products WHERE product_barcode LIKE '" + search + "%'";
                ConnectDB.showData(sql);
            }

            
            jBarcode.setText(ConnectDB.product_barcode.get(0));
            jID.setText(Integer.toString(ConnectDB.product_id.get(0)));
            jName.setText(ConnectDB.product_name.get(0));
            jPrice.setText(Double.toString(ConnectDB.product_price.get(0)));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_searchTxtKeyPressed

    private void btnAddToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToTableActionPerformed

        addToTable();
        
    }//GEN-LAST:event_btnAddToTableActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        saveToDB();
        deleteDataInTable();
        clearTxt();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDelFromTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFromTableActionPerformed
        totalAmount = 0;
        if (tbSale.getSelectedRow() != -1) {
            model.removeRow(tbSale.getSelectedRow());
            
            for (int i = 0; i < model.getRowCount(); i++) {
                totalAmount += (double) model.getValueAt(i, 5);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Please Select Row");
        }
       
       txtTotalAmount.setText(Double.toString(totalAmount));

    }//GEN-LAST:event_btnDelFromTableActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        deleteDataInTable();
        txtTotalAmount.setText("");
        clearTxt();
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void txtPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayActionPerformed
        Double totalToPrice=Double.parseDouble(txtTotalAmount.getText());
        Double pay=Double.parseDouble(txtPay.getText());
        Double change=pay-totalToPrice;
        txtChange.setText(change.toString());
    }//GEN-LAST:event_txtPayActionPerformed

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
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToTable;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnDelFromTable;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jBarcode;
    private javax.swing.JLabel jChange;
    private javax.swing.JLabel jDate;
    private javax.swing.JLabel jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jPay;
    private javax.swing.JLabel jPrice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton productBarcodeRadio;
    private javax.swing.JRadioButton productIDRadio;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTable tbSale;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtPay;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
