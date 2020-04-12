/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test.scenarios;

import guru.bubl.module.model.graph.*;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgeFactory;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.group_relation.GroupRelationFactory;
import guru.bubl.module.model.graph.group_relation.GroupRelationOperator;
import guru.bubl.module.model.graph.group_relation.GroupRelationPojo;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.test.GraphComponentTest;

import javax.inject.Inject;
import java.net.URI;
import java.util.UUID;

public class TestScenarios {

    @Inject
    protected GraphFactory graphFactory;

    @Inject
    protected VertexFactory vertexFactory;

    @Inject
    protected EdgeFactory edgeFactory;

    @Inject
    protected GroupRelationFactory groupRelationFactory;

    @Inject
    protected GraphComponentTest graphComponentTest;

    public GraphElementsOfTestScenario buildTestScenario(UserGraph userGraph) {
        graphComponentTest.removeWholeGraph();
        VertexOperator vertexA = vertexFactory.withUri(
                userGraph.createVertex().uri()
        );
        vertexA.label("vertex A");
        VertexOperator vertexB = vertexFactory.withUri(
                vertexA.addVertexAndRelation().destinationUri()
        );
        vertexB.label("vertex B");
        VertexOperator vertexC = vertexFactory.withUri(
                vertexB.addVertexAndRelation().destinationUri()
        );
        vertexC.label("vertex C");
        EdgeOperator edgeAB = vertexA.getEdgeToDestinationVertex(vertexB);
        edgeAB.label("edge AB");
        EdgeOperator edgeBC = vertexB.getEdgeToDestinationVertex(vertexC);
        edgeBC.label("edge BC");

        EdgeOperator edgeCD = edgeFactory.withUri(
                vertexC.addVertexAndRelation().uri()
        );
        edgeCD.label("edge CD");
        VertexOperator vertexD = vertexFactory.withUri(edgeCD.destinationUri());
        vertexD.label("vertex D");
        TagPojo todo = new TagPojo(
                URI.create(
                        "/to-do"
                ),
                new FriendlyResourcePojo(
                        "To do"
                )
        );
        GroupRelationPojo newGroupRelation = edgeCD.convertToGroupRelation(
                UUID.randomUUID().toString(),
                todo,
                true,
                ShareLevel.PRIVATE
        );
        GroupRelationOperator groupRelation = groupRelationFactory.withUriAndTagUri(
                newGroupRelation.uri(),
                newGroupRelation.getTag().uri()
        );
        EdgeOperator edgeCE = edgeFactory.withUri(
                groupRelation.addVertexAndRelation().uri()
        );
        edgeCE.label("edge DC");
        VertexOperator vertexE = vertexFactory.withUri(edgeCE.destinationUri());
        vertexE.label("vertex E");

        return new GraphElementsOfTestScenario(
                vertexA,
                vertexB,
                vertexC,
                vertexD,
                vertexE,
                groupRelation
        );
    }

    public GraphElementsOfTestScenario changeTestScenarioVerticesToLongLabels(UserGraph userGraph) {
        GraphElementsOfTestScenario graphElementsOfTestScenario = buildTestScenario(
                userGraph
        );
        graphElementsOfTestScenario.getVertexA().label("vertex Azure");
        graphElementsOfTestScenario.getVertexB().label("vertex Bareau");
        graphElementsOfTestScenario.getVertexC().label("vertex Cadeau");
        graphElementsOfTestScenario.getVertexD().label("vertex Défaite");
        graphElementsOfTestScenario.getVertexE().label("vertex Espoir");
        return graphElementsOfTestScenario;
    }

    public VertexOperator addPineAppleVertexToVertex(VertexOperator vertex) {
        Edge newEdge = vertex.addVertexAndRelation();
        VertexOperator pineApple = vertexFactory.withUri(
                newEdge.destinationUri()
        );
        pineApple.label("pine Apple");
        return pineApple;
    }

    public static TagPojo tagFromFriendlyResource(GraphElementOperator resource) {
        FriendlyResourcePojo friendlyResourcePojo = new FriendlyResourcePojo(
                resource.label(),
                resource.comment()
        );
        friendlyResourcePojo.setImages(resource.images());
        return new TagPojo(
                resource.uri(),
                new GraphElementPojo(
                        friendlyResourcePojo
                )
        );
    }
}
