import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Main_jFrame extends javax.swing.JFrame {

    public MyHashTable employeeTable;
    public DefaultTableModel model;
    public EmployeeInfo selectedEmployee;
    public ArrayList<EmployeeInfo> filteredTable;

    public Main_jFrame() {
        initComponents();
        employeeTable = new MyHashTable(10);
        selectedEmployee = null;
        jEditButton.setEnabled(false);
        jDeleteButton.setEnabled(false);
        jSearchButton.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jOptionPane = new javax.swing.JOptionPane();
        jAddButton = new javax.swing.JButton();
        jSaveButton = new javax.swing.JButton();
        jLoadButton = new javax.swing.JButton();
        jSearchButton = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jSearchComboBox = new javax.swing.JComboBox<>();
        jSearchTextField = new javax.swing.JTextField();
        jEditButton = new javax.swing.JButton();
        jDeleteButton = new javax.swing.JButton();

        jFileChooser.setApproveButtonText("");
        jFileChooser.setApproveButtonToolTipText("");
        jFileChooser.setDialogTitle("");

        jOptionPane.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jAddButton.setText("Add");
        jAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddButtonActionPerformed(evt);
            }
        });

        jSaveButton.setText("Save");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        jLoadButton.setText("Load");
        jLoadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoadButtonActionPerformed(evt);
            }
        });

        jSearchButton.setText("Search");
        jSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchButtonActionPerformed(evt);
            }
        });

        jTable.setAutoCreateColumnsFromModel(false);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable.setAutoscrolls(false);
        jTable.setColumnSelectionAllowed(true);
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTable);
        jTable.getAccessibleContext().setAccessibleName("");
        jTable.getAccessibleContext().setAccessibleDescription("");

        jSearchComboBox.setMaximumRowCount(3);
        jSearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee Number", "First Name", "Last Name" }));
        jSearchComboBox.setToolTipText("");

        jSearchTextField.setToolTipText("");

        jEditButton.setText("Edit");
        jEditButton.setEnabled(false);
        jEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditButtonActionPerformed(evt);
            }
        });

        jDeleteButton.setText("Delete");
        jDeleteButton.setEnabled(false);
        jDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jAddButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLoadButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSaveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSearchTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLoadButton)
                .addGap(6, 6, 6)
                .addComponent(jSaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAddButton)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEditButton)
                    .addComponent(jDeleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearchButton)
                    .addComponent(jSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jSearchComboBox.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddButtonActionPerformed
        new AddChangeEmployee_jFrame(employeeTable, jSearchButton).setVisible(true);
    }//GEN-LAST:event_jAddButtonActionPerformed

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        jFileChooser.setFileSelectionMode(jFileChooser.DIRECTORIES_ONLY);
        jFileChooser.showSaveDialog(this);
        File file = new File(jFileChooser.getSelectedFile().getAbsolutePath(), "HashTable.txt");
        for (int i = 1; file.exists(); i++){
            file = new File(jFileChooser.getSelectedFile().getAbsolutePath(), "HashTable(" + Integer.toString(i) + ").txt");
        }
        try {
            String formatedText = "";
            for (ArrayList<EmployeeInfo> currentBucket : employeeTable.buckets) {
                for (EmployeeInfo currentItem : currentBucket){
                    if (currentItem instanceof FTE){
                        FTE theFTE = (FTE) currentItem;
                        formatedText += "█" + String.join("█", "F", Integer.toString(theFTE.employeeNumber), theFTE.firstName, theFTE.lastName, Double.toString(theFTE.yearlySalary));
                    }
                    else {
                        PTE thePTE = (PTE) currentItem;
                        formatedText += "█" + String.join("█", "P", Integer.toString(thePTE.employeeNumber), thePTE.firstName, thePTE.lastName, Double.toString(thePTE.hourlyWage), Double.toString(thePTE.hoursPerWeek), Double.toString(thePTE.weeksPerYear));
                    }
                }
            }
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(formatedText);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }

        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void jLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoadButtonActionPerformed
        jFileChooser.setFileSelectionMode(jFileChooser.FILES_ONLY);
        jFileChooser.showOpenDialog(this);
        try {
            Scanner s = new Scanner(jFileChooser.getSelectedFile());
            s.useDelimiter("█");
            employeeTable = new MyHashTable(10);    
            while (s.hasNext()){
                if (s.next().equals("F")){
                    employeeTable.add(new FTE(new String[]{s.next(), s.next(), s.next(), s.next()}));
                }
                else {
                    employeeTable.add(new PTE(new String[]{s.next(), s.next(), s.next(), s.next(), s.next(), s.next()}));
                }
            }
            jSearchButton.doClick();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLoadButtonActionPerformed

    private void jSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchButtonActionPerformed
        filteredTable = employeeTable.retrieveAll(jSearchComboBox.getSelectedIndex(), jSearchTextField.getText());
        int num = filteredTable.size();
        int row = 0;
        model = new DefaultTableModel(new Object[] {"Status", "Emp Num", "First Name", "Last Name"}, num);
        jTable.setModel(model);
        jTable.setAutoCreateColumnsFromModel(true);
        for (EmployeeInfo employee : filteredTable) {
            model.setValueAt(employee instanceof FTE ? "Full Time" : "Part Time", row, 0);
            model.setValueAt(employee.employeeNumber, row, 1);
            model.setValueAt(employee.firstName, row, 2);
            model.setValueAt(employee.lastName, row, 3);
            row++;
        }
    }//GEN-LAST:event_jSearchButtonActionPerformed

    private void jEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditButtonActionPerformed
        new AddChangeEmployee_jFrame(employeeTable, jSearchButton, selectedEmployee).setVisible(true);
        jSearchButton.doClick();
    }//GEN-LAST:event_jEditButtonActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        if (jTable.getSelectedRow() != -1){
            selectedEmployee = filteredTable.get(jTable.getSelectedRow());
            jEditButton.setEnabled(true);
            jDeleteButton.setEnabled(true);
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteButtonActionPerformed
        if (jOptionPane.showConfirmDialog(this, "Are you sure you want to delete\nemployee #" + Integer.toString(selectedEmployee.employeeNumber) + ": " + selectedEmployee.firstName + " " + selectedEmployee.lastName + "?", "Deletion Confirmation",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.WARNING_MESSAGE) == 0){
            employeeTable.remove(selectedEmployee.employeeNumber);
            jSearchButton.doClick();
        }
    }//GEN-LAST:event_jDeleteButtonActionPerformed

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
                System.out.println(info.getName());
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_jFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddButton;
    private javax.swing.JButton jDeleteButton;
    private javax.swing.JButton jEditButton;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JButton jLoadButton;
    private javax.swing.JOptionPane jOptionPane;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton jSearchButton;
    private javax.swing.JComboBox<String> jSearchComboBox;
    private javax.swing.JTextField jSearchTextField;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
