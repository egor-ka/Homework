package test.task5.task5_1;

import org.junit.Before;
import org.junit.Test;
import tasks.task5.task5_1.FileExplorer;
import tasks.task5.task5_1.FileExplorerException;

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

        try {
            fileExplorer.openDirectoryOrFile("Users\\Egor\\IdeaProjects\\Homework\\src\\resources\\task5\\task5_1");
        } catch (FileExplorerException e) {
            assertTrue("Couldn't find existing directory", false);
        }

        //OPEN FILE
        try {
            fileExplorer.openDirectoryOrFile("file.txt");
        } catch (FileExplorerException e) {
            assertTrue("Couldn't open existing file", false);
        }

        //ADD TEXT
        try {
            fileExplorer.writeToCurrentFile("\ntext added using method");
        } catch (FileExplorerException e) {
            assertTrue("Couldn't add text to file", false);
        }
    }

    @Test
    public void createAndDeleteFileTest() {
        System.out.println("createAndDeleteFileTest:");

        fileExplorer.exitToRoot();
        try {
            fileExplorer.openDirectoryOrFile("Users\\Egor\\IdeaProjects\\Homework\\src\\resources\\task5\\task5_1");
        } catch (FileExplorerException e) {
            assertTrue("Couldn't find existing directory", false);
        }
        fileExplorer.printCurrentFileList();

        //CREATE
        try {
            fileExplorer.createFileInCurrDir("file_to_delete.txt");
        } catch (FileExplorerException e) {
            assertTrue("We should be able to create file", false);
        }
        try {
            fileExplorer.createFileInCurrDir("file_to_delete.txt");
            assertTrue("We shouldn't be able to create file(it already exists)", false);
        } catch (FileExplorerException e) {
        }
        fileExplorer.printCurrentFileList();

        //DELETE
        assertTrue("We should be able to delete file(it exists)", fileExplorer.deleteFileInCurrDir("file_to_delete.txt"));
        assertFalse("We shouldn't be able to delete file(it does not exist)", fileExplorer.deleteFileInCurrDir("file_to_delete.txt"));
        fileExplorer.printCurrentFileList();
    }
}