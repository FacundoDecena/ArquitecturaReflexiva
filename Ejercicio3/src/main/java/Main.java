public class Main {
    public static void main(String[] args) {
        System.out.println(Fson.toFson(new objetoRandom()));
    }
}

class objetoRandom {
    public String field1;
    public small field2;
    public big field3;

    objetoRandom() {
        field1 = "asd";
        field2 = new small();
        field3 = new big();
    }
}

class small {
    public int field2_1;
    public float field2_2;

    small() {
        field2_1 = 3;
        field2_2 = 4.2f;
    }
}

class big {
    public small field3_1;
    public float field3_2;
    public String field3_3;

    big() {
        field3_1 = new small();
        field3_2 = 54.3216f;
        field3_3 = "aksndlaksd";
    }
}