package org.example.memoria;

import org.example.processo.Processo;

public class MemoriaManager {
    private String[] memoriaFisica;
    private Estrategia estrategia;

    public MemoriaManager(Estrategia estrategia) {
        this.memoriaFisica = new String[128];
        this.estrategia = estrategia;
    }

    public void write(Processo process) {
        if (estrategia == Estrategia.FIRST_FIT) {
            modoFirstFit(process);
        } else if (estrategia == Estrategia.BEST_FIT) {
            modoBestFit(process);
        } else if (estrategia == Estrategia.WORST_FIT) {
            modoWorstFit(process);
        }
    }

    public void remove(Processo process) {
        String idProcesso = process.getId();

        for (int i = 0; i < memoriaFisica.length; i++) {
            if (memoriaFisica[i].equals(idProcesso)) {
                memoriaFisica[i] = "";
            }
        }

        logRemoverProcesso(idProcesso);
        showEmptySpaces();
    }

    private void logRemoverProcesso(String id) {
        System.out.println("Processo: " + id + " removido da memória.");
    }

    private void modoFirstFit(Processo process) {
        int contadorDeMemoria = 0;
        int inicioIndex = 0;
        int fimIndex = 0;

        for (int i = 0; i < memoriaFisica.length; i++) {
            if (memoriaFisica[i] == null) {
                contadorDeMemoria++;

                if (contadorDeMemoria == process.getSize()) {
                    fimIndex = inicioIndex + contadorDeMemoria;
                    break;
                }
            } else {
                inicioIndex = i + 1;
                contadorDeMemoria = 0;
            }
        }
        process.setEndereco(inicioIndex, fimIndex);
        boolean verificadorDeTamanho = process.getEndereco().getSize() >= process.getSize();

        if (verificadorDeTamanho) {
            logProcessoInicial(process.getSize(), process.getId());
            for (int indexMemoria = process.getEndereco().getInicio(); indexMemoria < process.getEndereco().getFim(); indexMemoria++) {
                memoriaFisica[indexMemoria] = process.getId();
                logCriarProcesso(indexMemoria, process.getId());
            }
            logFinalizarProcesso(process.getId());
        } else {
            logErroNoProcesso(process.getId(), process.getSize());
        }
    }

    private void modoBestFit(Processo process) {
        int melhorInicio = -1;
        int menorTamanho = Integer.MAX_VALUE;

        for (int i = 0; i < memoriaFisica.length; i++) {
            if (memoriaFisica[i] == null) {
                int j = i + 1;
                while (j < memoriaFisica.length && memoriaFisica[j] == null) {
                    j++;
                }
                int tamanho = j - i;
                if (tamanho >= process.getSize() && tamanho < menorTamanho) {
                    melhorInicio = i;
                    menorTamanho = tamanho;
                }
                i = j - 1; // Avança o índice para o próximo bloco de memória
            }
        }

        alocarProcesso(process, melhorInicio);
    }

    private void modoWorstFit(Processo process) {
        int piorInicio = -1;
        int maiorTamanho = 0;

        for (int i = 0; i < memoriaFisica.length; i++) {
            int j = i;
            while (memoriaFisica[j] == null && j < memoriaFisica.length) {
                j++;
            }
            int tamanho = j - i;
            if (tamanho >= process.getSize() && tamanho > maiorTamanho) {
                piorInicio = i;
                maiorTamanho = tamanho;
                i = j - 1;
            }
        }

        alocarProcesso(process, piorInicio);
    }

    private void alocarProcesso(Processo process, int inicioIndex) {
        if (inicioIndex == -1) {
            logErroNoProcesso(process.getId(), process.getSize());
            return;
        }

        int fimIndex = inicioIndex + process.getSize();
        process.setEndereco(inicioIndex, fimIndex);

        logProcessoInicial(process.getSize(), process.getId());
        for (int i = inicioIndex; i < fimIndex; i++) {
            memoriaFisica[i] = process.getId();
            logCriarProcesso(i, process.getId());
        }
        logFinalizarProcesso(process.getId());
    }

    private void logProcessoInicial(int size, String id) {
        System.out.println("----------------");
        System.out.println("Processo : " + id + " - size: " + size);
        System.out.println("----------\n");
    }

    private void logCriarProcesso(int index, String id) {
        System.out.println("Index: " + index + " -> Value: " + id);
    }

    private void logFinalizarProcesso(String id) {
        System.out.println("\nProcess: " + id + " inicializado!\n");
    }

    private void logErroNoProcesso(String id, int size) {
        System.out.println("{error: \"Memoria Insuficiente\", process: " + id + ", size: " + size + "}");
    }
    private void showEmptySpaces() {
        int emptySpaceStart = -1;
        int emptySpaceEnd = -1;

        for (int i = 0; i < memoriaFisica.length; i++) {
            if (memoriaFisica[i] == null) {
                if (emptySpaceStart == -1) {
                    emptySpaceStart = i;
                }
                emptySpaceEnd = i;
            } else {
                if (emptySpaceStart != -1) {
                    System.out.println("Espaço livre: " + emptySpaceStart + " - " + emptySpaceEnd);
                    emptySpaceStart = -1;
                    emptySpaceEnd = -1;
                }
            }
        }

        if (emptySpaceStart != -1) {
            System.out.println("Espaço livre: " + emptySpaceStart + " - " + emptySpaceEnd);
        }
    }
}
