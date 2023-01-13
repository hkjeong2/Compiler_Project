package syntaxAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class table {
    //slr parsing table 및 production table 셋업
    //위 정보를 기반으로 syntax analyzing 과정에서 shift&goto or reduce 중 하나를 계속해서 결정

    ArrayList<HashMap<String, String>> actionTable = new ArrayList<>();
    ArrayList<HashMap<String, String>> gotoTable = new ArrayList<>();
    ArrayList<HashMap<String, ArrayList<String>>> production = new ArrayList<>();

    public table(){
        setupTable();
        setupProduction();
    }

    public void setupTable(){
        setupActionTable();
        setupGotoTable();
    }

    public void setupActionTable(){
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s4");
            put("$", "r3");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("$", "acc");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s4");
            put("$", "r3");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s4");
            put("$", "r3");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s7");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("$", "r1");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("$", "r2");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "s8");
            put("lparen", "s9");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "r4");
            put("id", "r4");
            put("rbrace", "r4");
            put("if", "r4");
            put("while", "r4");
            put("return", "r4");
            put("$", "r4");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s11");
            put("rparen", "r7");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "s12");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s13");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("lbrace", "s14");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "r9");
            put("comma", "s16");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s23");
            put("id", "s20");
            put("rbrace", "r11");
            put("if", "s21");
            put("while", "s22");
            put("return", "r11");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "r6");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s24");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("return", "s26");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s23");
            put("id", "s20");
            put("rbrace", "r11");
            put("if", "s21");
            put("while", "s22");
            put("return", "r11");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "r12");
            put("id", "r12");
            put("rbrace", "r12");
            put("if", "r12");
            put("while", "r12");
            put("return", "r12");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("assign", "s28");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("lparen", "s29");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("lparen", "s30");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s31");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s32");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rbrace", "s33");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rbrace", "r10");
            put("return", "r10");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("literal", "s40");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "s8");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "r9");
            put("comma", "s16");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "r5");
            put("$", "r5");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "s47");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r23");
            put("rparen", "r23");
            put("addsub", "r23");
            put("multdiv", "r23");
            put("comp", "r23");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r24");
            put("rparen", "r24");
            put("addsub", "r24");
            put("multdiv", "r24");
            put("comp", "r24");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "s49");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r16");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r17");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r19");
            put("rparen", "r19");
            put("addsub", "s50");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r21");
            put("rparen", "r21");
            put("addsub", "r21");
            put("multdiv", "s51");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "s52");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("comp", "s53");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "s54");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "r8");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rbrace", "r26");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "s55");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "r13");
            put("id", "r13");
            put("rbrace", "r13");
            put("if", "r13");
            put("while", "r13");
            put("return", "r13");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("lbrace", "s58");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("id", "s36");
            put("lparen", "s35");
            put("num", "s37");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("lbrace", "s60");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r22");
            put("rparen", "r22");
            put("addsub", "r22");
            put("multdiv", "r22");
            put("comp", "r22");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r18");
            put("rparen", "r18");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("semi", "r20");
            put("rparen", "r20");
            put("addsub", "r20");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s23");
            put("id", "s20");
            put("rbrace", "r11");
            put("if", "s21");
            put("while", "s22");
            put("return", "r11");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rparen", "r25");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s23");
            put("id", "s20");
            put("rbrace", "r11");
            put("if", "s21");
            put("while", "s22");
            put("return", "r11");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rbrace", "s63");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rbrace", "s64");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("else", "s65");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "r15");
            put("id", "r15");
            put("rbrace", "r15");
            put("if", "r15");
            put("while", "r15");
            put("return", "r15");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("lbrace", "s66");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "s23");
            put("id", "s20");
            put("rbrace", "r11");
            put("if", "s21");
            put("while", "s22");
            put("return", "r11");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("rbrace", "s68");
        }});
        actionTable.add(new HashMap<String, String>(){{
            put("vtype", "r14");
            put("id", "r14");
            put("rbrace", "r14");
            put("if", "r14");
            put("while", "r14");
            put("return", "r14");
        }});
    }

    public void setupGotoTable(){
        gotoTable.add(new HashMap<String, String>(){{
            put("CODE", "1");
            put("VDECL", "2");
            put("FDECL", "3");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("CODE", "5");
            put("VDECL", "2");
            put("FDECL", "3");
        }});
        gotoTable.add(new HashMap<String, String>(){{
            put("CODE", "6");
            put("VDECL", "2");
            put("FDECL", "3");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("ARG", "10");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("MOREARGS", "15");
        }});
        gotoTable.add(new HashMap<String, String>(){{
            put("VDECL", "19");
            put("BLOCK", "17");
            put("STMT", "18");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("RETURN", "25");
        }});
        gotoTable.add(new HashMap<String, String>(){{
            put("VDECL", "19");
            put("BLOCK", "27");
            put("STMT", "18");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("FACTOR", "34");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("RHS", "38");
            put("EXPR", "39");
            put("TERM", "41");
            put("FACTOR", "42");
        }});
        gotoTable.add(new HashMap<String, String>(){{
            put("FACTOR", "44");
            put("COND", "43");
        }});
        gotoTable.add(new HashMap<String, String>(){{
            put("FACTOR", "44");
            put("COND", "45");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("MOREARGS", "46");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("EXPR", "48");
            put("TERM", "41");
            put("FACTOR", "42");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("EXPR", "56");
            put("TERM", "41");
            put("FACTOR", "42");
        }});
        gotoTable.add(new HashMap<String, String>(){{
            put("TERM", "57");
            put("FACTOR", "42");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("FACTOR", "59");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("VDECL", "19");
            put("BLOCK", "61");
            put("STMT", "18");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("VDECL", "19");
            put("BLOCK", "62");
            put("STMT", "18");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){{
            put("VDECL", "19");
            put("BLOCK", "67");
            put("STMT", "18");
        }});
        gotoTable.add(new HashMap<String, String>(){});
        gotoTable.add(new HashMap<String, String>(){});
    }

    public void setupProduction(){
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("S", new ArrayList<>(Arrays.asList("CODE")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("CODE", new ArrayList<>(Arrays.asList("VDECL", "CODE")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("CODE", new ArrayList<>(Arrays.asList("FDECL", "CODE")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("CODE", new ArrayList<>(Arrays.asList("epsilon")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("VDECL", new ArrayList<>(Arrays.asList("vtype", "id", "semi")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("FDECL", new ArrayList<>(Arrays.asList("vtype", "id", "lparen", "ARG", "rparen", "lbrace", "BLOCK", "RETURN", "rbrace")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("ARG", new ArrayList<>(Arrays.asList("vtype", "id", "MOREARGS")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("ARG", new ArrayList<>(Arrays.asList("epsilon")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("MOREARGS", new ArrayList<>(Arrays.asList("comma", "vtype", "id", "MOREARGS")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("MOREARGS", new ArrayList<>(Arrays.asList("epsilon")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("BLOCK", new ArrayList<>(Arrays.asList("STMT", "BLOCK")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("BLOCK", new ArrayList<>(Arrays.asList("epsilon")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("STMT", new ArrayList<>(Arrays.asList("VDECL")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("STMT", new ArrayList<>(Arrays.asList("id", "assign", "RHS", "semi")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("STMT", new ArrayList<>(Arrays.asList("if", "lparen", "COND", "rparen", "lbrace", "BLOCK", "rbrace", "else", "lbrace", "BLOCK", "rbrace")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("STMT", new ArrayList<>(Arrays.asList("while", "lparen", "COND", "rparen", "lbrace", "BLOCK", "rbrace")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("RHS", new ArrayList<>(Arrays.asList("EXPR")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("RHS", new ArrayList<>(Arrays.asList("literal")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("EXPR", new ArrayList<>(Arrays.asList("TERM", "addsub", "EXPR")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("EXPR", new ArrayList<>(Arrays.asList("TERM")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("TERM", new ArrayList<>(Arrays.asList("FACTOR", "multdiv", "TERM")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("TERM", new ArrayList<>(Arrays.asList("FACTOR")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("FACTOR", new ArrayList<>(Arrays.asList("lparen", "EXPR", "rparen")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("FACTOR", new ArrayList<>(Arrays.asList("id")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("FACTOR", new ArrayList<>(Arrays.asList("num")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("COND", new ArrayList<>(Arrays.asList("FACTOR", "comp", "FACTOR")));
        }});
        production.add(new HashMap<String, ArrayList<String>>(){{
            put("RETURN", new ArrayList<>(Arrays.asList("return", "FACTOR", "semi")));
        }});
    }

}
