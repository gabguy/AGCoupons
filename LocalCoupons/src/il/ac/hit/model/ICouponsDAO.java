package il.ac.hit.model;

import java.util.Iterator;

public interface ICouponsDAO
{
	/**
	 * 
	 * @param id
	 * @return
	 * @throws CouponException
	 */
   public abstract Coupon getCoupon(int id) throws CouponException;
   /**
    * 
    * @param ob
    * @return
    */
   public abstract boolean updateCoupon(Coupon ob);
   /**
    * 
    * @return
    */
   public abstract Iterator<Coupon> getCoupons();
   /**
    * 
    * @param id
    * @return
    */
   public abstract boolean deleteCoupon(int id);
   /**
    * 
    * @param ob
    * @return
    */
   public abstract boolean addCoupon(Coupon ob);
  
}
