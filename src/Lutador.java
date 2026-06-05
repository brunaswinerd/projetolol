public class Lutador extends Campeao implements HabilidadeUltimate {
    private int danoDeAtaque;

    public Lutador(String nome, int vida, int nivel, int danoDeAtaque) {
        super(nome, vida, nivel);
        this.danoDeAtaque = danoDeAtaque;
    }

    @Override
    public void ataqueBasico(Campeao alvo) {
        System.out.println("⚔️ " + getNome() + " avança corpo-a-corpo e atinge " + alvo.getNome() + " com sua arma!");
        alvo.receberDano(danoDeAtaque);
    }

    @Override
    public void conjurarUltimate(Campeao alvo) {
        System.out.println("💥 ULTIMATE: " + getNome() + " invoca a Justiça Demaciana sobre " + alvo.getNome() + "!");
        alvo.receberDano(danoDeAtaque * 3);
    }
}
