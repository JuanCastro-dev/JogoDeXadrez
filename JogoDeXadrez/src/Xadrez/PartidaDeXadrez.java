package Xadrez;

import Tabuleiro.posicao.Posicao;
import Tabuleiro.posicao.Tabuleiro;
import Xadrez.pecas.Rei;
import Xadrez.pecas.Torre;

public class PartidaDeXadrez {

    private Tabuleiro tabuleiro;

    public PartidaDeXadrez() {
        tabuleiro = new Tabuleiro(8,8);
        setupInicial();
    }

    public PecaDeXadrez[][] getPecasDeXadrez() {
        PecaDeXadrez [][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i,j);
            }
        }
        return mat;
    }

    private void setupInicial(){
        tabuleiro.colocarPeca(new Posicao(0,0),new Torre(tabuleiro,Cor.BRANCO));
        tabuleiro.colocarPeca(new Posicao(0,7),new Torre(tabuleiro,Cor.BRANCO));
        tabuleiro.colocarPeca(new Posicao(7,0),new Torre(tabuleiro,Cor.PRETO));
        tabuleiro.colocarPeca(new Posicao(7,7),new Torre(tabuleiro,Cor.PRETO));
        tabuleiro.colocarPeca(new Posicao(0,4),new Rei(tabuleiro,Cor.BRANCO));
        tabuleiro.colocarPeca(new Posicao(7,4),new Rei(tabuleiro,Cor.PRETO));
    }
}
