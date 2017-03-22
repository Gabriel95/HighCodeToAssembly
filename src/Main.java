
import java.io.*;
import java.util.HashMap;
import java.util.List;

import codegeneration.DataGeneration;
import codegeneration.VariableGenerator;
import tree.statement.StatementNode;

public class Main {

    static public void main(String argv[]) {
        /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("src/test.txt")));
            List<StatementNode> result = (List<StatementNode>) p.parse().value;

            String code = "";

            for(StatementNode stmnt:result)
            {
                code+= stmnt.generateCode();
            }

            code = DataGeneration.GenerateDeclarations(VariableGenerator.getInstance().getVariables()) + code + DataGeneration.GenerateBottomTemplate();

            System.out.println(code);

        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }
}
