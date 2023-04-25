package sample;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private long teacherID;
    private long studentID;
    private boolean isTeacher;
    private int scoreCounter;
    private double scorePercentage;

    private int submissionCalculator () {
        List<String> markSchemeList = null;
        List<String> submissionList = null;
        markSchemeList = readFromFile("mark-scheme-example.txt");
        submissionList = readFromFile("fail-submission-example.txt");
        for (String element: markSchemeList) {
            if (element.matches(submissionList.get(markSchemeList.indexOf(element)))) {
                scoreCounter += 1;
            }
        }
        submissionPercentageCalculator(scoreCounter, markSchemeList.size());
        return scoreCounter;
    }

    private double submissionPercentageCalculator(int score, int maxScore) {
        return (score/maxScore) * 100;
    }

    protected Person ValidId(long id) {
        List<Long> teacherIds = convertToIdList(readFromFile("teacher-id-list.txt"));
        if (teacherIds.contains(id)) {
            return new Teacher(32, "Tu Tor", id, true);
        } else {
            List<Long> studentIds = convertToIdList(readFromFile("student-id-list.txt"));
            if(studentIds.contains(id)) {
                return new Student(21, "Stu Dent", id, false, true);
            } else {
                // Return null if the ID is not valid
                return null;
            }
        }
    }

    private List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
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
        return lines;
    }

    private List<Long> convertToIdList(List<String> fileContents) {
        List<Long> idList = null;
        for (String element : fileContents) {
            idList.add(Long.parseLong(element));
        }
    }
}
