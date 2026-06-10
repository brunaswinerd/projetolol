/**
 * ApresentacaoLolAnimada.java
 *
 * Classe-lib nova para o projeto LoL.
 * Tem desenhos em ASCII, timer, mensagens digitadas devagar,
 * barra de carregamento, transicoes e animacoes simples no terminal.
 *
 * Uso no main:
 *     ApresentacaoLolAnimada.animada();
 *
 * Nao usa nenhuma biblioteca externa.
 */
public final class ApresentacaoProjetoLolLib {

    private static int atrasoLetraMs = 15;
    private static int pausaCurtaMs = 350;
    private static int pausaLongaMs = 900;
    private static boolean usarCores = true;

    private static final String RESET = "\u001B[0m";
    private static final String NEGRITO = "\u001B[1m";
    private static final String AZUL = "\u001B[34m";
    private static final String CIANO = "\u001B[36m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARELO = "\u001B[33m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String ROXO = "\u001B[35m";
    private static final String CINZA = "\u001B[90m";

    private ApresentacaoProjetoLolLib() {
    }

    // ============================================================
    // METODOS PUBLICOS PARA USAR NO MAIN
    // ============================================================

    public static void animada() {
        exibirApresentacaoCompletaAnimada();
    }

    public static void exibirAnimada() {
        exibirApresentacaoCompletaAnimada();
    }

    public static void exibirApresentacaoAnimada() {
        exibirApresentacaoCompletaAnimada();
    }

    public static void exibirApresentacaoCompleta() {
        exibirApresentacaoCompletaAnimada();
    }

    public static void exibirApresentacaoCompletaAnimada() {
        limparTela();
        aberturaComTimer();
        capa();
        objetivo();
        mapaDasClasses();
        explicarClasses();
        fluxoDaSimulacao();
        conceitosPoo();
        batalhaAnimada();
        melhoriasSugeridas();
        encerramento();
    }

    public static void exibirApresentacaoRapida() {
        int letraAnterior = atrasoLetraMs;
        int curtaAnterior = pausaCurtaMs;
        int longaAnterior = pausaLongaMs;

        configurarVelocidade(1, 80, 160);
        exibirApresentacaoCompletaAnimada();

        configurarVelocidade(letraAnterior, curtaAnterior, longaAnterior);
    }

    public static void configurarVelocidade(int atrasoLetra, int pausaCurta, int pausaLonga) {
        atrasoLetraMs = Math.max(0, atrasoLetra);
        pausaCurtaMs = Math.max(0, pausaCurta);
        pausaLongaMs = Math.max(0, pausaLonga);
    }

    public static void ativarCores(boolean ativar) {
        usarCores = ativar;
    }

    public static String getVersao() {
        return "ApresentacaoLolAnimada v2.0";
    }

    // ============================================================
    // PARTES DA APRESENTACAO
    // ============================================================

    private static void aberturaComTimer() {
        digitarLinha(cor(AZUL, "Abrindo o portal de Summoner's Rift..."));
        carregar("Carregando apresentacao visual", 30, 35);
        contador("Comecando em", 3);
    }

    private static void capa() {
        titulo("PROJETO LOL EM JAVA");
        arte(new String[] {
                "                 /\\",
                "                /  \\",
                "               /____\\        R I F T",
                "              /______\\",
                "",
                "        S U M M O N E R ' S   R I F T",
                "             Campeoes, classes e POO"
        }, CIANO, 90);

        digitarLinha(cor(AMARELO, "Apresentacao com desenhos, animacao, timer e explicacoes detalhadas."));
        pausarLongo();
    }

    private static void objetivo() {
        titulo("1. OBJETIVO DO PROJETO");
        digitarBloco(new String[] {
                "O projeto simula campeoes inspirados em League of Legends.",
                "Ele usa Java para representar personagens, ataques e habilidades especiais.",
                "A proposta principal e mostrar Programacao Orientada a Objetos de um jeito simples.",
                "Cada campeao tem dados proprios e comportamentos que aparecem durante a batalha."
        });

        caixa("Resumo", new String[] {
                "Tema: batalha entre campeoes",
                "Linguagem: Java",
                "Foco: classes, heranca, interface e polimorfismo",
                "Saida: apresentacao visual no terminal"
        }, VERDE);
    }

    private static void mapaDasClasses() {
        titulo("2. MAPA VISUAL DAS CLASSES");
        arte(new String[] {
                "                         +----------------------+",
                "                         |       Campeao        |",
                "                         |----------------------|",
                "                         | - nome               |",
                "                         | - vida               |",
                "                         | - nivel              |",
                "                         |----------------------|",
                "                         | + ataqueBasico()     |",
                "                         | + receberDano()      |",
                "                         +----------+-----------+",
                "                                    |",
                "                 +------------------+------------------+",
                "                 |                                     |",
                "       +---------v----------+             +------------v---------+",
                "       |      Lutador       |             |        Mago          |",
                "       |--------------------|             |----------------------|",
                "       | - danoFisico       |             | - poderMagico        |",
                "       | + ultimate()       |             | + escudo()           |",
                "       +---------+----------+             | + ultimate()         |",
                "                 |                        +------------+---------+",
                "                 |                                     |",
                "                 +------------------+------------------+",
                "                                    |",
                "                         +----------v-----------+",
                "                         | HabilidadeUltimate   |",
                "                         |----------------------|",
                "                         | + conjurarUltimate() |",
                "                         +----------------------+"
        }, ROXO, 15);

        digitarLinha(cor(CINZA, "Lutador e Mago herdam de Campeao e assinam o contrato da interface HabilidadeUltimate."));
        pausarLongo();
    }

    private static void explicarClasses() {
        titulo("3. EXPLICACAO DAS CLASSES");

        caixa("Campeao", new String[] {
                "Classe abstrata que serve como base para todos os campeoes.",
                "Guarda atributos em comum: nome, vida e nivel.",
                "Possui comportamento comum, como ataque basico e receber dano.",
                "Ajuda a evitar repeticao de codigo nas classes filhas."
        }, AZUL);

        caixa("Lutador", new String[] {
                "Classe concreta que representa campeoes de dano fisico.",
                "Herda as caracteristicas gerais da classe Campeao.",
                "Tem danoFisico como atributo especifico.",
                "Implementa conjurarUltimate com uma habilidade mais agressiva."
        }, VERMELHO);

        caixa("Mago", new String[] {
                "Classe concreta que representa campeoes de poder magico.",
                "Herda as caracteristicas gerais da classe Campeao.",
                "Tem poderMagico como atributo especifico.",
                "Pode conjurar escudo e tambem possui uma ultimate propria."
        }, CIANO);

        caixa("HabilidadeUltimate", new String[] {
                "Interface que define o metodo conjurarUltimate.",
                "Ela obriga as classes implementadoras a terem uma habilidade especial.",
                "Isso torna o projeto mais flexivel para criar novos tipos de campeao."
        }, AMARELO);
    }

    private static void fluxoDaSimulacao() {
        titulo("4. FLUXO DA SIMULACAO");
        passo(1, "O programa cria os campeoes Garen, Lux e Darius.");
        passo(2, "Garen executa um ataque basico contra Darius.");
        passo(3, "Lux conjura um escudo em Garen.");
        passo(4, "Darius usa sua ultimate contra Garen.");
        passo(5, "O terminal mostra as mensagens da batalha em ordem.");
        pausarLongo();
    }

    private static void conceitosPoo() {
        titulo("5. CONCEITOS DE POO DEMONSTRADOS");

        caixa("Heranca", new String[] {
                "Lutador e Mago reaproveitam atributos e metodos de Campeao.",
                "Isso deixa o projeto mais limpo e organizado."
        }, VERDE);

        caixa("Abstracao", new String[] {
                "Campeao representa a ideia geral de um personagem jogavel.",
                "Os detalhes ficam nas classes especificas, como Mago e Lutador."
        }, AZUL);

        caixa("Interface", new String[] {
                "HabilidadeUltimate define um contrato que outras classes devem seguir.",
                "Cada campeao pode executar a ultimate de uma forma diferente."
        }, AMARELO);

        caixa("Polimorfismo", new String[] {
                "Um Mago ou Lutador pode ser tratado como Campeao.",
                "Isso permite criar codigos mais flexiveis e reaproveitaveis."
        }, ROXO);
    }

    private static void batalhaAnimada() {
        titulo("6. BATALHA ANIMADA");

        arte(new String[] {
                "       GAREN                         DARIUS",
                "        O                              X",
                "       /|--- espada avanca --->      /|",
                "       / |                            / |"
        }, VERMELHO, 120);
        digitarLinha(cor(VERMELHO, "Garen usa ataque basico!"));
        barraVida("Vida de Darius", 20, 14);
        pausarCurto();

        arte(new String[] {
                "                    LUX",
                "                     *",
                "                  *  |  *",
                "               *     |     *",
                "             Escudo magico em Garen"
        }, CIANO, 120);
        digitarLinha(cor(CIANO, "Lux conjura Barreira Prismatica!"));
        carregar("Escudo sendo formado", 22, 40);
        pausarCurto();

        arte(new String[] {
                "       DARIUS prepara a ultimate",
                "             ====== MACHADO ======",
                "                    ||",
                "                    ||",
                "                 IMPACTO!"
        }, VERMELHO, 120);
        impacto();
        barraVida("Vida de Garen", 20, 9);
        pausarLongo();
    }

    private static void melhoriasSugeridas() {
        titulo("7. MELHORIAS SUGERIDAS NO CODIGO");

        ok("Remover o import org.jetbrains.annotations.NotNull se ele nao estiver configurado.");
        ok("Validar null antes de usar aliado.getNome() ou alvo.getNome().");
        ok("Adicionar getVida() e getNivel() na classe Campeao.");
        ok("Criar metodo status() para imprimir informacoes do campeao.");
        ok("Criar uma lista de Campeao para demonstrar polimorfismo.");
        ok("Separar apresentacao, criacao de campeoes e batalha em metodos diferentes.");

        pausarLongo();
    }

    private static void encerramento() {
        titulo("8. FECHAMENTO");
        digitarBloco(new String[] {
                "O projeto ja mostra uma boa base de POO em Java.",
                "Com essa lib, a explicacao fica mais visual e mais facil de apresentar.",
                "Agora o terminal vira uma mini apresentacao animada do projeto."
        });

        arte(new String[] {
                "              .-=========-.",
                "             |   TROFEU   |",
                "             |     1      |",
                "             |____________|",
                "                  ||",
                "               ___||___",
                "              |________|"
        }, AMARELO, 100);

        digitarLinha(cor(VERDE, "Apresentacao finalizada. A batalha pode comecar!"));
        separadorGrande();
    }

    // ============================================================
    // COMPONENTES DE TELA
    // ============================================================

    private static void titulo(String texto) {
        separadorGrande();
        digitarLinha(cor(NEGRITO + AMARELO, "=> " + texto));
        separadorPequeno();
        pausarCurto();
    }

    private static void caixa(String titulo, String[] linhas, String codigoCor) {
        String borda = "+------------------------------------------------------------+";
        System.out.println(cor(codigoCor, borda));
        System.out.println(cor(codigoCor, "| " + ajustar(titulo, 58) + " |"));
        System.out.println(cor(codigoCor, borda));

        for (String linha : linhas) {
            String[] partes = quebrarLinha(linha, 58).split("\\n");
            for (String parte : partes) {
                System.out.println(cor(codigoCor, "| " + ajustar(parte, 58) + " |"));
                dormir(45);
            }
        }

        System.out.println(cor(codigoCor, borda));
        System.out.println();
        pausarCurto();
    }

    private static void passo(int numero, String texto) {
        System.out.print(cor(CIANO, "[Passo " + numero + "] "));
        digitarLinha(texto);
        pausarCurto();
    }

    private static void ok(String texto) {
        System.out.print(cor(VERDE, "[OK] "));
        digitarLinha(texto);
        pausarCurto();
    }

    private static void barraVida(String nome, int total, int atual) {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(": [");
        for (int i = 1; i <= total; i++) {
            sb.append(i <= atual ? "#" : "-");
        }
        sb.append("] ").append(atual).append("/").append(total);
        digitarLinha(cor(VERDE, sb.toString()));
    }

    private static void carregar(String texto, int tamanho, int atrasoMs) {
        System.out.print(cor(CIANO, texto + ": ["));
        for (int i = 0; i < tamanho; i++) {
            System.out.print("#");
            dormir(atrasoMs);
        }
        System.out.println("] 100%");
    }

    private static void contador(String texto, int segundos) {
        for (int i = segundos; i >= 1; i--) {
            System.out.println(cor(AMARELO, texto + " " + i + "..."));
            dormir(700);
        }
        System.out.println(cor(VERDE, "Vai!"));
        pausarCurto();
    }

    private static void impacto() {
        for (int i = 0; i < 4; i++) {
            System.out.println(cor(VERMELHO, "      >>> IMPACTO <<<"));
            dormir(100);
            System.out.println(cor(VERMELHO, "   >>>    IMPACTO    <<<"));
            dormir(100);
        }
    }

    private static void arte(String[] linhas, String codigoCor, int atrasoLinhaMs) {
        for (String linha : linhas) {
            System.out.println(cor(codigoCor, linha));
            dormir(atrasoLinhaMs);
        }
        System.out.println();
    }

    private static void digitarBloco(String[] linhas) {
        for (String linha : linhas) {
            digitarLinha(linha);
            pausarCurto();
        }
        System.out.println();
    }

    private static void digitarLinha(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            dormir(atrasoLetraMs);
        }
        System.out.println();
    }

