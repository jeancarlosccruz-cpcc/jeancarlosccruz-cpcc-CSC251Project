import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Demo
{
   public static void main(String[] args) throws IOException
   {
      // Open the input file
      File file = new File("PolicyInformation.txt");
      Scanner inputFile = new Scanner(file);

      ArrayList<Policy> policyList = new ArrayList<Policy>();

      // Read data from the file and create objects
      while (inputFile.hasNext())
      {
         String policyNumber = inputFile.next();
         String providerName = inputFile.next();
         String firstName = inputFile.next();
         String lastName = inputFile.next();
         int age = inputFile.nextInt();
         String smokingStatus = inputFile.next();
         double height = inputFile.nextDouble();
         double weight = inputFile.nextDouble();

         // Create PolicyHolder object
         PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                smokingStatus, height, weight);

         // Create Policy object that "has-a" PolicyHolder
         Policy policy = new Policy(policyNumber, providerName, holder);

         // Add to the list
         policyList.add(policy);
      }

      inputFile.close();

      int smokerCount = 0;
      int nonSmokerCount = 0;

      // Display each Policy and count smokers/non-smokers
      for (Policy p : policyList)
      {
         // Implicitly calls p.toString()
         System.out.println(p);
         System.out.println();   // blank line between policies

         String status = p.getPolicyHolder().getSmokingStatus();

         if (status.equalsIgnoreCase("smoker") || status.equalsIgnoreCase("Y"))
         {
            smokerCount++;
         }
         else if (status.equalsIgnoreCase("non-smoker") || status.equalsIgnoreCase("N"))
         {
            nonSmokerCount++;
         }
      }

      // Display totals
      System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }
}
