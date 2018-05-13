package package1;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DepositsService {
	public ArrayList<String> getPrograms (String currencyName, int term){
		ArrayList<String> arr = new ArrayList<String> ();
		String arrI;
				
		SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory1.openSession();
		session1.beginTransaction();
		
		Criteria crit1 = session1.createCriteria(Currency.class);
		crit1.add(Restrictions.eq("name", currencyName));
		ArrayList<Currency> results1 = (ArrayList<Currency>) crit1.list();
		Currency currency = results1.get(0);
		
		Criteria crit2 = session1.createCriteria(Program.class);
		crit2.add(Restrictions.eq("currency", currency));
		crit2.add(Restrictions.eq("term", term));
		crit2.addOrder(Order.desc("percentage"));
		crit2.setFetchMode("bank", FetchMode.EAGER);
		ArrayList<Program> results2 = (ArrayList<Program>) crit2.list();
				
		for (Program e: results2){
			arrI= "";
			arrI += e.getBank().getName() + " ";
			arrI += e.getProgramName() + " ";
			arrI += e.getPercentage();
			arr.add(arrI);			
		}
		
		session1.close();	
		return arr;
		
	}
}
