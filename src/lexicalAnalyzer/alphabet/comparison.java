package lexicalAnalyzer.alphabet;

import java.util.ArrayList;

public class comparison extends alphabet{
    ArrayList<Character> myAlphabet;

    public comparison(){
        myAlphabet = new ArrayList<>();
        myAlphabet.add('<');
        myAlphabet.add('>');
    }

    @Override
    public boolean doesHave(char c) {
        if (myAlphabet.contains(c))
            return true;
        return false;
    }
}
