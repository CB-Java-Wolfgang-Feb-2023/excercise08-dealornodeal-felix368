package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuitcaseList {

    public static ArrayList<Suitcase> sList = new ArrayList<>();


    public void fillList(){
        List<Double> values = new ArrayList<>(List.of(0.01,1.0,5.0,10.0,25.0,50.0,75.0,100.0,200.0,300.0,400.0,500.0,750.0,1000.0,5000.0,10000.0,25000.0,50000.0,75000.0,100000.0,200000.0,300000.0,400000.0,500000.0,750000.0,1000000.0));
        for (Double value : values) {

            sList.add(new Suitcase(value));
        }
    }

    public void shuffleList(){
        Collections.shuffle(sList);
    }




    @Override
    public String toString() {

        StringBuilder listText = new StringBuilder();
        for (Suitcase suitcase : sList) {

            listText.append(suitcase.toString());
            listText.append("| ");
        }

        return listText.toString();
    }

    public int unusedCases(){
        int caseCount = 0;
        for (Suitcase suitcase : sList) {

            if (!suitcase.isUsed()){
                caseCount += 1;
            }
        }
        return caseCount;
    }

}
