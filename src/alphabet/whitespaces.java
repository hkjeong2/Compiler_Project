package alphabet;

import java.util.ArrayList;

public class whitespaces extends alphabet{

    @Override
    public boolean doesHave(char c) {
        if (c == '\n' || c == '\t' || c == ' ')
            return true;
        return false;
    }
}
