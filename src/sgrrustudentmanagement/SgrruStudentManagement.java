
package sgrrustudentmanagement;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class SgrruStudentManagement {


    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            
        }
        
        LoginFrame f = new LoginFrame();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
       //LoginFrame f = new LoginFrame();
        //ContactFrame f = new ContactFrame();
        //f.setLocationRelativeTo(null);
        //f.setVisible(true);
    }
    
}
