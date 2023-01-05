package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class assignmentMachine extends DFAMachine{

    assignment assignment = new assignment();
    empty empty = new empty();

    boolean[] accepted = {false, true};
    alphabet[][] table = {
            {empty, assignment},
            {empty, empty},
    };

    public assignmentMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        token.add("ASSIGNMENT");
        tokenValue.add(super.lexeme);
    }

}
