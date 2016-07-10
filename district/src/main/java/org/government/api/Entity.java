package org.government.api;

import java.util.UUID;

public interface Entity {
	UUID getObjectUUID();

	void setObjectUUID(UUID objectUUID);
}
