package org.example;

import org.example.memoria.Estrategia;
import org.example.processo.Processo;
import org.example.sistema.SO;
import org.example.sistema.TipoDeChamada;

public class App
{
    public static void main( String[] args )
    {
        // Escolha a estratégia que deseja testar
        Estrategia estrategia = Estrategia.BEST_FIT;

        // Crie uma instância do sistema operacional com a estratégia escolhida
        SO so = new SO(estrategia);

        // Crie os processos e faça as chamadas de sistema
        Processo p1 = new Processo(50);
        so.chamada(TipoDeChamada.WRITE_PROCESS, p1);

        Processo p2 = new Processo(20);
        so.chamada(TipoDeChamada.WRITE_PROCESS, p2);

        Processo p3 = new Processo(30);
        so.chamada(TipoDeChamada.WRITE_PROCESS, p3);

        Processo p4 = new Processo(27);
        so.chamada(TipoDeChamada.WRITE_PROCESS, p4);

        Processo p5 = new Processo(1);
        so.chamada(TipoDeChamada.WRITE_PROCESS, p5);

        so.chamada(TipoDeChamada.CLOSE_PROCESS, p2);
        so.chamada(TipoDeChamada.CLOSE_PROCESS, p4);
        so.chamada(TipoDeChamada.CLOSE_PROCESS, p5);
    }
}
