package University.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice empId;
    JTable table;
    JButton search, print, cancel;
    TeacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //heading label
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        //search by choice
        empId = new Choice();
        empId.setBounds(180,20,150,20);
        add(empId);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                empId.add(rs.getString("EmployeeId"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        //table
        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ae){
            ae.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        //buttons
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        //frame
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search){
            String query = "select * from teacherleave where EmpId = '"+empId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
