import DFAmachine.*;
import java.util.ArrayList;

public class lexicalAnalyzer {

    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;
    //각 token들의 각기 다르고 고유한 transition table을 iterate하며 input stream이 속한 token을 찾아내기 위해 일괄 처리에 용이한 하나의 형태로 획일화
    ArrayList<machine> machines = new ArrayList<>();
    int line = 0;   //오류 발생시 표기하기 위한 line number
    int idx = 0;    //오류 발생시 표기하기 위한 index

    public lexicalAnalyzer(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        machines.add(new assignmentMachine(tokenName, tokenValue));
        machines.add(new bracketMachine(tokenName, tokenValue));
        machines.add(new commaMachine(tokenName, tokenValue));
        machines.add(new comparisonMachine(tokenName, tokenValue));
        machines.add(new identifierMachine(tokenName, tokenValue));
        machines.add(new operatorMachine(tokenName, tokenValue));
        machines.add(new integerMachine(tokenName, tokenValue));
        machines.add(new parenthesisMachine(tokenName, tokenValue));
        machines.add(new stringMachine(tokenName, tokenValue));
        machines.add(new terminatingMachine(tokenName, tokenValue));
        machines.add(new whiteSpaceMachine(tokenName, tokenValue));
    }

    public void analyze(){
        //input file로 부터 읽어들인 전체 string을 line counting을 위해 개행문자 기준으로 나누어 분석
        file file = new file();
        String input = file.readFile();
        String[] inputToken = input.split("\n");

        for (String s : inputToken) {
            line += 1;
            idx = 0;

            //한 줄의 input stream을 모두 토큰화 할 때까지 분석 반복
            //해당 과정을 반복하기 위해 분석이 끝난 지점을 index에 저장하고 그 다음부터 재시작
            while (s.substring(idx).length() != 0) {

                //첫 문자부터 input stream의 끝 문자까지 string을 형성해 가며 유효한 토큰이 있으면 각 토큰 class내에 해당 문자열의 유효 지점까지 저장
                //이후 가장 길게 저장된 string을 token value로 판별하여 본 string을 소유한 해당 machine을 찾아내 token name 또한 define
                for (int j = idx; j < s.length(); j++) {

                    for (machine machine : machines) {
                        //input stream이 각 토큰 분석용 machine의 transition table을 통과하여 token화 가능한지 한 문자씩 검사
                        //한 문자씩 검사하기 때문에
                        // 1) 통과가 불가능하면 해당 토큰 machine에서는 그 다음부터 검사하지 않게끔 설정
                        // 2) 통과가 가능하면 해당 토큰 machine의 automata의 다음 state로 이동하며 문자를 string에 저장해 나감
                        machine.transit(s.charAt(j));
                    }
                }
                int mOrder = getValidMachine(); //가장 긴 길이의 유효한 string을 저장한 machine의 id
                int mIdx = machines.get(mOrder).getMIdx(); //해당 machine의 token value 길이

                //유효한 token value가 존재하지 않거나
                //유효하다고 선정된 string의 마지막 문자로 이동한 state가 accepted state가 아닐 시 (string이 덜 마무리)
                //오류로 판단하여 해당 string이 위치한 line, index, 첫 문자 출력
                if (mIdx <= 0 || !machines.get(mOrder).getAccepted()[machines.get(mOrder).getCurrentState()]) {
                    file.writeFile(line, idx, s.charAt(idx));
                    return;
                } else { //오류가 없다면 검수가 완료된 다음 지점부터 분석을 재시작 하기 위해 idx update, token name 및 value 저장
                    idx += mIdx;
                    machines.get(mOrder).addToken(tokenName, tokenValue);
                    initMachine();  //다음 분석 시작 전 모든 transition 정보 초기화
                }
            }
        }
        file.writeFile(tokenName, tokenValue); //symbol table에 여태 저장된 token name 및 value를 파일에 출력
    }

    public int getValidMachine(){
        int mIdx = 0;
        int mOrder = 0;

        for (int i = 0; i < machines.size(); i++){
            if (machines.get(i).getMIdx() > mIdx){
                mOrder = i;
                mIdx = machines.get(i).getMIdx();
            }
        }
        return mOrder;
    }

    public void initMachine(){
        for (machine machine : machines) {
            machine.init();
        }
    }

}
