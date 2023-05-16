import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Main_jFrame extends javax.swing.JFrame {

    public MyHashTable employeeTable;
    public DefaultTableModel model;

    public Main_jFrame() {
        initComponents();
        employeeTable = new MyHashTable(10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jAddEmployeeButton = new javax.swing.JButton();
        jSaveFileButton = new javax.swing.JButton();
        jLoadFileButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jFileChooser.setApproveButtonText("");
        jFileChooser.setApproveButtonToolTipText("");
        jFileChooser.setDialogTitle("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jAddEmployeeButton.setText("Add new employee");
        jAddEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddEmployeeButtonActionPerformed(evt);
            }
        });

        jSaveFileButton.setText("Save all employees to file");
        jSaveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveFileButtonActionPerformed(evt);
            }
        });

        jLoadFileButton.setText("Load all employees from file");
        jLoadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoadFileButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Display employees currently in the hash table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateColumnsFromModel(false);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jAddEmployeeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLoadFileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSaveFileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLoadFileButton)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSaveFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAddEmployeeButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddEmployeeButtonActionPerformed
        new AddNewEmployee_jFrame(employeeTable).setVisible(true);
    }//GEN-LAST:event_jAddEmployeeButtonActionPerformed

    private void jSaveFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveFileButtonActionPerformed
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

    }//GEN-LAST:event_jSaveFileButtonActionPerformed

    private void jLoadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoadFileButtonActionPerformed
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
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLoadFileButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int num = employeeTable.size;
        int row = 0;
        model = new DefaultTableModel(new Object[] {"Status", "Emp Num", "First Name", "Last Name"}, num);
        jTable1.setModel(model);
        jTable1.setAutoCreateColumnsFromModel(true);
        System.out.println("Here are the employees:");
        for (ArrayList<EmployeeInfo> bucket : employeeTable.buckets) {
            for (EmployeeInfo employee : bucket) {
                model.setValueAt(employee instanceof FTE ? "Full Time" : "Part Time", row, 0);
                model.setValueAt(employee.employeeNumber, row, 1);
                model.setValueAt(employee.firstName, row, 2);
                model.setValueAt(employee.lastName, row, 3);
                row++;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jAddEmployeeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JButton jLoadFileButton;
    private javax.swing.JButton jSaveFileButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
