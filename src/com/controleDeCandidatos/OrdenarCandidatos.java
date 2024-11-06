package Etapa2;

public class OrdenarCandidatos {

    /**
     * Método que ordena um array de candidatos pelo nome do candidato usando o algoritmo de inserção direta (Isertion Sort).
     *
     * @param candidatos Array de objetos Candidato a ser ordenado.
     */
    public static void ordenaCandidatosPorNome(Candidato [] candidatos){
        int n = candidatos.length; // Obtém o tamanho total do array de candidatos.

        // O loop começa na segunda posição (índice 1), assumindo que o primeiro elemento já está ordenado.
        for(int i = 1; i < n; i++){
            // Guarda o candidato atual que será comparado com as anteriores.
            Candidato elementoAtual = candidatos[i];
            int j = i - 1; // 'j' será usado para verificar os elementos à esquerda do 'elementoAtual'.

            // Este loop verifica se os elementos à esquerda são maiores que o 'elementoAtual'.
            // Se forem, eles são deslocados para a direita, abrindo espaço para o 'elementoAtual'.
            while(j >= 0 && candidatos[j].getNome().compareTo(elementoAtual.getNome()) > 0){ // retorna > 0 se o elemento anterior ao atual é maior e, assim, deve ser feita a troca
                candidatos[j+1] = candidatos[j]; // Desloca o elemento para a direita.
                j = j - 1; // Decrementa 'j' para continuar comparando com os elementos anteriores.
            }
            candidatos[j+1] = elementoAtual; // Insere o 'elementoAtual' na posição correta (no seu lugar).
        }
    }

    /**
     * Método que ordena um array de candidatos pela quantidade de intenções de voto usando o algoritmo de inserção direta (Insertion Sort).
     *
     * @param candidatos Array de objetos Candidato a ser ordenado.
     */
    public static void ordenaCandidatosPorVotos(Candidato [] candidatos){
        int n = candidatos.length;
        for (int i = 1; i < n; i++) {
            Candidato elementoAtual = candidatos[i];
            int j = i - 1;
            while (j >= 0 && candidatos[j].getIntencoesVotos() < elementoAtual.getIntencoesVotos()) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = elementoAtual;
        }
    }
    /**
     * Método que ordena um array de candidatos pelo nome do partido usando o algoritmo de inserção direta (Isertion Sort).
     *
     * @param candidatos Array de objetos Candidato a ser ordenado.
     */
    public static void ordenaCandidatosPorPartido(Candidato [] candidatos){
        int n = candidatos.length;
        for(int i = 1; i < n; i++){
            int j = i - 1;
            Candidato elementoAtual = candidatos[i];
            while(j >= 0 && candidatos[j].getPartido().compareTo(elementoAtual.getPartido()) > 0){
                candidatos[j+1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = elementoAtual;
        }
    }
    /**
     * Método que retorna a posição da primeira ocorrência de um nome de candidato dentro de um array de candidatos já ordenado
     *
     * @param candidatos Array de objetos Candidato a ser ordenado.
     * @return Posição da primeira ocorrência de um nome no array de candidatos já ordenado.
     */
    public static int pesquisaBinariaCandidatos(Candidato [] candidatos, String nome){
        int inf = 0;
        int sup = candidatos.length - 1;
        int resultado = -1;
        while(inf <= sup){
            int med = (inf + sup) / 2;
            if(nome.compareTo(candidatos[med].getNome().toLowerCase()) == 0) {
                resultado = med;
                // Continua pesquisando na metade esquerda para encontrar a primeira ocorrência
                sup = med - 1;
            }
            else if (nome.compareTo(candidatos[med].getNome().toLowerCase()) < 0)
                sup = med - 1;
            else
                inf = med + 1;
        }
        return resultado;
    }

}
