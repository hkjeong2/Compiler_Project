package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class parenthesisMachine extends machine {

    parenthesis parenthesis = new parenthesis();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {parenthesis};
    int[][] table = {
            {1},
            {-1},
    };

    public parenthesisMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        if (super.lexeme.charAt(0) == '{')
            tokenName.add("L_PARENTHESIS");
        else
            tokenName.add("R_PARENTHESIS");
        tokenValue.add(super.lexeme);
    }

}
