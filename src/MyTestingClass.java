import java.util.Random;

public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        for (int i = 0; i < name.length(); i++) {
            result = 31 * result + name.charAt(i);
        }
        return Math.abs(result);
    }

    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve",
                "Frank", "Grace", "Heidi", "Ivan", "Judy"};

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String name = names[random.nextInt(names.length)];
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student("Student" + i, random.nextInt(100));
            table.put(key, value);
        }

        System.out.println("Elements in each bucket:");
        table.printBucketSizes();
        System.out.println("Total size: " + table.getSize());
    }
}
