package sample;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private long teacherID;
    private long studentID;
    private boolean isTeacher;
    private int scoreCounter;

    public Person ValidId(long id) {
        List<Long> teacherIds = readIdsFromFile("teacher-id-list.txt");
        if (teacherIds.contains(id)) {
            return new Teacher(32, "Tu Tor", id, true);
        } else {
            List<Long> studentIds = readIdsFromFile("student-id-list.txt");
            if(studentIds.contains(id)) {
                return new Student(21, "Stu Dent", id, false, true);
            } else {
                // Return null if the ID is not valid
                return null;
            }
        }
    }

    private List<Long> readIdsFromFile(String fileName) {
        List<Long> ids = new ArrayList();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                ids.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ids;
    }
}
