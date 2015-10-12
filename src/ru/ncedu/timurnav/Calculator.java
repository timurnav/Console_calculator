package ru.ncedu.timurnav;

import ru.ncedu.timurnav.operations.*;

import java.io.IOException;

public class Calculator {

    public void main(){
        double n1 = 0, res;
        Operation o;
        while (true) {
            if (n1==0) n1 = giveMeNumber();
            o = giveMeOperation();
            if (o instanceof UnaryOperation){
                res = ((UnaryOperation)o).execute(n1);
            }
            else res = o.execute(n1, giveMeNumber());
            n1=0;
            if (res!=0 && saveResult()) n1=res;
        }
    }

    private boolean saveResult() {
        ConsoleHelper.writeMessage("If you want use the result of previous operation enter 'r'");
        try {
            return ConsoleHelper.getMessage().equals("r");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Operation giveMeOperation(){
        while (true){
            try {
                ConsoleHelper.writeMessage("Choose the operation. You may enter following simbols:" +
                        "\n " + DataHelper.getOperationsList());
                Operation o = getOperationBySign(ConsoleHelper.getMessage());
                if(o!=null) return o;
                ConsoleHelper.writeMessage("Incorrect input.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private double giveMeNumber(){
        while (true){
            ConsoleHelper.writeMessage("Please enter the number");
            try {
                String s = ConsoleHelper.getMessage();
                return Double.parseDouble(s);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e){
                ConsoleHelper.writeMessage("Incorrect input.");
            }
        }
    }

    private static Operation getOperationBySign(String sign){
        try {
            return (Operation) Class.forName(DataHelper.getClassNameBySign(sign)).newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
