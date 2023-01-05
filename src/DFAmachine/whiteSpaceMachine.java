package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class whiteSpaceMachine extends DFAMachine{
    whitespaces whitespaces = new whitespaces();
    empty empty = new empty();

    boolean[] accepted = {false, true, true, true};
    alphabet[][] table = {
            {empty, whitespaces, whitespaces, whitespaces},
            {empty, empty, empty, empty},
            {empty, empty, empty, empty},
            {empty, empty, empty, empty},
    };

    public whiteSpaceMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
    }
}
