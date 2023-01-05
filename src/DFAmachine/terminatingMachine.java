package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class terminatingMachine extends DFAMachine{
    terminator terminator = new terminator();
    empty empty = new empty();

    boolean[] accepted = {false, true};
    alphabet[][] table = {
            {empty, terminator},
            {empty, empty},
    };

    public terminatingMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        token.add("SEMICOLON");
        tokenValue.add(super.lexeme);
    }
}
