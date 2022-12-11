import java.util.Scanner;

public class psu {
    private int power;
    private String model;
    private int price;

    public psu(int power, String model)
    {
        this.power = power;
        this.model = model;
    }

    public psu(int power)
    {
        this.power = power;
    }

    public psu()
    {
        this.power = 0;
        this.model = null;
    }

    public void input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the model, wattage and price of the power supply (via \"Enter\")\n");
        this.model = in.nextLine();
        this.power = in.nextInt();
        this.price = in.nextInt();
    }

    public void output()
    {
        System.out.printf("\nPower supply:\n\t-model: %s", this.model);
        System.out.printf("\n\t-power: %d", this.power);
        System.out.printf("\n\t-price: %d", this.price);
    }

    public int get_power()
    {
        return power;
    }

    public String get_model()
    {
        return model;
    }

    public void set_power(int power)
    {
        this.power = power;
    }

    public void set_model(String model)
    {
        this.model = model;
    }

    public void set_price(int price) { this.price = price; }

    public int get_price() { return price; }

    void input_model() {
        Scanner in = new Scanner(System.in);
        this.model = in.nextLine();
    }

    public void null_model() {

        try {
            if (model == "-")
                throw new Ex();
        }
        catch (Ex e)
        {
            System.out.printf("\nPlease enter the PSU model\n");
            input_model();
        }
    }

}
