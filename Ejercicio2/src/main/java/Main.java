import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String wantedClass;
        System.out.println("Ingrese una clase");
        wantedClass = input.nextLine();
        input.close();
        try {
            Class<?> c = Class.forName(wantedClass);
            System.out.println(c);

            Field[] publicFields = c.getFields();
            for (Field field : publicFields) {
                String fieldName = field.getName();
                Class<?> typeClass = field.getType();
                System.out.println("Field: " + fieldName + " of type " + typeClass.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Clase invalida");
        }

    }
}

class objetoRandom {
    public String field1;
    public int field2;
}

class small {
    public int field2_1;
    public float field2_2;
}
