package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.memory.AddressMemory;

public class Process {
	private String id;
	private int sizeInMemory;
	// private List<Process> process;
	// private int timeToExecution;
	private AddressMemory addressInMemory;
	private AddressMemory address;
	
	public Process() {
		Random rand = new Random();
		this.id = UUID.randomUUID().toString();
		List<Integer> givenList = Arrays.asList(1, 2, 4, 5, 8, 10, 20, 50, 100);
		this.sizeInMemory = givenList.get(rand.nextInt(givenList.size()));
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSizeInMemory() {
		return sizeInMemory;
	}
	public void setSizeInMemory(int sizeInMemory) {
		this.sizeInMemory = sizeInMemory;
	}
	public AddressMemory getAddressInMemory() {
		return addressInMemory;
	}
	public void setAddressInMemory(AddressMemory addressInMemory) {
		this.addressInMemory = addressInMemory;
	}
	
	
	
}
