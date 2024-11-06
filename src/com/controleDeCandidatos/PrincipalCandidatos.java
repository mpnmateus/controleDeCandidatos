package Etapa2;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    public static void main(String[] args) {

        // Geração de número aleatório para determinar limite do array de candidatos
        int randomNumberOfElementsIntTheArray = (int) (Math.random() * 100) + 1;
        Candidato [] candidatos = new Candidato[randomNumberOfElementsIntTheArray];

        String caminhoArquivoNomes = "src/Etapa2/nomes.txt";
        String caminhoArquivoPartidos = "src/Etapa2/partidos.txt";


        // Lê os nomes dos candidatos a partir de um arquivo texto e armazena num array de String
        String [] nomes = lerNomesDeArquivo(caminhoArquivoNomes, randomNumberOfElementsIntTheArray);
        // Lê os partidos dos candidatos a partir de um arquivo texto e armazena num array de String
        String [] partidos = lerPartidosDeArquivo(caminhoArquivoPartidos, randomNumberOfElementsIntTheArray);


//        System.out.println(Arrays.toString(partidos)); // Prova real método que lê arquivo de nomes + armazenamento em array de String
//        System.out.println(Arrays.toString(nomes)); // Prova real método que lê arquivo de partidos + armazenamento em array de String


        Random rand = new Random(); // Cria um objeto Random para gerar valores aleatórios.
        // Preenche o array de candidatos com nomes e partidos advindos dos arquivos .txt
        for(int i = 0; i < candidatos.length; i++){
            String nomeCandidato = nomes[i];
            String partidoCandidato = partidos[i];
            int intencoesVotos = rand.nextInt(901) + 100; // Gera um número aleatório de intenções de voto

            candidatos[i] = new Candidato(nomeCandidato, partidoCandidato, intencoesVotos);
        }

//        // Prova real preenchimento array de Candidatos com seus atributos (advindos dos arquivos nomes.txt e partidos.txt
//        for(int j = 0; j < candidatos.length; j++){
//            System.out.println(candidatos[j]);
//        }

//        System.out.println("Candidatos ordenados por nome/votos/partido: " + Arrays.toString(candidatos));

        // Ordena os candidatos do menos relevante para o mais relevante, mantendo a ordenação e exibição em tela por ordem de relevância
        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos); // Critério menos significativo
        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos); // Critério intermediário
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos); // Critério mais significativo



        Scanner sc = new Scanner(System.in);
        String nomeCandidatoProcura = "";
        boolean entradaValida = false;

        // Fluxo de verificação evitando valores nulos (enter, espaço, etc)
        while (!entradaValida){
            // Solicita ao usuário que digite um nome a ser procurado no array
            System.out.println("\n Digite o nome de um candidato para procurar suas informaçoes:  ");
            nomeCandidatoProcura = sc.nextLine().trim();

            // Verifica se o valor informado pelo usuário é válido (entradaValida), pedindo que digite novamente caso não
            if (nomeCandidatoProcura.isEmpty()) {
                System.out.println("Erro: O nome do candidato não pode ser vazio.");
            } else {
                entradaValida = true;
            }
        }
        nomeCandidatoProcura = nomeCandidatoProcura.toLowerCase();

        // Através de de um método de pesquisa binária, verifica a primeira ocorrência do nome do candidato digitado no array de candidatos
        int posicaoCandidatoNoArray = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomeCandidatoProcura);


        // Imprime relatório condensando as informações mais importantes, com ordenação de candidatos seguindo a hierarquida do mais para o menos importante:
        // Nome, Intenção de votos, Partido
        imprimirCandidatos(candidatos);
        imprimirCandidatoPesquisado(candidatos, nomeCandidatoProcura, posicaoCandidatoNoArray);

    }

    /**
     * Método que imprime um cabeçalho e as informações de todos os candidatos do array (ordenado)
     *
     * @param candidatos Array de objetos Candidato já ordenado.
     */
    public static void imprimirCandidatos(Candidato[] candidatos){
        // Códigos de cores ANSI para o terminal
        String corVerde = "\u001B[32m";  // Verde para todo o texto
        String corReset = "\u001B[0m";   // Reset para a cor padrão

        // Imprime o cabeçalho uma única vez
        System.out.println(corVerde +
                "===========================================================================\n" +
                "         RELATÓRIO DE VOTAÇÃO\n" +
                "===========================================================================\n" +
                "Nome                 Partido         Intenções de Votos\n" +
                "===========================================================================\n" +
                "Candidatos ordenados por nome:" + corReset);
        System.out.println();
        // Imprime cada candidato com os dados formatados
        for (Candidato candidato : candidatos) {
            System.out.printf(corVerde + "%-20s %-15s %-5d" + corReset + "%n",
                    candidato.getNome(), candidato.getPartido(), candidato.getIntencoesVotos());
        }
        // Imprime primeiro candidato do array
        System.out.printf(corVerde +
                "===========================================================================\n" +
                "Primeiro Candidato: " +
                corVerde + "%-20s %-15s %-5d" + corReset + "%n",
                candidatos[0].getNome(), candidatos[0].getPartido(), candidatos[0].getIntencoesVotos()
        );
        // Imprime último candidato do array
        int tamanhoArray = candidatos.length - 1;
        System.out.printf(corVerde +
                        "Último Candidato: " +
                        corVerde + "%-20s %-15s %-5d" + corReset + "%n",
                candidatos[tamanhoArray].getNome(), candidatos[tamanhoArray].getPartido(), candidatos[tamanhoArray].getIntencoesVotos()
        );
    }
    /**
     * Método que imprime as informações do candidato que o usuário digitar, retornando uma mensagem de erro caso não esteja na lista
     *
     * @param candidatos Array de objetos Candidato já ordenado.
     */
    public static void imprimirCandidatoPesquisado(Candidato[] candidatos, String nomeCandidato, int posicaoCandidatoProcurado){
        // Códigos de cores ANSI para o terminal
        String corVerde = "\u001B[32m";  // Verde para todo o texto
        String corReset = "\u001B[0m";   // Reset para a cor padrão
        // Imprime informações do candidato procurado ou mensagem de erro, caso ele não esteja na lista
        if(posicaoCandidatoProcurado == -1)
            System.out.printf(corVerde + "[Erro]: O candidato " + nomeCandidato + " não está na lista." + corReset + "%n");
        else
            System.out.printf(corVerde +
                            "[OK] Candidato " + nomeCandidato + " encontrado na posição " + posicaoCandidatoProcurado + ": " +
                            corVerde + "%-20s %-15s %-5d" + corReset + "%n",
                    candidatos[posicaoCandidatoProcurado].getNome(), candidatos[posicaoCandidatoProcurado].getPartido(), candidatos[posicaoCandidatoProcurado].getIntencoesVotos()
            );
    }


    /**
     * Método que lê os nomes dos candidatos a partir de um arquivo de texto.
     *
     * @param nomeArquivo Nome do arquivo que contém os nomes dos países
     * @param quantidadeElementosArray Quantidade de linhas do arquivo nomes.txt
     * @return Array de Strings contendo os nomes dos candidatos pela ordem em que constam no arquivo original
     */
    public static String [] lerNomesDeArquivo(String nomeArquivo, int quantidadeElementosArray){
        String [] nomes = new String[quantidadeElementosArray];
        try {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(nomeArquivo));
            } catch (FileNotFoundException e) {
                String caminhoAjustado = "src/" + nomeArquivo;
                try{
                    br = new BufferedReader(new FileReader(caminhoAjustado));
                    nomeArquivo = caminhoAjustado;
                } catch (FileNotFoundException e2) {
                    throw new IllegalArgumentException("Arquivo não encontrado: " + nomeArquivo);
                }
            }

            String line;
            int i = 0;
            while((line = br.readLine()) != null && i < quantidadeElementosArray){
                nomes[i] = line;
                i++;
            }
            br.close();

            if(i < quantidadeElementosArray){
                System.out.println("Aviso: o arquivo contém menos linhas do que o necessário para preencher o array");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro na leitura do arquivo " + e.getMessage());
        }
        return nomes;
    }

    /**
     * Método que lê os nomes dos partidos a partir de um arquivo de texto.
     *
     * @param partidoArquivo Nome do arquivo que contém os nomes dos partidos relacionados aos candidatos
     * @param quantidadeElementosArray Quantidade de linhas do arquivo partidos.txt
     * @return Array de Strings contendo as siglas dos partidos relacionados aos candidatos pela ordem em que constam no arquivo original
     */
    public static String [] lerPartidosDeArquivo(String partidoArquivo, int quantidadeElementosArray){
        String [] partidos = new String [quantidadeElementosArray];
        try {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(partidoArquivo));
            } catch (FileNotFoundException e) {
                String caminhoAjustado = "src/" + partidoArquivo;
                try {
                    br = new BufferedReader(new FileReader(caminhoAjustado));
                    partidoArquivo = caminhoAjustado;
                } catch(FileNotFoundException e2) {
                    throw new IllegalArgumentException("Arquivo não encontrado: " + partidoArquivo);
                }
            }

            String line;
            int i = 0;
            while((line = br.readLine()) != null && i < quantidadeElementosArray){
                partidos[i] = line;
                i++;
            }
            br.close();

            if(i < quantidadeElementosArray){
                System.out.println("Aviso: o arquivo contém menos linhas do que o necessário para preencher o array.");
            }

        } catch(FileNotFoundException e) {
            System.out.println("Arquivo não encontrado " + partidoArquivo);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro na leitura do arquivo " + e.getMessage());
        }
        return partidos;
    }
}
