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

    public boolean openDirectoryOrFile(String name) throws FileExplorerException {
        File file = (currentFile.getPath().equals(ROOT))
                ? new File(File.separatorChar + name)
                : new File(currentFile.getPath() + File.separatorChar + name);
        if (!file.exists()) {
            throw new FileExplorerException("Path is not correct!");
        }
        currentFile = file;
        return true;
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

    public boolean writeToCurrentFile(String textToAppend) throws FileExplorerException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(currentFile, true)) {
            fileOutputStream.write(textToAppend.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (FileNotFoundException e) {
            throw new FileExplorerException("Could not found file to write!");
        } catch (IOException e) {
            throw new FileExplorerException("Could not write to file!");
        }
    }

    public boolean deleteFileInCurrDir(String fileName) {
        if (fileName != null) {
            File file = new File(currentFile.getPath() + File.separatorChar + fileName);
            return file.delete();
        }
        return false;
    }

    public boolean createFileInCurrDir(String fileName) throws FileExplorerException {
        if (fileName != null) {
            File file = new File(currentFile.getPath() + File.separatorChar + fileName);

            try {
                if (file.createNewFile()) {
                    return true;
                }
                throw new FileExplorerException("Couldn't create file " + file.getPath());
            } catch (IOException e) {
                throw new FileExplorerException("Couldn't create file - IOException");
            }
        }
        return false;
    }
}
