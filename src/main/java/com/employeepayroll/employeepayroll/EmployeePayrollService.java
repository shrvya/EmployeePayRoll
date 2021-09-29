package com.employeepayroll.employeepayroll;

import java.util.*;
public class EmployeePayrollService {
    public enum IOService{
        CONSOLE_IO,FIlE_IO,DB_IO,REST_IO
    }
    private List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollService()
    {
        System.out.println("Welcome to employee payroll service!!!");
    }
    /**
     * Create Employee Payroll Class of id, name and Salary
     * @param employeePayrollList list containing id,name and salary
     */
    public  EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
    {
        this.employeePayrollList=employeePayrollList;
    }
    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeepayrollList=new ArrayList<>();
        EmployeePayrollService employeePayrollService=new EmployeePayrollService(employeepayrollList);
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
        return new EmployeePayrollFileIOService().countEntries();
    }
     
    public void printData()
    {
        new EmployeePayrollFileIOService().printData();
    }
    
}