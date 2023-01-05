public class compiler {
    public static void main(String[] args) {

        symbolTable symbolTable = new symbolTable();    //토큰 정보를 저장하는 symbol table 관리
        lexicalAnalyzer lexicalAnalyzer = new lexicalAnalyzer(symbolTable.tokenName, symbolTable.tokenValue);
        lexicalAnalyzer.analyze();  //준비된 file의 String 데이터를 읽어들인 후 analyze 하여 symbolTable에 저장

    }
}
