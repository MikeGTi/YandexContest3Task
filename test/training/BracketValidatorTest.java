package training;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BracketValidatorTest {

    @Test
    public void shouldReturnAssertTrue(){
        Assertions.assertTrue(new BracketValidator('(',')').validate("((A)+B)*(C/(A-D))"));
    }

    @Test
    public void shouldReturnAssertFalse(){
        Assertions.assertFalse(new BracketValidator('(',')').validate("((A)+B)*)(C/(A-D))"));
        Assertions.assertFalse(new BracketValidator('(',')').validate(")((A)+B)*)(C/(A-D))"));
    }
}
