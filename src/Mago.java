import org.jetbrains.annotations.NotNull;

public class Mago extends Campeao implements HabilidadeUltimate {
    private int poderDeHabilidade;

    public Mago(String nome, int vida, int nivel, int poderDeHabilidade) {
        super(nome, vida, nivel);
        this.poderDeHabilidade = poderDeHabilidade;
    }

    @Override
    public void ataqueBasico(Campeao alvo) {
        System.out.println("***" + getNome() + " dispara um projétil mágico à distância em " + alvo.getNome() + ".");
        alvo.receberDano(poderDeHabilidade / 3);
    }

    @Override
    public void conjurarUltimate(Campeao alvo) {
        System.out.println("🌟 ULTIMATE: " + getNome() + " dispara a Centelha Final (Laser) rasgando o mapa na direção de " + alvo.getNome() + "!");
        alvo.receberDano(poderDeHabilidade * 4);
    }

    // \/ Sobrecarga, pode ser usada em métodos e construtores

    public void conjurarEscudo() {
        System.out.println("🛡️ " + getNome() + " conjura a Barreira Prismática em SI MESMA para absorver dano.");
    }

    public void conjurarEscudo(@NotNull Campeao aliado) {
        System.out.println("🛡️ " + getNome() + " lança seu bastão e aplica a Barreira Prismática no aliado: " + aliado.getNome() + "!");
    }
}
