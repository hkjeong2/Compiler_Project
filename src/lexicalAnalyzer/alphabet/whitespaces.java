package lexicalAnalyzer.alphabet;

public class whitespaces extends alphabet{

    @Override
    public boolean doesHave(char c) {
        if (c == '\n' || c == '\t' || c == ' ')
            return true;
        return false;
    }
}
