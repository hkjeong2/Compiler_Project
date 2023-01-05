package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class comparisonMachine extends DFAMachine{
    comparison comparison = new comparison();
    inequality inequality = new inequality();
    assignment assignment = new assignment();
    empty empty = new empty();

    boolean[] accepted = {false, false, true, true, true};
    alphabet[][] table = {
            {empty, inequality, comparison, empty, empty},
            {empty, empty, empty, assignment, empty},
            {empty, empty, empty, empty, assignment},
            {empty, empty, empty, empty, empty},
            {empty, empty, empty, empty, empty},
    };

    public comparisonMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        token.add("COMPARISON");
        tokenValue.add(super.lexeme);
    }

}
