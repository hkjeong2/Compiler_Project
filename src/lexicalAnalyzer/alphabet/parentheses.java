package lexicalAnalyzer.alphabet;

public class parentheses extends alphabet{
    @Override
    public boolean doesHave(char c) {
        if (c == '(' || c == ')')
            return true;
        return false;
    }
}
