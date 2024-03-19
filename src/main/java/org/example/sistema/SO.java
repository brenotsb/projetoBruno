package org.example.sistema;

import org.example.cpu.CpuManager;
import org.example.memoria.Estrategia;
import org.example.memoria.MemoriaManager;
import org.example.processo.Processo;

public class SO {
    private MemoriaManager memoriaManager;
    private CpuManager cpuManager;

    public SO(Estrategia estrategia) {
        this.memoriaManager = new MemoriaManager(Estrategia.BEST_FIT);
        this.cpuManager = new CpuManager();
    }

    public Processo chamada(TipoDeChamada type, Processo process) {
        if (type == TipoDeChamada.WRITE_PROCESS) {
            memoriaManager.write(process);
        } else if (type == TipoDeChamada.CLOSE_PROCESS) {
            closeProcess(process);
        }
        return null;
    }

    public Processo criarProcesso() {
        return new Processo();
    }

    private void closeProcess(Processo process) {
        memoriaManager.remove(process);
    }
}
