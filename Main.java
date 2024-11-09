//PROG1400 Assignment 2
//Cody Foster - W0400746
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Store the staff/students for future reporting
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Staff> staffList = new ArrayList<Staff>();

        //Lock the program into a loop
        boolean isRunning = true;
        while (isRunning){
            //Get our initial menu selection
            String[] menuOptions = {"Student", "Staff", "Finish"};
            int inputChoice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menuOptions, menuOptions[0]);
            switch(inputChoice){
                case 0:
                    //Student Adding
                    String studentName = JOptionPane.showInputDialog(null, "Enter Student Name:", "Input", JOptionPane.INFORMATION_MESSAGE);
                    String studentAddr = JOptionPane.showInputDialog(null, "Enter Student Address:", "Input", JOptionPane.INFORMATION_MESSAGE);
                    int studentYear = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student Year:", "Input", JOptionPane.INFORMATION_MESSAGE));

                    //Build and add the new student
                    Student newStudent = new Student(studentName, studentAddr, studentYear);
                    studentList.add(newStudent);
                    break;
                case -1:
                    isRunning = false;
                    break;
            }
        }
    }
}
