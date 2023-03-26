package Utils;

import com.github.javafaker.Faker;

public class constData {
	
	private static Faker faker = new Faker();
	
	public static String name = faker.name().firstName();
	public static String emaiID = faker.internet().emailAddress();
	public static String password = faker.internet().password();
	public static String comapnyName = faker.company().name();
	public static String website = faker.internet().url();
	public static String countryName = faker.country().name();
	public static String cityName = faker.address().city();
	public static String addrees01 = faker.address().buildingNumber();
	public static String address02 = faker.address().secondaryAddress();
	public static String stateName = faker.address().state();
	public static String zipcode = faker.address().zipCode();	

}
