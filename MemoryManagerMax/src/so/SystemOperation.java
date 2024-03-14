package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.schedule.Schedule;

public class SystemOperation {
	private static MemoryManager mm;
	private static CpuManager cm;
	private static Schedule schedule;
	
	public static MemoryManager getMm() {
		return mm;
	}
	public static void setMm(MemoryManager mm) {
		SystemOperation.mm = mm;
	}
	public static CpuManager getCm() {
		return cm;
	}
	public static void setCm(CpuManager cm) {
		SystemOperation.cm = cm;
	}
	public static Schedule getSchedule() {
		return schedule;
	}
	public static void setSchedule(Schedule schedule) {
		SystemOperation.schedule = schedule;
	}
	
	
	
	public static Object systemCall(SystemCallType type, Process p) {
		 if(type.equals(SystemCallType.WRITE_PROCESS)) {
	
		 } else if (type.equals(SystemCallType.DELETE_PROCESS)) {
	
		 } else if (type.equals(SystemCallType.CREATE_PROCESS)) {
			 if(cm == null) {
				 cm = new CpuManager();
			 }
			 if (mm == null) {
				 mm = new MemoryManager(Strategy.FIRST_FIT);
			 }
			 return systemCall(SystemCallType.CREATE_PROCESS, null);
			 
		 
		 }
	 }
}
