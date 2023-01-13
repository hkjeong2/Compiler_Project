package lexicalAnalyzer.DFAmachine;

import lexicalAnalyzer.alphabet.alphabet;
import java.util.ArrayList;

public class machine {
    //각 토큰 machine들은 transition table 및 accepting state만 다를 뿐
    //transition 로직은 동일하기 때문에 하나의 class를 각 machine들로 하여금 상속하여 사용할 수 있게 만든 parent class

    int currentState = 0;   //table의 transition 과정에서 현재 state 정보 저장
    int mIdx = 0;   //token value를 저장하기 위한 string의 index
    String lexeme = ""; //token value를 저장하기 위한 string
    boolean available = true;   //table 이동중 유효하지 않은 move일 시 이후부터는 검사하지 하지 않기 위한 변수

    //아래부터는 token별 고유 정보 변수
    boolean[] accepted; //각 state가 final, accepting state인지 저장
    //input 문자가 letter, digit 및 각종 다른 문자 집합들 중 어디에 속하는 지 table을 iterate하며 확인하기 위해 일괄 처리할 수 있도록 설정한 하나의 parent 객체 array
    alphabet[] alphabets;
    int[][] table;  //transition table의 state 정보를 저장

    public void transit(Character c) {

        if (!available) //검사할 필요 없는 오류 케이스는 return
            return;

        int nextState = checkTransition(c); //table내에서 transition 이후 다음 state 받아옴

        if (nextState == -1){   //invalid transition이었다면 이후부터는 검사 x
            available = false;
        }
        else{
            currentState = nextState;   //현재 state를 다음 state로 수정 및 이동
        }
    }

    public int checkTransition(Character c){
        // alphabets array를 iterate하며
        // 1) alphabet이 input 문자를 가진 집합이고
        // 2) 해당 문자로 move할 다음 state가 -1이 아닌 유효한 state number일 시 token value관련 정보 수정 및 적립
        for (int nextState = 0; nextState < alphabets.length; nextState++){
            if (alphabets[nextState].doesHave(c)){
                if (table[currentState][nextState] != -1){
                    mIdx += 1;
                    lexeme += String.valueOf(c);
                }
                return table[currentState][nextState];
            }
        }
        return -1;
    }

    public void init(){
        currentState = 0;
        mIdx = 0;
        lexeme = "";
        available = true;
    }

    //각 machine 종류별로 고유 tokenName 및 tokenValue 추가 (integerMachine의 경우 '-' 문자 관련 경우별 대응)
    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){}

    public int getMIdx(){
        return mIdx;
    }

    public int getCurrentState(){
        return currentState;
    }

    public boolean[] getAccepted(){
        return accepted;
    }

}
