/*package com.att.biq.day18.amir.exam3;

// it's not a real java file!
// just the solution with all classes inside

public class ATM implements Serializable {
	
	private static final long SerialVersionID = 1L;
	
	private String id;
	// TODO: Bill enum
	private Map<Bill, Integer> bills = new HashMap<>();
	
	public ATM() {}
	public ATM(String id) { this.id = id; }

	@Override
	public boolean equals(Object other) {
		if(! other instanceof ATM ) {
			return false;
		}
		ATM o = (ATM)other;
		return o.id.equals(id) && o.bills.equals(bills);
	}

	// binary
	public void save(FileOutputStream fos) {
		try (DataOutputStream ds = new DataOutputStream(fos)) {
			ds.writeUTF(id);
			ds.writeInt(bills.size());
			for(Map.Entry<Bill, Integer> bill2amount : bills.entrySet()) {
				ds.writeInt(bill2amount.getKey().monetaryValue());
				ds.writeInt(bill2amount.getValue());
			}
		}
	}
	
	public void load(FileInputStream fis) {
		bills.clear();
		try (DataInputStream ds = new DataInputStream(fis)) {
			id = ds.readUTF();
			int size = ds.readInt(); // number of bill2amount
			for(int i=0; i<size; ++i) {
				int monetaryValue = ds.readInt();
				int amount = ds.readInt();
				bills.put(Bill.getBill(monetaryValue), amount);
			}
		}
	}
	
	// text
	public void saveAsTextFile(FileOutputStream fos) {
		try (OutputStreamWriter writer = new OutputStreamWriter(fos)) {
			writer.write(id + '\n');
			writer.write("" + bills.size() + '\n');
			for(Map.Entry<Bill, Integer> bill2amount : bills.entrySet()) {
				writer.write("" + bill2amount.getKey().monetaryValue() + '\n');
				writer.write("" + bill2amount.getValue() + '\n');
			}
		}
	}
	
	public void loadFromTextFile(FileInputStream fis) {
		bills.clear();
		try (InputStreamReader reader = new InputStreamReader(fis);
		     BufferedReader br = new BufferedReader(reader)) {
			id = br.readLine();
			int size = Integer.parseInt(br.readLine());
			for(int i=0; i<size; ++i) {
				int billMonetaryValue = Integer.parseInt(br.readLine());
				int amount = Integer.parseInt(br.readLine());
				bills.put(Bill.getBill(billMonetaryValue), amount);
			}
		}		
	}
}

public class ATMTest {

	private ATM atm1 = new ATM("123");
	
	@BeforeEach
	public void init() {
		atm1.add(Bill._20, 5);
		atm1.add(Bill._50, 10);
	}

	@Test
	public void testSaveLoadWithSerialization() throws IOException {
		// save with Serialization
		try (FileOutputStream fos = new FileOutputStream("atm_test1.bin");
			ObjectOutputStream s = new ObjectOutputStream(fos)) {
				s.writeObject(atm1);
		}
		// load with Serialization
		ATM atm2 = null;
		try (FileInputStream fis = new FileInputStream("atm_test1.bin");
			ObjectInputStream s = new ObjectInputStream(fis)) {
				atm2 = (ATM)s.readObject();
		}
		assertEquals(atm1, atm2);
	}

	@Test
	public void testSaveLoadWithOurBinaryFormat() throws IOException {
		// save
		try (FileOutputStream fos = new FileOutputStream("atm_test1.bin")) {
			atm1.save(fos);
		}
		// load
		ATM atm2 = new ATM();
		try (FileInputStream fis = new FileInputStream("atm_test1.bin")) {
			atm2.load(fis);
		}
		assertEquals(atm1, atm2);
	}

	@Test
	public void testSaveLoadWithOurTextFormat() throws IOException {
		// save
		try (FileOutputStream fos = new FileOutputStream("atm_test1.bin")) {
			atm1.saveAsTextFile(fos);
		}
		// load
		ATM atm2 = new ATM();
		try (FileInputStream fis = new FileInputStream("atm_test1.bin")) {
			atm2.loadFromTextFile(fis);
		}
		assertEquals(atm1, atm2);
	}
}
*/