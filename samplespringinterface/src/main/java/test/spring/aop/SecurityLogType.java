package test.spring.aop;

public enum SecurityLogType {

    INSERT("INSERIMENTO"),
    MODIFY("MODIFICA"),
    DELETE("CANCELLAZIONE"),
    SEARCH("RICERCA"),
    VIEW("VISUALIZZAZIONE");

    private String tagName;

    private SecurityLogType(final String tagName) {
        this.tagName = tagName;
    }

    /**
     * @return the tagName
     */
    public String getTagName() {
        return tagName;
    }
}
