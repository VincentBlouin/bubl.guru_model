/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphElementType;
import guru.bubl.module.model.graph.ShareLevel;

import java.net.URI;
import java.util.Map;

public class GraphElementSearchResultPojo implements GraphElementSearchResult {

    private Map<URI, String> context;
    private GraphElementPojo graphElement;
    private GraphElementType type;
    private Integer nbReferences = 0;
    private Integer nbVisits = 0;
    private ShareLevel shareLevel = ShareLevel.PRIVATE;
    private Boolean isPattern = false;

    public GraphElementSearchResultPojo(
            GraphElementType type,
            GraphElementPojo graphElement,
            Map<URI, String> context
    ) {
        this.context = context;
        this.graphElement = graphElement;
        this.type = type;
    }

    @Override
    public GraphElementPojo getGraphElement() {
        return graphElement;
    }

    @Override
    public GraphElementType getType() {
        return type;
    }

    public Map<URI, String> getContext() {
        return context;
    }

    @Override
    public GraphElementSearchResultPojo getGraphElementSearchResult() {
        return this;
    }

    @Override
    public Integer getNbVisits() {
        return nbVisits;
    }

    @Override
    public Integer getNbReferences() {
        return nbReferences;
    }

    @Override
    public ShareLevel getShareLevel() {
        return shareLevel;
    }

    @Override
    public Boolean isPattern() {
        return isPattern;
    }

    public void setIsPattern(Boolean isPattern) {
        this.isPattern = isPattern;
    }


    public void setShareLevel(ShareLevel shareLevel) {
        this.shareLevel = shareLevel;
    }

    public void setNbReferences(Integer nbReferences) {
        this.nbReferences = nbReferences;
    }

    public void setNbVisits(Integer nbVisits) {
        this.nbVisits = nbVisits;
    }

}
