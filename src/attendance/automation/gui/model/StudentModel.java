/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui.model;

import attendance.automation.BLL.BLLManager;
import attendance.automation.be.Student;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Charlotte
 */
public class StudentModel {
    
        private final  String monday = "Monday";
        private final  String tuesday = "Tuesday";
        private final  String wednesday = "Wednesday";
        private final  String thursday = "Thursday";
        private final  String friday = "Friday";
        private List<Student> listofStudents;
        private BLLManager bll;
        
       public StudentModel(){
        bll = new BLLManager();
       
        listofStudents = bll.getStudentList();
  
       
       } 
        
    public Student getoneStudent(String username, String password){
        
        for (Student student : listofStudents)
        {
             if(student.getUsername().equals(username) && student.getPassword().equals(password) ){
             
                 return student;
                 
             }
        }
        
        return null;     
 
    }
    
       
    public ObservableList<PieChart.Data> setPiechartData(){
        
       ObservableList<PieChart.Data> pieChartData =   FXCollections.observableArrayList(
        new PieChart.Data("Presence", 48),
        new PieChart.Data("Absent", 52));  
        

        
        return pieChartData;
        
    }
    
 
    
    public XYChart.Series setPresence(){

        XYChart.Series presence = new XYChart.Series<>();

        presence.setName("Presence");
        presence.getData().add(new XYChart.Data(monday, 5));
        presence.getData().add(new XYChart.Data(tuesday, 4));
        presence.getData().add(new XYChart.Data(wednesday, 8));
        presence.getData().add(new XYChart.Data(thursday, 3));
        presence.getData().add(new XYChart.Data(friday, 2));

    
        
        return presence;
    }
    
     public XYChart.Series setAbsent(){
    
        XYChart.Series absent = new XYChart.Series<>();

        absent.setName("Absent");
        absent.getData().add(new XYChart.Data(monday, 3));
        absent.getData().add(new XYChart.Data(tuesday, 2));
        absent.getData().add(new XYChart.Data(wednesday, 1));
        absent.getData().add(new XYChart.Data(thursday, 0));
        absent.getData().add(new XYChart.Data(friday, 10));
        
        return absent;
    }
}
