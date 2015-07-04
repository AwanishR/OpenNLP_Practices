import java.util.Date;


public class TimeCalculator {
	public static void main (String args [])
	{
		long start = System.currentTimeMillis();
		Date d1 = new Date();
		System.out.println(d1.toString());
		for (double i=0;i<1000000000;i++)
		{
			
		}
		Date d2 = new Date ();
		long end = System.currentTimeMillis();
		System.out.println (d2.toString());
		System.out.println(d2.compareTo(d1));
		long diff = end-start;
		System.out.println("difference is ="+(float)diff/1000+" Seconds");
	}

}
