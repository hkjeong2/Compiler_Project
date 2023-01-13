import java.util.ArrayList;
import java.util.Stack;

public class symbolTable {
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;
    Stack<ArrayList<Integer>> pos;

    symbolTable(){
        tokenName = new ArrayList<String>();
        tokenValue = new ArrayList<String>();
        pos = new Stack<>();
    }
}
