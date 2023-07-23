package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox cbcourse, cbbranch,cbsemester;
    JButton update,pay,back;
    JLabel lbl_total;
    StudentFeeForm(){
        setSize(900, 500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lblrollno = new JLabel("Select Roll No");
        lblrollno.setBounds(40,60,150,20);
        lblrollno.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(200,60,150,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception ae){
            ae.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lblname);

        JLabel lbl_name = new JLabel();
        lbl_name.setBounds(200,100,150,20);
        lbl_name.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lbl_name);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40,140,150,20);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblfname);

        JLabel lbl_fname = new JLabel();
        lbl_fname.setBounds(200,140,150,20);
        lbl_fname.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lbl_fname);

        try{
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lbl_name.setText(rs.getString("name"));
                lbl_fname.setText(rs.getString("fname"));
            }
        }catch(Exception ae){
            ae.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        lbl_name.setText(rs.getString("name"));
                        lbl_fname.setText(rs.getString("fname"));
                    }
                }catch(Exception ae){
                    ae.printStackTrace();
                }
            }
        });
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lblcourse);

        String course[] = {"BTech","BBA","BCA","MCA","Bsc", "Msc", "MBA", "Bcom","Mcom","Mtech","MA","BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lblbranch);

        String branch[] = {"Computer Science","Electronics","Mechanical","Civil","Chemical", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lblsemester);

        String semester[] = {"Semester1","Semester2","Semester3","Semester4","Semester5", "Semester6","Semester7","Semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        //payment
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lbltotal);

        lbl_total = new JLabel();
        lbl_total.setBounds(200,300,150,20);
        lbl_total.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lbl_total);

        //buttons
        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==update){
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from CollegeFee where course='"+course+"'");
                while(rs.next()){
                    lbl_total.setText(rs.getString(semester));
                }
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getSource() == pay){
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String total = lbl_total.getText();

            try{
                Conn c = new Conn();
                String query = "insert into Cfee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College Fee Submitted Successfully");
                setVisible(false);
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
