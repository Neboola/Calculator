package com.luxoft;

/**
 * Created by 2 on 11/25/2015.
 */
public class SearchingComments {

    public static void main(String[] args) {


        String s = "/* !!!!!!!!!DELETE!!!!!!!!!!! */\n" +
                "public class Example {\n" +
                "char c = '/';    \n" +
                "// !!!!!!!!!!!!DELETE!!!!!!!!!!!!!!! \n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        Polimorf.test(); //!!!!!!!!!!!!DELETE!!!!!!!!!!!!!!!\n" +
                "\n" +
                "        Rand.generateRand(6); //!!!!!!!!!!!!DELETE!!!!!!!!!!!!!!!\n" +
                "\n" +
                "        SubStringSearch.subStringSearch(\"sdfasdfa\");\n" +
                "\n" +
                "/*\n" +
                "!!!!!!!!!!!!DELETE!!!!!!!!!!!!!!! ********* \n" +
                " */\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    public static void sec(int n){\n" +
                "        try {\n" +
                "            Thread.sleep(n*1000);\n" +
                "        } catch (InterruptedException e) {\n" +
                "            e.printStackTrace(); System.out.println(\"// DO NOT DELETE!\"); System.out.println(\"/* DO NOT DELETE! */\"); \n" +
                "        }\n" +
                "    }\n" +
                "/* !!!!!!!!!DELETE!!!!!!!!!!! */\n" +
                "} //";

        System.out.println(s);

        System.out.println();
        System.out.println("===================");
        System.out.println();


        char[] arr = s.toCharArray();
        StringBuffer buf = new StringBuffer();

        State state = new NormalState();

        for (char c : arr) {

            if (state instanceof PossibleCommentState) {
                state = state.nextState(c);
                if (state instanceof NormalState) buf.append('/');
            } else {

                if (state instanceof PossibleEndComment2State) {
                    state = state.nextState(c);
                    if (state instanceof NormalState) continue;

                } else {
                    state = state.nextState(c);
                }

            }

            if (state.canPrint()) buf.append(c);

        }

        System.out.println(buf);

    }

    private abstract static class State {

        abstract State nextState(char c);
        abstract boolean canPrint();
    }
    private static class NormalState extends State {



        @Override
        State nextState(char c) {

            if (c == '"') return new BracketsState();
            if (c == '/') return new PossibleCommentState();
            return this;

        }

        @Override
        boolean canPrint() {
            return true;
        }
    }
    private static class PossibleCommentState extends State {

        @Override
        State nextState(char c) {

            if (c == '/') return new Comment1State();
            if (c == '*') return new Comment2State();
            return new NormalState();
        }

        @Override
        boolean canPrint() {
            return false;
        }
    }
    private static class Comment1State extends State {
        @Override
        State nextState(char c) {
            if (c == '\n') return new NormalState();
            return this;
        }

        @Override
        boolean canPrint() {
            return false;
        }
    }
    private static class Comment2State extends State {
        @Override
        State nextState(char c) {
            if (c == '*') return new PossibleEndComment2State();
            return this;
        }

        @Override
        boolean canPrint() {
            return false;
        }
    }
    private static class PossibleEndComment2State extends State {
        @Override
        State nextState(char c) {
            if (c == '/') return new NormalState();
            return new Comment2State();
        }

        @Override
        boolean canPrint() {
            return false;
        }
    }
    private static class BracketsState extends State {
        @Override
        State nextState(char c) {
            if (c == '"') return new NormalState();
            return this;
        }

        @Override
        boolean canPrint() {
            return true;
        }
    }

}