package ru.gb;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        // Добавление нового Person
        Person person = new Person("John Doe", 25);
        personDAO.addPerson(person);
        System.out.println("Person добавлен: " + person);

        // Обновление Person
        person.setAge(26);
        personDAO.updatePerson(person);
        System.out.println("Person обновлен: " + person);

        // Получение Person по ID
        Person personFromDB = personDAO.getPerson(person.getId());
        System.out.println("Полученный Person: " + personFromDB);

        // Удаление Person
        personDAO.deletePerson(person.getId());
        System.out.println("Person удален");

        // Закрытие фабрики EntityManager
        PersonDAO.shutdown();
    }
}
