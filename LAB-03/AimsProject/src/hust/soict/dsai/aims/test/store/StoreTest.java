package hust.soict.dsai.aims.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
public static void main(String[] args) {
	Store store = new Store(5);
	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King"
			,"Animation","Roger Allers",87,19.95f);
	DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
			"Science Fiction","George Lucas",87,24.95f);
	DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
			"Animation",18.99f);
	store.addDVD(dvd1);
	store.addDVD(dvd2);
	store.addDVD(dvd3);
	store.displayStore();
	store.removeDVD(dvd2);
	store.displayStore();
}
}