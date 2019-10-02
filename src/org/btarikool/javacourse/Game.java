// Kingdom.java
package org.btarikool.javacourse;

public class Game {

    public static void main(String[] args) {

        Kingdom kingdom1 = new Kingdom("FarAway");
        King richard = (King) kingdom1.createPerson("Richard", "King", null);
        Lord lionel = (Lord) kingdom1.createPerson("Lionel", "Lord", richard);
        Lord lee = (Lord) kingdom1.createPerson("Lee", "Lord", richard);
        Wizard wally = (Wizard) kingdom1.createPerson("Wally", "wizard", richard);
        Knight keeney = (Knight) kingdom1.createPerson("Keeney", "kNIGHT", lionel);
        Knight koosey = (Knight) kingdom1.createPerson("koosey", "knight", lee);


        kingdom1.runActionsUp();
        kingdom1.runActionsDown();
        System.out.println(kingdom1);

        for (int i = 0; i < 5; i++){
            wally.cureKing(kingdom1);
        }
        System.out.println(kingdom1);

    }
}
