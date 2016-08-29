package org.government.dto.transformer;

public abstract class ModelTransformer<T, M> {
	public abstract T transform(M model);
}
