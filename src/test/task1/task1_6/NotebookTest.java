package test.task1.task1_6;

import org.junit.Test;
import tasks.task1.task1_6.Notebook;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 17.08.2016.
 */
public class NotebookTest {

    Notebook notebook = new Notebook(4);

    @Test
    public void isFullTest(){
        fillNotebook();

        assertEquals("Notebook should be full", true, notebook.isFull());
        notebook.printAllNotes();
    }

    @Test
    public void deleteTest(){
        notebook.deleteNote(notebook.notes[2]);
        assertEquals("Note should be deleted", true, notebook.notes[2].isDeleted());
        notebook.printAllNotes();
    }

    //add new note when notebook is full but there are deleted notes
    //(we wipe deleted notes out and put new notes in obtained space)
    @Test
    public void swipeDeletedNotesTest(){
        notebook.addNote("note 5", "Egor");
        assertEquals("Notebook should be full", true, notebook.isFull());
        System.out.println();
        notebook.printAllNotes();
    }

    @Test
    public void resizeNotebookTest(){
        notebook.addNote("note 6", "Egor");
        assertEquals("Notebook is full but shouldn't be!", false, notebook.isFull());
        System.out.println();
        notebook.printAllNotes();
    }

    private void fillNotebook(){
        notebook.addNote("note 0", "Egor");
        notebook.addNote("note 1", "Egor");
        notebook.addNote("note 2", "Egor");
        notebook.addNote("note 3", "Egor");
    }
}
