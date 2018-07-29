
package sgrrustudentmanagement;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBManager {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/sgrr";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "root";
    
    static{
        try{
            Class.forName(DBDRIVER);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "MySQL Driver is not Available\nProgram can not continue", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public static boolean insertStudent(Student s){
        boolean status = false;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("insert into student(StudentID, Name, FatherName, MotherName, DOB, Gender, Category, Nationality, Mobile, Email, Address, Course) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, s.getStudentId());
            st.setString(2, s.getName());
            st.setString(3, s.getfName());
            st.setString(4, s.getmName());
            java.sql.Date DOB = new java.sql.Date(s.getDOB().getTime());
            st.setDate(5, DOB);
            st.setString(6,s.getGender());
            st.setString(7,s.getCategory());
            st.setString(8,s.getNationality());
            st.setString(9,s.getMobileNumber());
            st.setString(10,s.getEmail());
            st.setString(11,s.getAddress());
            st.setString(12, s.getCourse());
            st.executeUpdate();
            st.close();
            status = true;
        }catch(Exception ex){
            System.out.println(ex);
        } 
        return status;
    }
    
     public static boolean insertChecklist(Checklist c){
        boolean status = false;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("insert into checklist values(?,?,?,?,?,?,?,?,?)");
            st.setInt(1, c.getStudentid());
            st.setBoolean(2, c.isXmark());
            st.setBoolean(3, c.isXiimark());
            st.setBoolean(4, c.isXcert());
            st.setBoolean(5, c.isXiicert());
            st.setBoolean(6, c.isDom());
            st.setBoolean(7, c.isMc());
            st.setBoolean(8, c.isTc());
            st.setBoolean(9, c.isGrad());
            st.executeUpdate();
            st.close();
            status = true;
        }catch(Exception ex){
            System.out.println(ex);
        } 
        return status;
    }
    
     public static Checklist getChecklist(int studentId){
        Checklist c = null;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("select * from checklist where StudentID=?");
            st.setInt(1, studentId);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                c = new Checklist();
                c.setStudentid(rs.getInt(1));
                c.setXmark(rs.getBoolean(2));
                c.setXiimark(rs.getBoolean(3));
                c.setXcert(rs.getBoolean(4));
                c.setXiicert(rs.getBoolean(5));
                c.setDom(rs.getBoolean(6));
                c.setMc(rs.getBoolean(7));
                c.setTc(rs.getBoolean(8));
                c.setGrad(rs.getBoolean(9));
                }
                rs.close();
                st.close();
            }catch(Exception ex){

            } 
            return c;
    }  
     
      public static boolean updateChecklist(Checklist c){
        boolean status = false;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("update checklist set Xmark=?, Xiimark=?, Xcert=?, xiicert=?, dom=?, mc=?, tc=?, grad=? where StudentID=?");
            st.setBoolean(1, c.isXmark());
            st.setBoolean(2, c.isXiimark());
            st.setBoolean(3, c.isXcert());
            st.setBoolean(4, c.isXiicert());
            st.setBoolean(5, c.isDom());
            st.setBoolean(6, c.isMc());
            st.setBoolean(7, c.isTc());
            st.setBoolean(8, c.isGrad());
            st.setInt(9, c.getStudentid());
            st.executeUpdate();
            st.close();
            status = true;
        }catch(Exception ex){ 
            System.out.println(ex);
        } 
        return status;
    } 
     
    
    public static int genStudentID(){
        int sid=0;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("select StudentID from student order by StudentID desc limit 1");
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                sid = rs.getInt(1);
            }
        }
        catch(Exception ex){
        }
        return sid+1;
    }
    public static Student getStudent(int studentId){
        Student s = null;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("select * from student where StudentID=?");
            st.setInt(1, studentId);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                s = new Student();
                s.setStudentId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setfName(rs.getString(4));
                s.setmName(rs.getString(3));
                s.setDOB(rs.getDate(5));
                s.setGender(rs.getString(6));
                s.setCategory(rs.getString(7));
                s.setNationality(rs.getString(8));
                s.setMobileNumber(rs.getString(9));
                s.setEmail(rs.getString(10));
                s.setAddress(rs.getString(11));
                s.setCourse(rs.getString(12));
                s.setTotal(rs.getInt(13));
                s.setPaid(rs.getInt(14));
                s.setBalance(rs.getInt(15));
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            
        } 
        return s;
    }  
    
     public static ArrayList<Student> getAllStudents(){
        ArrayList<Student> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("select StudentID,Name,FatherName,MotherName,Gender,DOB,Category,Mobile,Email,Course from student");
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setStudentId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setfName(rs.getString(3));
                s.setmName(rs.getString(4));
                s.setGender(rs.getString(5));
                s.setDOB(rs.getDate(6));
                s.setCategory(rs.getString(7));
                s.setMobileNumber(rs.getString(8));
                s.setEmail(rs.getString(9));
                s.setCourse(rs.getString(10));
                list.add(s);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            
        } 
        return list;
    }
     
    public static ArrayList<Student> getAllStudentsByCriteria(String criteria){
        ArrayList<Student> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("select StudentID,Name,FatherName,MotherName,Gender,DOB,Category,Mobile,Email,Course from student where "+criteria);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setStudentId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setfName(rs.getString(3));
                s.setmName(rs.getString(4));
                s.setGender(rs.getString(5));
                s.setDOB(rs.getDate(6));
                s.setCategory(rs.getString(7));
                s.setMobileNumber(rs.getString(8));
                s.setEmail(rs.getString(9));
                s.setCourse(rs.getString(10));
                list.add(s);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            System.out.println(ex);
        } 
        return list;
    }  
    
    public static ArrayList<Student> getAllStudentsByCourse(String course){
        ArrayList<Student> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("select StudentID,Name,FatherName,MotherName,Gender,DOB,Category,Mobile,Email,Course from student where Course=?");
            st.setString(1, course);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setStudentId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setfName(rs.getString(3));
                s.setmName(rs.getString(4));
                s.setGender(rs.getString(5));
                s.setDOB(rs.getDate(6));
                s.setCategory(rs.getString(7));
                s.setMobileNumber(rs.getString(8));
                s.setEmail(rs.getString(9));
                s.setCourse(rs.getString(10));
                list.add(s);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            
        } 
        return list;
    }
    
    public static boolean updateStudent(Student s){
        boolean status = false;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("update student set Name=?, FatherName=?, MotherName=?,DOB=?, Gender=? , Category=?, Nationality=?, Mobile=?, Email=?, Address=?, Course=? where StudentID=?");
            st.setString(1, s.getName());
            st.setString(2, s.getfName());
            st.setString(3, s.getmName());
            java.sql.Date DOB = new java.sql.Date(s.getDOB().getTime());
            st.setDate(4, DOB);
            st.setString(5,s.getGender());
            st.setString(6,s.getCategory());
            st.setString(7,s.getNationality());
            st.setString(8,s.getMobileNumber());
            st.setString(9,s.getEmail());
            st.setString(10,s.getAddress());
            st.setString(11, s.getCourse());
            st.setInt(12, s.getStudentId());
            st.executeUpdate();
            st.close();
            status = true;
        }catch(Exception ex){ 
            System.out.println(ex);
        } 
        return status;
    } 
    
    public static boolean deleteStudent(int studentId){
        boolean status = false;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("delete from student where StudentID=?");
            st.setInt(1, studentId);
            st.executeUpdate();
            st.close();
            status = true;
        }catch(Exception ex){            
        } 
        return status;
    } 
   public static boolean submitFee(Student s){
        boolean status = false;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("update student set Total=?, Paid=?, Balance=? where StudentID=?");
            st.setInt(1, s.getTotal());
            st.setInt(2, s.getPaid());
            st.setInt(3, s.getBalance());
            st.setInt(4, s.getStudentId());
            st.executeUpdate();
            st.close();
            status = true;
        }catch(Exception ex){
            System.out.println(ex);
        } 
        return status;
   }
   public static String authenticateUser(String userName, String passwd){
        String roleName = null;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("select RoleName from users where UserName=? and Passwd=?");
            st.setString(1, userName);
            st.setString(2, passwd);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                roleName = rs.getString(1);
            }
            rs.close();
            st.close();
        }catch(Exception ex){            
        } 
        return roleName;
    } 
   
   public static Boolean changePassword(String userName, String passwd){
       Boolean s= false;
       try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("update users set Passwd=? where UserName=?");
            st.setString(2, userName);
            st.setString(1, passwd);
            st.executeUpdate();
            st.close();
            s=true;
        }catch(Exception ex){            
        } 
        return s;
   }
   public static Boolean addUser(String userName, String passwd, String roleName){
       Boolean s= false;
       try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st = con.prepareStatement("insert into users values(?,?,?)");
            st.setString(1, userName);
            st.setString(2, passwd);
            st.setString(3, roleName);
            st.executeUpdate();
            st.close();
            s=true;
        }catch(Exception ex){            
        } 
        return s;
   }
   public static Student getFee(int studentId){
        Student s = null;
        try(Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);){
            PreparedStatement st2 = con.prepareStatement("select * from fee where ID=?");
            st2.setInt(1, studentId);
            ResultSet rs= st2.executeQuery();
            if(rs.next()){
                s = new Student();
                /*s.setStudentId(rs.getInt(1));
                s.setTotal(rs.getInt(2));*/
                s.setPaid(rs.getInt(1));
                s.setBalance(rs.getInt(2));
                
            }
            rs.close();
            st2.close();
        }catch(Exception ex){
            
        } 
        return s;
    }  
}
