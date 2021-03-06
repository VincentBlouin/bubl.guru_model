/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.FriendlyResource;

public interface CenterGraphElementOperatorFactory {
    CenterGraphElementOperator usingFriendlyResource(FriendlyResource friendlyResource);
}
