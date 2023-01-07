package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class operatorMachine extends machine {

    operator operator = new operator();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {operator};
    int[][] table = {
            {1},
            {-1},
    };

    public operatorMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        tokenName.add("OPERATOR");
        tokenValue.add(super.lexeme);
    }

}
