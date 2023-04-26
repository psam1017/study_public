package _06_action_tags;

public class Table {
	
	private int[] table;
	
	public Table() {
		table = new int[9];
	}

	public String[] getTable(int number) {
		String[] temp = new String[9];
		for(int i = 0; i < table.length; i++) {
			table[i] = number * (i + 1);
			temp[i] = number + " * " + (i + 1) + " =" + table[i];
		}
		
		return temp;
	}
}
