package lexicalAnalyzer.alphabet;

public class quot extends alphabet{

    @Override
    public boolean doesHave(char c) {
        if (c == '"')
            return true;
        return false;
    }
}
