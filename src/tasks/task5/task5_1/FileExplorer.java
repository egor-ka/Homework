package tasks.task5.task5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Egor on 15.09.2016.
 */
public class FileExplorer {

    private static final String ROOT = "\\";
    private File currentFile;

    public FileExplorer() {
        currentFile = new File(ROOT);
    }

    //File methods throw SecurityException
    // File(path) throws NullPointerException
    public FileExplorer(String path) {
        if (path != null) {
            currentFile = new File(path);
            if (!currentFile.exists()) {
                currentFile = null;
            }
        }
        currentFile = null;
    }

    //File methods throw SecurityException
    public void printCurrentFileList() {
        if (currentFile.isDirectory()) {
            String[] list = currentFile.list();
            System.out.println("Directory " + currentFile.getPath());
            for (String name: list) {
                System.out.println("    " + name);
            }
            System.out.println();
        }
    }

    //File methods throw SecurityException
    public boolean openDirectoryOrFile(String name) {
        File file = (currentFile.getPath().equals(ROOT))
                ? new File(File.separatorChar + name)
                : new File(currentFile.getPath() + File.separatorChar + name);
        if (file.exists()) {
            currentFile = file;
            return true;
        }
        return false;
    }

    public boolean exitToParentFile() {
        if (currentFile.getParentFile() != null) {
            currentFile = currentFile.getParentFile();
            return true;
        }
        return false;
    }

    public void exitToRoot() {
        currentFile = new File(ROOT);
    }

    //File methods throw - SecurityException
    public boolean writeToCurrentFile(String textToAppend) {
        if (currentFile != null) {
            if (currentFile.isFile() && currentFile.canWrite()) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(currentFile, true)) {
                    fileOutputStream.write(textToAppend.getBytes());
                    fileOutputStream.flush();
                    return true;
                } catch (FileNotFoundException e) {
                    System.out.println("Could not found file to write - writeToCurrentFile method");
                    return false;
                } catch (IOException e) {
                    System.out.println("Could not found write to file - writeToCurrentFile method");
                    return false;
                }
            }
        }
        return false;
    }

    // File(path) throws NullPointerException
    public boolean deleteFileInCurrDir(String fileName) {
        if (fileName != null) {
            File file = new File(currentFile.getPath() + File.separatorChar + fileName);
            return file.delete();
        }
        return false;
    }

    // File(path) throws NullPointerException
    public boolean createFileInCurrDir(String fileName) {
        if (fileName != null) {
            File file = new File(currentFile.getPath() + File.separatorChar + fileName);

            try {
                return file.createNewFile();
            } catch (IOException e) {
                System.out.println("Couldn't create file " + file.getPath());
                return false;
            }
        }
        return false;
    }

}
