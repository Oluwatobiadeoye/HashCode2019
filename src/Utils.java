import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    static List<Integer> list ;
    static int compare (Slide A, Slide B) {
        list = new ArrayList<>();
        list.add(Sets.intersection(A.tags, B.tags).size());
        list.add(Sets.difference(A.tags,B.tags).size());
        list.add(Sets.difference(B.tags,A.tags).size());
        return Collections.min(list);
    }
}
