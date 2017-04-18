
/**
 * @(#)PayRoll.java
 *
 *
 * @author Group PayMoreKa
 * @version 1.00 2017/4/17
 */
import java.rmi.*;

   /**
     * This is an interface contains the methods that adds employees, generates report, tracks
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
      */
     public void timeIn();

     /**
      * this method lets the user to input time-out to the system
      */
     public void timeOut();

     /**
      * this method computes the total work hours of an employee per day
      *
      * @param timeIn Time in of the user
      * @param timeOut Time out of the user
      * @throws InvalidNumberOfHoursException if number is beyond expected number
      * @return totalHours total hours of the employee
      */
      public double computeWorkHoursDay(double timeIn, double timeOut);
}