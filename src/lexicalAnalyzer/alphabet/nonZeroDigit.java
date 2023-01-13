package lexicalAnalyzer.alphabet;

import java.util.ArrayList;

public class nonZeroDigit extends alphabet{
    ArrayList<Character> myAlphabet;

    public nonZeroDigit(){
        myAlphabet = new ArrayList<>();
        myAlphabet.add('1');
        myAlphabet.add('2');
        myAlphabet.add('3');
        myAlphabet.add('4');
        myAlphabet.add('5');
        myAlphabet.add('6');
        myAlphabet.add('7');
        myAlphabet.add('8');
        myAlphabet.add('9');
    }

    @Override
    public boolean doesHave(char c) {
        if (myAlphabet.contains(c))
            return true;
        return false;
    }
}
