
/**
 * @(#)PayRoll.java
 *
 *
 * @author Group PayMoreKa
 * @version 1.00 2017/4/17
 */
import java.rmi.*;

   /**
    * This is an interface that contains the methods that adds employees, generates report, tracks
    * employees’ attendance, tax, income etc. in the system 
    *
    */
public interface PayRoll extends Remote {
   /**
    * This method adds an employee and the postition of the employee in the system 
    *
    * @param name name of employee
    * @param position position of employee
    * @throws InvalidNameException if name is not a string
    * @throws InvalidPositionException if position is not a string
    * @throws NullException if parameters is and empty input
    * User defined class: Employee -> details of the employee
    */
  public void addEmployees(String name, String position);
  /**
   *  this method deletes an employee and the position of the employee in the system 
   * @throws UserNotFoundException
   */
  public void removeEmployees();

  /**
   * this method lets the user to input time-in to the system
   *
   * @param name Employee's name
   * @return time returns the time of the time in
   */
  public void timeIn(String name);

  /**
   * this method lets the user to input time-out to the system
   * @param name Employee's name
   * @return time returns the time of the time out.
   */
  public void timeOut(double timeIn, double timeOut);

   /**
    * this method computes the total work hours of an employee per day
    *
    * @param timeIn Time in of the user
    * @param timeOut Time out of the user
    * @throws InvalidNumberOfHoursException if number is beyond expected number
    * @return totalHours total hours of the employee
    */
   public double computeWorkHoursDay(double timeIn, double timeOut);

	/**
	 * this method computes the deductions such as tax of the employee 
	 *
	 * @param name employee's name
	 * @param salary employees salary
	 * @return totalDeducted employee's salary which has deductions
	 * @throws InvalidValueException if input is not of suitable variable type
	 */
	public double salaryDeduct(String name, double salary);
	
	/**
	 *
	 * this method generates paying employment taxes to the government.
	 *
	 * @param name employee's name
	 * @param tax total deduction in the employee's salary
	 * @return taxTotal total deduction in the salary of the employee
	 * @throws InvalidValueException if input is not of suitable variable type
	 */
	public double totalTax(String name, double tax);
	
	/**
	 *
	 * this method determines how much bonus will an employee (13nth month pay)
	 * 
	 * @param name Employee's name
	 * @param salary salary of the employee
	 * @throws InvalidValueException if input is not of suitable variable type
	 * @return bonus
	 */
	public double bonus(String name, double salary);
	
	/**
	 *
	 * this method generates pay checks of the employee
	 * 
	 * @param employee Employee's name
	 * @return paycheckString
	 * @throws EmployeeNotFoundException if the employee does not exist
	 */
	 public String payCheck(String name);
	 
	 
	 /**
	  *
	  * this method views the records of employees
	  *
	  * User defined class Employees
	  */
	  public void viewRecord();
    


}