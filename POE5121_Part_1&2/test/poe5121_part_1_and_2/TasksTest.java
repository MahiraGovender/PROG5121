
package poe5121_part_1_and_2;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TasksTest {
    
    public TasksTest() {
    }

    @Test
    public void testSetTotalTasks() {
    }

    @Test
    public void testGetTotalTasks() {
    }

    @Test
    public void testTask() {
    }

    @Test
    public void testTaskDetails() {
    }

    @Test
    public void testReturnTotalHoursTask1And2() {
    Tasks task1And2 = new Tasks();
    
    Tasks.setTotalTasks(0);
    double actual = task1And2.ReturnTotalHours(8 + 10);
    double expected = 18;
    
    assertEquals(expected, actual);
    }
    
    @Test
    public void testReturnTotalHoursAdditionalTask() {
    Tasks taskAdditional = new Tasks();
    
    Tasks.setTotalTasks(0);
    double actual = taskAdditional.ReturnTotalHours(10 + 12 + 55 + 11 + 1);
    double expected = 89;
    
    assertEquals(expected, actual);
    }

    @Test
    public void testCreateTaskI0() {
    Tasks taskCR1 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Like Mike";
    
    String actual = taskCR1.createTaskID(taskName, developer);
    String expected = "CR:0:IKE";
    
    assertEquals(expected, actual);
    
    }

    @Test
    public void testCreateTaskID1() {
    Tasks taskCR2 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Harry Bard";
    
    String actual = taskCR2.createTaskID(taskName, developer);
    String expected = "CR:1:ARD";
    
    assertEquals(expected, actual);
    
    }

    @Test
    public void testCreateTaskID2() {
    Tasks taskCR3 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Aggi Roatha";
    
    String actual = taskCR3.createTaskID(taskName, developer);
    String expected = "CR:2:THA";
    
    assertEquals(expected, actual);
    
    }

    @Test
    public void testCreateTaskID3() {
    Tasks taskCR4 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Mone Nd";
    
    String actual = taskCR4.createTaskID(taskName, developer);
    String expected = "CR:3: ND";
    
    assertEquals(expected, actual);
    
    }
    
    @Test
    public void testcheckTaskDescriptionTask1Success() {
    Tasks task1 = new Tasks();
    
    boolean actual = task1.checkTaskDescription("Create Login to authenticate users");
    String message = "Task successfully captured";
    
    assertTrue(actual);
    assertEquals(true, actual, message);
    }
    
    @Test
    public void testcheckTaskDescriptionTask2Success() {
    Tasks task2 = new Tasks();
    
    boolean actual = task2.checkTaskDescription("Create Add Task feature to add task users");
    String message = "Task successfully captured";
    
    assertTrue(actual);
    assertEquals(true, actual, message);
    }
    
    @Test
    public void testcheckTaskDescriptionTask1Failure() {
    Tasks task1 = new Tasks();
    
    boolean actual = task1.checkTaskDescription(" ");
    String message = "Please enter a task description of less than 50 charcters";
    
    assertFalse(actual);
    assertEquals(false, actual, message);
    }
    
    @Test
    public void testcheckTaskDescriptionTask2Failure() {
    Tasks task2 = new Tasks();
    
    boolean actual = task2.checkTaskDescription("""
    123456789012345678901234567890123456789012345678901""");
    String message = "Please enter a task description of less than 50 charcters";
    
    assertFalse(actual);
    assertEquals(false, actual, message);
    }
   

    @Test
    public void testPrintTaskDetailsTask1() {
    Tasks task1 = new Tasks();
        
    String taskName = "Add Task Feature";
    String description = "Create Add Task feature to add task users";
    String developer = "Robyn Harrison";
    double numTasks = 8;
    String Status = "To Do";
    
    Tasks.setTaskNumber(-1);
    
    String actual = task1.printTaskDetails(taskName, description, developer, numTasks, Status);
    Tasks.setTaskNumber(-1);
    String expected = task1.printTaskDetails("Add Task Feature", "Create Add Task feature to add task users"
            , "Robyn Harrison", 8, "To Do");
    
    assertEquals(expected, actual);
    }
    
    @Test
    public void testPrintTaskDetailsTask2() {
    Tasks task2 = new Tasks();
        
    String taskName = "Add Task Feature";
    String description = "Create Add Task feature to add task users";
    String developer = "Mike Smith";
    double numTasks = 10;
    String Status = "Doing";
    
    String actual = task2.printTaskDetails(taskName, description, developer, numTasks, Status);
    Tasks.setTaskNumber(0);
    String expected = task2.printTaskDetails("Add Task Feature", "Create Add Task feature to add task users"
            , "Mike Smith", 10, "Doing");
    
     assertEquals(expected, actual);
    }
    
   @Test
    public void testRetrieveStatus() {
    }
    
}
