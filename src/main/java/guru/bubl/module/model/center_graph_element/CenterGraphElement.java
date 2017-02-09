/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.graph.GraphElement;

import java.util.Date;

public interface CenterGraphElement {
    Integer getNumberOfVisits();
    GraphElement getGraphElement();
    Date getLastCenterDate();
}
