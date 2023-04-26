package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a file processor that is responsible for comparing a submitted file with a mark scheme
 * and resulting in results as well as checking for valid student id's.
 */

public class FileProcessor {

    // A counter to store the score of the work in the process of being marked.
    private int scoreCounter;

    // A double to represent the score of the user as a percentage.
    private double scorePercentage;

    // Strings to represent the file paths of various resources required.
    private String markSchemePath = "C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\mark-scheme-example";
    private String teacherIdListPath = "C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\teacher-id-list";
    private String studentIdListPath = "C:\\Users\\jamie\\IdeaProjects\\AutoGrader\\src\\sample\\Resources\\student-id-list";

    /**
     * This method takes a file name as input and reads two lists from files. It then compares the
     * corresponding elements of the lists and increments a counter for every match, which is
     * returned as the final score.
     *
     * @param fileName the name of the file to be compared with the mark scheme file.
     * @return the score calculated based on the comparison of the files.
     */
    public int submissionCalculator(String fileName) {
        scoreCounter = 0;
        List<String> markSchemeList = new ArrayList<String>();
        List<String> submissionList = new ArrayList<String>();
        markSchemeList = readFromFile(markSchemePath);
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

    /**
     * @returns the size of the mark scheme file by reading it from the file system and
     * returning the size of the resulting list.
     */
    public int markSchemeSize() {
        return readFromFile(markSchemePath).size();
    }

    /**
     * Calculates the percentage score of a submission, given the achieved score and the maximum possible score.
     *
     * @param score    The achieved score.
     * @param maxScore The maximum possible score.
     * @return The percentage score as an integer value.
     */
    public int submissionPercentageCalculator(int score, int maxScore) {
        scorePercentage = ((double) score / maxScore) * 100;
        return (int) scorePercentage;
    }

    /**
     * Checks if the given ID is valid and returns a corresponding Person object.
     *
     * @param id the ID to be checked.
     * @return a Person object corresponding to the ID, or null if the ID is invalid.
     */
    public Person ValidId(long id) {
        // Read the teacher ID list and check if the ID belongs to a teacher.
        List<Long> teacherIds = convertToIdList(readFromFile(teacherIdListPath));
        if (teacherIds.contains(id)) {
            return new Teacher(32, "Tu Tor", id, true);
        } else {
            // Read the student ID list and check if the ID belongs to a student.
            List<Long> studentIds = convertToIdList(readFromFile(studentIdListPath));
            if (studentIds.contains(id) && id < studentIds.get(14)) {
                return new Student(21, "Stu Dent", false, id);
            } else if (studentIds.contains(id) && id > studentIds.get(14)) {
                return new Student(20, "Leah Ner", false, id);
            } else {
                // Return null if the ID is not valid.
                return null;
            }
        }
    }

    /**
     * Determines if a given ID belongs to a valid teacher.
     *
     * @param id The ID to check for validity.
     * @return true if the ID belongs to a valid teacher, false otherwise.
     */
    public boolean isValidTeacherID(long id) {
        List<Long> teacherIds = convertToIdList(readFromFile(teacherIdListPath));
        if (teacherIds.contains(id)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the given ID belongs to a valid student.
     *
     * @param id the ID to be checked.
     * @return true if the ID is valid for a student, false otherwise.
     */
    public boolean isValidStudentID(long id) {
        List<Long> studentIds = convertToIdList(readFromFile(studentIdListPath));
        if (studentIds.contains(id) && id < studentIds.get(14)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Reads the contents of a file and returns them as a list of strings.
     *
     * @param fileName the name of the file to be read.
     * @return a list of strings containing the contents of the file.
     */
    private List<String> readFromFile(String fileName) {
        // Initialize a list to store the lines read from the file.
        List<String> lines = new ArrayList();
        // Initialize the buffered reader with the given file name.
        BufferedReader reader = null;
        try {
            // Read the file line by line and store each line in the list.
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            // If there is an error reading from the file, print the stack trace.
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

    /**
     * Converts a list of strings representing IDs to a list of Long integers.
     *
     * @param fileContents the list of strings representing IDs.
     * @return the list of Long integers.
     */
    private List<Long> convertToIdList(List<String> fileContents) {
        List<Long> idList = new ArrayList<Long>();
        for (String element : fileContents) {
            idList.add(Long.parseLong(element));
        }
        return idList;
    }
}