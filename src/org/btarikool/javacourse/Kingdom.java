// Kingdom.java
package org.btarikool.javacourse;

public class Kingdom {
    private String name;
    Person[] people = new Person[10];
    public Kingdom(String name) {
        this.name = name;
    }

    public Person createPerson(String name, String title){
        if(title.toLowerCase().equals("king")) {
            return new King(name);
        } else if(title.toLowerCase().equals("lord")) {
            return new Lord(name);
        } else if(title.toLowerCase().equals("knight")) {
            return new Knight(name);
        } else {
            return new Peasant(name);
        }
    }
    public static boolean runActionsChain(King king, Lord lord1, Lord lord2, Knight knight1, Knight knight2) {
        try {
            knight1.doAction("my hommage to " + lord1.getTitleAndName(), true);
            knight2.doAction("my military service to " + lord2.getTitleAndName(), true);
            lord1.doAction("my loyalty to " + king.getTitleAndName(), true);
            lord2.doAction("my military aid to " + king.getTitleAndName(), true);
            king.doAction("I give fief to " + lord1.getTitleAndName());
            king.doAction("I give 2 peasants to " + lord2.getTitleAndName());
            Peasant peasant1 = king.providePeasant(lord1.getTitleAndName());
            Peasant peasant2 = king.providePeasant(lord1.getTitleAndName());
            lord1.doAction("I give food to " + knight1.getTitleAndName());
            lord2.doAction("I give protection to " + knight2.getTitleAndName());
            knight1.doAction("I bring new lands to " + king.getTitleAndName(), true);
            knight2.doAction("I bring new lands to " + king.getTitleAndName(), true);
            peasant1.doAction("I give food to " + lord1.getTitleAndName(), true);
            peasant2.doAction("I give food to " + lord2.getTitleAndName(), true);
            peasant1.report();
            peasant2.report();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void report(King king, Lord lord1, Lord lord2, Knight knight1, Knight knight2) {
        king.report();
        lord1.report();
        lord2.report();
        knight1.report();
        knight2.report();
    }
}
