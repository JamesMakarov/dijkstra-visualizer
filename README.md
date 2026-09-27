# Dijkstra Visualizer

[![Java tests](https://github.com/JamesMakarov/dijkstra-visualizer/actions/workflows/ci.yml/badge.svg)](https://github.com/JamesMakarov/dijkstra-visualizer/actions/workflows/ci.yml)

Interactive desktop application built with **Java and JavaFX** to visualize Dijkstra's shortest-path algorithm on a directed weighted graph.

The project separates the graph model and algorithm from the JavaFX interface, allowing the algorithm to emit events while the UI displays each step of the execution.

## Features

- create and remove vertices;
- create directed weighted edges;
- drag vertices across the canvas;
- select source and destination vertices;
- reject negative edge weights;
- animate visits, relaxations and rejected edges;
- highlight the final shortest path;
- calculate the total path cost;
- detect unreachable destinations;
- generate random graphs;
- reset algorithm colors without deleting the graph;
- clear the entire graph.

## Structure

```text
src/
├── algorithm/
│   ├── DijkstraListener.java
│   └── DijkstraSolver.java
├── app/
│   ├── EdgeFX.java
│   ├── GraphMain.java
│   ├── Launcher.java
│   ├── Main.java
│   └── NodeFX.java
└── model/
    ├── Edge.java
    └── Vertex.java
```

## Algorithm

`DijkstraSolver` uses:

- a `PriorityQueue` to select the next closest vertex;
- a distance map;
- a predecessor map;
- path reconstruction after the destination is reached.

If the destination is never reached, the solver returns an empty path.

## UI synchronization

The visual execution runs outside the JavaFX Application Thread.

The application starts Dijkstra on a worker thread and uses `Platform.runLater()` for visual updates. This keeps the UI responsive while the algorithm animation is running.

## Event-based visualization

`DijkstraListener` exposes events for:

- vertex visit;
- vertex finalization;
- edge relaxation;
- rejected relaxation attempt.

This keeps the algorithm independent from JavaFX-specific drawing code.

## Requirements

- JDK 21 or newer;
- Maven.

JavaFX is resolved automatically by Maven.

## Running

Clone the repository:

```bash
git clone https://github.com/JamesMakarov/dijkstra-visualizer.git
cd dijkstra-visualizer
```

Compile:

```bash
mvn compile
```

Run the application:

```bash
mvn javafx:run
```

The main class is `app.Launcher`.

## Tests

The project includes JUnit tests for the core shortest-path behavior:

- selection of the actual minimum-cost path;
- unreachable destinations;
- source equal to destination.

Run them with:

```bash
mvn test
```

The same suite runs automatically on GitHub Actions.

## Controls

| Action | Purpose |
|---|---|
| Move | Drag vertices |
| Add node | Create a vertex |
| Add edge | Create a directed weighted edge |
| Remove | Delete a vertex or edge |
| Start | Select the source vertex |
| End | Select the destination vertex |
| Generate graph | Create a random graph |
| Reset | Clear algorithm visualization state |
| Run Dijkstra | Execute the algorithm |
| Clear | Remove the entire graph |

## Notes

Dijkstra's algorithm assumes non-negative edge weights, so the interface blocks negative values when edges are created.
