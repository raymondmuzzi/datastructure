package com.raymond.set;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author raymondmuzzi
 * @date 2020-05-05 13:36:38
 */
public class FileOperation {
    public static boolean readFile(String fileName, Set<String> set) {
        if (null == fileName || "".equalsIgnoreCase(fileName) || null == set) {
            System.out.println("Filename is blank or words is null");
            return false;
        }

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
                            if (!Character.isLetter(word.charAt(word.length() - 1))) {
                                word = word.substring(0, word.length() - 1);
                            }
                            set.add(word.trim().toLowerCase());
                        }
                    }
                }
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static boolean readFile(String fileName, List<String> set) {
        if (null == fileName || "".equalsIgnoreCase(fileName) || null == set) {
            System.out.println("Filename is blank or words is null");
            return false;
        }

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
                            if (!Character.isLetter(word.charAt(word.length() - 1))) {
                                word = word.substring(0, word.length() - 1);
                            }
                            set.add(word.trim().toLowerCase());
                        }
                    }
                }
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
