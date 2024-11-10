//PROG1400 Assignment 2
//Cody Foster - W0400746
import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //Store the staff/students for future reporting
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();

        //Lock the program into a loop
        boolean isRunning = true;
        while (isRunning){
            //Get our initial menu selection
            String[] menuOptions = {"Student", "Staff", "Finish"};
            int inputChoice = JOptionPane.showOptionDialog(null, "Select an input type:", "Accounting App", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menuOptions, menuOptions[0]);
            switch(inputChoice) {
                case 0:
                    //Student Adding
                    String studentName, studentAddr;
                    int studentYear;
                    while (true) {
                        studentName = JOptionPane.showInputDialog(null, "Enter Student Name:", "Input", JOptionPane.QUESTION_MESSAGE);
                        //Input Validation
                        if (studentName == null){
                            //Cancel and return to the main manu
                            continue;
                        }

                        if (studentName.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            break;
                        }
                    }
                    while (true){
                        studentAddr = JOptionPane.showInputDialog(null, "Enter Student Address:", "Input", JOptionPane.QUESTION_MESSAGE);
                        //Input Validation
                        if (studentAddr.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter an address.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            break;
                        }
                    }
                    while (true){
                        //try-catch to handle invalid numbers
                        try {
                            studentYear = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student Year:", "Input", JOptionPane.QUESTION_MESSAGE));
                            //Input Validation
                            if (studentYear < 1 || studentYear > 4) {
                                JOptionPane.showMessageDialog(null, "Please enter a year between 1-4.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    //Build and add the new student
                    Student newStudent = new Student(studentName, studentAddr, studentYear);
                    studentList.add(newStudent);
                    break;
                case 1:
                    //Staff Adding
                    String staffName, staffAddr;
                    int staffYearsOfService;

                    while (true) {
                        staffName = JOptionPane.showInputDialog(null, "Enter Staff Name:", "Input", JOptionPane.QUESTION_MESSAGE);
                        //Input Validation
                        if (staffName.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            break;
                        }
                    }
                    while (true){
                        staffAddr = JOptionPane.showInputDialog(null, "Enter Staff Address:", "Input", JOptionPane.QUESTION_MESSAGE);
                        //Input Validation
                        if (staffAddr.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter an address.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            break;
                        }
                    }
                    while (true){
                        //try-catch to handle invalid numbers
                        try {
                            staffYearsOfService = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Years of Service:", "Input", JOptionPane.QUESTION_MESSAGE));
                            //Input Validation for proper range
                            if (staffYearsOfService < 1 || staffYearsOfService >= 30) {
                                JOptionPane.showMessageDialog(null, "Please enter a year between 1-29.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //Build and add the new staff
                    Staff newStaff = new Staff(staffName, staffAddr, staffYearsOfService);
                    staffList.add(newStaff);
                    break;
                case 2:
                    //Reporting Feature
                    String reportString = String.format("Students [Total: %d]:", studentList.size());
                    for (Student student : studentList) {
                        reportString = String.join("\n", reportString, student.toString());
                    }

                    reportString = String.join("\n", reportString, String.format("\nStaff [Total: %d]:", staffList.size()));
                    for (Staff staff : staffList) {
                        reportString = String.join("\n", reportString, staff.toString());
                    }
                    JOptionPane.showMessageDialog(null, reportString, "Final Report", JOptionPane.PLAIN_MESSAGE);
                    isRunning = false;
                    break;
                case -1:
                    isRunning = false;
                    break;
            }
        }
    }
}
