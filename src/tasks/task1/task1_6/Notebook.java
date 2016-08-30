package tasks.task1.task1_6;

/**
 * Created by Egor on 17.08.2016.
 */
public class Notebook {

    static final int DEFAULT_CAPACITY = 50;

    private int capacity;
    private int size;
    public Note[] notes;

    public Notebook(int capacity){
        this.capacity = capacity;
        this.size = 0;
        notes = new Note[capacity];
    }

    public Notebook(){
        this(DEFAULT_CAPACITY);
    }

    public void addNote(String text, String userName){
        Note note = new Note(text, userName);

        if (isFull()){
            if (hasDeletedNotes()){
                swipeDeletedNotes();
            } else {
                resizeNotebook();
            }
        }
        this.notes[size] = note;
        this.size++;
    }

    public void addNote(String text){
        addNote(text, "Unknown writer");
    }

    public void changeNote(Note note, String newText, String newUserName){
        note.setText(newText);
        note.setUserName(newUserName);
    }

    public void changeNote(Note note, String newText){
        changeNote(note, newText);
    }

    public void deleteNote(Note note){
        note.setDeleted(true);
    }

    public void printAllNotes(){
        for (int i = 0; i < this.size; i++) {
            if (!this.notes[i].isDeleted()) {
                notes[i].printNote();
            }
        }
    }

    public boolean isFull(){
        return size == capacity;
    }

    private boolean hasDeletedNotes(){
        for (int i = 0; i < this.size; i++) {
            if (this.notes[i].isDeleted()){
                return true;
            }
        }
        return false;
    }

    private void swipeDeletedNotes(){
        int countDeleted = 0;

        for (int i = 0; i < this.size; i++) {
            if (!this.notes[i].isDeleted()){
                if (countDeleted != 0){
                    this.notes[i - countDeleted] = notes[i];
                    this.size--;
                }
            } else {
                countDeleted++;
            }
        }
    }

    private void resizeNotebook(){
        int newCapacity = this.capacity * 2;
        int newSize = 0;
        int newNotebookIndex = 0;
        Note[] newNotes = new Note[newCapacity];


        for (int i = 0; i < this.size; i++) {
            if (!this.notes[i].isDeleted()){
                newNotes[newNotebookIndex++] = this.notes[i];
                newSize++;
            }
        }
        this.capacity = newCapacity;
        this.size = newSize;
        this.notes = newNotes;
    }

}
