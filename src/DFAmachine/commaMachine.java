package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class commaMachine extends DFAMachine{
    comma comma = new comma();
    empty empty = new empty();

    boolean[] accepted = {false, true};
    alphabet[][] table = {
            {empty, comma},
            {empty, empty},
    };

    public commaMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        token.add("COMMA");
        tokenValue.add(super.lexeme);
    }

}
