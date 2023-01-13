package lexicalAnalyzer.DFAmachine;

import lexicalAnalyzer.alphabet.*;
import java.util.ArrayList;

public class comparisonMachine extends machine {

    comparison comparison = new comparison();
    inequality inequality = new inequality();
    assignment assignment = new assignment();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true, false, true};
    alphabet[] alphabets = {comparison, assignment, inequality};
    int[][] table = {
            {1, 2, 2},
            {-1, 3, -1},
            {-1, 3, -1},
            {-1, -1, -1},
    };

    public comparisonMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        tokenName.add("comp");
        tokenValue.add(super.lexeme);
    }

}
