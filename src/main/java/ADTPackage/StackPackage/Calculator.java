package ADTPackage.StackPackage;

public class Calculator
{
    public static void main(String[] args) 
    {
        // Given infix, then convert to Postfix
        String infix = "a*b/(c-a)+d*e";
        String postfix = convertToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);

        // Given values, a = 2, b = 3, c = 4, d = 5, e = 6
        String numPostfix = "23*42-/56*+";
        System.out.println("Evaluation: " + evaluatePostfix(numPostfix));
    }

    /** Converts infix expression to postfix expression
     * @param infix Infix expression containing alphabetical operands
     * @return Conversion of infix to postfix expression
     */

    public static String convertToPostfix(String infix)
    {
        if(infix.length() == 0)
        {
            return "";
        }

        LinkedStack<String> operatorStack = new LinkedStack<>();
        String postfix = "";
        int index = 0;

        while(index != (infix.length()))
        {
            String nextCharacter = infix.substring(index, index + 1).toLowerCase();
            if(nextCharacter != " ")
            {
                switch (nextCharacter)
                {
                    case "a": case "b": case "c": case "d": case "e":
                    case "f": case "g": case "h": case "i": case "j":
                    case "k": case "l": case "m": case "n": case "o":
                    case "p": case "q": case "r": case "s": case "t":
                    case "u": case "v": case "w": case "x": case "y":
                    case "z":
                        postfix += nextCharacter;
                        break;

                    case "^":
                        operatorStack.push(nextCharacter);
                        break;

                    case "+" : case "-" : case "*" : case "/":
                        int nextCharPrecedence = 0;
                        int peekPrecedence = 0;

                        if(nextCharacter.equals("*") || nextCharacter.equals("/"))
                        {
                            nextCharPrecedence = 2;
                        }
                        else if (nextCharacter.equals("+") || nextCharacter.equals("-"))
                        {
                            nextCharPrecedence = 1;
                        }

                        if ( !operatorStack.isEmpty() )
                        {
                            if(operatorStack.peek().equals("*") || operatorStack.peek().equals("/"))
                            {
                                peekPrecedence = 2;
                            }
                            else if (operatorStack.peek().equals("+") || operatorStack.peek().equals("-"))
                            {
                                peekPrecedence = 1;
                            }
                        }

                        while(!operatorStack.isEmpty() && (nextCharPrecedence <= peekPrecedence)
                                && !operatorStack.peek().equals("("))
                        {
                            postfix += operatorStack.peek();
                            operatorStack.pop();

                            if(!operatorStack.isEmpty())
                            {
                                if(operatorStack.peek() == "*" || operatorStack.peek() == "/")
                                {
                                    peekPrecedence = 2;
                                }
                                else if (operatorStack.peek() == "+" || operatorStack.peek() == "-")
                                {
                                    peekPrecedence = 1;
                                }
                                else
                                {
                                    peekPrecedence = 0;
                                }
                            }
                        }
                        operatorStack.push(nextCharacter);
                        break;

                    case "(":
                        operatorStack.push(nextCharacter);
                        break;

                    case ")":
                        String topOperator = operatorStack.pop();
                        while (!topOperator.equals("("))
                        {
                            postfix += topOperator;
                            topOperator = operatorStack.pop();
                        }
                        break;

                    default: break;
                }
            }

            index++;
        }

        while (!operatorStack.isEmpty())
        {
            String topOperator = operatorStack.pop();
            postfix += topOperator;
        }

        return postfix;
    }

    /** Evaluates a postfix expression assuming user sets the value
     * @param postfix Postfix expression containing numerical operands
     * @return Integer number of evaluation of postfix
     */

    public static int evaluatePostfix(String postfix)
    {
        if(postfix.length() == 0)
        {
            return 0;
        }

        ArrayStack <Integer> valueStack = new ArrayStack<>();
        int index = 0;
        String nextCharacter;
        int result = 0;
        while(index != postfix.length())
        {
            nextCharacter = postfix.substring(index, index + 1);

            if(nextCharacter != " ")
            {
                switch (nextCharacter)
                {
                    case "0": case "1": case "2": case "3": case "4":
                    case "5": case "6": case "7": case "8": case "9":
                        valueStack.push(Integer.parseInt(nextCharacter));
                        
                        break;
                        
                    case "+": case "-": case "*": case "/": case "^":
                        
                            int operandTwo = valueStack.pop();
                            int operandOne = valueStack.pop();
    
                            if (nextCharacter.equals("+"))                         
                            result = operandOne + operandTwo;                                
                           

                            else if (nextCharacter.equals("-"))
                            result = operandOne - operandTwo;                                
                           

                            else if (nextCharacter.equals("*"))
                            result = operandOne * operandTwo;
                            
                            else if (nextCharacter.equals("/"))
                            result = operandOne / operandTwo;
                            

                            else if (nextCharacter.equals("^"))
                            result = (int) Math.pow(operandOne, operandTwo);
                         
                        valueStack.push(result);
                    
                    break;

                    default: break;

                }

            }
            index++;
        }

        return valueStack.peek();
    }
}
