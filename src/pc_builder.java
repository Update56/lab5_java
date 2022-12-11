import java.util.Scanner;

public class pc_builder {
    private motherboard Motherboard = new motherboard();
    private cpu Cpu = new cpu();
    private gpu Gpu = new gpu();
    private ram Ram = new ram();
    private psu Psu = new psu();
    private static int tax = 0; //стат поле

    public void set_tax(int tax)
    {
        this.tax = tax;
    }
    public int get_tax()
    {
        return tax;
    }

    private void input_tax()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter tax\n");
        this.tax = in.nextInt();
    }
    private int scoring(int var_Keyword, double amount)
    {
        int[] numbers = {0, 0, 0};
        switch (var_Keyword)
        {
            case 0:
                numbers[0] = 4;
                numbers[1] = 8;
                numbers[2] = 16;
                break;
            case 1:
                numbers[0] = 0;
                numbers[1] = 5;
                numbers[2] = 57;
                break;
            case 2:
                numbers[0] = 12;
                numbers[1] = 50;
                numbers[2] = 105;
                break;
            default:
                break;
        }

        if (amount > numbers[0] && amount <= numbers[1])
        {
            return 1;
        }
        else if (amount > numbers[1] && amount <= numbers[2])
        {
            return 2;
        }
        else if (amount > numbers[2])
        {
            return 3;
        }
        return 0;
    }

    public pc_builder(motherboard Motherboard, cpu Cpu, gpu Gpu, ram Ram, psu Psu)
    {
        this.Motherboard = Motherboard;
        this.Cpu = Cpu;
        this.Gpu = Gpu;
        this.Ram = Ram;
        this.Psu = Psu;
    }
    public pc_builder(motherboard Motherboard)
    {
        this.Motherboard = Motherboard;
    }

    public pc_builder()
    {

    }

    public void input()
    {
        Motherboard.input();
        Cpu.input();
        Gpu.input();
        Ram.input();
        Psu.input();
        input_tax();
    }

    public void output()
    {
        Motherboard.output();
        Cpu.output();
        Gpu.output();
        Ram.output();
        Psu.output();
        System.out.printf("\nTax: \n%d", tax);
    }

    public void check_model()
    {
        Motherboard.null_model();
        Cpu.null_model();
        Gpu.null_model();
        Ram.null_model();
        Psu.null_model();
    }

    public void score()
    {
        int total_score = 0;

        double score_cpu = Cpu.get_clock_rate() * Cpu.get_amount_core();
        double score_gpu = (Gpu.get_clock_rate() / 1000.0) * Gpu.get_memory_size() * (Gpu.get_bandwidt() / 100.0);
        double score_ram = (Ram.get_clock_rate() / 1000.0) * Ram.get_memory_size();

        total_score += scoring(0, score_cpu);
        total_score += scoring(1, score_gpu);
        total_score += scoring(2, score_ram);

        if (total_score <= 2)
        {
            System.out.printf("This is a VERY weak PC.");
        }
        else if (total_score > 2 && total_score < 6)
        {
            System.out.printf("It's a weak PC.");
        }
        else if (total_score >= 6 && total_score < 9)
        {
            System.out.printf("It's a good, powerful PC.");
        }
        else if (total_score >= 9)
        {
            System.out.printf("It's the most powerful PC");
        }

    }

    public void recom()
    {
        double score_cpu = Cpu.get_clock_rate() * Cpu.get_amount_core();
        double score_gpu = (Gpu.get_clock_rate() / 1000.0) * Gpu.get_memory_size() * (Gpu.get_bandwidt() / 100.0);
        double score_ram = (Ram.get_clock_rate() / 1000.0) * Ram.get_memory_size();

        int f_score_cpu = scoring(0, score_cpu);
        int f_score_gpu = scoring(1, score_gpu);
        int f_score_ram = scoring(2, score_ram);

        if ((f_score_cpu > f_score_gpu) && (f_score_cpu > f_score_ram))
        {
            System.out.print("The processor is too powerful. It is recommended to choose another or more powerful video card and RAM");
            return;
        }

        if ((f_score_cpu < f_score_gpu) && (f_score_gpu > f_score_ram))
        {
            System.out.print("The video card is too powerful. It is recommended to choose another or more powerful processor and RAM");
            return;
        }

        if ((f_score_cpu < f_score_ram) && (f_score_gpu < f_score_ram))
        {
            System.out.print("Too much memory. It is recommended to choose another or more powerful processor and video card");
            return;
        }

        System.out.print("Your assembly is balanced");
        return;
    }

    public void compatibility_check()
    {
        if (Motherboard.get_socket().equals(Cpu.get_socket())) {
            System.out.print("Processor and motherboard are compatible\n");
        } else {
            System.out.print("Processor and board sockets are different!\n");
        }
        if (Motherboard.get_type_memory().equals(Ram.get_type_memory())) {
            System.out.print("The motherboard and RAM are compatible\n");
        } else {
            System.out.print("The memory type of the motherboard and the RAM are different!\n");
        }
        if ((Cpu.get_power() + Gpu.get_power()) < Psu.get_power()) {
            System.out.printf("The power of the PSU is enough (about %d watts to spare)\n", (Psu.get_power() - (Cpu.get_power() + Gpu.get_power())));
        } else {
            System.out.printf("Weak PSU, not enough %d watts\n", (Cpu.get_power() + Gpu.get_power()) - Psu.get_power());
        }
    }
    public static void Tarriff(pc_builder s) //стат функция
    {
        int temp = s.Cpu.get_price() + s.Gpu.get_price() + s.Psu.get_price() + s.Ram.get_price() + s.Motherboard.get_price(); //Цена ПК
        System.out.printf("Pc price %d\n", temp);
        System.out.printf("Tax equals %d%%\n", s.tax);
        System.out.printf("Price with tax %f\n", temp + (temp * (s.tax / 100.0))); //Цена с таможенной пошлиной
    }
    public void perf(performance k) //передача через вспомогательный класс
    {
        k.perf_cpu = 64 * this.Cpu.get_amount_core() * this.Cpu.get_clock_rate();
        k.perf_gpu = 0.04 * this.Gpu.get_clock_rate();
    }
}

