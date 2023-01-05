package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class stringMachine extends DFAMachine{
    quot quot = new quot();
    letter letter = new letter();
    digit digit = new digit();
    blank blank = new blank();
    empty empty = new empty();

    boolean[] accepted = {false, false, false, false, false, false, false, false, true};
    alphabet[][] table = {
            {empty, quot, empty, empty, empty, empty, empty, empty, empty},
            {empty, empty, letter, digit, blank, empty, empty, empty, empty},
            {empty, empty, empty, empty, empty, letter, digit, blank, quot},
            {empty, empty, empty, empty, empty, letter, digit, blank, quot},
            {empty, empty, empty, empty, empty, letter, digit, blank, quot},
            {empty, empty, empty, empty, empty, letter, digit, blank, quot},
            {empty, empty, empty, empty, empty, letter, digit, blank, quot},
            {empty, empty, empty, empty, empty, letter, digit, blank, quot},
            {empty, empty, empty, empty, empty, empty, empty, empty, empty},
    };

    public stringMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        token.add("STRING");
        tokenValue.add(super.lexeme);
    }
}
