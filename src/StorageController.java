import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StorageController {

    private final StorageManager[] storageManagers = new StorageManager[2];

    private final short stringIndex = 0, personIndex = 1;

    public StorageController() {
        storageManagers[stringIndex] = new StringStorage();
        storageManagers[personIndex] = new PersonStorage();
    }

    public StringStorage getStringStorage() {
        if (storageManagers[stringIndex] instanceof StringStorage) {
            return (StringStorage) storageManagers[stringIndex];
        }
        return null;
    }

    public PersonStorage getPersonStorage() {
        if (storageManagers[personIndex] instanceof PersonStorage) {
            return (PersonStorage) storageManagers[personIndex];
        }
        return null;
    }

    public List<Object> search(final String searchKey) {

        final String formattedKey = searchKey.toLowerCase().trim();

        final List<Object> resultList = new ArrayList<>();

        Arrays.stream(storageManagers).parallel().forEach(storageManager -> {
            if (storageManager instanceof PersonStorage) {
                // Searches for persons with the specified key!
                final String[] strings = formattedKey.split(" ");
                final Predicate<Person> key = p -> p.getFirstName().toLowerCase().contains(strings[0]) || p.getLastName().toLowerCase().contains(strings[0]);
                resultList.addAll(((PersonStorage) storageManager).find(key));

            } else if (storageManager instanceof StringStorage) {
                // Searches for strings with the specified key!
                final Predicate<String> key = s -> s.toLowerCase().contains(formattedKey);
                resultList.addAll(((StringStorage) storageManager).find(key));

            } else {

                throw new NoSuchElementException("No valid Storage!");

            }
        });

        return resultList;
    }
}
