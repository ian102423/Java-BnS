import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        BnS bnS1 = BnS.WAR_LOCK;
        BnS bnS2 = BnS.KUNG_FU_MASTER;

        BnS.dual(bnS1, bnS2);
    }
}

enum BnS {
    WAR_LOCK("Warlock", 50, 1000, 25, "body", "Head"), KUNG_FU_MASTER("Kung Fu Master", 25, 3000, 15, "head", "Body");

    private final String name;
    private final int attackPoints;
    private final int healthPoints;
    private final int criticalPoints;
    private final String weakSpot;
    private final String attackSpot;


    BnS(String name, int attackPoints, int healthPoints, int criticalPoints, String weakSpot, String attackSpot) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
        this.criticalPoints = criticalPoints;
        this.weakSpot = weakSpot;
        this.attackSpot = attackSpot;
    }


    public static void dual(BnS firstDeck, BnS secondDeck) {

        boolean firstWeakSpot = false;
        boolean secondWeakSpot = false;
        int firstDmgAmount = firstDeck.attackPoints;
        int secondDmgAmount = secondDeck.attackPoints;
        int firstDeckHP = firstDeck.healthPoints;
        int secondDeckHP = secondDeck.healthPoints;


        System.out.println("(Player1) Tell me where to hit");
        Scanner scan1 = new Scanner(System.in);

        String tellMeTheWeakSpotP1;
        tellMeTheWeakSpotP1 = scan1.nextLine().toLowerCase();


        System.out.println("(Player2) Tell me where to hit");
        Scanner scan2 = new Scanner(System.in);

        String tellMeTheWeakSpotP2;
        tellMeTheWeakSpotP2 = scan2.nextLine().toLowerCase();


        if(secondDeck.weakSpot == tellMeTheWeakSpotP1){
            System.out.println("Its Equal");
        } else{
            System.out.println("Not Equal");
            System.out.println(secondDeck.weakSpot);
            System.out.println(tellMeTheWeakSpotP1);
        }


        if (secondDeck.weakSpot == tellMeTheWeakSpotP1) {
            firstWeakSpot = true;
        }
        if (firstDeck.weakSpot == tellMeTheWeakSpotP2) {
            secondWeakSpot = true;
        }

        if (firstWeakSpot == true) {
            firstDmgAmount += criticalDmg(firstDeck.attackPoints);
            secondDeckHP -= firstDmgAmount;
            System.out.println(firstDeck.name + "(P1):\n Critical Hit on Target!!! (" + firstDmgAmount + " Damage), " + secondDeckHP + " HP left on Target.");
        } else {
            secondDeckHP -= firstDmgAmount;
            System.out.println(firstDeck.name + "(P1):\n Hit on Target!!! (" + firstDeck.attackPoints + " Damage), " + secondDeckHP + " HP left on Target.\n");
        }
        if (secondWeakSpot == true) {
            secondDmgAmount += criticalDmg(secondDeck.attackPoints);
            firstDeckHP -= secondDmgAmount;
            System.out.println(secondDeck.name + "(P2):\n Critical Hit on Target!!! (" + secondDmgAmount + " Damage), " + firstDeckHP + " HP left on Target.");
        } else {
            firstDeckHP -= secondDmgAmount;
            System.out.println(secondDeck.name + "(P2):\n Hit on Target!!! (" + secondDeck.attackPoints + " Damage), " + firstDeckHP + " HP left on Target.");
        }


    }

//    public static void askWeakSpot() {
//        System.out.println("(Player1)Tell me where to hit");
//        Scanner scan1 = new Scanner(System.in);
//        System.out.println("(Player2)Tell me where to hit");
//        Scanner scan2 = new Scanner(System.in);
//        String tellMeTheWeakSpot1P;
//        String tellMeTheWeakSpot2P;
//        tellMeTheWeakSpot1P = scan1.nextLine();
//        tellMeTheWeakSpot2P = scan2.nextLine();
//    }

    public static int criticalDmg(int c) {
        if (c == 0) return 0;
        else {
            return c + criticalDmg(c - 1);
        }
    }
}





