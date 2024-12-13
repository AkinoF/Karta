import java.time.LocalDate;
import java.util.*;
public class Karta {
    public static void main(String[] args) {
        List<OldCustomer> shoppers = new ArrayList<>();

        // Добавление старых клиентов
        shoppers.add(new OldCustomer("Иванов", "Иван", "Иванович", LocalDate.of(1985, 5, 15)));
        shoppers.add(new OldCustomer("Петров", "Петр", "Петрович", LocalDate.of(1990, 3, 20)));

        // Добавление новых клиентов
        shoppers.add(new NewCustomer("Смирнов", "Сергей", "Сергеевич", LocalDate.of(1995, 7, 30), "1234567890"));
        shoppers.add(new NewCustomer("Кузнецова", "Анастасия", "Алексеевна", LocalDate.of(1988, 12, 10), "0987654321"));

        // Вывод всей информации о клиентах
        System.out.println("Информация о покупателях:");
        for (OldCustomer shopper : shoppers) {
            System.out.println(shopper);
        }

        // Поиск номера телефона по ФИО
        String searchLastName = "Смирнов";
        String searchFirstName = "Сергей";
        String searchPatronymic = "Сергеевич";

        Optional<String> phoneNumber = findPhoneNumber(shoppers, searchLastName, searchFirstName, searchPatronymic);
        if (phoneNumber.isPresent()) {
            System.out.println("Номер телефона для " + searchLastName + " " + searchFirstName + " " + searchPatronymic + ": " + phoneNumber.get());
        } else {
            System.out.println("Клиент не найден.");
        }

        // Вывод полной информации о новых записях
        System.out.println("\nПолная информация о новых записях:");
        for (OldCustomer shopper : shoppers) {
            if (shopper instanceof NewCustomer) {
                System.out.println(shopper);
            }
        }

        // Подсчет старых и новых записей
        long oldCount = shoppers.stream().filter(shopper -> shopper instanceof OldCustomer && !(shopper instanceof NewCustomer)).count();
        long newCount = shoppers.stream().filter(shopper -> shopper instanceof NewCustomer).count();

        System.out.println("\nКоличество старых записей: " + oldCount);
        System.out.println("Количество новых записей: " + newCount);
    }

    private static Optional<String> findPhoneNumber(List<OldCustomer> shoppers, String lastName, String firstName, String patronymic) {
        for (OldCustomer shopper : shoppers) {
            if (shopper.getFullName().equals(lastName + " " + firstName + " " + patronymic) && shopper instanceof NewCustomer) {
                return Optional.of(((NewCustomer) shopper).getMobilePhone());
            }
        }
        return Optional.empty();
    }
}