package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraph;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface SubGraph {
    VertexInSubGraph vertexWithIdentifier(URI identifier);
    Edge edgeWithIdentifier(URI identifier);
    int numberOfEdgesAndVertices();
    int numberOfEdges();
    int numberOfVertices();
    Boolean containsVertex(Vertex vertex);
    Boolean containsEdge(Edge edge);
    Boolean hasEdgeWithUri(URI uri);
    Map<URI, ? extends VertexInSubGraph> vertices();
    Map<URI, ? extends Edge> edges();
}
