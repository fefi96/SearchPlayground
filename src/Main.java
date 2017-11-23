public class Main {

    public static void main(String[] args) {

        final StorageController controller = new StorageController();

        final StringStorage stringStorage = controller.getStringStorage();
        stringStorage.add("Test");
        stringStorage.add("Tannenbaum");
        stringStorage.add("Traktor");

        final PersonStorage personStorage = controller.getPersonStorage();
        personStorage.add(new Person("Torsten", "Mälzer"));
        personStorage.add(new Person("Hans", "Tillmann"));

        System.out.println(controller.search(""));
    }
}