    private static void separadorGrande() {
        System.out.println(cor(CINZA, "============================================================"));
    }

    private static void separadorPequeno() {
        System.out.println(cor(CINZA, "------------------------------------------------------------"));
    }

    private static void limparTela() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
        System.out.println();
        System.out.println();
    }

    // ============================================================
    // UTILITARIOS
    // ============================================================

    private static void pausarCurto() {
        dormir(pausaCurtaMs);
    }

    private static void pausarLongo() {
        dormir(pausaLongaMs);
    }

    private static void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static String cor(String codigoCor, String texto) {
        if (!usarCores) {
            return texto;
        }
        return codigoCor + texto + RESET;
    }

    private static String ajustar(String texto, int tamanho) {
        if (texto.length() > tamanho) {
            return texto.substring(0, tamanho);
        }

        StringBuilder sb = new StringBuilder(texto);
        while (sb.length() < tamanho) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private static String quebrarLinha(String texto, int tamanho) {
        if (texto.length() <= tamanho) {
            return texto;
        }

        StringBuilder resultado = new StringBuilder();
        StringBuilder linhaAtual = new StringBuilder();
        String[] palavras = texto.split(" ");

        for (String palavra : palavras) {
            if (linhaAtual.length() + palavra.length() + 1 > tamanho) {
                resultado.append(linhaAtual).append("\n");
                linhaAtual = new StringBuilder(palavra);
            } else {
                if (linhaAtual.length() > 0) {
                    linhaAtual.append(" ");
                }
                linhaAtual.append(palavra);
            }
        }

        resultado.append(linhaAtual);
        return resultado.toString();
    }
}