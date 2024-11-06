# GerenciadorDeCandidatos

## 📖 Descrição do Programa

Este projeto é uma aplicação Java que gerencia dados de candidatos políticos. Lê nomes e partidos de arquivos, atribui votos aleatórios, ordena os candidatos usando o algoritmo **Insertion Sort** e permite a pesquisa eficiente por nome com **Pesquisa Binária**. Demonstra conceitos de programação orientada a objetos, estruturas de dados e algoritmos.

## 🌟 Funcionalidades

- **Leitura de Dados**: Importa nomes de candidatos e partidos de arquivos de texto.
- **Atribuição de Votos Aleatórios**: Gera intenções de votos aleatórias para cada candidato.
- **Ordenação de Candidatos**: Ordena candidatos por nome, intenções de votos e partido usando **Insertion Sort**.
- **Pesquisa Eficiente**: Permite pesquisa rápida de candidatos por nome utilizando **Pesquisa Binária**.
- **Interação com o Usuário**: Interface de linha de comando para interação e exibição de resultados.
- **Exibição de Dados**: Apresenta informações dos candidatos de forma organizada e legível.

## 🛠️ Tecnologias Utilizadas

- ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=java&logoColor=white)
- ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=flat-square&logo=intellij-idea&logoColor=white)
- ![Git](https://img.shields.io/badge/Git-%23F05033.svg?style=flat-square&logo=git&logoColor=white)
- ![GitHub](https://img.shields.io/badge/GitHub-%23121011.svg?style=flat-square&logo=github&logoColor=white)

## 🗺️ Arquitetura do Projeto

O projeto é composto por três classes principais:

- **Candidato**: Representa um candidato com atributos como nome, partido e intenções de votos.
- **OrdenarCandidatos**: Contém métodos estáticos para ordenar e pesquisar candidatos.
- **PrincipalCandidatos**: Classe principal que executa a lógica do programa, incluindo leitura de dados, ordenação e interação com o usuário.

### Diagrama de Classes (UML)

*Imagem do diagrama UML ilustrando as classes e suas interações.*

![Diagrama UML](path_to_uml_diagram.png)

## 📝 Diagrama UML

> *Substitua `path_to_uml_diagram.png` pelo caminho real da imagem do diagrama UML.*

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java JDK 8** ou superior instalado.
- IDE como **IntelliJ IDEA** ou **Eclipse** (opcional, mas recomendado).

### Passos

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seuusuario/GerenciadorDeCandidatos.git

2. **Navegue até o diretório do projeto:**

   ```bash
   cd GerenciadorDeCandidatos

3. **Prepare os arquivos de dados:**
- Certifique-se de que os arquivos nomes.txt e partidos.txt estão no diretório correto conforme especificado no código (src/Etapa2/).

4. **Navegue até o diretório do projeto:**

- Usando o terminal:
   ```bash
   javac src/PrincipalCandidatos.java

- Usando uma IDE:

    Importe o projeto e utilize a opção de Build ou Compilar.

5. **Execute a aplicação:**

- Via terminal:
   ```bash
   java src/PrincipalCandidatos

- Via IDE:

  Execute a classe PrincipalCandidatos como uma aplicação Java.

6. **Interaja com o programa:**

- Siga as instruções exibidas no console para pesquisar candidatos e visualizar os dados ordenados.


