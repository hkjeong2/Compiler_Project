package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class integerMachine extends DFAMachine{
    
    digit digit = new digit();
    nonZeroDigit nzd = new nonZeroDigit();
    minus minus = new minus();
    zero zero = new zero();
    empty empty = new empty();

    boolean[] accepted = {false, true, false, true, true};
    alphabet[][] table = {
            {empty, zero, minus, nzd, empty},
            {empty, empty, empty, empty, empty},
            {empty, empty, empty, nzd, empty},
            {empty, empty, empty, empty, digit},
            {empty, empty, empty, empty, digit},
    };

    public integerMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        token.add("INTEGER");
        tokenValue.add(super.lexeme);
    }
}
