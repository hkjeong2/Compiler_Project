package alphabet;

public class parenthesis extends alphabet{
    @Override
    public boolean doesHave(char c) {
        if (c == '{' || c == '}')
            return true;
        return false;
    }
}
