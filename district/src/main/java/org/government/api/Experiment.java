package org.government.api;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Experiment {
	private long id;

    @Length(max = 3)
    private String content;

    public Experiment() {
        // Jackson deserialization
    }

    public Experiment(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
