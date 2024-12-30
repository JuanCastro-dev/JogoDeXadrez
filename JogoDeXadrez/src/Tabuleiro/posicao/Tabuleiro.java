package Tabuleiro.posicao;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1)
            throw new TabuleiroException("Erro ao criar tabuleiro: São necessárias pelo menos 1 linha e 1 coluna");

        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna) {
        if (!posicaoExiste(linha, coluna))
            throw new TabuleiroException("A posição informada não existe no tabuleiro");
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExiste(posicao))
            throw new TabuleiroException("A posição informada não existe no tabuleiro");
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Posicao posicao, Peca peca) {
        if (jaTemPeca(posicao))
            throw new TabuleiroException("Já existe uma peça nessa posição");
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao) {
        if (!posicaoExiste(posicao))
            throw new TabuleiroException("Posição inválida");
        if (peca(posicao) == null)
            return null;
        Peca auxiliar = peca(posicao);
        auxiliar.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return auxiliar;
    }

    public boolean posicaoExiste(Posicao posicao) {
        return posicao.getLinha() >= 0 && posicao.getLinha() < linhas && posicao.getColuna() >= 0 && posicao.getColuna() < colunas;
    }

    public boolean posicaoExiste(int linha, int coluna) {
        return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;
    }

    public boolean jaTemPeca(Posicao posicao) {
        if (!posicaoExiste(posicao))
            throw new TabuleiroException("A posição informada não existe no tabuleiro");
        return peca(posicao) != null;
    }
}
