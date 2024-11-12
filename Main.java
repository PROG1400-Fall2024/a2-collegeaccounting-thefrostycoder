//PROG1400 Assignment 2
//Cody Foster - W0400746
import javax.swing.*;
import java.util.ArrayList;

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
                    addStudent(studentList);
                    break;
                case 1:
                    addStaff(staffList);
                    break;
                case 2:
                    //Reporting Feature
                    //Students
                    String reportString = String.format("Students [Total: %d]:", studentList.size());
                    double weeklyFees = 0, weeklyPays = 0;
                    for (Student student : studentList) {
                        weeklyFees += student.getFee();
                        reportString = String.join("\n", reportString, student.toString());
                    }

                    //Staff
                    reportString = String.join("\n", reportString, String.format("\nStaff [Total: %d]:", staffList.size()));
                    for (Staff staff : staffList) {
                        weeklyPays += staff.getSalary();
                        reportString = String.join("\n", reportString, staff.toString());
                    }

                    //Calculate Totals
                    weeklyFees /= 2;
                    weeklyPays /= 26;
                    reportString += String.format("\n\nResults:\nOutgoing: $%.2f\nIncoming: $%.2f\nTotal: $%.2f", weeklyPays, weeklyFees, weeklyFees - weeklyPays);

                    //Display Report
                    JOptionPane.showMessageDialog(null, reportString, "Final Report", JOptionPane.PLAIN_MESSAGE);
                    isRunning = false;
                    break;
                case -1:
                    isRunning = false;
                    break;
            }
        }
    }

    //Prompt for and build a student to add to our list
    private static void addStudent(ArrayList<Student> students){
        //Student Adding
        String studentName, studentAddr, studentYear;
        int studentYearInt;
        while (true) {
            studentName = JOptionPane.showInputDialog(null, "Enter Student Name:", "Input", JOptionPane.QUESTION_MESSAGE);
            //Input Validation
            if (studentName == null) return; //Handle cancellations

            if (studentName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        while (true){
            studentAddr = JOptionPane.showInputDialog(null, "Enter Student Address:", "Input", JOptionPane.QUESTION_MESSAGE);
            //Input Validation
            if (studentAddr == null) return; //Handle cancellations
            if (studentAddr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an address.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        while (true){
            //try-catch to handle invalid numbers
            try {
                studentYear = JOptionPane.showInputDialog(null, "Enter Student Year:", "Input", JOptionPane.QUESTION_MESSAGE);
                //Input Validation
                if (studentYear == null) return; //Handle cancellations
                studentYearInt = Integer.parseInt(studentYear);
                if (studentYearInt < 1 || studentYearInt > 4) {
                    JOptionPane.showMessageDialog(null, "Please enter a year between 1-4.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Build and add the new student
        Student newStudent = new Student(studentName, studentAddr, studentYearInt);
        students.add(newStudent);
    }

    //Prompt for and build a staff member to add to our list
    private static void addStaff(ArrayList<Staff> staffs){
        //Staff Adding
        String staffName, staffAddr, staffYearsOfService;
        int staffYearsOfServiceInt;

        while (true) {
            staffName = JOptionPane.showInputDialog(null, "Enter Staff Name:", "Input", JOptionPane.QUESTION_MESSAGE);
            //Input Validation
            if (staffName == null) return; //Handle cancellations
            if (staffName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        while (true){
            staffAddr = JOptionPane.showInputDialog(null, "Enter Staff Address:", "Input", JOptionPane.QUESTION_MESSAGE);
            //Input Validation
            if (staffAddr == null) return; //Handle cancellations
            if (staffAddr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an address.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        while (true){
            //try-catch to handle invalid numbers
            try {
                staffYearsOfService = JOptionPane.showInputDialog(null, "Enter Years of Service:", "Input", JOptionPane.QUESTION_MESSAGE);

                if (staffYearsOfService == null) return; //Handle cancellations

                staffYearsOfServiceInt = Integer.parseInt(staffYearsOfService);
                //Input Validation for proper range
                if (staffYearsOfServiceInt < 1 || staffYearsOfServiceInt >= 30) {
                    JOptionPane.showMessageDialog(null, "Please enter a year between 1-29.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Build and add the new staff
        Staff newStaff = new Staff(staffName, staffAddr, staffYearsOfServiceInt);
        staffs.add(newStaff);
    }
}
