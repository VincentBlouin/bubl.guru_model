package org.triple_brain.module.model.test.scenarios;

import org.triple_brain.module.model.test.GraphComponentTest;
import org.triple_brain.module.model.graph.GraphFactory;
import org.triple_brain.module.model.graph.UserGraph;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.vertex.VertexOperator;

import javax.inject.Inject;

/*
* Copyright Mozilla Public License 1.1
*/
public class TestScenarios {

    @Inject
    protected GraphFactory graphFactory;

    @Inject
    protected GraphComponentTest graphComponentTest;

    public VerticesCalledABAndC makeGraphHave3VerticesABCWhereAIsDefaultCenterVertexAndAPointsToBAndBPointsToC(UserGraph userGraph) {
        graphComponentTest.removeWholeGraph();
        graphFactory.createForUser(userGraph.user());
        VertexOperator vertexA = userGraph.defaultVertex();
        vertexA.label("vertex A");
        VertexOperator vertexB = vertexA.addVertexAndRelation().destinationVertex();
        vertexB.label("vertex B");
        VertexOperator vertexC = vertexB.addVertexAndRelation().destinationVertex();
        vertexC.label("vertex C");
        EdgeOperator betweenAAndB = vertexA.edgeThatLinksToDestinationVertex(vertexB);
        betweenAAndB.label("between vertex A and vertex B");
        EdgeOperator betweenBAndC = vertexB.edgeThatLinksToDestinationVertex(vertexC);
        betweenBAndC.label("between vertex B and vertex C");
        return new VerticesCalledABAndC(
                vertexA,
                vertexB,
                vertexC
        );
    }

    public VerticesCalledABAndC makeGraphHave3SerialVerticesWithLongLabels(UserGraph userGraph) throws Exception {
        VerticesCalledABAndC verticesCalledABAndC = makeGraphHave3VerticesABCWhereAIsDefaultCenterVertexAndAPointsToBAndBPointsToC(
                userGraph
        );
        verticesCalledABAndC.vertexA().label("vertex Azure");
        verticesCalledABAndC.vertexB().label("vertex Bareau");
        verticesCalledABAndC.vertexC().label("vertex Cadeau");
        return verticesCalledABAndC;
    }

    public VertexOperator addPineAppleVertexToVertex(VertexOperator vertex) {
        EdgeOperator newEdge = vertex.addVertexAndRelation();
        VertexOperator pineApple = newEdge.destinationVertex();
        pineApple.label("pine Apple");
        return pineApple;
    }
}
