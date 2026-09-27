<div align="center">

  # 🕸️ Dijkstra Visualizer
  
  **Visualizador interativo do algoritmo de Dijkstra em JavaFX.**
  
  ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
  ![JavaFX](https://img.shields.io/badge/JavaFX-2D2D30?style=for-the-badge&logo=java&logoColor=white)
  ![Status](https://img.shields.io/badge/Status-Finished-39ff14?style=for-the-badge)

  ---
  
  *Visualização em tempo real do algoritmo de caminho mínimo com arquitetura desacoplada.*

</div>

## 📖 Sobre o Projeto

Este projeto não é apenas uma visualização de algoritmo, é um estudo de caso em **Engenharia de Software** aplicada. O objetivo foi criar uma aplicação desktop robusta, responsiva e visualmente moderna para demonstrar o funcionamento do **Algoritmo de Dijkstra**.

O visualizador separa a lógica do algoritmo da interface e executa o processamento em uma thread separada para manter a interface responsiva durante a animação.

## ✨ Funcionalidades Principais

### 🎨 Interface & UX
* **Modo Dark Neon:** Design moderno inspirado em ferramentas de engenharia e cyberpunk.
* **Drag & Drop Fluido:** Manipulação livre de vértices e arestas.
* **Feedback Visual:** Cores distintas para nós visitados (Amarelo), finalizados (Verde) e caminhos descartados (Vermelho).

### ⚙️ Engenharia & Performance
* **Gerador de Grafos Aleatórios:** Crie cenários de teste complexos (10 a 100 nós) com um único clique.
* **Thread Safety:** O algoritmo roda em *Worker Threads*, prevenindo o congelamento da interface.
* **Validação em Tempo Real:** * Bloqueio de arestas com pesos negativos.
    * Detecção automática de grafos desconexos.
    * Tratamento de caminhos impossíveis.

## 🛠️ Arquitetura e Design Patterns

O código foi estruturado para ser escalável e testável:

| Padrão / Conceito | Aplicação no Projeto |
| :--- | :--- |
| **Observer Pattern** | Desacopla o Algoritmo (`DijkstraSolver`) da Interface (`GraphMain`). O backend apenas "notifica" eventos, sem saber quem os desenha. |
| **Multithreading** | Uso de `Platform.runLater()` para sincronizar o processamento pesado com a *JavaFX Application Thread*. |
| **Composite Pattern** | Componentes visuais como `NodeFX` e `EdgeFX` encapsulam sua própria lógica de renderização e eventos. |

## 🎮 Como Usar (Guia de Controles)

A barra de ferramentas foi projetada para ser intuitiva:

| Botão / Cor | Função |
| :--- | :--- |
| **✋ Mover** | Arraste os nós para organizar o grafo. |
| **➕ Nó / 🔗 Aresta** | Ferramentas de edição para desenhar manualmente. |
| **🚩 Início / 🏁 Fim** | Define os pontos de partida e chegada. |
| **🟪 Gerar (Roxo)** | Cria um grafo aleatório proceduralmente. |
| **🟩 Rodar (Verde)** | Inicia a animação do algoritmo. |
| **🟧 Resetar (Laranja)** | Limpa apenas a "tinta" da animação, mantendo o grafo. |
| **🟥 Limpar (Vermelho)** | Apaga tudo da tela (Reset total). |

## 🚀 Como Rodar Localmente

### Pré-requisitos
* **Java JDK 21** ou superior.
* Maven (opcional) ou qualquer IDE compatível (IntelliJ IDEA recomendado).

### Passo a Passo

1. **Clone o repositório**
   ```bash
   git clone https://github.com/JamesMakarov/dijkstra-visualizer.git
