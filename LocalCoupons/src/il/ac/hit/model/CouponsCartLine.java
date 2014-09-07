package il.ac.hit.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CouponsCartLine {

	private Coupon coupon;
	private int quantity;
	private static Logger log = LogManager.getRootLogger();

	/**
	 * 
	 * @param coupon
	 * @param quantity
	 */
	public CouponsCartLine(Coupon coupon, int quantity) {
		super();
		setCoupon(coupon);
		setQuantity(quantity);
		log.info("InventoryController | new line created!");
	}
	
	@Override
	public boolean equals(Object ob)
	{
		return this.coupon.equals(((CouponsCartLine)ob).getCoupon());
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CouponsCartLine [coupon=" + coupon + ", quantity=" + quantity
				+ "]";
	}
	
	

}
