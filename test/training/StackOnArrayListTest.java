package training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StackOnArrayListTest {

    private static final int capacity = 17;

    private static StackOnArrayList<Integer> intStack = new StackOnArrayList<>();

    private static StackOnArrayList<String> stringStack = new StackOnArrayList<>();

    @Test
    public void shouldReturnIntegerStackEmptyTrue(){
        intStack.clean();
        Assertions.assertTrue(intStack.isEmpty());
        Assertions.assertTrue(intStack.size()==0);
    }

    @Test
    public void shouldReturnStringStackEmptyTrue(){
        stringStack.clean();
        Assertions.assertTrue(stringStack.isEmpty());
        Assertions.assertTrue(stringStack.size()==0);
    }

    @Test
    public void shouldReturnIntegerStackSizeEqual(){
        intStack.clean();
        fillIntegerStack();
        Assertions.assertFalse(intStack.isEmpty());
        Assertions.assertEquals(intStack.size(), capacity);
    }

    @Test
    public void shouldReturnStringStackSizeEqual(){
        stringStack.clean();
        fillStringStack();
        Assertions.assertFalse(stringStack.isEmpty());
        Assertions.assertEquals(stringStack.size(), capacity);
    }

    @Test
    public void shouldReturnIntegerStackPushPop(){
        intStack.clean();
        fillIntegerStack();
        Assertions.assertEquals(capacity, (int) intStack.size());

        intStack.clean();
        Assertions.assertTrue(intStack.isEmpty());
    }

    @Test
    public void shouldReturnStringStackPushPop(){
        stringStack.clean();
        fillStringStack();
        Assertions.assertEquals(capacity, (int) stringStack.size());

        stringStack.clean();
        Assertions.assertTrue(stringStack.isEmpty());
    }

    public static void fillIntegerStack(){
        for (int i = 1; i <= capacity; i++) {
            intStack.push(i);
        }
    }

    public static void fillStringStack(){
        for (int i = 1; i <= capacity; i++) {
            stringStack.push(Integer.toString(i));
        }
    }
}
