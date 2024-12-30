package aplicacao;

import Tabuleiro.posicao.Posicao;
import Tabuleiro.posicao.Tabuleiro;
import Xadrez.PartidaDeXadrez;
import Xadrez.PecaDeXadrez;
import Xadrez.PosicaoXadrez;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        PartidaDeXadrez partida = new PartidaDeXadrez();
        Scanner sc = new Scanner(System.in);

        while(true){
            UI.printTabuleiro(partida.getPecasDeXadrez());
            System.out.println();
            System.out.println("Origem: ");
            PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

            System.out.println();
            System.out.println("Destino: ");
            PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

            PecaDeXadrez pecaCapturada = partida.performarJogada(origem,destino);
        }
    }
}
