import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Video {
	private String title ;

	private int priceCode ;
	public static final int REGULAR = 1 ;
	public static final int NEW_RELEASE =2 ;

	private int videoType ;
	public static final int VHS = 1 ;
	public static final int CD = 2 ;
	public static final int DVD = 3 ;

	private Date registeredDate ;
	private boolean rented ;
	private Map<Integer, IPricePolicy> pricePolicyMap = new HashMap<Integer, IPricePolicy>();
	private IPricePolicy pricePolicy;
	private ICalcPoint iCalcPoint;

	public Video(String title, int videoType, int priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
		makePricePolicyFactory(priceCode);
		try {
			pricePolicy = setPolicy(priceCode);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		setPointPolicy(priceCode);
	}

	private void makePricePolicyFactory(int priceCode) {
		pricePolicyMap.put(1, new RegularPricePolicy());
		pricePolicyMap.put(2, new NewReleasePricePolicy());
	}

	private IPricePolicy setPolicy(int priceCode) throws Exception{
		if(!pricePolicyMap.containsKey(priceCode)) {
			throw new Exception("price code 존재 하지 않음");
		}

		return pricePolicyMap.get(priceCode);
	}

	private void setPointPolicy(int priceCode) {
		if (priceCode == Video.NEW_RELEASE)
			iCalcPoint = new NewReleaseCalcPoint();
		else
			iCalcPoint = new NormalCalcPoint();
	}

	public int getPoint(int daysRented, int daysRentedLimit) {
		return iCalcPoint.calcPoint(daysRented, daysRentedLimit, getLateReturnPointPenalty());
	}

	public double getPrice(int daysRented) {
		return pricePolicy.GetPrice(daysRented);
	}

	public int getLateReturnPointPenalty() {
		int pentalty = 0 ;
		switch ( videoType ) {
			case VHS: pentalty = 1 ; break ;
			case CD: pentalty = 2 ; break ;
			case DVD: pentalty = 3 ; break ;
		}
		return pentalty ;
	}
	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getVideoType() {
		return videoType;
	}

	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}
}
