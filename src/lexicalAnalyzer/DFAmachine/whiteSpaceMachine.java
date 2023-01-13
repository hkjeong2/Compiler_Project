package lexicalAnalyzer.DFAmachine;

import lexicalAnalyzer.alphabet.*;
import java.util.ArrayList;

public class whiteSpaceMachine extends machine {

    whitespaces whitespaces = new whitespaces();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {whitespaces};
    int[][] table = {
            {1},
            {-1},
    };

    public whiteSpaceMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
    }

}
