package de.domi;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.IExpectationSetters;
import org.junit.Test;

import de.domi.de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.domi.de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import de.domi.de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.domi.de.hs_furtwangen.informatik.meldeauskunft.service.ResidentService;
import de.domi.de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;
import static org.easymock.EasyMock.*;
public class BaseResidentServiceTest{
	BaseResidentService bs = new BaseResidentService();


	@Test
	public void testGetUniqueResident() throws ResidentServiceException {
		bs.setResidentRepository(new ResidentRepositoryStub());
		Resident f = new Resident("Helga",  "Schmidt", "Bla 2", "Freiburg", new Date(1990,06,10));
		assertNotNull(bs.getUniqueResident(f));
	}
	@Test
	public void testGetUniqueResident2() throws ResidentServiceException {
		bs.setResidentRepository(new ResidentRepositoryStub());
		Resident f = new Resident("Bla",  "Bla", "Bla 2", "Freiburg", new Date(1990,06,10));
		try{
		bs.getUniqueResident(f);
		fail("Suchanfrage lieferte kein eindeutiges Ergebnis! nicht geworfen");
		}catch(ResidentServiceException e){
			
		}
	}
	@Test
	public void testGetUniqueResident3() throws ResidentServiceException {
		bs.setResidentRepository(new ResidentRepositoryStub());
		Resident f = new Resident("Bla",  "Bla", "Bla 2", "Freiburg", new Date(1990,06,10));
		try{
		bs.getUniqueResident(f);
		fail("Wildcards (*) sind nicht erlaubt! nicht geworfen");
		}catch(ResidentServiceException e){
			
		}
	}

	@Test
	public void testGetFilteredResidentsList() {
		bs.setResidentRepository(new ResidentRepositoryStub());
		Resident filter = new Resident();
		filter.setGivenName("He*");
		List<Resident> test = new ArrayList<Resident>();
		test = bs.getFilteredResidentsList(filter);
		assertTrue(test.size() == 1);
		
	}
	@Test
	public void testGetFilteredResidentsList2() {
		bs.setResidentRepository(new ResidentRepositoryStub());
		Resident filter = new Resident();
		filter.setGivenName("BLA");
		List<Resident> test = new ArrayList<Resident>();
		test = bs.getFilteredResidentsList(filter);
		assertTrue(test.size() == 0);
	}
	@Test
	public void testGetFilteredResidentsList3() {
		bs.setResidentRepository(new ResidentRepositoryStub());
		Resident filter = new Resident("Helga",  "Schmidt", "Bla 2", "Freiburg", new Date(1990,06,10));
		List<Resident> test = new ArrayList<Resident>();
		test = bs.getFilteredResidentsList(filter);
		assertTrue((test.size() == 1 )&& (test.get(0).getGivenName().equals(filter.getGivenName())));
	}
	
	@Test
	public void testGetFilteredResidentsList4() {
		ResidentRepository mock = createMock(ResidentRepository.class);
		List<Resident> data = new ArrayList<Resident>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("deprecation")
		Resident res1 = new Resident("Helga",  "Schmidt", "Bla 2", "Freiburg", new Date(1990,06,10));
		Resident res2 = new Resident("Hans",  "Peter", "Bla 4", "Stuttgart", new Date(1990,06,10));
		Resident res3 = new Resident("Rudi",  "Müller", "Bla 6", "Freiburg", new Date(1990,06,10));
		Resident res4 = new Resident("Hanna",  "Bla", "Bla 2", "Freiburg", new Date(1990,06,10));
		Resident res5 = new Resident("Inge",  "Peter", "Bla 4", "Stuttgart", new Date(1990,06,10));
		Resident res6 = new Resident("Michi",  "Müller", "Bla 7", "Stuttgart", new Date(1990,06,10));
		data.add(res1);
		data.add(res2);
		data.add(res3);
		data.add(res4);
		data.add(res5);
		data.add(res6);
		
		expect((mock.getResidents())).andReturn(data);
		
		replay(mock);
		bs.setResidentRepository(mock);
		Resident filter = new Resident("Helga",  "Schmidt", "Bla 2", "Freiburg", new Date(1990,06,10));
		List<Resident> test = new ArrayList<Resident>();
		test = bs.getFilteredResidentsList(filter);
		assertTrue((test.size() == 1 )&& (test.get(0).getGivenName().equals(filter.getGivenName())));
	}
}
