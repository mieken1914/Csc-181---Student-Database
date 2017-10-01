/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gui;

import java.sql.Connection;
import java.sql.DriverManager;

import my.info.Student_Info;
public class AddConfirmMessage extends javax.swing.JFrame {

    /**
     * Creates new form AddConfirmMessage
     */
    public AddConfirmMessage(Student_Info passed_acct) {
        initComponents(passed_acct);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents(Student_Info passed_acct) {
    	
    	

        labelID = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        labelAddress = new javax.swing.JLabel();
        labelCollege = new javax.swing.JLabel();
        labelCourse = new javax.swing.JLabel();
        labelBDate = new javax.swing.JLabel();
        buttonConfirm = new javax.swing.JButton();
        currentID = new javax.swing.JLabel();
        currentName = new javax.swing.JLabel();
        currentGender = new javax.swing.JLabel();
        currentAddress1 = new javax.swing.JLabel();
        currentCollege = new javax.swing.JLabel();
        currentCourse = new javax.swing.JLabel();
        currentBdate = new javax.swing.JLabel();
        currentAddress2 = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        labelYearLvl = new javax.swing.JLabel();
        currentYearLvl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelID.setText("ID Number:");

        labelName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelName.setText("Name:");

        labelGender.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelGender.setText("Gender:");

        labelAddress.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelAddress.setText("Address:");

        labelCollege.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelCollege.setText("College:");

        labelCourse.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelCourse.setText("Course:");

        labelBDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelBDate.setText("Birthdate:");

        buttonConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonConfirm.setText("CONFIRM!");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
                dispose();
                Connection con = null;
            	try{
            		
        			Class.forName("org.postgresql.Driver");
        			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_db", "postgres", "apipahdessopolao");

        			
        		} catch(Exception ex){
        			System.out.println(ex.getMessage());
        		}
                passed_acct.addToDB(con);
            }
        });

        currentID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentID.setText(""+passed_acct.getIdnum());

        currentName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentName.setText(passed_acct.getL_name().toUpperCase()+", "+passed_acct.getF_name()+" "+passed_acct.getM_name().charAt(0));

        currentGender.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentGender.setText(""+passed_acct.getGender());

        currentAddress1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentAddress1.setText(passed_acct.getAd_house_num()+", "+passed_acct.getAd_street()+",");

        currentCollege.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentCollege.setText(passed_acct.getCollege());

        currentCourse.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentCourse.setText(passed_acct.getCourse());

        currentBdate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentBdate.setText(passed_acct.getBdate());

        currentAddress2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentAddress2.setText(passed_acct.getAd_brgy()+", "+passed_acct.getAd_city());

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelTitle.setText("New Account Info:");
        
        labelYearLvl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelYearLvl.setText("Year Lvl:");

        currentYearLvl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        currentYearLvl.setText(passed_acct.getYear_lvl());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonConfirm))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelID)
                                    .addComponent(labelBDate)
                                    .addComponent(labelCourse)
                                    .addComponent(labelCollege)
                                    .addComponent(labelAddress)
                                    .addComponent(labelGender)
                                    .addComponent(labelName)
                                    .addComponent(labelYearLvl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentYearLvl)
                                    .addComponent(currentBdate)
                                    .addComponent(currentCourse)
                                    .addComponent(currentCollege)
                                    .addComponent(currentAddress1)
                                    .addComponent(currentGender)
                                    .addComponent(currentName)
                                    .addComponent(currentAddress2)
                                    .addComponent(currentID))))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelID)
                    .addComponent(currentID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(currentName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGender)
                    .addComponent(currentGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress)
                    .addComponent(currentAddress1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentAddress2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCollege)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelBDate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentCollege)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentBdate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelYearLvl)
                    .addComponent(currentYearLvl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(buttonConfirm)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        //confirm add
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],Student_Info passed_acct) {
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
            java.util.logging.Logger.getLogger(AddConfirmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddConfirmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddConfirmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddConfirmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddConfirmMessage(passed_acct).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JLabel currentAddress1;
    private javax.swing.JLabel currentAddress2;
    private javax.swing.JLabel currentBdate;
    private javax.swing.JLabel currentCollege;
    private javax.swing.JLabel currentCourse;
    private javax.swing.JLabel currentGender;
    private javax.swing.JLabel currentID;
    private javax.swing.JLabel currentName;
    private javax.swing.JLabel currentYearLvl;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelBDate;
    private javax.swing.JLabel labelCollege;
    private javax.swing.JLabel labelCourse;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelYearLvl;
    // End of variables declaration                   
}
