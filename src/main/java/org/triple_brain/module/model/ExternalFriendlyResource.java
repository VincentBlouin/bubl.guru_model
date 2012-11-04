package org.triple_brain.module.model;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalFriendlyResource {
    private URI uri;
    private String label;
    private Set<Image> images = new HashSet();

    public static ExternalFriendlyResource withUriAndLabel(URI uri, String label){
        return new ExternalFriendlyResource(
                uri,
                label
        );
    }

    public static ExternalFriendlyResource withUriLabelAndImages(URI uri, String label, Set<Image> images){
        return new ExternalFriendlyResource(
                uri,
                label,
                images
        );
    }

    private ExternalFriendlyResource(URI uri, String label){
        this(
                uri,
                label,
                new HashSet<Image>()
        );
    }

    private ExternalFriendlyResource(URI uri, String label, Set<Image> images){
        this.uri = uri;
        this.label = label;
        this.images = images;
    }

    public URI uri(){
        return uri;
    }

    public String label(){
        return label;
    }

    public Set<Image> images(){
        return images;
    }

    public void images(Set<Image> images){
        this.images = images;
    }

    public Boolean gotTheImages(){
        return images().size() > 0;
    }

    @Override
    public boolean equals(Object friendlyResourceToCompareAsObject) {
        ExternalFriendlyResource friendlyResourceToCompare = (ExternalFriendlyResource) friendlyResourceToCompareAsObject;
        return uri().equals(friendlyResourceToCompare.uri());
    }

    @Override
    public int hashCode() {
        return uri().hashCode();
    }
}