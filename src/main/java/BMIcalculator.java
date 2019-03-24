import java.util.Scanner;

public class BMIcalculator implements calculator {

    double BMIresult;
    String template = "You're %s";
    String text ="";
    public BMIcalculator(int weight, int height) {

         BMIresult = weight / Math.pow((height*0.01),2);

    }
    @Override
    public String calculate() {

        return "Your BMI index is: " + BMIresult;
    }

    @Override
    public String interpret() {

        if (BMIresult<=15){
            text = "very severely underweight";
        }else if(BMIresult>15 && BMIresult<=16){
            text = "severely underweight";
        }
        else if (BMIresult>16 && BMIresult<=18.5){
            text = "underweight";
        }
        else if (BMIresult>18.5 && BMIresult<=25){
            text = "normal";
        }
         else if(BMIresult>25 && BMIresult<=30){
            text = "overweight";
        }
         else if(BMIresult>30 && BMIresult<=35){
            text = "obese Class I";
        }
        else if(BMIresult>35 && BMIresult<=40){
            text = "obese Class II";
        }
        else if(BMIresult>40 && BMIresult<=45){
            text = "obese Class III";
        }
        else if(BMIresult>45 && BMIresult<=50){
            text="obese Class IV";
        }
        else if(BMIresult>50 && BMIresult<=60){
            text = "obese Class V";
        }

       return String.format(template,text);
    }
}
