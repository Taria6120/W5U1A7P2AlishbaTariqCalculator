// Filename: W5U1A7P2_Alishba_Tariq_Calculator
// Author: Alishba Tariq 
// Date:  Wednesday, March 21, 2024
// Purpose:  Making a functional calculator
// */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner keyedInput = new Scanner(System.in);
    double inputAmountDouble = 0;
    double num1, num2, answer;
    num1 = 0;
    num2 = 0;
    char inputOperation = 0;
    int countOperand = 0;
    char operator = 'a';
    answer = 0;
    while (true) {
      if (countOperand > 0) {
        System.out.println("+,-,/,*, s (square), r (square root), ^ (power), n (antilog), c (clear), q (for quit)");
        // user can choose the operation
        operator = keyedInput.next().charAt(0);
        keyedInput.nextLine(); // Consume newline
        
      }
      if (operator == 'q') {
        System.out.println("Exiting...");
        break;
        // if user choose q, the program will exit
      }
      if ((operator != 'c') 
          && (operator != 'r')
          && (operator != '^')
          && (operator != 's')
          && (operator != 'n')){
        System.out.println("Enter number: ");
        String inputAmountNum1 = keyedInput.nextLine();
        num1 = Double.parseDouble(inputAmountNum1);
        countOperand++;
        // if user choose any other operator, the program will ask for the second number
      }
      
      switch (operator) {
        case '+':
          if (countOperand == 1)
            answer = num1;
          else
            answer += num1;
          // if user choose +, the program will add the number
          break;
        case '-':
          if (countOperand == 1)
            answer = num1;
          else
            answer -= num1;
          // if user choose -, the program will subtract the number
          break;
        case '*':
          if (countOperand > 1)
            answer *= num1;
          // if user choose *, the program will multiply the number
          break;
        case '/':
          if (countOperand > 1 && num1 != 0)
            answer /= num1;
          // if user choose /, the program will divide the number
          else
            System.out.println("Error: Division by zero or not enough operands!");
          break;
        case 'r':
          if (answer >= 0) {
            answer = Math.sqrt(answer);
            num1 = answer;
          // if user choose r, the program will square root the number
          }
          break;
        case 'c':
          answer = 0;
          countOperand = 0;
          operator = 'a';
          // if user choose c, the program will clear the number
          break;
          
        case '^':
          System.out.println("Enter power: ");
          String inputNum2 = keyedInput.nextLine();
          double power = Double.parseDouble(inputNum2);
          answer = exponentOperation(num1, power);
          num1 = answer;
          // if user choose ^, the program will power the number
        break;

        case 'n':
          if (num1 >= 0) {
            answer = antiLogOperation(num1);
            num1 = answer;
          // if user choose n, the program will antilog the number
          }
        break;
        case 's':
          answer = squareOperation(answer);
          num1 = answer;
          break;
          // if user choose s, the program will square the number
        default:
          answer = num1;
          // if user choose any other operator, the program will keep the number
          break;
      }
      System.out.println("Answer is " + answer);
      // print the answer
    }
    keyedInput.close();
    
  }  
  public static double antiLogOperation(double num1) {
    return exponentOperation(10, num1);
    // antilog is 10^x
  }
  public static double exponentOperation(double base, double power){
    double answer = 1;
    while (power > 0.000001) { 
        if (power >= 1) {
            answer *= base;
            power--;
        } else {
            base = Math.sqrt(base);
            power *= 2;
          // exponent operation
        }
    }
    return answer;
  }
  public static double squareOperation(double num1) {
    return num1 * num1;
    // square operation
  }
}