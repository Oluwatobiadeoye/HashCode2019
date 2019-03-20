import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Photo {
        public int type;
        public int index;
        public Set<String> tags;
        Photo (int index, int type) {
            this.index = index;
            this.type = type;
            tags = new HashSet<>();
        }

    @Override
    public String toString() {
        return this.index + " " + type + " "  + tags.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return  true;
        if (! (obj instanceof Photo)) return false;

        Photo photo = (Photo) obj;
        return index == photo.index && Objects.equals(type, photo.type) && Objects.equals(tags, photo.tags);

    }

    @Override
    public int hashCode() {
        return Objects.hash(type,index,tags);
    }
}
