package alphabet;

public class bracket extends alphabet{

    @Override
    public boolean doesHave(char c) {
        if (c == '(' || c == ')')
            return true;
        return false;
    }
}
