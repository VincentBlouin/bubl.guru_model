package guru.bubl.module.model.notification;

import java.net.URI;
import java.util.Date;

public class Notification {
    private URI uri;
    private URI rootUri;
    private URI watchUri;
    private Date creationDate;
    private String action;
    private String watchLabel;

    public Notification(URI uri, URI rootUri, URI watchUri, Date creationDate, String action, String watchLabel) {
        this.uri = uri;
        this.rootUri = rootUri;
        this.watchUri = watchUri;
        this.creationDate = creationDate;
        this.action = action;
        this.watchLabel = watchLabel;
    }

    public URI getUri() {
        return uri;
    }

    public URI getRootUri() {
        return rootUri;
    }

    public URI getWatchUri() {
        return watchUri;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getAction() {
        return action;
    }

    public String getWatchLabel() {
        return watchLabel;
    }
}
