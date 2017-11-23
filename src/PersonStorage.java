import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonStorage implements StorageManager<Person> {

    private final List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> find(Predicate<Person> predicate) {
        return personList.stream().parallel().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void add(Person value) {
        personList.add(value);
    }

    @Override
    public void remove(Person value) {
        personList.remove(value);
    }

    @Override
    public void remove(Integer index) {
        personList.remove(index);
    }
}
