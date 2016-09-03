package tasks.task2.task2_5;

/**
 * Created by Egor on 04.09.2016.
 */
public class Discipline<MarkType>{

    private DisciplineName disciplineName;

    public Discipline(DisciplineName disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Group createGroup(){
        return new Group<MarkType>();
    }

    public DisciplineName getDisciplineName() {
        return disciplineName;
    }
}
