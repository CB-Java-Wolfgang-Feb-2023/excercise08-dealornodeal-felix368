package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInteraction {

    SuitcaseList suitcaseList = new SuitcaseList();
    private int rounds;

    public UserInteraction() {
        this.rounds = 0;
    }

    public void printCases(){

        StringBuilder printStr = new StringBuilder();

        for (int i = 0;i< SuitcaseList.sList.size();i++) {
            Suitcase suitcase = SuitcaseList.sList.get(i);
            if (suitcase.isUsed()){
                printStr.append(suitcase);
                printStr.append("$| ");
            } else {
                printStr.append(" ");
                printStr.append(i);
                printStr.append(" |");
            }
        }
        System.out.println(printStr);
    }

    public Suitcase selectNewCase() {

        System.out.println("Pleas select a new Case");
        boolean incorrectInput = true;
        Suitcase selectedCase = null;
        while (incorrectInput) {
            try {

                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();

                if(userInput < 0 || userInput > 25){
                    System.out.println("Pleas select a number between 0 and one");
                    incorrectInput = true;
                }

                else if(SuitcaseList.sList.get(userInput).isUsed()){
                    System.out.print("This case is open select a new one:");
                    incorrectInput = true;
                }
                else {
                    incorrectInput = false;
                    selectedCase = openSuitcase(userInput);

                }

            } catch (InputMismatchException err){
                System.out.println("wrong input try it again:");
            }
        }
        return selectedCase;
    }

    public Suitcase openSuitcase(int selection){
        SuitcaseList.sList.get(selection).setUsed(true);
        return SuitcaseList.sList.get(selection);
    }

    public double sumAllUnusedCases(){
        double sum = 0;
        for (int i = 0; i < SuitcaseList.sList.size(); i++) {

            if(!SuitcaseList.sList.get(i).isUsed()){
                sum += SuitcaseList.sList.get(i).getValue();
            }
        }
        return sum;
    }

    public double getBank(double lastCaseSumm){

        return (sumAllUnusedCases() + lastCaseSumm) / suitcaseList.unusedCases() / rounds / 10;
    }

    public void addNewRound(){
        rounds += 1;
    }

    public int getRounds() {
        return rounds;
    }

    public boolean bankOffer(Suitcase selectedCase){
        double bankSum = getBank(selectedCase.getValue());
        System.out.println("The bank offers you: " + bankSum);

        try {
            System.out.print("Please press Y/y for YES and N/n for NO:");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            if(userInput.toLowerCase().equals("y")){
                System.out.println("you win :" + bankSum + "$");
                return true;
            }
        }finally {
            //intentionally empty
        }

        return false;
    }



}


