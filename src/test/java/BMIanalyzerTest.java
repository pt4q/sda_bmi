import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JUnitParamsRunner.class)
public class BMIanalyzerTest {

    BMIanalyzer bmiAnalyzer;

    @Before
    public void setUp() {
        bmiAnalyzer = new BMIanalyzer();
    }

    @Test
    @Parameters(method = "testMethodToCheckIfPersonHasMalnuration")
    public void checkIfPersonHasMalnutrition(Gender gender, double bmi, boolean expected) {
        assertThat(bmiAnalyzer.checkIfMalnuration(gender, bmi), is(expected));
    }

    private Object[] testMethodToCheckIfPersonHasMalnuration() {
        return new Object[]{
                new Object[]{Gender.MALE, 21, false},
                new Object[]{Gender.MALE, 20.99, true},
                new Object[]{Gender.MALE, 18, true},
                new Object[]{Gender.MALE, 15, true},
                new Object[]{Gender.MALE, 15.01, true},

                new Object[]{Gender.FEMALE, 19, false},
                new Object[]{Gender.FEMALE, 18.99, true},
                new Object[]{Gender.FEMALE, 16, true},
                new Object[]{Gender.FEMALE, 13, true},
                new Object[]{Gender.FEMALE, 12.99, true},
        };
    }

    @Test
    @Parameters(method = "testMethodToCheckIfPersonHasTheCorrectWeight")
    public void checkIfPersonHasTheCorrectWeight(Gender gender, double bmi, boolean expected) {
        assertThat(bmiAnalyzer.checkIfCorrectWeight(gender, bmi), is(expected));
    }

    private Object[] testMethodToCheckIfPersonHasTheCorrectWeight() {
        return new Object[]{
                new Object[]{Gender.MALE, 20.99, false},
                new Object[]{Gender.MALE, 21, true},
                new Object[]{Gender.MALE, 23, true},
                new Object[]{Gender.MALE, 25, true},
                new Object[]{Gender.MALE, 25.01, false},

                new Object[]{Gender.FEMALE, 18.99, false},
                new Object[]{Gender.FEMALE, 19, true},
                new Object[]{Gender.FEMALE, 21, true},
                new Object[]{Gender.FEMALE, 23, true},
                new Object[]{Gender.FEMALE, 24, false},
        };
    }

    @Test
    @Parameters(method = "testMethodToCheckIfPersonIsOverweight")
    public void checkIfPersonIsOverweight(double growth, double weight, boolean expected) {

    }

    private Object[] testMethodToCheckIfPersonIsOverweight() {
        return new Object[]{
                new Object[]{1.73, 1.73, true}
        };
    }
}
