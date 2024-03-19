package so.memory;

import so.Process;

public class MemoryManager {
	
	private String[] physicMemory;
	private Strategy strategy;
	
	public MemoryManager(Strategy strategy) {
		this.strategy = strategy;
		physicMemory = new String[128];
		
	}
		public void write (Process p){	
			if(this.strategy.equals(Strategy.FIRST_FIT)) {
				this.writeUsingFirstFit(p);
			} else if (this.strategy.equals(Strategy.BEST_FIT)) {
				this.writeUsingBestFit(p);
			} else if (this.strategy.equals(Strategy.WORST_FIT)) {
				this.writeUsingWorstFit(p);
			} else if (this.strategy.equals(Strategy.PAGING)) {
				this.writeUsingPaging(p);
			}
		}
		private void writeUsingPaging(Process p) {
			// TODO Auto-generated method stub
			
		}
		private void writeUsingWorstFit(Process p) {
			// TODO Auto-generated method stub
			
		}
		private void writeUsingBestFit(Process p) {
			// TODO Auto-generated method stub
			
		}
		private void writeUsingFirstFit(Process p) {
			int actualSize = 0;
			for(int i = 0; i < physicMemory.length; i++ ) {
				if (i == physicMemory.length - 1) {
					if(actualSize > 0) {
						if (p.getSizeInMemory() <= actualSize);
						int start = i - actualSize;
						int end = i;
						AddressMemory address = new AddressMemory(start, end);
						if(p.getSizeInMemory() <= address.getSize()) {
							insertProcessInMemory(p, address);
							break; 
						}
					}
				
				}else if(physicMemory[i] == null) {
					actualSize++;
				} else {
					if(actualSize > 0) {
						int start = i - actualSize;
						int end = i - 1;
						AddressMemory address = new AddressMemory(start, end);
						if(p.getSizeInMemory() <= address.getSize()) {
							insertProcessInMemory(p, address);
							break; 
						}
					}
					actualSize = 0;
				}
			}
			printMemoryStatus();
			
		}
		private void printMemoryStatus() {
			for(int i = 0; i < physicMemory.length; i++) {
				System.out.print(physicMemory[i] + " / ");
			}
			
		}
		private void insertProcessInMemory(Process p, AddressMemory address) {
			for(int i = address.getStart(); i<= address.getEnd(); i++);
			int i = 0;
			this.physicMemory[i] = p.getId();
			
			
		}
		public void delete (Process p){	
			
		}
}