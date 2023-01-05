package DFAmachine;

import alphabet.*;

import java.util.ArrayList;

public class bracketMachine extends DFAMachine{

    bracket bracket = new bracket();
    empty empty = new empty();

    boolean[] accepted = {false, true, true};
    alphabet[][] table = {
            {empty, bracket, bracket},
            {empty, empty, empty},
            {empty, empty, empty},
    };

    public bracketMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        if (super.lexeme.charAt(0) == '(')
            token.add("L_BRACKET");
        else
            token.add("R_BRACKET");
        tokenValue.add(super.lexeme);
    }

}
