package Etapa2;

public class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos){
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPartido() { return partido; }
    public void setPartido(String partido) { this.partido = partido; }

    public int getIntencoesVotos() { return intencoesVotos; }
    public void setIntencoesVotos(int intencoesVotos) { this.intencoesVotos = intencoesVotos; }

    @Override
    public String toString() {
        // Códigos de cores ANSI para o terminal
        String corAzul = "\u001B[34m";   // Azul para o cabeçalho
        String corVerde = "\u001B[32m";  // Verde para os números
        String corReset = "\u001B[0m";   // Reset para a cor padrão

        return String.format(
                "%s============================ INFORMAÇÃO DO CANDIDATO ============================%s%n" +
                        "Nome: %s%s%s%n" +                           // Nome do candidato
                        "Partido: %s%s%s%n" +                        // Partido
                        "Intenções de voto: %s%d%s%n" +              // Número de intenções de votos
                        "===============================%n",
                corAzul, corReset,                         // Cores para o cabeçalho
                corReset, nome, corReset,                  // Nome do candidato
                corVerde, partido, corReset,               // Nome do Partido do Candidato
                corVerde, intencoesVotos, corReset         // Intenções de voto
        );
    }
}
