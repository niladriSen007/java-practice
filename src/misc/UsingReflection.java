package misc;

import java.lang.reflect.Field;

public class UsingReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final int secret = 42;
        Field field = UsingReflection.class.getDeclaredField("secret");
        field.setAccessible(true);
        field.setInt(null, 99); // Trying to change the value
        System.out.println(secret);
    }
}
