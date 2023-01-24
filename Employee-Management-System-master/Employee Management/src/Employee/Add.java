package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;  
public class Add implements ActionListener
{
    JFrame jf;
    JLabel title,lblimage,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton submit,cancel,reset;
    Add(int k){}
    Add()
    {
        //JFrame Details
        jf=new JFrame("ADD EMPLOYEE");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(20,20);
        jf.setSize(900,600);
        
        //Background Image
        lblimage= new JLabel();
        lblimage.setBounds(0,0,900,600);
        lblimage.setLayout(null);
        ImageIcon i = new ImageIcon("src\\Employee\\images\\add_employee.jpg");
        lblimage.setIcon(i);
        jf.add(lblimage);
        
        //Label Details
        
        title = new JLabel("NEW EMPLOYEE DETAILS");
        title.setBounds(210,30,500,50);
        title.setFont(new Font("serif",Font.ITALIC,36));
        title.setForeground(Color.BLUE);
        lblimage.add(title);

        l1 = new JLabel("NAME");
        l1.setBounds(50,150,100,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l1);
        
        l2 = new JLabel("SURNAME");
        l2.setBounds(400,150,200,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l2);
        
        l3 = new JLabel("AGE");
        l3.setBounds(50,200,100,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l3);
        
        l4 = new JLabel("DATE OF BIRTH");
        l4.setBounds(400,200,200,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l4);
        
        l5 = new JLabel("ADDRESS");
        l5.setBounds(50,250,100,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l5);
        
        l6 = new JLabel("PHONE NO.");
        l6.setBounds(400,250,200,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l6);
        
        l7 = new JLabel("EMAIL ID");
        l7.setBounds(50,300,100,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l7);
        
        l8 = new JLabel("EDUCATION");
        l8.setBounds(400,300,200,30);
        l8.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l8);
        
        l9 = new JLabel("JOB POST");
        l9.setBounds(50,350,100,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l9);
        
