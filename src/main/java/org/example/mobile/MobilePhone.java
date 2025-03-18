package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String number, List<Contact> contacts) {
        this.myNumber = number;
        this.myContacts = new ArrayList<>(contacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact.getName());
        if (index < 0) {
            return false;
        }
        myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact.getName());
        if (index < 0) {
            return false;
        }
        myContacts.remove(index);
        return true;
    }

    public int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        int index = findContact(contactName);
        return (index >= 0) ? myContacts.get(index) : null;
    }

    public void printContact() {
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
