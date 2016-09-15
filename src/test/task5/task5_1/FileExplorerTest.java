package test.task5.task5_1;

import org.junit.Before;
import org.junit.Test;
import tasks.task5.task5_1.FileExplorer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Egor on 15.09.2016.
 */
public class FileExplorerTest {

    FileExplorer fileExplorer;

    @Before
    public void setUp() {
        fileExplorer = new FileExplorer();
    }

    @Test
    public void exitToParentFileTest() {
        System.out.println("exitToParentFileTest:");
        assertFalse("We are in root! There is no parent!", fileExplorer.exitToParentFile());
    }

    @Test
    public void writeToCurrentFileTest() {
        System.out.println("writeToCurrentFileTest:");

        fileExplorer.exitToRoot();
        assertTrue("Couldn't find existing directory", fileExplorer.openDirectoryOrFile("Users\\Egor\\IdeaProjects\\Homework\\src\\resources\\task5\\task5_1"));

        //OPEN FILE
        assertTrue("Couldn't open existing file", fileExplorer.openDirectoryOrFile("file.txt"));

        //ADD TEXT
        assertTrue("Couldn't add text to file", fileExplorer.writeToCurrentFile("\ntext added using method"));
    }

    @Test
    public void createAndDeleteFileTest() {
        System.out.println("createAndDeleteFileTest:");

        fileExplorer.exitToRoot();
        assertTrue("Couldn't find existing directory", fileExplorer.openDirectoryOrFile("Users\\Egor\\IdeaProjects\\Homework\\src\\resources\\task5\\task5_1"));
        fileExplorer.printCurrentFileList();

        //CREATE
        assertTrue("We should be able to create file", fileExplorer.createFileInCurrDir("file_to_delete.txt"));
        assertFalse("We shouldn't be able to create file(it already exists)", fileExplorer.createFileInCurrDir("file_to_delete.txt"));
        fileExplorer.printCurrentFileList();

        //DELETE
        assertTrue("We should be able to delete file(it exists)", fileExplorer.deleteFileInCurrDir("file_to_delete.txt"));
        assertFalse("We shouldn't be able to delete file(it does not exist)", fileExplorer.deleteFileInCurrDir("file_to_delete.txt"));
        fileExplorer.printCurrentFileList();
    }
}
