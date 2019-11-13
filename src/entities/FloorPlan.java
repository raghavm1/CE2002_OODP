package entities;

/**
 * A entity that represents the floor plan for a single {@link CinemaHall}
 *
 * @author Gan Shyan
 */
public class FloorPlan {

    /**
     * Value of 1 indicates that a seat is booked
     */
    public static final int BOOKED = 1;

    /**
     * Value of 0 indicates that a seat is empty
     */
    public static final int FREE = 0;

    /**
     * Value of -1 indicates that a slot is not actually a seat
     */
    private static final int NOT_A_SEAT = -1;

    // Elements to print on the console
    private static final String bookedSeatElement = "[x]";
    private static final String emptySeatElement = "[ ]";
    private static final String notASeatElement = "   ";

    /**
     * A 2D array which represents the seating plan
     */
    private int[][] seatingPlan;

    /**
     * Number of rows of the floor plan
     */
    private int numberOfRows;

    /**
     * Number of columns of the floor plan
     */
    private int numberOfColumns;

    /**
     * Constructor
     *
     * @param seatingPlan
     * @param numberOfRows
     * @param numberOfColumns
     */
    public FloorPlan(int[][] seatingPlan, int numberOfRows, int numberOfColumns) {
        this.seatingPlan = seatingPlan;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * Change the status of a seat.
     *
     * @param status
     * @param row
     * @param column
     * @return boolean value indicating if the change in the seat status is successive
     */
    public boolean setSeatStatus(int status, int row, int column) {
        if (seatingPlan[row][column] == NOT_A_SEAT) { // That empty 'seat' is not actually a seat, thus status cannot change
            return false;
        } else {
            seatingPlan[row][column] = status;
            return true;
        }
    }

    /**
     * Get the status of a particular seat
     *
     * @param row
     * @param column
     * @return
     */
    public int getSeatStatus(int row, int column) {
        return seatingPlan[row][column];
    }

    /**
     * Print out the floor plan of the cinema hall.
     */
    public void printOutFloorPlan() {
        System.out.println("****** Floor Plan ******\n");
        char rowIndex = 'A';

        // Print the first row (which is the column index)
        System.out.print("        ");
        for (int k = 0; k < numberOfColumns; k++) {
            if (k < 9) {
                System.out.print(k + 1 + "  ");
            } else {
                System.out.print(k + 1 + " ");
            }
            if (k == 8) {
                System.out.print("  ");
            }

        }
        System.out.print("\n");

        // Print the rows consecutively
        for (int i = 0; i < numberOfRows; i++) {
            System.out.print(rowIndex + "      ");
            for (int j = 0; j < numberOfColumns; j++) {
                if (j == 9) {
                    System.out.print("  ");
                }
                if (seatingPlan[i][j] == 0) { // Empty seat
                    System.out.print(emptySeatElement);
                } else if (seatingPlan[i][j] == 1) { // Booked seat
                    System.out.print(bookedSeatElement);
                } else if (seatingPlan[i][j] == -1) {    // Not a seat
                    System.out.print(notASeatElement);
                }

            }
            System.out.print("\n");
            rowIndex += 1;
        }
    }

}
