import java.util.Scanner;

public class gpu {
    private int clock_rate, bandwidth, memory_size, power;
    private String model;
    private int price;

    public gpu(int clock_rate, int bandwidth, int memory_size, int power, String model)
    {
        this.clock_rate = clock_rate;
        this.bandwidth = bandwidth;
        this.memory_size = memory_size;
        this.power = power;
        this.model = model;
    }

    public gpu(int clock_rate)
    {
        this.clock_rate = clock_rate;
    }

    public gpu()
    {
        this.clock_rate = 0;
        this.bandwidth = 0;
        this.memory_size = 0;
        this.power = 0;
        this.model = null;
    }

    public void input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the model, frequency, memory bandwidth, memory size, power consumption and price of the graphics card (via \"Enter\")\n");
        this.model = in.nextLine();
        this.clock_rate = in.nextInt();
        this.bandwidth = in.nextInt();
        this.memory_size = in.nextInt();
        this.power = in.nextInt();
        this.price = in.nextInt();
    }

    public void output()
    {
        System.out.printf("\nGPU\n\t-model: %s", this.model);
        System.out.printf("\n\t-clock rate: %d", this.clock_rate);
        System.out.printf("\n\t-bandwidth memory: %d", this.bandwidth);
        System.out.printf("\n\t-memory size: %d", this.memory_size);
        System.out.printf("\n\t-power consumption: %d", this.power);
        System.out.printf("\n\t-price: %d", this.price);
    }

    public void set_clock_rate(int clock_rate)
    {
        this.clock_rate = clock_rate;
    }

    public void set_memory_size(int memory_size)
    {
        this.memory_size = memory_size;
    }

    public void set_model(String model)
    {
        this.model = model;
    }

    public void set_power(int power)
    {
        this.power = power;
    }

    public void set_bandwidth(int bandwidth)
    {
        this.bandwidth = bandwidth;
    }

    public int get_clock_rate()
    {
        return clock_rate;
    }

    public int get_memory_size()
    {
        return memory_size;
    }

    public String get_model()
    {
        return model;
    }

    public int get_power()
    {
        return power;
    }

    public int get_bandwidt()
    {
        return bandwidth;
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
            System.out.printf("\nPlease enter the GPU model\n");
            input_model();
        }
    }
}
