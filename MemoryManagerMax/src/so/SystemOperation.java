package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.Schedule;

public class SystemOperation {
	 private static MemoryManager mm;
	 private static CpuManager cm;

	public static Process SystemCall(SystemCallType type, Process p) {
		if(type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);
		} else if (type.equals(SystemCallType.READ_PROCESS)) {
			
		} else if (type.equals(SystemCallType.DELETE_PROCESS)) {
			mm.delete(p);
		} else if (type.equals(SystemCallType.CREATE_PROCESS)) {
			 if (mm == null) {
				 mm = new MemoryManager(Strategy.FIRST_FIT);
			 }
			 if (cm == null) {
				 cm = new CpuManager();
			 }
			 return new Process();
		} 	
			return null;
	}
}