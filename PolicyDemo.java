import java.util.*;
import java.io.*;

public class Demo
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Policy> list = new ArrayList<>();

        File file = new File("PolicyInformation.txt");
        Scanner input = new Scanner(file);

        // Read file and create Policy objects
        while (input.hasNext())
        {
            String policyNumber = input.nextLine();
            String providerName = input.nextLine();
            String firstName = input.nextLine();
            String lastName = input.nextLine();
            int age = Integer.parseInt(input.nextLine());
            String smokingStatus = input.nextLine();
            double height = Double.parseDouble(input.nextLine());
            double weight = Double.parseDouble(input.nextLine());

            Policy p = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
            list.add(p);

            if (input.hasNext())
                input.nextLine(); // skip blank line
        }

        input.close();

        int smokers = 0;
        int nonSmokers = 0;

        // Display each policy
        for (Policy p : list)
        {
            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println("Policyholder's First Name: " + p.getFirstName());
            System.out.println("Policyholder's Last Name: " + p.getLastName());
            System.out.println("Policyholder's Age: " + p.getAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
            System.out.println("Policyholder's Height: " + p.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + p.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", p.getBMI());
            System.out.printf("Policy Price: $%.2f\n", p.calculatePolicyPrice());
            System.out.println();

            if (p.getSmokingStatus().equalsIgnoreCase("smoker"))
                smokers++;
            else
                nonSmokers++;
        }

        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }
}
