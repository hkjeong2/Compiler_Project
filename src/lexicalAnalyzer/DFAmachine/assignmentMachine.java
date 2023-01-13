package lexicalAnalyzer.DFAmachine;

import lexicalAnalyzer.alphabet.*;
import java.util.ArrayList;

public class assignmentMachine extends machine {

    assignment assignment = new assignment();
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {assignment};
    int[][] table = {
            {1},
            {-1},
    };

    public assignmentMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        tokenName.add("assign");
        tokenValue.add(super.lexeme);
    }

}
