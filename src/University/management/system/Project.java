package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1540,850);

        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/MAC.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        //Menu bar
        JMenuBar menu = new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        menu.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        //details
        //JMenuBar details = new JMenuBar();
        JMenu newDetails = new JMenu("View Details");
        newDetails.setForeground(Color.RED);
        menu.add(newDetails);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        newDetails.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        newDetails.add(studentDetails);

        //leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        menu.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Teacher Leave");
        facultyDetails.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        menu.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Teacher Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //Examination details
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        menu.add(exam);

        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        //update info
        JMenu updateInfo = new JMenu("Update Information");
        updateInfo.setForeground(Color.RED);
        menu.add(updateInfo);

        JMenuItem updateFacultyDetails = new JMenuItem("Update Faculty Details");
        updateFacultyDetails.setBackground(Color.WHITE);
        updateFacultyDetails.addActionListener(this);
        updateInfo.add(updateFacultyDetails);

        JMenuItem studentUpdateDetails = new JMenuItem("Update Student Details");
        studentUpdateDetails.setBackground(Color.WHITE);
        studentUpdateDetails.addActionListener(this);
        updateInfo.add(studentUpdateDetails);

        //Fee structure
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        menu.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem studentFeeForm = new JMenuItem("Student Fee Form");
        studentFeeForm.setBackground(Color.WHITE);
        studentFeeForm.addActionListener(this);
        fee.add(studentFeeForm);

        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        menu.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        //About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        menu.add(about);

        JMenuItem aboutDeatils = new JMenuItem("About");
        aboutDeatils.setBackground(Color.WHITE);
        aboutDeatils.addActionListener(this);
        about.add(aboutDeatils);

        //Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        menu.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);



        setJMenuBar(menu);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Project();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(msg.equals("Notepad")){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        }else if(msg.equals("View Student Details")){
            new StudentDetails();
        }
        else if(msg.equals("Teacher Leave")){
            new TeacherLeave();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Teacher Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
        else if(msg.equals("About")){
            new About();
        }
        else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }else{
            setVisible(false);
        }
    }
}
