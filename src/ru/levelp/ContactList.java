package ru.levelp;

/**
 * Created by Student-15 on 14.04.2016.
 */
public class ContactList {

    Contact[] contacts;

    // Протестировано
    public void add(Contact c) {
        if (contacts == null) {
            contacts = new Contact[1];
            contacts[0] = c;
        } else {
            Contact[] temp = new Contact[contacts.length + 1];
            for (int i = 0; i < contacts.length; i++) {
                temp[i] = contacts[i];
            }
            temp[temp.length - 1] = c;
            contacts = temp;
        }
    }

    // Протестировано
    public void add(int index, Contact c) {
        if (contacts == null) {
            if (index == 0) {
                contacts = new Contact[1];
            } else {
                contacts = new Contact[index+1];
            }
            contacts[index] = c;
        } else {
            Contact[] tmp = new Contact[contacts.length + 1];
            for (int i = 0; i < index; i++) {
                tmp[i] = contacts[i];
            }
            tmp[index] = c;
            for (int j = index; j < contacts.length; j++) {
                tmp[j+1] = contacts[j];
            }
            contacts = tmp;
        }
    }

    // Протестировано
    public void remove(int index) {
        if (contacts == null) {
            return;
        } else {
            Contact[] tmp = new Contact[contacts.length];
            for (int i = 0; i < index; i++) {
                tmp[i] = contacts[i];
            }
            for (int j = index + 1; j < contacts.length; j++) {
                tmp[j-1] = contacts[j];
            }
            contacts = tmp;
        }
    }

    // Не срабатывает случай (i > contacts.length - 1) [это случай выхода за длину телефонной книги]
    public Contact get(int i) {
        if (contacts == null) {
            System.err.println("ОШИБКА! Данные телефонной книги отсутствуют");
        } else if (contacts[i] == null) {
            System.err.println("ОШИБКА! Данные под индексом " + i + " отсутствуют");
        } else if (i > contacts.length - 1) { // Условие не срабатывает
            System.err.println("ОШИБКА! Данные под индексом " + i + " отсутствуют (превышение индекса)");
        }
        return contacts[i];
    }

    // Метод невозможно вызвать извне: ошибка println(void)
    public void size() {
        int size = contacts.length;
    }

    // Протестировано
    public void clear() {
        contacts = null;
    }

}
