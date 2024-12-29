package Xadrez.pecas;

import Tabuleiro.posicao.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "T";
    }
}
