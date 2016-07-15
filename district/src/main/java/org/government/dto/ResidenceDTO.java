package org.government.dto;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResidenceDTO {
	private @JsonProperty String name;
	private @JsonProperty String age;
	private @JsonProperty String gender;
	private @JsonProperty UUID objectUUID;
}
