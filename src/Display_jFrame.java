import java.util.ArrayList;
import javax.swing.table.*;

public class Display_jFrame extends javax.swing.JFrame {

    private MyHashTable employeeTable;
    private DefaultTableModel model;
   
    public Display_jFrame(MyHashTable employeeTable) {
        initComponents();
        this.employeeTable = employeeTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int numInHT = employeeTable.size;

        model = new DefaultTableModel(new Object[] {"Status", "Emp Num", "First Name", "Last Name"}, numInHT);
        jTable1.setModel(model);
        jTable1.setAutoCreateColumnsFromModel(true);
        System.out.println("Here are the employees:");
        for (int i = 0; i < employeeTable.size; i++) {
            for (EmployeeInfo employee: employeeTable.buckets[i]) {
                model.setValueAt(employee instanceof FTE ? "Full Time" : "Part Time", i, 0);
                model.setValueAt(employee.employeeNumber, i, 1);
                model.setValueAt(employee.firstName, i, 2);
                model.setValueAt(employee.lastName, i, 3);
            }
        }           
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
