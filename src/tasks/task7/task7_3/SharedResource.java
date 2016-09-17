package tasks.task7.task7_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 17.09.2016.
 */
public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<Integer>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}
