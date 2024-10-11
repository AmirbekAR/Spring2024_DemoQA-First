package demoqa.data;
import com.github.javafaker.Faker;
import demoqa.entities.TextBox;

public class MockDataGenerator { // этот класс нам будет отвечать чтобы он нам давал какие-то случайные данные
    // то-есть генерирует случайные данные

    private static Faker faker = new Faker();

    public static String randomFullName() {
        return faker.name().fullName();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomAddress() {
        return faker.address().fullAddress();
    }

    public static TextBox randomTextBox() {
        String fullName = randomFullName();
        String email = randomEmail();
        String currentAddress = randomAddress();
        String permanentAddress = randomAddress();
        TextBox textBox = new TextBox(fullName, email, currentAddress, permanentAddress);
        return textBox;

    }
}

