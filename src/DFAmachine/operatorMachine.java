package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class operatorMachine extends DFAMachine{
    operator operator = new operator();
    empty empty = new empty();

    boolean[] accepted = {false, true, true, true, true};
    alphabet[][] table = {
            {empty, operator, operator, operator, operator},
            {empty, empty, empty, empty, empty},
            {empty, empty, empty, empty, empty},
            {empty, empty, empty, empty, empty},
            {empty, empty, empty, empty, empty},
    };

    public operatorMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        token.add("OPERATOR");
        tokenValue.add(super.lexeme);
    }
}
