
package sgrrustudentmanagement;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class SearchCourseFrame extends javax.swing.JInternalFrame {

    ArrayList<Student> list;
    public SearchCourseFrame() {
        initComponents();
        jTable1.setRowHeight(40);
        list = DBManager.getAllStudents();
        total = list.size();
        lblStudent.setText(""+total);
        loadData();
    }
        int total = 0;
     private void loadData(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        for(Student s : list){
            Object[] row = new Object[10];
            row[0] = s.getStudentId();
            row[1] = s.getName();
            row[2] = s.getfName();
            row[3] = s.getmName();
            row[4] = s.getGender();
            row[5] = s.getDOB();
            row[6] = s.getCategory();
            row[7] = s.getMobileNumber();
            row[8] = s.getEmail();
            row[9] = s.getCourse();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboCourse = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Course Search");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/sgrrustudentmanagement/course-icon.png"))); // NOI18N

        jPanel1.setPreferredSize(new java.awt.Dimension(886, 70));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgrrustudentmanagement/search.png"))); // NOI18N
        jLabel1.setText("Course :");

        cboCourse.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        cboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "B.Sc. IT", "BCA", "BBA", "B.Pharma", "MCA", "MBA", "M.Pharma", "Ph.D" }));
        cboCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCourseItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgrrustudentmanagement/add_icon.png"))); // NOI18N
        jLabel2.setText("Total Students :");

        lblStudent.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(lblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Father's Name", "Mother's Name", "Gender", "Date of Birth", "Category", "Mobile Number", "Email ID", "Course"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCourseItemStateChanged
        
        if(cboCourse.getSelectedIndex()==0){
            list = DBManager.getAllStudents();
             total = list.size();
             lblStudent.setText(""+total);
            loadData();
        }else{
            String course = cboCourse.getSelectedItem().toString();
            list = DBManager.getAllStudentsByCourse(course); 
                total = list.size();
                lblStudent.setText(""+total);
            loadData();
        }
    }//GEN-LAST:event_cboCourseItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblStudent;
    // End of variables declaration//GEN-END:variables
}