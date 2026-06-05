public abstract class Campeao {
    private String nome;
    private int vida;
    private int nivel;

    public Campeao (String nome, int vida, int nivel){
        this.nome = nome;
        this.vida = vida;
        this.nivel = nivel;
    }

    public String getNome(){
        return nome;
    }

    public boolean isVivo(){
        return vida > 0;
    }

    public abstract void ataqueBasico(Campeao alvo);

    public void receberDano(int dano){
        vida -= dano;
        if (vida < 0) vida = 0;
    }

}