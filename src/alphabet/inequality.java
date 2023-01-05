package alphabet;

import java.util.ArrayList;

public class inequality extends alphabet{
    ArrayList<Character> myAlphabet;

    public inequality(){
        myAlphabet = new ArrayList<>();
        myAlphabet.add('!');
        myAlphabet.add('=');
    }

    @Override
    public boolean doesHave(char c) {
        if (myAlphabet.contains(c))
            return true;
        return false;
    }
}
