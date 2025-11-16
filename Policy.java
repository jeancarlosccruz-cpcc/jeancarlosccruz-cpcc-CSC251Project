/**
 * The Policy class models an insurance policy for one person.
 */
public class Policy
{
    // fields
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * No-arg constructor, initializes fields to default values.
     */
    public Policy()
    {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0;
        weight = 0;
    }

    /**
     * Full constructor.
     * @param pNumber The policy number
     * @param pName The provider name
     * @param fName Policyholder's first name
     * @param lName Policyholder's last name
     * @param a Policyholder's age
     * @param sStatus Policyholder's smoking status ("smoker" or "non-smoker")
     * @param h Policyholder's height in inches
     * @param w Policyholder's weight in pounds
     */
    public Policy(String pNumber, String pName, String fName, String lName, int a, String sStatus, double h, double w)
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

    /** @return The policy number */
    public String getPolicyNumber()
    {
        return policyNumber;
    }

    /** @param pNumber Sets the policy number */
    public void setPolicyNumber(String pNumber)
    {
        policyNumber = pNumber;
    }

    /** @return The provider name */
    public String getProviderName()
    {
        return providerName;
    }

    /** @param pName Sets the provider name */
    public void setProviderName(String pName)
    {
        providerName = pName;
    }

    /** @return First name */
    public String getFirstName()
    {
        return firstName;
    }

    /** @param fName Sets first name */
    public void setFirstName(String fName)
    {
        firstName = fName;
    }

    /** @return Last name */
    public String getLastName()
    {
        return lastName;
    }

    /** @param lName Sets last name */
    public void setLastName(String lName)
    {
        lastName = lName;
    }

    /** @return Age */
    public int getAge()
    {
        return age;
    }

    /** @param a Sets age */
    public void setAge(int a)
    {
        age = a;
    }

    /** @return Smoking status */
    public String getSmokingStatus()
    {
        return smokingStatus;
    }

    /** @param sStatus Sets smoking status */
    public void setSmokingStatus(String sStatus)
    {
        smokingStatus = sStatus;
    }

    /** @return Height in inches */
    public double getHeight()
    {
        return height;
    }

    /** @param h Sets height */
    public void setHeight(double h)
    {
        height = h;
    }

    /** @return Weight in pounds */
    public double getWeight()
    {
        return weight;
    }

    /** @param w Sets weight */
    public void setWeight(double w)
    {
        weight = w;
    }

    /**
     * Calculates BMI.
     * @return The BMI value
     */
    public double getBMI()
    {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the policy price using BMI and smoking status.
     * @return The policy price
     */
    public double calculatePolicyPrice()
    {
        double basePrice = 600.0;
        double smokerFee = 100.0;
        double bmiFee = 0.0;

        if (getBMI() > 35)
            bmiFee = (getBMI() - 35) * 20;

        if (smokingStatus.equalsIgnoreCase("smoker"))
            return basePrice + smokerFee + bmiFee;
        else
            return basePrice + bmiFee;
    }
}
