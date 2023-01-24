package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class EMPView implements ActionListener
{
    JFrame jf;
    JLabel lblimage,lblid;
    JTextField empid;
    JButton bsearch,bcancel;
    EMPView()
    {
        //JFrame Details
        jf=new JFrame("EMPLOYEE DETAILS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLocation(30,30);
        jf.setLayout(null);
        jf.setSize(500,270);
        
        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,500,270);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\Employee\\images\\view.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);
        
        //Employee ID Label
        lblid=new JLabel("ENTER EMPLOYEE ID: ");
        lblid.setBounds(35,60,250,30);
        lblid.setForeground(Color.BLACK);
        lblid.setFont(new Font("Times_New_Roman",Font.BOLD,18));
        lblimage.add(lblid);
        
        //Text Field Details
        empid=new JTextField();
        empid.setBounds(240,60,220,30);
        empid.setFont(new Font("serif",Font.PLAIN,18));
        empid.setForeground(Color.BLACK);
        lblimage.add(empid);
        
        //Button Details
        bsearch=new JButton("VIEW");
        bcancel=new JButton("CANCEL");
        
        bsearch.setBounds(240,150,110,30);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,16));
        bsearch.setForeground(Color.WHITE);
        bsearch.setBackground(Color.BLACK);
        lblimage.add(bsearch);
        
        bcancel.setBounds(370,150,100,30);
        bcancel.setFont(new Font("Times_New_Roman",Font.PLAIN,16));
        bcancel.setForeground(Color.WHITE);
        bcancel.setBackground(Color.BLACK);
        lblimage.add(bcancel);
        
        bsearch.addActionListener(this);
        bcancel.addActionListener(this);
        
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bsearch)
        {
            try
            {
                Databaseconn c=new Databaseconn();
                String str = "select Name,Phone,EmailID from employee_details where EmployeeID ='"+empid.getText()+"';";
                ResultSet rs = c.s.executeQuery(str);
                int i=0;
                if(rs.next())
                {
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email=rs.getString(3);
                    i=1;
                }
                if(i==0)
                {
                    jf.dispose();
                    JOptionPane.showMessageDialog(null,"ID NOT FOUND OR EMPLOYEE DOES NOT EXISTS");
                    EMPView v=new EMPView();
                }
                if(i==1)
                {
                    jf.dispose();
                    EMPDisplay_Details dd=new EMPDisplay_Details(empid.getText());
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bcancel)
        {
            jf.dispose();
            EMPMain mp=new EMPMain();
        }
    }
    public static void main(String args[])
    {
        EMPView v=new EMPView();
    }
}
