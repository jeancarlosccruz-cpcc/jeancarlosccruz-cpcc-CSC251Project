import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
   Reads policy information from a text file, stores Policy
   objects in a dynamic list, prints policy details, and
   counts smokers and non-smokers.
*/
public class Project2_Demo
{
   public static void main(String[] args)
   {
      ArrayList<Policy> policyList = new ArrayList<Policy>();  // dynamic list

      // Attempt to open the file containing policy records
      Scanner inputFile = null;

      try
      {
         inputFile = new Scanner(new File("PolicyInformation.txt"));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Could not open PolicyInformation.txt.");
         return;
      }

      // Read information as long as there are lines left in the file
      while (inputFile.hasNextLine())
      {
         String line = inputFile.nextLine().trim();

         // skip empty lines between policies
         if (line.equals(""))
         {
            continue;
         }

         String pNumber = line;
         String pName = inputFile.nextLine();
         String fName = inputFile.nextLine();
         String lName = inputFile.nextLine();
         int age = Integer.parseInt(inputFile.nextLine());
         String status = inputFile.nextLine();
         double height = Double.parseDouble(inputFile.nextLine());
         double weight = Double.parseDouble(inputFile.nextLine());

         // create a Policy object with the values read from the file
         Policy obj = new Policy(pNumber, pName, fName, lName, age,
                                 status, height, weight);

         // add object to the ArrayList
         policyList.add(obj);
      }

      inputFile.close();

      int smokers = 0;
      int nonSmokers = 0;

      // Loop through the ArrayList using a standard index loop
      for (int i = 0; i < policyList.size(); i++)
      {
         Policy p = policyList.get(i);

         System.out.println("Policy Number: " + p.getPolicyNumber());
         System.out.println("Provider Name: " + p.getProviderName());
         System.out.println("Policyholder's First Name: " + p.getFirstName());
         System.out.println("Policyholder's Last Name: " + p.getLastName());
         System.out.println("Policyholder's Age: " + p.getAge());
         System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
         System.out.println("Policyholder's Height: " + p.getHeight() + " inches");
         System.out.println("Policyholder's Weight: " + p.getWeight() + " pounds");
         System.out.printf("Policyholder's BMI: %.2f%n", p.getBMI());
         System.out.printf("Policy Price: $%.2f%n", p.getPrice());
         System.out.println();

         if (p.getSmokingStatus().equalsIgnoreCase("smoker"))
         {
            smokers++;
         }
         else
         {
            nonSmokers++;
         }
      }

      System.out.println("The number of policies with a smoker is: " + smokers);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
   }
}
