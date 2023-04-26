package ch34_database;

public class Step1_LoadDriver {

	public static void loadDriver() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Load Success!");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		loadDriver();
	}
}
