package com.employeepayroll.employeepayroll;


public class EmployeePayrollData {
   private int id;
   private String name;
   private double salary;
   public EmployeePayrollData(Integer id,String name,Double salary)
   {
       this.id=id;
       this.name=name;
       this.salary=salary;
   }
   public String toString()
   {
       return "id="+id+",name"+'\''+",salary="+salary;
   }
}