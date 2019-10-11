// Kingdom.java
package org.btarikool.javacourse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kingdom {
    private String name;
    Person[] people = {};
    public Kingdom(String name) {
        this.name = name;
    }

    public Person createPerson(String name, String title, Person chief){
        Person createdPerson;
        switch (title.toLowerCase()) {
            case "king":
                createdPerson = new King(name);
                break;
            case "lord":
                createdPerson = new Lord(name);
                break;
            case "knight":
                createdPerson = new Knight(name);
                break;
            case "wizard":
                createdPerson = new Wizard(name);
                break;
            default:
                createdPerson = new Peasant(name);

        }
        createdPerson.setChief(chief);
        if (chief != null){
            chief.addSubordinate(createdPerson);
        }
        addToPeople(createdPerson);
        return createdPerson;
    }



    private void addToPeople(Person p) {
        p.setId(this.people.length);
        int arrayLen = this.people.length;
        Person [] newPeopleArray = Arrays.copyOf(this.people, arrayLen + 1);
        newPeopleArray[arrayLen] = p;
        this.people = newPeopleArray;
    }

    public void runActionsUp() {
        int lastIndex = this.people.length - 1;
        for(int i = lastIndex; i >= 0; i-- ) {
            if (this.people[i] instanceof King) {
                ((King) this.people[i]).providePeasantToSubordinates(this);
                continue;
            }
            this.people[i].doAction ();

        }
    }

    public void runActionsDown() {
        for(Person p: this.people) {
            if (p.subordinates == null || p.subordinates.length == 0) {
                continue;
            }
            for (Person subordinate: p.subordinates) {
                p.doAction(subordinate);
            }


        }
    }

    public Knight[] choosetRandomPair() {
        List<Person> allKnights = new ArrayList<>();
        for (Person p : this.people) {
            if (p instanceof Knight & p.chief.title == Wizard.TITLE ) {
                allKnights.add(p);
            }
        }
        
        return new Knight[2];
    }

    public void doFight(Knight[] knightPair) {
        double knight1Rank = Person.getRank(knightPair[0]);
        double kinght2Rank = Person.getRank(knightPair[1]);
        //TODO: Нужно будет сравнить, насколько отличается ранг рыцарей и в
        //TODO: В зависимости от этого выбрать победителя
    }


    @Override
    public String toString() {
        String kingdom = "***" +  this.name + " Kingdom *** \n";
        for (Person p : this.people) {
            kingdom = kingdom + p + "; \n";
        }
        return kingdom;
    }
}
