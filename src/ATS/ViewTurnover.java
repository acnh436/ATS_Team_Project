/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATS;

import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Reha
 */
public class ViewTurnover extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form viewBlankStock
     */
    public ViewTurnover() {
        initComponents();
        conn = Driver.ConnectDB();setDefaultCloseOperation(ViewTurnover.DISPOSE_ON_CLOSE);
        
    }
    
    public void viewReports() {
        model = (DefaultTableModel) turnoverTable.getModel();
        model.setRowCount(0);
        String initialdate = dateYear1.getSelectedItem().toString() + "/"
                + dateMonth1.getSelectedItem().toString() + "/" + dateDay1.getSelectedItem().toString();
        String enddate = dateYear2.getSelectedItem().toString() + "/"
                + dateMonth2.getSelectedItem().toString() + "/" + dateDay2.getSelectedItem().toString();
        String sql1 = "SELECT blankId FROM blanks WHERE Date >= '" + initialdate + "' AND Date <= '" + enddate + "'";
        String sql2 = "SELECT userId, blankId FROM users, blanks WHERE role =  'Advisor' AND user_userId = userId AND Date >= '" + initialdate + "' AND Date <= '" + enddate + "'";
        String sql3 = "SELECT userId, blankId FROM users, blanks WHERE role =  'Advisor' AND user_userId = userId AND Date < '" + initialdate + "'";
        String sql4 = "SELECT blankId FROM users, blanks WHERE Date < '" + initialdate + "' AND Validity = 'valid'";
        String sql5 = "SELECT blankId FROM blanks";
        String sql6 = "SELECT userId, blankId FROM users, blanks WHERE role = 'Advisor' AND user_userId = userId";
        
        try {
            Object row[] = new Object [9];
            int i;
            
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            
            while(rs.next()){
                row[0] = rs.getLong("blankId");
                model.addRow(row);
            }
            
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            i=0;
            while(rs.next()){
                row[1] = rs.getLong("userId");
                row[2] = rs.getLong("blankId");
                model.setValueAt(row[1], i, 1);
                model.setValueAt(row[2], i, 2);
                i++;
            }
            
            pst = conn.prepareStatement(sql3);
            rs = pst.executeQuery();
            i=0;
            while(rs.next()){
                row[3] = rs.getLong("userId");
                row[4] = rs.getLong("blankId");
                model.setValueAt(row[3], i, 3);
                model.setValueAt(row[4], i, 4);
                i++;
            }
            
            pst = conn.prepareStatement(sql4);
            rs = pst.executeQuery();
            i=0;
            while(rs.next()){
                row[5] = rs.getLong("blankId");
                model.setValueAt(row[5], i, 5);
                i++;
            }
            
            pst = conn.prepareStatement(sql5);
            rs = pst.executeQuery();
            i=0;
            while(rs.next()){
                row[6] = rs.getLong("blankId");
                model.setValueAt(row[6], i, 6);
                i++;
            }
            
            pst = conn.prepareStatement(sql6);
            rs = pst.executeQuery();
            
            while(rs.next()){
                row[7] = rs.getLong("userId");
                row[8] = rs.getLong("blankId");
                model.setValueAt(row[7], i, 7);
                model.setValueAt(row[8], i, 8);
                i++;
            }
            
            
            
        } catch(Exception e) {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewBlanksBackPanel = new javax.swing.JPanel();
        AdminTopPanel = new javax.swing.JPanel();
        AirViaLtdLabel = new javax.swing.JLabel();
        PlaneImg = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        dateDay1 = new javax.swing.JComboBox<>();
        dateMonth1 = new javax.swing.JComboBox<>();
        dateYear1 = new javax.swing.JComboBox<>();
        name4 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        dateDay2 = new javax.swing.JComboBox<>();
        dateMonth2 = new javax.swing.JComboBox<>();
        dateYear2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        turnoverTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewBlanksBackPanel.setBackground(new java.awt.Color(241, 223, 200));

        AdminTopPanel.setBackground(new java.awt.Color(0, 0, 51));

        AirViaLtdLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        AirViaLtdLabel.setForeground(new java.awt.Color(255, 153, 51));
        AirViaLtdLabel.setText("AirViaLtd");

        PlaneImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATS/images/plane.png"))); // NOI18N

        javax.swing.GroupLayout AdminTopPanelLayout = new javax.swing.GroupLayout(AdminTopPanel);
        AdminTopPanel.setLayout(AdminTopPanelLayout);
        AdminTopPanelLayout.setHorizontalGroup(
            AdminTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminTopPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PlaneImg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AirViaLtdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        AdminTopPanelLayout.setVerticalGroup(
            AdminTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminTopPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(AdminTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AirViaLtdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlaneImg, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTextField1.setText("Recieved Blanks");

        jTextField2.setText("Assigned/Used Blanks");

        jTextField3.setText("Final Amounts");

        dateDay1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        dateMonth1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        dateYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));

        name4.setText("Starting Date:");

        name5.setText("End Date:");

        dateDay2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        dateMonth2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        dateYear2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        turnoverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blank Number", "Code", "Blank Number", "Code", "Assigned", "Used", "Blank Number", "Code", "Blank Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(turnoverTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout viewBlanksBackPanelLayout = new javax.swing.GroupLayout(viewBlanksBackPanel);
        viewBlanksBackPanel.setLayout(viewBlanksBackPanelLayout);
        viewBlanksBackPanelLayout.setHorizontalGroup(
            viewBlanksBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminTopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(viewBlanksBackPanelLayout.createSequentialGroup()
                .addGroup(viewBlanksBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewBlanksBackPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(viewBlanksBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(viewBlanksBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(viewBlanksBackPanelLayout.createSequentialGroup()
                                    .addComponent(name4)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateDay1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(name5)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateDay2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateMonth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(viewBlanksBackPanelLayout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(viewBlanksBackPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewBlanksBackPanelLayout.setVerticalGroup(
            viewBlanksBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBlanksBackPanelLayout.createSequentialGroup()
                .addComponent(AdminTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(viewBlanksBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateDay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateMonth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addGroup(viewBlanksBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewBlanksBackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewBlanksBackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        viewReports();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewTurnover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTurnover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTurnover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTurnover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTurnover().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminTopPanel;
    private javax.swing.JLabel AirViaLtdLabel;
    private javax.swing.JLabel PlaneImg;
    private javax.swing.JComboBox<String> dateDay1;
    private javax.swing.JComboBox<String> dateDay2;
    private javax.swing.JComboBox<String> dateMonth1;
    private javax.swing.JComboBox<String> dateMonth2;
    private javax.swing.JComboBox<String> dateYear1;
    private javax.swing.JComboBox<String> dateYear2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JTable turnoverTable;
    private javax.swing.JPanel viewBlanksBackPanel;
    // End of variables declaration//GEN-END:variables
}