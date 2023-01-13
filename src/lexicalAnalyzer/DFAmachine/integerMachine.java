package lexicalAnalyzer.DFAmachine;

import lexicalAnalyzer.alphabet.*;
import java.util.ArrayList;

public class integerMachine extends machine {
    
    digit digit = new digit();
    nonZeroDigit nzd = new nonZeroDigit();
    minus minus = new minus();
    zero zero = new zero();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true, false, true, true};
    alphabet[] alphabets = {zero, minus, nzd, digit};
    int[][] table = {
            {1, 2, 3, -1},
            {-1, -1, -1, -1},
            {-1, -1, 3, -1},
            {4, -1, 4, 4},
            {4, -1, 4, 4},
    };

    public integerMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        //이전 token이 INTEGER or ID 일 시 현재 integer value가 음수라면 '-'를 음수가 아닌 operator로 해석
        if (tokenName.get(tokenName.size() - 1).equals("INTEGER") || tokenName.get(tokenName.size() - 1).equals("ID")){
            if (super.lexeme.charAt(0) == '-'){
                tokenName.add("operator");
                tokenValue.add(String.valueOf('-'));
                tokenName.add("num");
                tokenValue.add(super.lexeme.substring(1));
            }
            else{
                tokenName.add("num");
                tokenValue.add(super.lexeme);
            }
        }
        else{
            tokenName.add("num");
            tokenValue.add(super.lexeme);
        }
    }

}
