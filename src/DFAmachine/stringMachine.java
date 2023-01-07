package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class stringMachine extends machine {

    quot quot = new quot();
    letter letter = new letter();
    digit digit = new digit();
    blank blank = new blank();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, false, false, false, false, false, false, false, true};
    alphabet[] alphabets = {quot, letter, digit, blank};
    int[][] table = {
            {1, -1, -1, -1},
            {-1, 2, 3, 4},
            {8, 5, 6, 7},
            {8, 5, 6, 7},
            {8, 5, 6, 7},
            {8, 5, 6, 7},
            {8, 5, 6, 7},
            {8, 5, 6, 7},
            {-1, -1, -1, -1}
    };

    public stringMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.alphabets = this.alphabets;
        super.accepted = this.accepted;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        tokenName.add("STRING");
        tokenValue.add(super.lexeme);
    }

}
