import java.util.List;
import java.util.function.Predicate;

public interface StorageManager<T> {

    List<T> find(Predicate<T> predicate);

    void add(T value);

    void remove(T value);

    void remove(Integer index);

}
