package poe5121_part_1_and_2;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Tasks {
    
    private String taskName;
    private String description;
    public static int taskNumber = -1;
    private String developer;
    private double numTasks; 
    public static double totalTasks = 0;
    private String TaskID;
    private String Status;
    
    //Used to reset total hours to zero when starting new 'Add task'
    public static void setTotalTasks(double totalTasks) {
        Tasks.totalTasks = totalTasks;
    }
        
    //Unit testing purposes
    public static void setTaskNumber(int taskNumber) {
        Tasks.taskNumber = taskNumber;
    }
    
    //Asks user questions to capture relevent data when making a task
    public void taskDetails(String firstName, String lastName)
    {
        try {
        String task = JOptionPane.showInputDialog(null, "Plese enter the number of tasks you want to make");
                   int Tasks = Integer.parseInt(task);
        
        //for loop to make sure user only fills in deatils for the number of tasks they set above
        for (int i=0; i < Tasks; i++)
        { 
            taskName = JOptionPane.showInputDialog(null, "Plese enter the task's name " + (i+1));
            //Task name must be there and must have 3 or more characters
            if (!checkTaskName(taskName)) {
                do {
                JOptionPane.showMessageDialog(null, "Error! Please enter 3 characters or more");
                 taskName = JOptionPane.showInputDialog(null, "Plese enter the task's name " + (i+1));
                }while (!checkTaskName(taskName));
            }
            
            description = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s descrption " + (i+1));
            //Description must'nt be blank and must be 50 charcters or less
            if (!checkTaskDescription(description)) {
                do {
                JOptionPane.showMessageDialog(null, "Error! Please enter 50 characters or less");
                 description = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s descrption " + (i+1));
                }while (!checkTaskDescription(description));
            }
            
            developer = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s developer " + (i+1));
            //Makes sure user enters a name and surname
            if (!developer.contains(" ")) {
                do{
                JOptionPane.showMessageDialog(null, "Error! Please enter name and surname");
                developer = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s developer " + (i+1));
                }while (!developer.contains(" "));
            }
            
            //Hours for task contributes to accumulator
            String amount = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s duration " + (i+1));
             int duration = Integer.parseInt(amount);
            
             int option = 0;
             
             ImageIcon icon = new ImageIcon("To Do, Doing, Done.png");
            
             String[] options = {"To Do", "Doing", "Done"};
             option = JOptionPane.showOptionDialog(null,
             null,
             "Please select" + taskName + "'s status:",
             WindowConstants.DISPOSE_ON_CLOSE,
             JOptionPane.PLAIN_MESSAGE,
             icon,
             options,
             options[0]);
             
             //Impliment's method
             retrieveStatus(option);
             
            //Simultaneous execution for 3 methods to captur and display task details
            JOptionPane.showMessageDialog(null,printTaskDetails(taskName, description, developer, duration, Status));
            //The pop-up box for total return hours of all tasks
            JOptionPane.showMessageDialog(null,"Total amount of Task hours: "+ ReturnTotalHours(duration));
          }
        }catch (NumberFormatException n) {    
              JOptionPane.showMessageDialog(null,"Invalid value, please enter a number ");
         }
 
    }
    
    //Accumulator for total hours of all tasks
    public double ReturnTotalHours(int duration)
    {
            totalTasks += duration;
            numTasks = totalTasks;
            return totalTasks;
    }
    
    //Method to generate each tasks ID
    public String createTaskID(String taskName, String developer) {
        
        this.taskName = taskName;
        this.developer = developer;
        taskNumber++;
        
        String id = taskName.substring(0, 2).toUpperCase();
        String id2 = developer.substring(developer.length()-3).toUpperCase();
        TaskID = id + ":" + taskNumber + ":" + id2;
        return TaskID;  
    }
     
    //Method to check that task description is 50 characters long or less and not blank
     public boolean checkTaskDescription(String description) 
    {
        if(description.length() <= 50 && !description.isBlank())
        {
            return true;
        }
        
        else {
            return false;
        }
    }
     
     //Method to check that task name is 3 characters long or more and not blank
     public boolean checkTaskName(String taskName) 
    {
        if(taskName.length() >= 3 && !taskName.isBlank())
        {
            return true;
        }
        else {
            return false;
        }
    }


    //Method prints all the details regarding each task. 1 pop up box = 1 task
    public String printTaskDetails(String taskName, String description, String developer, double numTasks, String Status) {
        this.taskName = taskName;
        this.description = description;
        this.developer = developer;
        this.numTasks = numTasks;
        this.TaskID = createTaskID(taskName, developer);
        this.Status = Status;
        
        //Designing my pop up box content
        StringBuilder display = new StringBuilder();
        //append, toString...
        display.append("Task Name: ").append(taskName);
        display.append("\nTask Description: ").append(description);
        display.append("\nDeveloper Details: ").append(developer);
        display.append("\nTask Duration: ").append(numTasks);
        display.append("\nTask ID: ").append(TaskID);
        display.append("\nTask Status: ").append(Status);
        
        return display.toString();
    }
    
    //Method  
    public String retrieveStatus(int option)
    { 
        
              switch (option) {
                case 0:
                   Status = "To Do"; 
                break;
                
                case 1:
                    Status = "Doing"; 
                break;
                
                case 2:
                    Status = "Done";
    }
              return  Status;// return status
    }
}
