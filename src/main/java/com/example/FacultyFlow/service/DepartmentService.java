package com.example.FacultyFlow.service;

import com.example.FacultyFlow.model.Department;
import com.example.FacultyFlow.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService{
    private List<com.example.FacultyFlow.model.Department> departments = List.of(
            new Department("Computer Science and Engineering", "CSE", Arrays.asList(
                    new Faculty("Dr. John Doe", "Professor", "johndoe@gmail.com"),
                    new Faculty("Dr. Jane Smith", "Associate Professor", "janesmith@gmail.com"),
                    new Faculty("Dr. Michael White", "Lecturer", "michaelwhite@gmail.com"),
                    new Faculty("Dr. Sarah Johnson", "Assistant Professor", "sarahjohnson@gmail.com"),
                    new Faculty("Dr. David Brown", "Professor", "davidbrown@gmail.com"),
                    new Faculty("Dr. Emily Clark", "Senior Lecturer", "emilyclark@gmail.com"),
                    new Faculty("Dr. Thomas Lee", "Lecturer", "thomaslee@gmail.com")
            )),
            new Department("Electronics and Communication Engineering", "ECE", Arrays.asList(
                    new Faculty("Dr. Alice Brown", "Professor", "alicebrown@gmail.com"),
                    new Faculty("Dr. Robert Wilson", "Lecturer", "robertwilson@gmail.com"),
                    new Faculty("Dr. Richard Taylor", "Assistant Professor", "richardtaylor@gmail.com"),
                    new Faculty("Dr. Sophia Martin", "Professor", "sophiamartin@gmail.com"),
                    new Faculty("Dr. Daniel Scott", "Senior Lecturer", "danielscott@gmail.com"),
                    new Faculty("Dr. Olivia Garcia", "Lecturer", "oliviagarcia@gmail.com"),
                    new Faculty("Dr. William Thomas", "Associate Professor", "williamthomas@gmail.com")
            )),
            new Department("Information Technology", "IT", Arrays.asList(
                    new Faculty("Dr. Henry Adams", "Professor", "henryadams@gmail.com"),
                    new Faculty("Dr. Julia Roberts", "Associate Professor", "juliaroberts@gmail.com"),
                    new Faculty("Dr. Kevin White", "Lecturer", "kevinwhite@gmail.com"),
                    new Faculty("Dr. Lisa Green", "Assistant Professor", "lisagreen@gmail.com"),
                    new Faculty("Dr. Brian Carter", "Senior Lecturer", "briancarter@gmail.com"),
                    new Faculty("Dr. Rachel Lewis", "Professor", "rachellewis@gmail.com"),
                    new Faculty("Dr. Andrew Walker", "Lecturer", "andrewwalker@gmail.com")
            )),
            new Department("Artificial Intelligence and Machine Learning", "AIML", Arrays.asList(
                    new Faculty("Dr. Samuel Adams", "Professor", "samueladams@gmail.com"),
                    new Faculty("Dr. Victoria Hall", "Associate Professor", "victoriahall@gmail.com"),
                    new Faculty("Dr. Nathan Rogers", "Lecturer", "nathanrogers@gmail.com"),
                    new Faculty("Dr. Emma King", "Assistant Professor", "emmaking@gmail.com"),
                    new Faculty("Dr. Jacob Turner", "Senior Lecturer", "jacobturner@gmail.com"),
                    new Faculty("Dr. Megan Scott", "Professor", "meganscott@gmail.com"),
                    new Faculty("Dr. Ethan Ward", "Lecturer", "ethanward@gmail.com")
            )),
            new Department("Computer Science and Management", "CSM", Arrays.asList(
                    new Faculty("Dr. Charles Evans", "Professor", "charlesevans@gmail.com"),
                    new Faculty("Dr. Grace Murphy", "Associate Professor", "gracemurphy@gmail.com"),
                    new Faculty("Dr. Steven Cooper", "Lecturer", "stevencooper@gmail.com"),
                    new Faculty("Dr. Laura Harris", "Assistant Professor", "lauraharris@gmail.com"),
                    new Faculty("Dr. Patrick Wright", "Senior Lecturer", "patrickwright@gmail.com"),
                    new Faculty("Dr. Angela Young", "Professor", "angelayoung@gmail.com"),
                    new Faculty("Dr. Ryan Diaz", "Lecturer", "ryandiaz@gmail.com")
            )),
            new Department("Computer Science and Cyber Security", "CSC", Arrays.asList(
                    new Faculty("Dr. Adam Scott", "Professor", "adamscott@gmail.com"),
                    new Faculty("Dr. Monica Reed", "Associate Professor", "monicareed@gmail.com"),
                    new Faculty("Dr. Jason Parker", "Lecturer", "jasonparker@gmail.com"),
                    new Faculty("Dr. Natalie Bennett", "Assistant Professor", "nataliebennett@gmail.com"),
                    new Faculty("Dr. Christopher Hill", "Senior Lecturer", "christopherhill@gmail.com"),
                    new Faculty("Dr. Olivia Adams", "Professor", "oliviaadams@gmail.com"),
                    new Faculty("Dr. Brandon Moore", "Lecturer", "brandonmoore@gmail.com")
            )),
            new Department("Computer Science and Design", "CSD", Arrays.asList(
                    new Faculty("Dr. James Ford", "Professor", "jamesford@gmail.com"),
                    new Faculty("Dr. Lily Harris", "Associate Professor", "lilyharris@gmail.com"),
                    new Faculty("Dr. Benjamin Lee", "Lecturer", "benjaminlee@gmail.com"),
                    new Faculty("Dr. Amelia Scott", "Assistant Professor", "ameliascott@gmail.com"),
                    new Faculty("Dr. Noah Taylor", "Senior Lecturer", "noahtaylor@gmail.com"),
                    new Faculty("Dr. Ava Clark", "Professor", "avaclark@gmail.com"),
                    new Faculty("Dr. Elijah Walker", "Lecturer", "elijahwalker@gmail.com")
            )),
            new Department("Electrical and Electronics Engineering", "EEE", Arrays.asList(
                    new Faculty("Dr. Harrison Bell", "Professor", "harrisonbell@gmail.com"),
                    new Faculty("Dr. Chloe Adams", "Associate Professor", "chloeadams@gmail.com"),
                    new Faculty("Dr. William Stewart", "Lecturer", "williamstewart@gmail.com"),
                    new Faculty("Dr. Zoe Miller", "Assistant Professor", "zoemiller@gmail.com"),
                    new Faculty("Dr. Lucas Robinson", "Senior Lecturer", "lucasrobinson@gmail.com"),
                    new Faculty("Dr. Isabella Hall", "Professor", "isabellahall@gmail.com"),
                    new Faculty("Dr. Mason Young", "Lecturer", "masonyoung@gmail.com")
            )),
            new Department("Mechanical Engineering", "MECH", Arrays.asList(
                    new Faculty("Dr. Daniel Turner", "Professor", "danielturner@gmail.com"),
                    new Faculty("Dr. Charlotte Green", "Associate Professor", "charlottegreen@gmail.com"),
                    new Faculty("Dr. Christopher Harris", "Lecturer", "christopherharris@gmail.com"),
                    new Faculty("Dr. Emily Lewis", "Assistant Professor", "emilylewis@gmail.com"),
                    new Faculty("Dr. Matthew Evans", "Senior Lecturer", "matthewevans@gmail.com"),
                    new Faculty("Dr. Sophia Wright", "Professor", "sophiawright@gmail.com"),
                    new Faculty("Dr. Jacob Allen", "Lecturer", "jacoballen@gmail.com")
            )),
            new Department("Computer Science and Information Technology", "CSIT", Arrays.asList(
                    new Faculty("Dr. Oliver Mitchell", "Professor", "olivermitchell@gmail.com"),
                    new Faculty("Dr. Emma Harris", "Associate Professor", "emmaharris@gmail.com"),
                    new Faculty("Dr. Ethan Lewis", "Lecturer", "ethanlewis@gmail.com"),
                    new Faculty("Dr. Isabella Parker", "Assistant Professor", "isabellaparker@gmail.com"),
                    new Faculty("Dr. James Robinson", "Senior Lecturer", "jamesrobinson@gmail.com"),
                    new Faculty("Dr. Amelia Thompson", "Professor", "ameliathompson@gmail.com"),
                    new Faculty("Dr. Benjamin Martinez", "Lecturer", "benjaminmartinez@gmail.com")
            ))
    );





    public List<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartmentByCode(String code) {
        return departments.stream()
                .filter(dept -> dept.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
