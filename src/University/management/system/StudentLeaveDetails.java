package University.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice crollno;
    JTable table;
    JButton search, print, cancel;
    StudentLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //heading label
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        //search by choice
        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        //table
        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
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
        new StudentLeaveDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search){
            String query = "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
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
