import java.util.Scanner;

public class ram {
    private int clock_rate, memory_size;
    private String model, type_memory;
    private int price;

    public ram(int clock_rate, int memory_size, String model, String type_memory)
    {
        this.clock_rate = clock_rate;
        this.memory_size = memory_size;
        this.model = model;
        this.type_memory = type_memory;
    }

    public ram(int memory_size)
    {
        this.memory_size = memory_size;
    }

    public ram()
    {
        this.clock_rate = 0;
        this.memory_size = 0;
        this.model = null;
        this.type_memory = null;
    }
    
    public void input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the model, type, frequency, amount, and price of RAM (via \"Enter\")\n");
        this.model = in.nextLine();
        this.type_memory = in.nextLine();
        this.clock_rate = in.nextInt();
        this.memory_size = in.nextInt();
        this.price = in.nextInt();
    }

    public void output()
    {
        System.out.printf("\nRAM\n\t-model: %s", this.model);
        System.out.printf("\n\t-memory type: %s", this.type_memory);
        System.out.printf("\n\t-clock rate: %d", this.clock_rate);
        System.out.printf("\n\t-size: %d", this.memory_size);
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

    public void set_type_memory(String type_memory)
    {
        this.type_memory = type_memory;
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

    public String get_type_memory()
    {
        return type_memory;
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
            System.out.printf("\nPlease enter the RAM model\n");
            input_model();
        }
    }
}
