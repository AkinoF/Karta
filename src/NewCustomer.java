import java.time.LocalDate;

public class NewCustomer extends OldCustomer {
    private String mobilePhone;

    public NewCustomer(String lastName, String firstName, String patronymic, LocalDate birthDate, String mobilePhone) {
        super(lastName, firstName, patronymic, birthDate);
        this.mobilePhone = mobilePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    @Override
    public String toString() {
        return "Новый клиент: " + getFullName() + ", Дата рождения: " + getBirthDate() + ", Телефон: " + mobilePhone;
    }
}