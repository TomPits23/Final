import java.awt.Color;
import java.awt.Font;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.FileWriter;


class LogIn extends JFrame{
    JLabel userLab = new JLabel("UserID");
    JLabel userpass = new JLabel("Password");
    JLabel wel = new JLabel("Help Us To Know Who You Are:");
    JLabel c = new JLabel();
    JLabel tt = new JLabel();
    JLabel mes = new JLabel();
    JTextField t1,t2;
    JButton bt1,bt2;

    LogIn (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
       
        tt = new JLabel("SCHOOL INFORMATION SYSTEM");
        tt.setFont(new Font("Times New Roman",  Font.BOLD,28));
        tt.setForeground(Color.BLUE);
        tt.setBounds(80, 90, 500, 40);


        
        c = new JLabel("Enter the Credentials");
        c.setFont(new Font("Times New Roman",  Font.BOLD,12));
        c.setBounds(150, 200, 300, 20);
        t1 = new JTextField();
        t2 = new JPasswordField();
        bt1 = new JButton("SignIn");
        bt2 = new JButton("SignUp");
        mes = new JLabel(""); 

        wel.setBounds(225, 130, 200, 40);
        userLab.setBounds(70, 230, 80, 25);
        t1.setBounds(150, 230, 300, 20);
        userpass.setBounds(70, 270, 80, 25);
        t2.setBounds(150, 270, 300, 20);
        bt1.setBounds(200, 300, 80, 20);
        bt2.setBounds(290, 300, 80, 20 );
        
       
        mes.setFont(new Font("Times New Roman", Font.BOLD, 29));
        mes.setForeground(Color.RED);
        mes.setBounds(150,350,400,30);


        
        add(wel);
        add(c);
        add(userLab);
        add(userpass);
        add(t1);
        add(t2);
        add(bt1);
        add(tt);
        add(mes);
        add(bt2);
        

        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                boolean matched = false;
                String userID = t1.getText().toString();
                String password = t2.getText().toString();


                try{
                FileReader r = new FileReader("ICSPdata.txt");
                BufferedReader br = new BufferedReader(r);
                String Ln; 
                while ((Ln=br.readLine())!=null){
                    if(Ln.equals(userID + "\t" + password)){
                        matched = true;
                        break;
                    }
                }
                r.close();
            } catch(Exception e){}

                if (matched) {
                    
                    mes.setText("Pesonel Confirmed!");
                    
                 } else {
                    mes.setText("Invalid UserID or Password!");


                }




            }
        });

        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                SignUp s = new SignUp();
                s.setSize(600,600);
                s.setVisible(true);
                s.setTitle("International State College of the Philippines");
                


            }
        });



    }
}

class SignUp extends JFrame{
   
    ImageIcon  image = new ImageIcon("logo.png");
    JLabel sg = new JLabel();
    JLabel sF = new JLabel("First Name ");
    JLabel sL = new JLabel("Last Name ");
    JLabel sUID = new JLabel("Enter your UserID ");
    JLabel spwd = new JLabel("Enter your Password ");
    JTextField fn,ln,uSID,t2;
    JButton sbt1 = new JButton();
    


    SignUp(){

        setLayout(null);

        sbt1 = new JButton("Submit");
        sg = new JLabel("Sign Up");
        sg.setFont(new Font("Times New Roman",  Font.BOLD,28));
        sg.setForeground(Color.BLUE);
        sg.setBounds(80, 50, 500, 40);


        sbt1.setBounds(115, 300, 100, 20);
        sF.setBounds(70, 120, 100, 25);
        sL.setBounds(70, 160, 80, 25);
        sUID.setBounds(70, 200, 120, 25);
        spwd.setBounds(70, 240, 180, 25);
     

        fn = new JTextField();
        ln = new JTextField();
        uSID = new JTextField();
        t2 = new JPasswordField();
       
        fn.setBounds(70,145,200,18);
        ln.setBounds(70,185,200,18);
        uSID.setBounds(70,225,200,18);
        t2.setBounds(70,263,200,18);


        sbt1.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){

                try{    
                FileWriter data = new FileWriter("ICSPdata.txt",true);
                data.write(uSID.getText() + "\t" + t2.getText() + "\n" + fn.getText() + "\t" + ln.getText() + "\n");
                data.close();
                JFrame fr = new JFrame();
                JOptionPane.showMessageDialog(fr,"Registration Completed");
                dispose();
                } catch (Exception e){

                }

            }
        });


        add(sF);
        add(sL);
        add(sUID);
        add(spwd);
        add(fn);
        add(ln);
        add(uSID);
        add(t2);
        add(sg);
        add(sbt1);


    }

}

class LogInDemo{

    public static void main(String[] args) {
        LogIn lg = new LogIn();
        lg.setSize(600,600);
        lg.setVisible(true);
        lg.setTitle("International State College of the Philippines");
    
       
        
    }

}


