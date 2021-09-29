package com.employeepayroll.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Employee Payroll Service to Read and Write Employee Payroll to a Console

 */
public class EmployeePayrollFileIOService {
    public enum IOService{
        CONSOLE_IO,FIlE_IO,DB_IO,REST_IO
    }
    private List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollFileIOService()
    {
        System.out.println("Welcome to employee payroll service!!!");
    }
    /**
     * Create Employee Payroll Class of id, name and Salary
     * @param employeePayrollList list containing id,name and salary
     */
    public  EmployeePayrollFileIOService(List<EmployeePayrollData> employeePayrollList)
    {
        this.employeePayrollList=employeePayrollList;
    }
    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeepayrollList=new ArrayList<>();
        EmployeePayrollFileIOService employeePayrollService=new EmployeePayrollFileIOService(employeepayrollList);
        Scanner consoleInputReader=new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.FIlE_IO);
    }
    /**
     * write the Employee Payroll to the Console
     */
    public void writeEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO))
        {
            System.out.println("\nWriting Employee Payroll roaster to console\n"+employeePayrollList);   
        }
        else if(ioService.equals(IOService.FIlE_IO))
        {
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
        }
    }
    /**
     * Read the information from the Console
     * @param consoleInputReader console input reader
     */
   public void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id:");
        int id=consoleInputReader.nextInt();
        System.out.println("Enter Employee Name:");
        String name=consoleInputReader.next();
        System.out.println("Enter Employee Salary:");
        double salary=consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));       
    }
    public long countEntries(IOService ioService) {  
        return new EmployeePayrollFileIOService().countEntries(ioService);
    }
    
    public void printData()
    {
        new EmployeePayrollFileIOService().printData();
    }
    
}