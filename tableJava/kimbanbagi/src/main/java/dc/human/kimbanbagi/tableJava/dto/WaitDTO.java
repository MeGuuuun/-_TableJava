package dc.human.kimbanbagi.tableJava.dto;

public class WaitDTO {
	private String userId;
	private String phoneNumber;
	private String restaurantId;
	private String restaurantName;
	private String headCount;
	private String  waitingNumber;
	private String waitingStatus;
	
	// Gettes and Setters
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public void setHeadCount(String headCount) {
		this.headCount = headCount;
	}
	
	public String getHeadCount() {
		return headCount;
	}
	
    public void setWaitingNumber(String waitingNumber) {
        this.waitingNumber = waitingNumber;
    }
    
	public String getWaitingNumber() {
        return waitingNumber;
    }

    public void setWaitingStatus(String waitingStatus) {
        this.waitingStatus = waitingStatus;
    }
    
    public String getWaitingStatus() {
        return waitingStatus;
    }

}
