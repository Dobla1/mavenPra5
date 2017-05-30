package de.domi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.domi.de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.domi.de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@SuppressWarnings("deprecation")
	private Resident res1 = new Resident("Helga",  "Schmidt", "Bla 2", "Freiburg", new Date(1990,06,10));
	private Resident res2 = new Resident("Hans",  "Peter", "Bla 4", "Stuttgart", new Date(1990,06,10));
	private Resident res3 = new Resident("Rudi",  "Müller", "Bla 6", "Freiburg", new Date(1990,06,10));
	private Resident res4 = new Resident("Hanna",  "Bla", "Bla 2", "Freiburg", new Date(1990,06,10));
	private Resident res5 = new Resident("Inge",  "Peter", "Bla 4", "Stuttgart", new Date(1990,06,10));
	private Resident res6 = new Resident("Michi",  "Müller", "Bla 7", "Stuttgart", new Date(1990,06,10));
	
	
	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		List<Resident> tmp = new ArrayList<Resident>();
		tmp.add(res1);
		tmp.add(res2);
		tmp.add(res3);
		tmp.add(res4);
		tmp.add(res5);
		tmp.add(res6);
		return tmp;
	}

}
