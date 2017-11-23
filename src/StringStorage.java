import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringStorage implements StorageManager<String> {

    private final List<String> stringList = new ArrayList<>();

    @Override
    public List<String> find(Predicate<String> predicate) {
        return stringList.stream().parallel().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void add(String value) {
        stringList.add(value);
    }

    @Override
    public void remove(String value) {
        stringList.remove(value);
    }

    @Override
    public void remove(Integer index) {
        stringList.remove(index);
    }
}
