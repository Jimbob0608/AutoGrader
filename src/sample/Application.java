package sample;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private ArrayList idList;
    private long teacherID;
    private long studentID;
    private boolean isTeacher;
    private int scoreCounter;

    protected void ValidId(long id) {
        idReader("teacher-id-list.txt");
        if (idList.contains(id)) {
            new Teacher(32, "Tu Tor", id, true);
        } else {
            idReader("student-id-list.txt");
            if(idList.contains(id)) {
                new Student(21, "Stu Dent", id, false, true);
            }
        }

    }

    private void idReader(String fileName) {
        //String fileName = "teacher-id-list.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                idList.add(line);
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
    }
}
