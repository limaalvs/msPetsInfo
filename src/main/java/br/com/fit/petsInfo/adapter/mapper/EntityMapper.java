package br.com.fit.petsInfo.adapter.mapper;

public interface EntityMapper<T> {
	public Object mapping(T obj);
	public T unmapping(Object obj);
}
