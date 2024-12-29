package aplicacao;

import Tabuleiro.posicao.Posicao;
import Tabuleiro.posicao.Tabuleiro;
import Xadrez.PartidaDeXadrez;

public class Program {
    public static void main(String[] args) {
        PartidaDeXadrez partida = new PartidaDeXadrez();
        UI.printTabuleiro(partida.getPecasDeXadrez());
    }
}
