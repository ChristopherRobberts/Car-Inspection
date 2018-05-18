package se.kth.ict.carinspection.integration;


/**
 * Contains information about one particular vehicle part that can be inspected.
 */
public class InspectionPartDTO {
    private final String name;
    private final double cost;

    /**
     * Creates a new instance representing a vehicle part to be inspected.
     *
     * @param name The name of the vehicle part.
     * @param cost The cost of getting this vehicle part inspected.
     */
    public InspectionPartDTO(String name, double cost) {
        this.name = name;
        this.cost = cost;

    }

    /**
     *
     * @return The name of the vehicle part.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return The cost of getting this vehicle part inspected.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Two <code>InspectionPartDTO</code> are equal if they have the same name and cost.
     *
     * @param other The <code>InspectionPartDTO</code> to compare with this one.
     * @return <code>true</code> if they are equal, else <code>false</code>.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (!(other instanceof InspectionPartDTO))
            return false;

        InspectionPartDTO otherInspectionPartDTO = (InspectionPartDTO) other;

        return this.name.equals(otherInspectionPartDTO.name) && this.cost == otherInspectionPartDTO.cost;
    }
}
