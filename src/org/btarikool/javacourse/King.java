// King.java
package org.btarikool.javacourse;

public class King extends Person {
    int peasants = 10;
    private static String TITLE = "King ";


    public King(String name) {
        super(name);
        this.title = TITLE;
        this.setHealth(0.5);
        this.power = 10;
        this.actions = new String[][]{
                {null, null},
                {"fief", "fief"}
        };
    }

    public Peasant providePeasant(String masterName) {
        peasants--;
        return new Peasant(masterName + "'s peasant #" + (10 - peasants));
    }

    public void providePeasantToSubordinates(Kingdom kingdom) {
        for (Person lord : this.subordinates) {
            if (!(lord instanceof Lord)) {
                continue;
            }
            createPeasantWithName(lord, kingdom);
        }
    }
    public Person createPeasantWithName(Person p, Kingdom k) {
        String name = p.getTitleAndName() + "'s peasant";
        return k.createPerson(name, "", p);
    }
}