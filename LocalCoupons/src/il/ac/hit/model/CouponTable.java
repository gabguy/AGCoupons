package il.ac.hit.model;


import il.ac.hit.util.Location;

import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CouponTable implements ICouponsDAO {

	//Singleton
	private static CouponTable myCouponTable;
	private List couponsList;
	private Set<String> categorySet;
	private static Logger log = LogManager.getRootLogger();
	
	
	public static CouponTable getInstance()
	{
		if (myCouponTable == null)
		{
			myCouponTable = new CouponTable();
		}
		
		return myCouponTable;
	}
	
	private SessionFactory factory;

	public CouponTable()
	{
		//creating factory for getting sessions
		factory = new AnnotationConfiguration().configure().buildSessionFactory();

		categorySet = new TreeSet<String>();
	}
	
	@Override
	public Coupon getCoupon(int id)
	{
		Session session = factory.openSession();
		Coupon myCoupon = null;
		
		try
		{
			myCoupon = (Coupon)session.get(Coupon.class, id);
		}
		
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		
		return myCoupon; 
	}
		
	@Override
	public boolean updateCoupon(Coupon ob)
	{
	
		Session session = factory.openSession();
		
		try {
			
			//creating a new session for updating products
			session.beginTransaction();
			session.update(ob);
			session.getTransaction().commit();
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	
		return true;
	}
	

	public Iterator getCoupons()

	{
		log.info("CouponTable | getCoupons");
		
		Session session = factory.openSession();
		
		if (couponsList != null)
		{
			couponsList.clear();
		}
		
		couponsList = session.createQuery("from Coupon").list();
		
		return couponsList.iterator();
		
	}
	
	/**
	 * 
	 * @param category
	 * @return
	 */
	public Iterator getCouponsByCategory(String category)
	{
		Session session = factory.openSession();
		
		if (couponsList != null)
		{
			couponsList.clear();
		}
		
		couponsList = session.createQuery("from Coupon where category=\'" + category +"\'").list();
	
		return couponsList.iterator();
	}
	
	/**
	 * 
	 * @param business
	 * @return
	 */
	public Iterator getCouponsByBusiness(String business)
	{
		Session session = factory.openSession();
		
		if (couponsList != null)
		{
			couponsList.clear();
		}
		
		couponsList = session.createQuery("from Coupon where business=\'" + business +"\'").list();
	
		return couponsList.iterator();
	}
	
	public Iterator getCouponsByLocation(double latitude, double longitude)
	{
		
		//clear the list to avoid duplicates
		if (couponsList != null)
		{
			couponsList.clear();
		}
		
		Session session = factory.openSession();
		
		List tempCouponsList = session.createQuery("from Coupon").list();
		
		Coupon curCoupon = null;
		double range = 2.0; //Proximity to the user's location of 2 KM
		Iterator iter = tempCouponsList.iterator();
		
		while (iter.hasNext())
		{
			curCoupon = (Coupon)iter.next();
			
			if (Location.isCoordinateInRange(curCoupon.getLatitude(), curCoupon.getLongitude(), latitude, longitude, range))
			{
				couponsList.add(curCoupon);
			}
		}
		
		return couponsList.iterator();
	}
	
	@Override
	public boolean deleteCoupon(int id) {
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
	        Coupon myCoupon = 
	                  (Coupon)session.get(Coupon.class, id);
	        session.delete(myCoupon);
	        session.getTransaction().commit();
	        log.info("CouponTable | Coupon deleted!");
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return true;
	}
	
	@Override
	public boolean addCoupon(Coupon ob)
	{
		
		Session session = factory.openSession();
		
		try {
		
			if (getCoupon(ob.getId()) == null)
			{
					session.beginTransaction();
					session.save(ob);
					session.getTransaction().commit();
					  log.info("CouponTable | Coupon added");
			}
			else
			{
				return false;
			}
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally 
		{
			session.close();
			  log.info("CouponTable | session closed.");
		}
		
		
		return true;
	}
	
	public void removeExpiredCoupons()
	{
		
		Iterator iter = getCoupons();

		Coupon curCoupon = null;
		
		while (iter.hasNext())
		{
			curCoupon = (Coupon)iter.next();

			if (isExpired(curCoupon.getDate()))
			{
				deleteCoupon(curCoupon.getId());
				  log.info("CouponTable | Coupon expired & deleted!");
			}
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isExist(int id)
	{
		if (getCoupon(id) == null)
		{
			return false;
		}
		  log.info("CouponTable | Coupon exist");
		return true;
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	private boolean isExpired(Date date)
	{
		
		Calendar expiry = Calendar.getInstance();
		expiry.setTime(date);
		log.info("CouponTable | Checking if Coupon expired");
		return expiry.before(Calendar.getInstance());
	}
	
	public Iterator<String> getCategories()
	{
		Iterator iter = getCoupons();
		
		while (iter.hasNext())
		{
			categorySet.add(((Coupon)iter.next()).getCategory());
		}
		
		return categorySet.iterator();
	}
}
