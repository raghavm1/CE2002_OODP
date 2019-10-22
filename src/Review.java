/**
 * Represents a single movie review
 * @author Lakshyajeet Dwivedee
 *
 */
public class Review {
	/**
	 * The review of the movie
	 */
	private String review;
	/**
	 * The rating given to the movie
	 * Must be between 1 and 5
	 */
	private int rating;
	
	/**
	 * Creates a new Review with the given review and rating
	 * Both review and rating must be given
	 * @param review Review of the movie
	 * @param rating Rating of the movie
	 */
	public Review(String review, int rating) {
		this.review = review;
		this.rating = rating;
	}
	
	/**
	 * Return the text of this review
	 * @return The review text
	 */
	public String getReview() {
		return this.review;
	}
	
	/**
	 * Return the rating given in this review
	 * @return The review rating
	 */
	public int getRating() {
		return rating;
	}
}
