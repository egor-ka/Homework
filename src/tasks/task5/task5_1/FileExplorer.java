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

    public boolean openDirectoryOrFile(String name) {
        File file = (currentFile.getPath().equals(ROOT))
                ? new File(File.separatorChar + name)
                : new File(currentFile.getPath() + File.separatorChar + name);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Path is not correct!");
            }
            currentFile = file;
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return false;
        }
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

    public boolean writeToCurrentFile(String textToAppend) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(currentFile, true)) {
            fileOutputStream.write(textToAppend.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.out.println("Could not found file to write!");
            return false;
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("Could not write to file!");
            return false;
        }
    }

    public boolean deleteFileInCurrDir(String fileName) {
        if (fileName != null) {
            File file = new File(currentFile.getPath() + File.separatorChar + fileName);
            return file.delete();
        }
        return false;
    }

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
