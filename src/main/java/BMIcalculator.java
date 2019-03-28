import java.util.Scanner;

public class BMIcalculator implements calculator {

    private double BMIresult;
    private String template = "You're %s";
    private String text ="";
    private double heightInMeters;

    public BMIcalculator(int weight, int height) {

        if (weight<= 0 || height <= 0){
            throw new IllegalArgumentException("Put positive value");
        }
        if (weight > 300){
            throw new IllegalArgumentException("Limit is 300kg");
        }
        if (height > 250){
            throw new IllegalArgumentException("Limit is 250cm");
        }

         heightInMeters = (double)height / 100;
         BMIresult = weight / Math.pow(heightInMeters,2);
         BMIresult*=100;
         BMIresult = Math.round(BMIresult);
         BMIresult/=100;


    }
    @Override
    public String calculate() {

        return "BMI: " + BMIresult;
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
