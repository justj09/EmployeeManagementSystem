import java.io.*;
import java.util.*;

public class Main_jFrame extends javax.swing.JFrame {

    public MyHashTable employeeTable;

    public Main_jFrame() {
        initComponents();
        employeeTable = new MyHashTable(10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jDisplayEmployeeButton = new javax.swing.JButton();
        jAddEmployeeButton = new javax.swing.JButton();
        jSaveFileButton = new javax.swing.JButton();
        jLoadFileButton = new javax.swing.JButton();

        jFileChooser.setApproveButtonText("");
        jFileChooser.setApproveButtonToolTipText("");
        jFileChooser.setDialogTitle("");
        jFileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDisplayEmployeeButton.setText("Display all employees");
        jDisplayEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDisplayEmployeeButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDisplayEmployeeButton)
                    .addComponent(jAddEmployeeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(jLoadFileButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSaveFileButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLoadFileButton)
                .addGap(75, 75, 75)
                .addComponent(jDisplayEmployeeButton)
                .addGap(29, 29, 29)
                .addComponent(jAddEmployeeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jSaveFileButton)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDisplayEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDisplayEmployeeButtonActionPerformed
        new Display_jFrame(employeeTable).setVisible(true);
    }//GEN-LAST:event_jDisplayEmployeeButtonActionPerformed

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
    private javax.swing.JButton jDisplayEmployeeButton;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JButton jLoadFileButton;
    private javax.swing.JButton jSaveFileButton;
    // End of variables declaration//GEN-END:variables
}
