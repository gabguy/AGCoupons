package il.ac.hit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 */
@Entity
@Table(name="coupons")
public class Coupon {
	
	/**
	 * @param An int value that represents the id of the Coupon, also the primary key of the object
	 */
	private int id;
	/**
	 * @param A string that represents the business that issued the coupon
	 */
	private String business;
	/**
	 * @param A string that represents the url of the image on the ftp storage server
	 */
	private String image;
	/**
	 * @param A string the defines additional details about the coupon
	 */
	private String details;
	/**
	 * @param A string that represents the category of products the coupon is related to
	 */
	private String category;
	/**
	 * @param A Date object that represents the timestamp of the expiry date of the coupon (date + time)
	 */
	private Date date;
	
	/**
	 * @param A double value that represents the latitude coordinate of the coupon
	 */
	private double latitude;
	
	/**
	 * @param A double value that represents the longitude coordinate of the coupon
	 */
	private double longitude;
	
	private static Logger log = LogManager.getRootLogger();

	/**
	 * Class constructor
	 */
	public Coupon() {
		super();
	}

	/**
	 * Class constructor with parameters
	 * @param id
	 * @param business
	 * @param image
	 * @param details
	 * @param category
	 * @param date
	 * @param latitude
	 * @param longitude
	 */
	public Coupon(int id, String business, String image, String details,
			String category, Date date, double latitude, double longitude)
	{
		super();
		setId(id);
		setBusiness(business);
		setImage(image);
		setDetails(details);
		setCategory(category);
		setDate(date);
		setLatitude(latitude);
		setLongitude(longitude);
		log.info("Coupon | Coupon object created.");
	}
	
	/**
	 * A getter for the id value of the coupon
	 * @return An int value that represents the id of the Coupon, also the primary key of the object
	 */
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * A getter for the business name associated with the coupon
	 * @return A string that represents the business that issued the coupon
	 */
	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object ob) {

		return (this.getId() == ((Coupon)ob).getId());
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", business=" + business + ", image="
				+ image + ", details=" + details + ", category=" + category
				+ ", date=" + date + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}
