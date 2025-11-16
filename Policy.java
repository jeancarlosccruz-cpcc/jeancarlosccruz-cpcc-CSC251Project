/**
   The Policy class stores information related to an insurance
   policyholder and offers methods to compute the BMI and
   overall cost of the insurance policy.
*/
public class Policy
{
   // Fields
   private String policyNumber;
   private String providerName;
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   /**
      Default constructor that initializes all fields
      to their default values.
   */
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0.0;
      weight = 0.0;
   }

   /**
      Constructor that sets all fields to the provided values.
      @param pNumber Policy identification number.
      @param pName   Provider of the policy.
      @param fName   Policyholder's first name.
      @param lName   Policyholder's last name.
      @param a       Policyholder's age.
      @param sStatus Smoking status (smoker or non-smoker).
      @param h       Height in inches.
      @param w       Weight in pounds.
   */
   public Policy(String pNumber, String pName, String fName, String lName,
                 int a, String sStatus, double h, double w)
   {
      policyNumber = pNumber;
      providerName = pName;
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }

   // ----------- SETTER METHODS ------------

   /**
      Sets the policy number.
      @param pNumber The policy number.
   */
   public void setPolicyNumber(String pNumber)
   {
      this.policyNumber = pNumber;
   }

   /**
      Sets the provider name.
      @param pName The provider name.
   */
   public void setProviderName(String pName)
   {
      this.providerName = pName;
   }

   /**
      Sets the policyholder's first name.
      @param fName First name.
   */
   public void setFirstName(String fName)
   {
      this.firstName = fName;
   }

   /**
      Sets the policyholder's last name.
      @param lName Last name.
   */
   public void setLastName(String lName)
   {
      this.lastName = lName;
   }

   /**
      Sets the policyholder's age.
      @param a Age of the policyholder.
   */
   public void setAge(int a)
   {
      this.age = a;
   }

   /**
      Sets the smoking status.
      @param sStatus Smoker or non-smoker.
   */
   public void setSmokingStatus(String sStatus)
   {
      this.smokingStatus = sStatus;
   }

   /**
      Sets the height in inches.
      @param h Height.
   */
   public void setHeight(double h)
   {
      this.height = h;
   }

   /**
      Sets the weight in pounds.
      @param w Weight.
   */
   public void setWeight(double w)
   {
      this.weight = w;
   }

   // ----------- GETTER METHODS ------------

   /**
      Returns the policy number.
      @return The policy number.
   */
   public String getPolicyNumber()
   {
      return policyNumber;
   }

   /**
      Returns the provider name.
      @return The provider name.
   */
   public String getProviderName()
   {
      return providerName;
   }

   /**
      Returns the policyholder's first name.
      @return The first name.
   */
   public String getFirstName()
   {
      return firstName;
   }

   /**
      Returns the policyholder's last name.
      @return The last name.
   */
   public String getLastName()
   {
      return lastName;
   }

   /**
      Returns the policyholder's age.
      @return The age.
   */
   public int getAge()
   {
      return age;
   }

   /**
      Returns the smoking status.
      @return "smoker" or "non-smoker".
   */
   public String getSmokingStatus()
   {
      return smokingStatus;
   }

   /**
      Returns the height in inches.
      @return Height.
   */
   public double getHeight()
   {
      return height;
   }

   /**
      Returns the weight in pounds.
      @return Weight.
   */
   public double getWeight()
   {
      return weight;
   }


   // ----------- CALCULATIONS ------------

   /**
      Computes the BMI using the standard formula:
      (weight * 703) / (height^2)
      @return The BMI value.
   */
   public double getBMI()
   {
      final double FACTOR = 703.0;
      return (weight * FACTOR) / (height * height);
   }

   /**
      Calculates and returns the cost of the policy.
      Base Price: $600  
      + $75 if age > 50  
      + $100 if smoker  
      + $20 for every BMI point above 35
      @return The final price of the policy.
   */
   public double getPrice()
   {
      final double BASE = 600.0;
      final double AGE_FEE = 75.0;
      final double SMOKER_FEE = 100.0;
      final double BMI_FEE_RATE = 20.0;

      double total = BASE;

      if (age > 50)
         total += AGE_FEE;

      if (smokingStatus.equalsIgnoreCase("smoker"))
         total += SMOKER_FEE;

      double bmi = getBMI();
      if (bmi > 35)
         total += (bmi - 35) * BMI_FEE_RATE;

      return total;
   }
}
