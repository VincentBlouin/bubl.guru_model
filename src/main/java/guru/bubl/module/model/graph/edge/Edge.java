package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.graph_element.GraphElement;

import java.net.URI;

public interface Edge {
    URI sourceUri();

    URI destinationUri();

    @Deprecated
    GraphElement source();

    @Deprecated
    GraphElement destination();
}
