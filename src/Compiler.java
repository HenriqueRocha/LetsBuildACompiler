import java.io.IOException;

public class Compiler {
    private static char lookahead;

    public static void main(String[] args) throws IOException {
        lookahead = (char) System.in.read();
        try {
            expression();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void expression() throws IOException, ParseException {
        System.out.println("mov $" + getNum() + ", %eax");
    }

    private static char getNum() throws IOException, ParseException {
        if (!Character.isDigit(lookahead)) {
            throw new ParseException("Integer expected");
        }
        return lookahead;
    }

    static class ParseException extends Exception {

        ParseException(String reason) {
            super(reason);
        }
    }
}