        l10 = new JLabel("AADHAR NO.");
        l10.setBounds(400,350,200,30);
        l10.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l10);
        
        l11 = new JLabel("EMPLOYEE ID");
        l11.setBounds(50,400,150,30);
        l11.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(l11);
        
        l1.setForeground(Color.BLACK);
        l2.setForeground(Color.BLACK);
        l3.setForeground(Color.BLACK);
        l4.setForeground(Color.BLACK);
        l5.setForeground(Color.BLACK);
        l6.setForeground(Color.BLACK);
        l7.setForeground(Color.BLACK);
        l8.setForeground(Color.BLACK);
        l9.setForeground(Color.BLACK);
        l10.setForeground(Color.BLACK);
        l11.setForeground(Color.BLACK);
        
        //TextField Details
        t1=new JTextField();  //Name
        t1.setBounds(200,150,170,30);
        lblimage.add(t1);
        
        t2=new JTextField();  //Sur Name
        t2.setBounds(600,150,170,30);
        lblimage.add(t2);
        
        t3=new JTextField();  //Age
        t3.setBounds(200,200,170,30);
        lblimage.add(t3);
        
        t4=new JTextField();  //DOB
        t4.setBounds(600,200,170,30);
        lblimage.add(t4);
        
        t5=new JTextField();  //Address
        t5.setBounds(200,250,170,30);
        lblimage.add(t5);
        
        t6=new JTextField();  //Phone No.
        t6.setBounds(600,250,170,30);
        lblimage.add(t6);
        
        t7=new JTextField();  //Email Id
        t7.setBounds(200,300,170,30);
        lblimage.add(t7);
        
        t8=new JTextField();  //Education
        t8.setBounds(600,300,170,30);
        lblimage.add(t8);
        
        t9=new JTextField();  //Job Post
        t9.setBounds(200,350,170,30);
        lblimage.add(t9);
        
        t10=new JTextField();  //Aadhar No.
        t10.setBounds(600,350,170,30);
        lblimage.add(t10);
        
        t11=new JTextField();  //Employee Id
        t11.setBounds(200,400,170,30);
        lblimage.add(t11);
        
        //Input Text Details
        t1.setFont(new Font("serif",Font.PLAIN,18));
        t1.setForeground(Color.BLACK);
        t2.setFont(new Font("serif",Font.PLAIN,18));
        t2.setForeground(Color.BLACK);
        t3.setFont(new Font("serif",Font.PLAIN,18));
        t3.setForeground(Color.BLACK);
        t4.setFont(new Font("serif",Font.PLAIN,18));
        t4.setForeground(Color.BLACK);
        t5.setFont(new Font("serif",Font.PLAIN,18));
        t5.setForeground(Color.BLACK);
        t6.setFont(new Font("serif",Font.PLAIN,18));
        t6.setForeground(Color.BLACK);
        t7.setFont(new Font("serif",Font.PLAIN,18));
        t7.setForeground(Color.BLACK);
        t8.setFont(new Font("serif",Font.PLAIN,18));
        t8.setForeground(Color.BLACK);
        t9.setFont(new Font("serif",Font.PLAIN,18));
        t9.setForeground(Color.BLACK);
        t10.setFont(new Font("serif",Font.PLAIN,18));
        t10.setForeground(Color.BLACK);
        t11.setFont(new Font("serif",Font.PLAIN,18));
        t11.setForeground(Color.BLACK);
        
        //Button Details
        submit=new JButton("SUBMIT");
        cancel=new JButton("CANCEL");
        reset=new JButton("RESET");
        
        submit.setBounds(215,480,150,40);
        submit.setFont(new Font("Times_New_Roman",Font.PLAIN,24));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        lblimage.add(submit);
        
        cancel.setBounds(375,480,150,40);
        cancel.setFont(new Font("Times_New_Roman",Font.PLAIN,24));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        lblimage.add(cancel);
        
        reset.setBounds(535,480,150,40);
        reset.setFont(new Font("Times_New_Roman",Font.PLAIN,24));
        reset.setForeground(Color.WHITE);
        reset.setBackground(Color.BLACK);
        lblimage.add(reset);
        
        submit.addActionListener(this);
        cancel.addActionListener(this);
        reset.addActionListener(this);
        
        jf.setVisible(true);
    }
    //Validetion Methods
    public static boolean isValidMobileNo(String str)  
    {  
        //(0/91): number starts with (0/91)  
        //[7-9]: starting of the number may contain a digit between 0 to 9  
        //[0-9]: then contains digits 0 to 9  
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
        //the matcher() method creates a matcher that will match the given input against this pattern  
        Matcher match = ptrn.matcher(str);  
        //returns a boolean value  
        return (match.find() && match.group().equals(str));  
    }  
    public static boolean isValidAadharNo(String str)  
    {  
        
        Pattern ptrn = Pattern.compile("[0-9]{12}");  
        Matcher match = ptrn.matcher(str);  
        return (match.find() && match.group().equals(str));  
    }  
    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            try
            {
                Databaseconn c=new Databaseconn();
                String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,q,qe;
                s1=t1.getText();
                s2=t2.getText();
                s3=t3.getText();
                s4=t4.getText();
                s5=t5.getText();
                s6=t6.getText();
                s7=t7.getText();
                s8=t8.getText();
                s9=t9.getText();
                s10=t10.getText();
                s11=t11.getText();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals("")||s9.equals("")||s10.equals("")||s11.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You must fill in  the text fields!",
               "Swing Tester", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if (!isValidMobileNo(s6)){
                        JOptionPane.showMessageDialog(null, "Phone No. is wrong Enter correct Phone No. ",
               "Swing Tester", JOptionPane.ERROR_MESSAGE);
                    }  
                    if (!isValidAadharNo(s10)){
                        JOptionPane.showMessageDialog(null, "Aadhar No. is wrong Enter correct Aadhar No. ",
               "Swing Tester", JOptionPane.ERROR_MESSAGE);
                    }  
                    if (!isValidEmail(s7)){
                        JOptionPane.showMessageDialog(null, "Email ID is wrong Enter correct Email ID ",
               "Swing Tester", JOptionPane.ERROR_MESSAGE);
                    }
                    if(isValidMobileNo(s6) && isValidEmail(s7) && isValidAadharNo(s10))
                    {
                        q="insert into employee_details (EmployeeID,Name,SurName,Age,DOB,Address,Phone,EmailID,Education,JobPost,AadharNo) values ('"+s11+"',"+"'"+s1+"',"+"'"+s2+"',"+"'"+s3+"',"+"'"+s4+"',"+"'"+s5+"',"+"'"+s6+"',"+"'"+s7+"',"+"'"+s8+"',"+"'"+s9+"',"+"'"+s10+"')";
                        c.s.executeUpdate(q);
                        qe="insert into employee_login (username,password,keyid) values ('"+s11+"',"+"'"+s11+"',"+"'"+s11+"')";
                        c.s.executeUpdate(qe);
                        JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                        jf.dispose();
                        new MainPage();
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
        else if(ae.getSource()==reset)
        {
            jf.dispose();
            Add a=new Add();
        }
    }
    public static void main(String args[])
    {
        Add a=new Add();
    }
}
