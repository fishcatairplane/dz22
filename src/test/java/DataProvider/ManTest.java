package DataProvider;

import com.Person.Man;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Person.Woman;

public class ManTest {
    private Man man;

    @DataProvider(name = "personData")
    public Object[][] getPersonData() {
        return new Object[][] {
                { "Petro", "Chaika", 31 },
                { "Ihor", "Shur", 42 },
                // Додайте інші дані про особу тут
        };
    }

    @Test(dataProvider = "personData", description = "Test getter/setter Last name")
    public void testGetSetLastName(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        Assert.assertEquals(man.getLastName(), lastName);
        man.setLastName("Shur");
        Assert.assertEquals(man.getLastName(), "Shur");
    }

    @Test(dataProvider = "personData", description = "Test getter/setter First name")
    public void testGetSetFirstName(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        Assert.assertEquals(man.getFirstName(), firstName);
        man.setFirstName("Ihor");
        Assert.assertEquals(man.getFirstName(), "Ihor");
    }

    @Test(dataProvider = "personData", description = "Test getter/setter Age")
    public void testGetSetAge(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        Assert.assertEquals(man.getAge(), age);
        man.setAge(61);
        Assert.assertEquals(man.getAge(), 61);
    }
    @Test(description = "Test if man is not retired")
    public void testIsRetired() {
        Man man = new Man("Petro", "Chaika", 31);
        Assert.assertFalse(man.isRetired());
    }

    @Test(description = "Test get/set partner")
    public void testGetSetPartner() {
        Man man = new Man("Petro", "Chaika", 31);
        Woman woman = new Woman("Zoe", "Reno", 53);
        Assert.assertNull(man.getPartner());
        man.setPartner(woman);
        Assert.assertEquals(man.getPartner(), woman);
    }
}