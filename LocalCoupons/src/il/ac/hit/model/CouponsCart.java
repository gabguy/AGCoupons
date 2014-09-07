package il.ac.hit.model;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CouponsCart {

	private Map<Coupon,CouponsCartLine> lines;
	private static Logger log = LogManager.getRootLogger();

	
	public CouponsCart()
	{
		lines = new Hashtable<Coupon,CouponsCartLine>();
	}
	
	/**
	 * 
	 * @param coupon
	 */
	public void addCouponToCart(Coupon coupon)
	{
		CouponsCartLine line = (CouponsCartLine)(lines.get(coupon));
		
	
		if (line == null)
		{	
			lines.put(coupon, new CouponsCartLine(coupon, 1));
			log.info("CouponsCart | new line added");
		}
		else
		{
			line.setQuantity(line.getQuantity() + 1);
			log.info("CouponsCart | Quantity increased: +1");
		}
	}
	

	public String getXMLTable()
	{
		CouponsCartLine line = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table class=\"table borderless\"><tr><th><h4>Coupon Id</h4></th>"
				+ "<th><h4>Business</h4></th><th><h4>Image</h4></th>"
				+ "<th><h4>Details</h4></th><th><h4>Category</h4></th>"
				+ "<th><h4>Quantity</h4></th>"
				+ "<th><h4>Remove</h4></th></tr>");
		Iterator<CouponsCartLine> iterator = lines.values().iterator();
		
		while(iterator.hasNext())
		{
			line = (CouponsCartLine)iterator.next();
			sb.append("<tr><td><h5>"+line.getCoupon().getId()+"</h5></td>");
			sb.append("<td><h5>"+line.getCoupon().getBusiness()+"</h5></td>");
			sb.append("<td><img src=\"http://mahshev.herobo.com/agcoupons/"+line.getCoupon().getImage()+"\" width=\"80\" height=\"80\" border=\"0\"></img></td>");
			sb.append("<td><h5>"+line.getCoupon().getDetails()+"</h5></td>");
			sb.append("<td><h5>"+line.getCoupon().getCategory()+"</h5></td>");
			sb.append("<td><h5>"+line.getQuantity()+"</h5></td>");
			sb.append("<td><a href=\"/LocalCoupons/InventoryController?remove=" + line.getCoupon().getId() + "\" class=\"btn btn-danger\"><i class=\"fa fa-times\"></i></a></td></tr>");
		}
		
		sb.append("</table>");
		
		return sb.toString();
	}
	
	public boolean isEmpty()
	{
		return lines.isEmpty();
	}
	
	/**
	 * 
	 * @param coupon
	 */
	public void removeLine(Coupon coupon)
	{
		lines.remove(coupon);
		log.info("CouponsCart | line removed");

	}
	
	public void removeExpiredCouponsFromCart()
	{
		Iterator iter = lines.keySet().iterator();
		CouponTable couponTable = CouponTable.getInstance();
		
		while(iter.hasNext())
		{
			
			Coupon myCoupon = (Coupon)iter.next();
			
			if (couponTable.getCoupon(myCoupon.getId()) == null)
			{
				lines.remove(myCoupon);
			}
			
		}
		
	}

}
