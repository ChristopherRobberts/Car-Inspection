package se.kth.ict.carinspection.integration;

/**
 * Contains information about one vehicle registration number.
 */
public class RegistrationNoDTO {
    private final String registrationNo;

    /**
     * Creates a new instance representing a registration number for a vehicle.
     *
     * @param registrationNo The registration number of the vehicle.
     */
    public RegistrationNoDTO(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    /**
     *
     * @return A string representation of the registration number.
     */
    public String getRegistrationNo() {
        return registrationNo;
    }

    /**
     * Two <code>RegistrationNoDTO</code> are equal if they represent the same registration number.
     *
     * @param other The <code>RegistrationNoDTO</code> to compare with this one.
     * @return <code>true</code> if the registration number is the same as this one, <code>false</code> if it is not.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (!(other instanceof RegistrationNoDTO))
            return false;

        RegistrationNoDTO otherRegistrationNoDTO = (RegistrationNoDTO) other;

        return this.registrationNo.equals(otherRegistrationNoDTO.registrationNo);
    }

    @Override
    public int hashCode() {
        return registrationNo.hashCode();
    }
}
