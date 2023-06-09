package DataProvider;

import com.Person.Man;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Person.Woman;

public class WomanTest {
    private Woman woman;

    @DataProvider(name = "personData")
    public Object[][] getPersonData() {
        return new Object[][] {
                { "Zoe", "Reno", 53 },
                { "Anna", "Smith", 45 },
                // Додайте інші дані про особу тут
        };
    }

    @Test(dataProvider = "personData", description = "Test getter/setter Last name")
    public void testGetSetLastName(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        Assert.assertEquals(woman.getLastName(), lastName);
        woman.setLastName("Davis");
        Assert.assertEquals(woman.getLastName(), "Davis");
    }

    @Test(dataProvider = "personData", description = "Test getter/setter First name")
    public void testGetSetFirstName(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        Assert.assertEquals(woman.getFirstName(), firstName);
        woman.setFirstName("Emma");
        Assert.assertEquals(woman.getFirstName(), "Emma");
    }

    @Test(dataProvider = "personData", description = "Test getter/setter Age")
    public void testGetSetAge(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        Assert.assertEquals(woman.getAge(), age);
        woman.setAge(50);
        Assert.assertEquals(woman.getAge(), 50);
    }

    // Додайте інші тести з використанням провайдера даних

    @Test(description = "Test if woman is retired")
    public void testIsRetired() {
        Woman woman = new Woman("Zoe", "Reno", 53);
        Assert.assertFalse(woman.isRetired());
    }

    @Test(description = "Test get/set partner")
    public void testGetSetPartner() {
        Woman woman = new Woman("Zoe", "Reno", 53);
        Man man = new Man("Petro", "Chaika", 31);
        Assert.assertNull(woman.getPartner());
        woman.setPartner(man);
        Assert.assertEquals(woman.getPartner(), man);
    }

    @Test(description = "Test registering partnership")
    public void testRegisterPartnership() {
        Woman woman = new Woman("Zoe", "Reno", 53);
        Man man = new Man("Petro", "Chaika", 31);
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }

    @Test(description = "Test deregistering partnership with returning girlish last name")
    public void testDeregisterPartnershipReturnGirlishLastName() {
        Woman woman = new Woman("Zoe", "Reno", 53);
        Man man = new Man("Petro", "Chaika", 31);
        woman.registerPartnership(man);
        woman.deregisterPartnership(true);
        Assert.assertEquals(woman.getLastName(), woman.getGirlishLastName());
    }

    @Test(description = "Test deregistering partnership without returning girlish last name")
    public void testDeregisterPartnershipNoReturnGirlishLastName() {
        Woman woman = new Woman("Zoe", "Reno", 53);
        Man man = new Man("Petro", "Chaika", 31);
        woman.registerPartnership(man);
        woman.deregisterPartnership(false);
        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }
}