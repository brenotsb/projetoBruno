package org.example.memoria;
public class EnderecoDeMemoria {
    private int inicio;
    private int fim;

    public EnderecoDeMemoria(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    public int getSize() {
        return fim - inicio;
    }
}