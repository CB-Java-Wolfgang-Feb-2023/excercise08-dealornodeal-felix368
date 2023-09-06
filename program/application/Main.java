package application;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SuitcaseList suitcaseList = new SuitcaseList();
        UserInteraction user = new UserInteraction();

        suitcaseList.fillList();

        ArrayList bankRounds = new ArrayList(List.of(6,11,15,18,20,21,22,23,24));
        boolean bankAccepted = false;
        Suitcase selectedCase = null;
        while (user.getRounds() < SuitcaseList.sList.size() && !bankAccepted){

            user.printCases();
            selectedCase =  user.selectNewCase();
            int currentRound = user.getRounds();

            if(bankRounds.contains(currentRound)){

                bankAccepted = user.bankOffer(selectedCase);
            }

            user.addNewRound();
        }

        if(!bankAccepted){
            System.out.println("you won:"+ selectedCase.getValue()+ "$") ;
        }




    }
}
