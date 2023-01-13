package lexicalAnalyzer.alphabet;

public class letter extends alphabet{

    @Override
    public boolean doesHave(char c) {
        if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
            return true;
        return false;
    }
}
