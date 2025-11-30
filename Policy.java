public class Policy
{
   // Static field to keep track of number of Policy objects
   private static int policyCount = 0;

   // Fields that belong to the policy
   private String policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;   // "has-a" relationship

   /**
      No-arg constructor.
   */
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      policyHolder = new PolicyHolder();
      policyCount++;
   }

   /**
      Overloaded constructor that accepts a PolicyHolder object.
   */
   public Policy(String policyNumber, String providerName, PolicyHolder holder)
   {
      this.policyNumber = policyNumber;
      this.providerName = providerName;

      // Use a copy for security (no direct reference escape)
      this.policyHolder = new PolicyHolder(holder);

      policyCount++;
   }

   // Getters and setters

   public String getPolicyNumber()
   {
      return policyNumber;
   }

   public void setPolicyNumber(String policyNumber)
   {
      this.policyNumber = policyNumber;
   }

   public String getProviderName()
   {
      return providerName;
   }

   public void setProviderName(String providerName)
   {
      this.providerName = providerName;
   }

   /**
      Returns a copy of the PolicyHolder to help minimize
      security issues with aggregate classes.
   */
   public PolicyHolder getPolicyHolder()
   {
      return new PolicyHolder(policyHolder);
   }

   /**
      Sets the PolicyHolder using a copy.
   */
   public void setPolicyHolder(PolicyHolder holder)
   {
      this.policyHolder = new PolicyHolder(holder);
   }

   /**
      Static method that returns the number of Policy objects created.
   */
   public static int getPolicyCount()
   {
      return policyCount;
   }

   /**
      Calculates and returns the price of the policy.
      Formula based on the typical Gaddis assignment:

      Base fee: $600
      If age > 50, add $75
      If smoker, add $100
      If BMI > 35, add (BMI - 35) * 20
   */
   public double getPolicyPrice()
   {
      final double BASE_FEE = 600.0;
      final double SMOKER_FEE = 100.0;
      final double AGE_FEE = 75.0;
      final double BMI_RATE = 20.0;

      double totalPrice = BASE_FEE;
      double bmi = policyHolder.getBMI();

      // Age fee if over 50
      if (policyHolder.getAge() > 50)
      {
         totalPrice += AGE_FEE;
      }

      // Smoker fee
      String status = policyHolder.getSmokingStatus();
      if (status.equalsIgnoreCase("smoker") || status.equalsIgnoreCase("Y"))
      {
         totalPrice += SMOKER_FEE;
      }

      // Extra BMI fee
      if (bmi > 35.0)
      {
         totalPrice += (bmi - 35.0) * BMI_RATE;
      }

      return totalPrice;
   }

   /**
      Returns a String with all policy information, including the
      policyholder information. This will be used implicitly when
      we print the Policy object in the Demo class.
   */
   @Override
   public String toString()
   {
      return "Policy Number: " + policyNumber + "\n" +
             "Provider Name: " + providerName + "\n" +
             policyHolder.toString() + "\n" +
             String.format("Policy Price: $%.2f", getPolicyPrice());
   }
}
