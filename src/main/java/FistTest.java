public class FistTest {
    String name = "David";

    public void chek() {
        // name = "ffdf";
    }

    public void chek2() {
        name = "Maria";
    }

    public static void main(String[] args) {
        int age;
        boolean isVisible;
        String name = "David";
        String name2 = "David";
        String name3 = new String("David");
        System.out.println(name == name2);
        System.out.println(name == name3);
        System.out.println(name.equals(name3));
    }

}

