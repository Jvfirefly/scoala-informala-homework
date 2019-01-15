import java.util.Objects;

public class Test {
    private String name;
    private int age = 17;

    public Test() {
        this.name = "no name";
    }

    public Test(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        this.name = name;
    }

    public static void main(String[] args) {
//      aceeasi adr de memorie
        Test t = new Test();
        Test t1 = t;
        System.out.println(t == t1);

//      adr de memo diferite => folosim equals()
        Test t2 = new Test("Daniel");
        Test t3 = new Test("Daniel");
        System.out.println(t2 == t3);
        System.out.println(t2.equals(t3));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) {
            System.out.println("Object is null");
            return false;
        }
        if (this.getClass() != o.getClass()) {
            System.out.println("Object is of diffrent class");
            return false;
        }
        Test test = (Test) o; //down-casting
        return
                this.name.equals(test.name) && this.age == test.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
/*public static void main(String[] args) {
        System.out.println("Test.");
    }*/
}
