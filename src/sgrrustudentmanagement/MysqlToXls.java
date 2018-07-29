package sgrrustudentmanagement;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MysqlToXls {
    public static void main(String[] args) {}
     
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "MySQL Driver is not Available\nProgram can not continue", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
     public static Boolean getXLS(String Course){  
        boolean status=false;
        
         try(Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sgrr", "root", "root");){
         
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from student where Course="+"'"+Course+"'");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet spreadsheet = workbook.createSheet("Student Database");
            HSSFRow row = spreadsheet.createRow(1);
            HSSFCell cell;
            cell = row.createCell(0);
            cell.setCellValue("Student ID");
            cell = row.createCell(1);
            cell.setCellValue("Name");
            cell = row.createCell(2);
            cell.setCellValue("Father's Name");
            cell = row.createCell(3);
            cell.setCellValue("Mother's Name");
            cell = row.createCell(4);
            cell.setCellValue("Gender");
            cell = row.createCell(5);
            cell.setCellValue("Date of Birth");
            cell = row.createCell(6);
            cell.setCellValue("Category");
            cell = row.createCell(7);
            cell.setCellValue("Mobile Number");
            cell = row.createCell(8);
            cell.setCellValue("Email ID");
            cell = row.createCell(9);
            cell.setCellValue("Fee Paid");
            cell = row.createCell(10);
            cell.setCellValue("Fee Balance");
            int i = 2;
            while (resultSet.next()) {
                row = spreadsheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(resultSet.getInt("StudentID"));
                cell = row.createCell(1);
                cell.setCellValue(resultSet.getString("Name"));
                cell = row.createCell(2);
                cell.setCellValue(resultSet.getString("FatherName"));
                cell = row.createCell(3);
                cell.setCellValue(resultSet.getString("MotherName"));
                cell = row.createCell(4);
                cell.setCellValue(resultSet.getString("Gender"));
                cell = row.createCell(5);
                cell.setCellValue(resultSet.getString("DOB"));
                cell = row.createCell(6);
                cell.setCellValue(resultSet.getString("Category"));
                cell = row.createCell(7);
                cell.setCellValue(resultSet.getString("Mobile"));
                cell = row.createCell(8);
                cell.setCellValue(resultSet.getString("Email"));
                cell = row.createCell(9);
                cell.setCellValue(resultSet.getInt("Paid"));
                cell = row.createCell(10);
                cell.setCellValue(resultSet.getInt("Balance"));
                i++;
            }
            
            FileOutputStream out = new FileOutputStream(new File(
                    ""+Course+"_Data"+".xls"));
            
            workbook.write(out);
            out.close();
            System.out.println("File Successfully created");
            status =true;
            con.close();
        } 
        catch(Exception e){
        }
        return status;
     }
}