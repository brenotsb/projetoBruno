package org.example.processo;

import org.example.memoria.EnderecoDeMemoria;

public class Processo {
    private static int contador = 1;
    private String id;
    private int size;
    private EnderecoDeMemoria endereco;

    public Processo() {
        this.id = "P" + contador++;
        this.size = (int) (Math.random() * 128);
    }

    public Processo(int size) {
        this.id = "P" + contador++;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public EnderecoDeMemoria getEndereco() {
        return endereco;
    }

    public void setEndereco(int inicio, int fim) {
        this.endereco = new EnderecoDeMemoria(inicio, fim);
    }
}