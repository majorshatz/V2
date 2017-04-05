/**
 * CS4380 W01
 Concepts of Programming Languages
 Professor: Jose M Garrido
 Students: Juan E. Tenorio Arzola, Thomas Nguyen, Andrew Shatz
 */

public class token
{
    String lexeme;
    String tokType;

    public token(String tokType, String lexeme)
    {
        this.tokType = tokType;
        this.lexeme = lexeme;
    }
    public String getLexeme()
    {
        return this.lexeme;
    }
    public String getTokType()
    {
        return this.tokType;
    }

}

/*
TokenType
    PD,
    SM,
    DV,
    MP,
    ST,
    NUM,
    KW,
    ID,
    EQ,
    AS,
    LP,
    RP,
    EOS,
 */
