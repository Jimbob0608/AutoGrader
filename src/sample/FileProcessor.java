package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private long teacherID;
    private long studentID;
    private boolean isTeacher;
    private int scoreCounter;
    private double scorePercentage;

    /***
     *
     * @return
     */
    public int submissionCalculator(String fileName) {
        scoreCounter = 0;
        List<String> markSchemeList = new ArrayList<String>();
        List<String> submissionList = new ArrayList<String>();
        markSchemeList = readFromFile("C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\mark-scheme-example");
        submissionList = readFromFile(fileName);
        int counter = 0;
        for (String element : markSchemeList) {
            if (element.matches(submissionList.get(counter))) {
                scoreCounter += 1;
            }
            counter++;
        }
        return scoreCounter;
    }

    public int markSchemeSize() {
        return readFromFile("C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\mark-scheme-example").size();
    }

    public int submissionPercentageCalculator(int score, int maxScore) {
        scorePercentage = ((double) score / maxScore) * 100;
        return (int) scorePercentage;
    }

    public Person ValidId(long id) {
        List<Long> teacherIds = convertToIdList(readFromFile("C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\" +
                "sample\\Resources\\teacher-id-list"));
        if (teacherIds.contains(id)) {
            return new Teacher(32, "Tu Tor", id, true);
        } else {
            List<Long> studentIds = convertToIdList(readFromFile("C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\" +
                    "sample\\Resources\\student-id-list"));
            if (studentIds.contains(id) && id < studentIds.get(14)) {
                return new Student(21, "Stu Dent", false, id);
            } else if (studentIds.contains(id) && id > studentIds.get(14)) {
                return new Student(20, "Leah Ner", false, id);
            } else {
                // Return null if the ID is not valid
                return null;
            }
        }
    }

    public boolean isValidTeacherID(long id) {
        List<Long> teacherIds = convertToIdList(readFromFile("C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\teacher-id-list"));
        if (teacherIds.contains(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidStudentID(long id) {
        List<Long> studentIds = convertToIdList(readFromFile("C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\student-id-list"));
        if (studentIds.contains(id) && id < studentIds.get(14)) {
            return true;
        } else {
            return false;
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
        List<Long> idList = new ArrayList<Long>();
        for (String element : fileContents) {
            idList.add(Long.parseLong(element));
        }
        return idList;
    }
}