package cashMachine;

import javaRepositories.Print;

public class CashMachine
{
    public void sortMoneyBill(double[] moneyBill)
    {
        int i, j;
        double helper;
        for (i = 0; i < moneyBill.length; i++)
        {
            for (j = 0; j < moneyBill.length - 1; j++)
            {
                if (moneyBill[j] < moneyBill[j + 1])
                {
                    helper = moneyBill[j];
                    moneyBill[j] = moneyBill[j + 1];
                    moneyBill[j + 1] = helper;
                }
            }
        }
    }

    public void bankDraft(double[] moneyBill, double value)
    {
        int[] moneyBillQuantity = new int[10];
        double valueBankDraft = value;
        double remainder = 0;

        Print.print("");
        Print.print("BankDraft with the value: " + valueBankDraft);

        for (int i = 0; i < moneyBill.length; i++)
        {
            if (value == moneyBill[i] || value >= moneyBill[i])
            { //se o value do BankDraft for igual ao value da nota ou //se o value do saque for maior ou igual o da nota, adiciona essa nota para ser sacada
                moneyBillQuantity[i] += 1;
                value -= moneyBill[i];
            }
        }

        if (valueBankDraft - value != 0)
        {
            remainder = value;
            for (int j = 0; j < moneyBill.length; j++)
            {
                if (remainder == moneyBill[j] || remainder >= moneyBill[j])
                { //se o value do saque for igual ao value da nota ou //se o value do saque for maior ou igual o da nota, adiciona essa nota para ser sacada
                    moneyBillQuantity[j] += 1;
                    remainder -= moneyBill[j];
                }
            }
        }
        else
        {
            remainder = value;
        }

        for (int i = 0; i < moneyBill.length; i++)
        {
            Print.print("Money bill: " + moneyBill[i]);
            Print.print("Quantity of money bill: " + moneyBillQuantity[i]);
            Print.print("");
        }
        Print.print("Remainder: " + remainder);
    }
}

