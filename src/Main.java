
import java.io.*;
import java.util.HashMap;
import java.util.List;
import tree.statement.StatementNode;

public class Main {

    static public void main(String argv[]) {
        /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("src/test.txt")));
            List<StatementNode> result = (List<StatementNode>) p.parse().value;

            String code="";

            for(StatementNode stmnt:result)
            {
                code+= stmnt.generateCode();
            }

            System.out.println(code);

            int potato = 0;
            potato++;


        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }
}
