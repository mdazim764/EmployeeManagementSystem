package Employee;
import Employee.PasswordGenerator.PasswordGeneratorBuilder;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class SignUp extends JFrame implements ActionListener {
    JButton bsignup,bcancel,blog,bpassgen;
    JLabel lbsusername,lbspassword,image,lbskey;
    JTextField tssername,tskey;
    JPasswordField tpassword;
    SignUp(){
        super("SignUp");
        
        //Label Details
        lbskey=new JLabel("KEYID: ");
        lbskey.setBounds(20,85,120,30);
        lbskey.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        lbskey.setForeground(Color.BLACK);
        add(lbskey);
        
        lbsusername=new JLabel("USERNAME: ");
        lbsusername.setBounds(20,50,120,30);
        lbsusername.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        lbsusername.setForeground(Color.BLACK);
        add(lbsusername);
        
        lbspassword=new JLabel("PASSWORD: ");
        lbspassword.setBounds(20,120,125,30);
        lbspassword.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        lbspassword.setForeground(Color.BLACK);
        add(lbspassword);
        
        //TextField Details
        tssername=new JTextField();
        tssername.setBounds(135,50,180,30);
        tssername.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,16));
        tssername.setForeground(Color.BLACK);
        tssername.setBackground(Color.WHITE);
        add(tssername);
        
        tskey=new JTextField();
        tskey.setBounds(135,85,180,30);
        tskey.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,16));
        tskey.setForeground(Color.BLACK);
        tskey.setBackground(Color.WHITE);
        add(tskey);
        
        //PasswordField Details
        tpassword=new JPasswordField();
        tpassword.setBounds(135,120,180,30);
        tpassword.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,16));
        tpassword.setForeground(Color.BLACK);
        tpassword.setBackground(Color.WHITE);
        add(tpassword);
        
        //ButtonsDetails
        bsignup=new JButton("SignUp");
        bcancel=new JButton("CANCEL");
        blog=new JButton("For Login");
        bpassgen=new JButton("Generate Secure ");
        
        bsignup.setBounds(20,195,130,30);
        bsignup.setBackground(Color.GREEN);
        bsignup.setForeground(Color.BLACK);
        bsignup.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bsignup.addActionListener(this);
        add(bsignup);
        
        bcancel.setBounds(170,195,130,30);
        bcancel.setBackground(Color.RED);
        bcancel.setForeground(Color.BLACK);
        bcancel.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bcancel.addActionListener(this);
        add(bcancel);
        
        blog.setBounds(320,195,220,30);
        blog.setBackground(Color.LIGHT_GRAY);
        blog.setForeground(Color.BLACK);
        blog.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        blog.addActionListener(this);
        add(blog);
        
        bpassgen.setBounds(180,150,150,20);
        bpassgen.setBackground(Color.WHITE);
        bpassgen.setForeground(Color.BLACK);
        bpassgen.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,10));
        bpassgen.setBorderPainted(false);
        bpassgen.addActionListener(this);
        add(bpassgen);
        
        //Image Details
        
        ImageIcon i=new ImageIcon("src\\Employee\\images\\login.jpg");
        Image i1 = i.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        image=new JLabel(i2);
        image.setBounds(350,5,200,220);
        add(image);
        
               
        
        //Frame Details 
        setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setSize(560,270);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bsignup)
        {
            try{
                Databaseconn c = new Databaseconn();
                String u = tssername.getText();
                String k = tskey.getText();
                String v = tpassword.getText();
                if (u.equals("") || k.equals("") || v.equals("")) {
                    JOptionPane.showMessageDialog(null, "You must fill in  the text fields!",
               "Swing Tester", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String q = "select * from login where username='"+u+"' and password='"+v+"'";

                    ResultSet rs = c.s.executeQuery(q);
                    Boolean userEx=false;
                    while(rs.next()){
                        String username = rs.getString(1);
                        String password = rs.getString(2);
                        String key=rs.getString(3);
                        if(u.equals(username)||k.equals(k)){
                            JOptionPane.showMessageDialog(null, "UserName Or User Key Is  Already Exists");
                            userEx=true;
                            break;
                        }
                    }
                    if(!userEx){
                      q="insert into login (username,password,keyid) values ('"+u+"',"+"'"+v+"',"+"'"+k+"')";
                     int rs1 =c.s.executeUpdate(q);
                    System.out.println(rs1);
                    JOptionPane.showMessageDialog(null,"SignUp. Successfully Completed");
                    dispose();
                    Login login=new Login();  
                    }
                }

                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bcancel)
        {
           int result = JOptionPane.showConfirmDialog(null,"Sure? You want to exit?", "Swing Tester",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               setVisible(false);
               dispose();
            }
        }
        else if(ae.getSource()==blog)
        {
            dispose();
                Login l=new Login();
        }
        else if(ae.getSource()==bpassgen)
        {
           PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
        .useDigits(true)
        .useLower(true)
        .useUpper(true)
        .build();
        String password = passwordGenerator.generate(8);
        System.out.println(password);
        tpassword.setText(password);
        JOptionPane.showMessageDialog(null, "Your Password is: "+password);
        
        }
    }
    public static void main(String args[]){
        SignUp s=new SignUp();
    }
}
