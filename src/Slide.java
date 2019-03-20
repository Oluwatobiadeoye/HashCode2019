import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slide {
    public Set<String> tags = new HashSet<>();
    public List<Integer> indexes = new ArrayList<>();

    Slide(Photo photoA) {
        tags.addAll(photoA.tags);
        indexes.add(photoA.index);
    }

    Slide (Photo photoA, Photo photoB) {
        indexes.add(photoA.index);
        indexes.add(photoB.index);
        tags.addAll(photoA.tags);
        tags.addAll(photoB.tags);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index:indexes) {
            stringBuilder.append(index);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
