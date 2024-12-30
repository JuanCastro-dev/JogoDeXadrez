package Xadrez;

import Tabuleiro.posicao.Peca;
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

    private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
        tabuleiro.colocarPeca(new PosicaoXadrez(coluna, linha).toPosicao(),peca);
    }

    public  PecaDeXadrez performarJogada(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
        Posicao origem = posicaoOrigem.toPosicao();
        Posicao destino = posicaoDestino.toPosicao();
        validarPosicaoOrigem(origem);
        Peca pecaCapturada = realizarMovimento(origem,destino);
        return (PecaDeXadrez) pecaCapturada;
    }

    private Peca realizarMovimento(Posicao origem, Posicao destino) {
        Peca p = tabuleiro.removerPeca(origem);
        Peca capturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(destino, p);
        return capturada;
    }

    private void validarPosicaoOrigem(Posicao origem) {
        if (!tabuleiro.jaTemPeca(origem))
            throw new XadrezException("Não há peça na posição "+origem);
        if(!tabuleiro.peca(origem).haMovimentoPossivel())
            throw new XadrezException("Não há movimentos possíveis para a peça selecionada");
    }

    private void setupInicial(){
        colocarNovaPeca('a',8,new Torre(tabuleiro,Cor.BRANCO));
        colocarNovaPeca('h',8,new Torre(tabuleiro,Cor.BRANCO));
        colocarNovaPeca('a',1,new Torre(tabuleiro,Cor.PRETO));
        colocarNovaPeca('h',1,new Torre(tabuleiro,Cor.PRETO));
        colocarNovaPeca('e',8,new Rei(tabuleiro,Cor.BRANCO));
        colocarNovaPeca('e',1,new Rei(tabuleiro,Cor.PRETO));
    }
}
