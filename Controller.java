package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class Controller{
    public String number = "";
    public String fullEquation = "";
    public float total = 0;
    public ArrayList<String> totalEquation = new ArrayList<String>();
    public TextField screen, screen2;

    @FXML
    public void whenClicked(ActionEvent event){
        Button sourceButton = (Button) event.getSource();

        if(number.endsWith(".") && sourceButton.getText().equals("."))
            return;
        else{
            number += sourceButton.getText();
            fullEquation += sourceButton.getText();
            screen.setText(fullEquation);
        }
    }

    @FXML
    public void printFullEquation(){
        String temp = "";
        for (int i=0; i<totalEquation.size(); i++)
            temp += totalEquation.get(i) + " ";
        screen2.setText(temp);
    }

    @FXML
    public void arithmeticOperation(ActionEvent event){
        Button sourceButton = (Button) event.getSource();
        if(fullEquation.length() == 0){
            return;
        }

        if(fullEquation.charAt(fullEquation.length()-1) >= 48 && fullEquation.charAt(fullEquation.length()-1) <= 57){
            totalEquation.add(number);
            totalEquation.add(sourceButton.getText());
            fullEquation += sourceButton.getText();
            screen.setText(fullEquation);
            printFullEquation();
            number = "";
        }else{
            return;
        }

    }

    @FXML
    public void clear(){
        screen.clear();
        screen2.clear();
        totalEquation.clear();
        number = "";
        fullEquation = "";
        total = 0;
    }

    @FXML
    public void clearEntry(){
        String tempFullEquation = "";
        for(int i=0; i<fullEquation.length()-1; i++){
            tempFullEquation += fullEquation.charAt(i);
        }
        number = "";
        fullEquation = tempFullEquation;
        screen.setText(tempFullEquation);


    }

    @FXML
    public void makeNegative(){
        String tempEquation = "";
        if(number != ""){
            return;
        }
       if(fullEquation != ""){
           for(int i=0; i<fullEquation.length(); i++){
               tempEquation += fullEquation.charAt(i);
           }
           fullEquation = tempEquation + " ";
       }
       number = "-" + number;
       fullEquation += number;
       screen.setText(fullEquation);

    }

    @FXML
    public void equals(){
        screen.clear();
        totalEquation.add(number);
        total += Float.parseFloat(totalEquation.get(0));
        for(int i=1; i<totalEquation.size(); i+=2){
            String sign = totalEquation.get(i);
            float tempNum = 0;
            if(!totalEquation.get(i+1).isEmpty()) {
                tempNum = Float.parseFloat(totalEquation.get(i + 1));
            }
            else{
                fullEquation += "0";
            }
            if(sign.equals("+"))
                total+= tempNum;
            else if(sign.equals("-"))
                total-= tempNum;
            else if(sign.equals("x"))
                total*= tempNum;
            else if(sign.equals("/")) {
                if (tempNum == 0) {
                    total = 0;
                    fullEquation += " = cannot divide by zero";
                }else {
                    total /= tempNum;
                }
            }
            else if(sign.equals("%"))
                total = ((total/100) * tempNum);
        }
        if(!fullEquation.endsWith("zero"))
            fullEquation += " = " + total;

        screen2.setText(fullEquation);
        screen.clear();
        totalEquation.clear();
        number = "";
        total = 0;
        fullEquation = "";

    }



}
