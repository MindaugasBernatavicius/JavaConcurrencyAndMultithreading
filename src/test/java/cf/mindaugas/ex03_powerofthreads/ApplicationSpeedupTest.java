package cf.mindaugas.ex03_powerofthreads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static cf.mindaugas.ex03_powerofthreads.ApplicationSpeedup.AdderSequential;

public class ApplicationSpeedupTest {

    @Test
    public void sequentialAdder_givenSetOfFiles_calculatesCorrectSumInCertainTime(){
        // given
        // C:\Users\bernam\Desktop\JavaConcurrencyAndMultithreading\target\test-classes\file1.txt
        // C:\Users\bernam\Desktop\JavaConcurrencyAndMultithreading\target\test-classes\cf\mindaugas\ex03_powerofthreads\ApplicationSpeedupTest.class
        // Path currentDir = Paths.get(".");
        // System.out.println(currentDir.toAbsolutePath());

        String projectDir = "./target/test-classes/";
        String[] inFiles = {"file1.txt", "file2.txt"};
        String[] outFiles = {"file1.out.txt", "/file2.out.txt"};
        AdderSequential adder;

        // when
        try {
            // TODO :: add benchmarking code
            for(int i = 0; i < inFiles.length; i++) {
                adder = new AdderSequential(projectDir + inFiles[i], projectDir + outFiles[i]);
                adder.doAdd();
            }
        } catch(IOException e) {
            System.err.println("IOException 1: " + e.getMessage());
        }

        // then
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(projectDir + outFiles[0]))) {
            Assertions.assertEquals("Total: 3", (reader.lines().toArray()[0]).toString());
        } catch(IOException e) {
            System.err.println("IOException 2: " + e.getMessage());
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(projectDir + outFiles[1]))) {
            Assertions.assertEquals("Total: 7", (reader.lines().toArray()[0]).toString());
        } catch(IOException e) {
            System.err.println("IOException 2: " + e.getMessage());
        }
    }


}
