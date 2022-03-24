package ultil;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    private final Locale locale = new Locale("en");
    private final Faker faker = new Faker(locale);

    public static DataHelper getData() {
        return new DataHelper();
    }

    public String getFirstname() {
        return faker.address().firstName();
    }

    public String getLastname() {
        return faker.address().lastName();
    }

    public String getCompanyName() {
        return faker.company().name();
    }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getPassword() {
        return faker.internet().password(6, 10);
    }
}
