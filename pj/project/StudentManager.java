package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


 

public class StudentManager 
{
    private List<Student> studentList;
     
    public StudentManager()
     {
    	 studentList=new ArrayList<>();
     }
     
     public void add(Student student)
     {
    	 studentList.add(student);
    	 
     }
     
     public List<Student> getstudent()
     {
    	 return studentList;
     }
     
     public void delete(int id) {
         Student student = null;
         int size = studentList.size();
         for (int i = 0; i < size; i++) {
             if (studentList.get(i).getId() == id) {
                 student = studentList.get(i);
                 break;
             }
         }
         if (student != null) {
             studentList.remove(student);
         } else {
             System.out.printf("id = %d not existed.\n", id);
         }
     }

public void edit(int id, String name, String address, float gpa) {
    boolean isExisted = false;
    int size = studentList.size();
    for (int i = 0; i < size; i++) {
        if (studentList.get(i).getId() == id) {
            isExisted = true;
            studentList.get(i).setName(name);
            studentList.get(i).setId(id);
            studentList.get(i).setAddress(address);
            studentList.get(i).setGpa(gpa);
            break;
        }
    }
    if (!isExisted) {
        System.out.printf("id = %d not existed.\n", id);
    } else {
 
    }
}


/**
 * sort student by id
 */
public void sortStudentByName() {
    Collections.sort(studentList, new SortStudentByName());
}

public void sortStudentByGPA() {
    Collections.sort(studentList, new SortStudentByGPA());
}
}


