import lexicalAnalyzer.lexicalAnalyzer;
import syntaxAnalyzer.syntaxAnalyzer;

import java.util.ArrayList;
import java.util.Stack;

public class compiler {
    public static void main(String[] args) {

        symbolTable symbolTable = new symbolTable();  //토큰 종류 및 위치 정보를 저장하는 symbol table 및 pos 관리

        try{
            lexicalAnalyzer lexicalAnalyzer = new lexicalAnalyzer(symbolTable.pos, symbolTable.tokenName, symbolTable.tokenValue);
            lexicalAnalyzer.analyze();  //준비된 file의 String 데이터를 읽어들인 후 analyze 하여 symbolTable에 저장
            syntaxAnalyzer syntaxAnalyzer = new syntaxAnalyzer(symbolTable.pos, symbolTable.tokenName, symbolTable.tokenValue);
            syntaxAnalyzer.analyze();   //symbolTable에 저장된 토큰 정보의 syntax를 전처리로 제작된 slr parsing table을 통해 검사
        } catch(Exception e) {
            System.out.println("error has occurred by the analyzer");
        }

    }
}
