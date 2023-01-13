package syntaxAnalyzer;

import file.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class syntaxAnalyzer {

    Stack<ArrayList<Integer>> pos;  //토큰이 읽힌 순서에 맞게 해당 토큰 정보를 저장
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;
    table table;
    int nextSymbolIdx;  //tokenName 리스트 중 다음으로 읽을 토큰의 index 
    int step = 1;   
    Stack<String> stSymbol = new Stack<>();  //읽어들인 symbol의 변화 과정 저장을 위한 stack
    Stack<Integer> stState = new Stack<>(); //table의 state 이동 과정 저장을 위한 stack
    file file;

    public syntaxAnalyzer(Stack<ArrayList<Integer>> pos, ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.pos = pos;
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        table = new table();
        file = new file();
    }

    public void init(){
        nextSymbolIdx = 0;
        stState.push(0);
        tokenName.add("$");
        tokenValue.add("$");
        file.writeFile(new String[] {">>> Syntax Analyzer <<<\n\n", "Syntax Analyzer has created the following stack trace\n\n"});
    }

    public void analyze() throws Exception{
        init();
        //lexical analyzer로 읽어들인 토큰 set을 대상으로 순차적으로 slr parsing table로 parsing하여 shift&goto 혹은 reduce by production을 수행
        //1)위 과정을 토큰을 모두 검사 완료하거나   (syntax valid)
        //2)유효하지 않은 action을 발견할 때까지 반복  (syntax invalid)
        while (true) {
            //현재 stState stack의 top에 위치한 table의 currentState와 읽어들일 token으로 action 정보가 들어있는 table의 위치를 참조하여 value를 obtain
            String val = getTableValue();

            file.writeFile(step, stState, stSymbol);    //record the stack trace
            step += 1;

            if (val == null){   //table에 value가 없다는 것은 읽어들인 token이 invalid in terms of the syntax
                reportError();  //error report
                throw new Exception();
            }
            else if (val.equals("acc")){    //parsing 과정의 끝에 도달, valid syntax
                reportSuccess();
                return;
            }
            if (val.charAt(0) == 's'){
                shiftAndGoto(val);  //이동할 목적지 state 저장, 읽어들인 symbol 저장 및 다음 symbol을 읽기 위한 index update
            }
            else{
                reduce(val);    //특정 production을 참조하여 stState 및 stSymbol update
            }
        }
    }

    public String getSymbol(){
        if (tokenName.get(nextSymbolIdx).equals("operator")){
            if (tokenValue.get(nextSymbolIdx).equals("+") || tokenValue.get(nextSymbolIdx).equals("-"))
                return "addsub";
            else
                return "multdiv";
        }
        return tokenName.get(nextSymbolIdx);
    }

    public String getTableValue(){
        return table.actionTable.get(stState.peek()).get(getSymbol());
    }

    public void shiftAndGoto(String val){
        stState.push(Integer.parseInt(val.substring(1)));
        stSymbol.push(getSymbol());
        nextSymbolIdx += 1;
    }

    public void reduce(String val){
        HashMap<String, ArrayList<String>> product = table.production.get(Integer.parseInt(val.substring(1)));

        String key = (String) product.keySet().toArray()[0];
        int lenProduction = product.get(key).size();

        if (!product.get(key).get(0).equals("epsilon")){    //epsilon에 의한 production의 경우와 구분
            for (int i = 0; i < lenProduction; i++){
                stState.pop();
                stSymbol.pop();
            }
        }
        stSymbol.push(key);
        stState.push(Integer.parseInt(table.gotoTable.get(stState.peek()).get(key)));
    }

    public void reportSuccess(){
        file.writeFile(new String[] {"\nParsing has successfully finished\n\n"});
    }

    public void reportError(){
        file.writeFile(pos.get(nextSymbolIdx).get(0), pos.get(nextSymbolIdx).get(1), getSymbol(), tokenValue.get(nextSymbolIdx));
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("The next input token must be one of the following tokens instead: ");
        for (int i = 0; i < table.actionTable.get(stState.peek()).entrySet().size(); i++){
            errorMsg.append(table.actionTable.get(stState.peek()).keySet().toArray()[i]);
            if (i != table.actionTable.get(stState.peek()).entrySet().size() - 1)
                errorMsg.append(", ");
        }
        file.writeFile(new String[] {errorMsg.toString(), "\n"});
    }

}
