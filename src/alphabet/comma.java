package alphabet;

public class comma extends alphabet{
    @Override
    public boolean doesHave(char c) {
        if (c == ',')
            return true;
        return false;
    }
}
