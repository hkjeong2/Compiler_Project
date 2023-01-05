package alphabet;

public class terminator extends alphabet{
    @Override
    public boolean doesHave(char c) {
        if (c == ';')
            return true;
        return false;
    }
}
