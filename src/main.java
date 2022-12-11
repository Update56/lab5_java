import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {

        int n = 1;
        do {
            System.out.printf("Enter amount PC (>0)\n");
            Scanner t = new Scanner(System.in);
            n = t.nextInt();
        } while (n == 0);

        pc_builder[] my_pc = new pc_builder[n];
        performance prf = new performance();

        for (int i = 0; i <= n-1; i++)
        {
            my_pc[i] = new pc_builder();
            System.out.printf("Input %d PC\n", i);
            my_pc[i].input();
        }

        for (int i = 0; i <= n; i++)
        {
            System.out.printf("Checking exception for %d PC\n", i);
            my_pc[i].check_model();
        }
        int choice;
        int number = nmb(n);
        do
        {
            my_pc[n].check_model();

            Scanner in = new Scanner(System.in);
            System.out.printf("\n1. List of accessories\n2. Check compatibility\n3. Build evaluation\n4. Recommendations\n5. Set new accessories\n6.Price and tax\n7.Performance\n8.Another PC.\n56. Exit\n");
            choice = in.nextInt();
            switch (choice)
            {
                case 1:
                    my_pc[number].output();
                    break;
                case 2:
                    my_pc[number].compatibility_check();
                    break;
                case 3:
                    my_pc[number].score();
                    break;
                case 4:
                    my_pc[number].recom();
                    break;
                case 5:
                    my_pc[number].input();
                    break;
                case 6:
                    pc_builder.Tarriff(my_pc[number]);
                    break;
                case 7:
                    my_pc[number].perf(prf);
                    System.out.printf("Performance your CPU is %f Gflop/s", prf.perf_cpu);
                    System.out.printf("Performance your GPU is %f Hash/s (Zhash algorithm)", prf.perf_gpu);
                    break;
                case 8:
                    number = nmb(n);
                    break;
                case 56:
                    break;
                default:
                    System.out.print("Wrong menu item");
                    break;
            }

        } while (choice != 56);

        return;
    }



    private static int nmb(int n)
    {
        Scanner in = new Scanner(System.in);
        System.out.printf("Chose PC (0 - &d)\n", n);
        return in.nextInt();
    }


}
