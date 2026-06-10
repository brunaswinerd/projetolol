public class SummonersRift {
    public static void main(String[] args) {
        ApresentacaoProjetoLolLib.animada();
        System.out.println("Bem vindo a SummonersRift");

        Campeao garen = new Lutador("Garen", 2000, 18, 150);
        Mago lux = new Mago("Lux", 1200, 18, 250);
        Lutador darius = new Lutador("Darius", 2100, 18, 160);

        garen.ataqueBasico(darius);
        lux.conjurarEscudo(garen);
        darius.conjurarUltimate(garen);
    }
}
