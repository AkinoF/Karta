import java.time.LocalDate;

public class OldCustomer {
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate birthDate;

    public OldCustomer(String lastName, String firstName, String patronymic, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Старый клиент: " + getFullName() + ", Дата рождения: " + birthDate;
    }
}