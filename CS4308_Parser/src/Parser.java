/**
 * CS4380 W01
 Concepts of Programming Languages
 Professor: Jose M Garrido
 Students: Juan E. Tenorio Arzola, Thomas Nguyen, Andrew Shatz
 */
/*
Parts that need work
-Print method issues are in comments there
-if RB present needs a match and if LB_Present needs a match if needed.
-Handling ArrayList, may have to do toArray() method. Not sure how to go from one node to the next
 */
/*
 */
import com.sun.javafx.fxml.expression.Expression;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Parser
{
        public static void main(String[] args) throws FileNotFoundException
        {
            lexer lex = null;
            // head of tree;
            ArrayList<Node> head = new ArrayList<>();
            //keeps track of branches
            //if end is hit. Branch++ should be called an new branch next node should be start of array.
            int branch = 0;
            //If true current token will be added to branch and will continue.
            Boolean addTo = true;
            //Keeps track of where new tokens should be added.
            //Should move when new node is added or end statement hits.
            Node current = new Node();


            while (lex.getNextToken().tokType != "EOS")
            {
                {
                    token next = lex.getNextToken();
                    while (next.tokType != "END")
                    {
                        //Need to change end to some lexeme or something that equals end not variable name
                        if (match(lex.getNextToken().tokType) == true)
                        {
                            addTo = true;
                        }
                        else
                            {
                            addTo = false;
                        }
                        //As long as addTo is true the token can be added to the new branch.
                        if (addTo == true)
                        {
                            current.setChild(new Node(next, branch));
                            current = current.getChild();
                        }
                    }

                    if (next.tokType == "END")
                    {
                        //Need to change end to some lememe or something that equals end not variable name
                        branch++;
                        //May have to do while loop to make sure the taken matches requirements.
                        //match token.
                        if (match(lex.getNextToken().tokType) == true)
                        {
                            head.add(new Node(next, branch));//**************************May or may not be wrong.
                        }
                        //Don't think it's necessary
                       // else
                        //{
                            //while may be necessary
                          //  next = lex.getNextToken();//Causes it to move to next and see if viable.
                       // }
                    }
                }
            }
            //print tree
            Node track= new Node();// should equal first spot in tree
            while (track.nToken.tokType !="EOS"){
                while(track.nToken.tokTyep!="END"){
                    System.out.print(track.nToken.Lexeme);
                    track=track.next;
                }

                //move to next branch
                if(track.nToken.tokenType==end){
                    System.out.println();
                    //moves to next branch.
                    track=head.next();//not right may have to do to array() and go from there.
                }
        }

        //Should read token and and call method that checks till "end" or when requirement is met.
        public static boolean match(String m)
        {
            if (m == "LP")
            {
                //Call method to see if RP is present
                if (LP_PRESENT("RP") == true)
                {
                    return true;

                }
                else
                {
                    return false;
                }
                //Do this for all the possible types
            }
            // print statement no matching token
            if (m == "RP") {
                //Call method to see if RP is present
                if (RP_PRESENT("END") == true) {
                    return true;

                } else {
                    return false;
                }
            }
                //Do this for all the possible types
                if (m == "SM")
                {
                    //Call method to see if RP is present
                    if (SM_PRESENT("ID") == true)
                    {
                        return true;

                    }
                    else
                    {
                        return false;
                    }

            }





            return false;//Print error here non recongnizable token
        }

        //Start of checking if next token type is present.
        //parameter is the tokenType
        //Para is used during if's and whiles and right para should be followed by a {
        public static boolean RP_PRESENT(String rB)
        {

              if (rB=="RB") {
                  return true;
              }
              else

            return false;

        }
        //After left ( right but be present at some point or error. Only one expression per line so no (( or ))
        public static boolean LP_PRESENT(String rP)
        {
                //Scan next token till end some how.
                if (rP == "RP")
                {
                    return true;
                }
            else{
            return false;}
        }
        //if product is present the next token should be an ID... true for all operators
        public static boolean PD_PRESENT(String pD) {

                if (pD == "ID") {
                    return true;
                }
            else{
            return false;}
        }

        public static boolean SM_PRESENT(String sM)
        {
                if(sM == "ID")
                {
                    return true;
                }
                else{
                    return false;}
        }
        public static boolean DV_PRESENT(String dV)
        {

                if(dV == "DV")
                {
                    return true;
                }
                else{
                    return false;}
        }
        public static boolean MP_PRESENT(String mP)
        {
                if(mP == "MP")
                {
                    return true;
                }
                else{
                    return false;}
        }
        public static boolean ST_PRESENT(String sT)
        {
                if(sT == "ST")
                {
                    return true;
                }
            }
            return false;
        }
        public static boolean NUM_PRESENT(String nUM)
        {

                if(nUM == "NUM")
                {
                    return true;
                }
                else{
                    return false;}
        }
        public static boolean ID_PRESENT(String iD)
        {

                if((iD == "ID" )|| (iD == "SM" ) || (iD == "DV" )||(iD == "ST") || (iD == "MP" ))
                {
                    return true;
                }
                else{
            return false;}
        }
        public static boolean EQ_PRESENT(String eQ)
        {
                if(eQ == "EQ")
                {
                    return true;
                }
                else{
                    return false;}
        }
        public static boolean AS_PRESENT(String aS)
        {

                if(aS == "AS")
                {
                    return true;
                }
                else{
                    return false;}
        }
        //{
        //maybe not EOS
        public static boolean LB_PRESENT(String LB)
        {
                if(LB != "EOS")
                {
                    return true;
                }
                else{
                    return false;}
        }
        // not sure if RB needs anything.
        /*
        public static boolean RB_PRESENT(String eOS)
        {
            if(eOS == "EOS")
             {
               return true;
            }
            else{
                return false;}
        }
    */
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
    RB }
    LB {
 */
}

























// matching methods go below here.
// will be like for RP Present scan till end if none token.lexeme== ")" print error, return false; if ) return true



//grabs next token without moving initial scanner
//    public token getNextToken()
//    {
//        String tok = null;
//        tok = this.lex.getNextToken();
//        return tok;
//    }

