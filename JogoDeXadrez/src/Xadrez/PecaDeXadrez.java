package Xadrez;

import Tabuleiro.posicao.Peca;
import Tabuleiro.posicao.Tabuleiro;

public abstract class PecaDeXadrez extends Peca {

    private Cor cor;

    public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
}
