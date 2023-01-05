import DFAmachine.*;
import java.util.ArrayList;

public class lexicalAnalyzer {

    ArrayList<DFAMachine> machine = new ArrayList<>();
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;
    int idx = 0;
    int line = 0;
    file file = new file();

    public lexicalAnalyzer(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        machine.add(new whiteSpaceMachine());
        machine.add(new bracketMachine());
        machine.add(new commaMachine());
        machine.add(new comparisonMachine());
        machine.add(new assignmentMachine());
        machine.add(new identifierMachine());
        machine.add(new integerMachine());
        machine.add(new operatorMachine());
        machine.add(new parenthesisMachine());
        machine.add(new stringMachine());
        machine.add(new terminatingMachine());
    }

    public void analyze(){
        String input = file.readFile();
        String[] inputToken = input.split("\n");

        for(int i = 0; i < inputToken.length; i++){
            line += 1;
            idx = 0;

            while(inputToken[i].substring(idx).length() != 0){

                for (int j = 0; j < machine.size(); j++){
                    int tempIdx = machine.get(j).transit(inputToken[i].substring(idx), tokenName, tokenValue);

                    if (tempIdx != 0){
                        idx += tempIdx;
                        break;
                    }

                    if (j == machine.size() - 1){
                        file.writeFile(line, idx, inputToken[i].substring(idx).charAt(0));
                        return;
                    }
                }
            }
        }
        file.writeFile(tokenName, tokenValue);
    }

}
