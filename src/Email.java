import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    //constructor to receive  the first name and last name
    //конструктор для получения имени и фамилии
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        //Вызвать метод с запросом отдела - вернуть отдел
        this.department = setDepartment();

        //Call a method thet returns a random password
        //Вызов метода, который возвращает случайный пароль
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your passwor is: " + this.password);

        //combine elements to generate email
        //комбинировать элементы для создания электронной почты
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for the department
    private String setDepartment() {
        System.out.println("New worker:" + firstName + ". Department codes:\n1 for Sales\n2 for Development\n3 for Acaunting \n0 for none\nenter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    //generate a random password
    //генерируем случайных чисел пароля
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    //Устанавливаем объем эл.ящика
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set the alternte email
    //Установливаем альтернативный адрес электронной почты
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    //Изменяем пароль
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display name: " + firstName + " " + lastName +
                "\nCampany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + "mb";
    }
}