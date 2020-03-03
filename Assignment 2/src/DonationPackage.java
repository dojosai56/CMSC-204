
public class DonationPackage {

	private String pDesc;
	private double pWeight;

/**
 * Constructers
 * @param pDesc
 * @param pWeight
 */
	public DonationPackage(String pDesc, double pWeight) {
		this.pDesc = pDesc;
		this.pWeight = pWeight;
	}
/**
 * Getter for String
 * @return
 */
	public String getDescription() {
		return pDesc;
	}
/**
 * 
 * @return whether weight is heavy or not
 */
	public boolean isHeavy() {
		if(pWeight >= 20)
		{
			return true;
		}
		else
			return false;
	}
	
	/**
	 * returns name and weight as string
	 */
	public String toString() {
		return pDesc + " " + pWeight + " lbs";
				
		}

}
