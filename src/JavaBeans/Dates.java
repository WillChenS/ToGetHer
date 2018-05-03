package JavaBeans;

import java.sql.Timestamp;

public class Dates {
	private String profile1;
	private String profile2;
	public String getProfile1() {
		return profile1;
	}
	public void setProfile1(String profile1) {
		this.profile1 = profile1;
	}
	public String getProfile2() {
		return profile2;
	}
	public void setProfile2(String profile2) {
		this.profile2 = profile2;
	}
	public String getCustRep() {
		return custRep;
	}
	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getBookingFee() {
		return bookingFee;
	}
	public void setBookingFee(int bookingFee) {
		this.bookingFee = bookingFee;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getUser1Rating() {
		return user1Rating;
	}
	public void setUser1Rating(int user1Rating) {
		this.user1Rating = user1Rating;
	}
	public int getUser2Rating() {
		return user2Rating;
	}
	public void setUser2Rating(int user2Rating) {
		this.user2Rating = user2Rating;
	}
	public String getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}
	private String custRep;
	private Timestamp dateTime;
	private String location;
	private int bookingFee;
	private String comments;
	private int user1Rating;
	private int user2Rating;
	private String geoLocation;
	
}
