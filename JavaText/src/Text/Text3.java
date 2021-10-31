package Text;

import java.util.Scanner;

public class Text3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = null;
        int hours;
        double hourRate;
        double federalRate;
        double stateRate;
        double gross;
        try {
            name = sc.nextLine();
            hours = sc.nextInt();
            hourRate = sc.nextDouble();
            federalRate = sc.nextDouble();
            stateRate = sc.nextDouble();
            gross = hourRate * hours;
            System.out.println("Employee Name:" + name);
            System.out.println("Hours Worked:" + hours);
            System.out.println("Pay Rate:" + hourRate);
            System.out.println("Gross Pay" + hourRate*hours);
            System.out.println("Deductions:");
            System.out.println("Federal Withholding (" + (federalRate * 100) + "%)" + ": $" + federalRate*gross);
            System.out.println("State Withholding(" + (stateRate * 100) + "%): $" + stateRate*gross);
            System.out.printf("Total Deduction: $%.2f", (federalRate + stateRate)*gross);
            System.out.printf("Net Pay: $%.2f", (1 - federalRate - stateRate)*gross);
        } catch (Exception e) {
            System.out.println("输入的格式不正确，请输入正确的格式！");
        }

    }

}
