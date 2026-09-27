package algorithm;

import model.Vertex;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DijkstraSolverTest {

    @Test
    void findsShortestPathInsteadOfFirstDiscoveredPath() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.addEdge(b, 1);
        b.addEdge(d, 10);
        a.addEdge(c, 2);
        c.addEdge(d, 2);

        List<Vertex> path = new DijkstraSolver().findShortestPath(a, d);

        assertEquals(List.of(a, c, d), path);
    }

    @Test
    void returnsEmptyPathWhenDestinationIsUnreachable() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex isolated = new Vertex("Isolated");

        a.addEdge(b, 1);

        List<Vertex> path = new DijkstraSolver().findShortestPath(a, isolated);

        assertTrue(path.isEmpty());
    }

    @Test
    void returnsStartWhenSourceAndDestinationAreTheSame() {
        Vertex a = new Vertex("A");

        List<Vertex> path = new DijkstraSolver().findShortestPath(a, a);

        assertEquals(List.of(a), path);
    }
}
