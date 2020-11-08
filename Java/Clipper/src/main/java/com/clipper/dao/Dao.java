package com.clipper.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface Dao <Type, Identifier> {
	List<Type> findAll();
	
	Type findById(Identifier i);
	
	Type update(Type t);
	
	Type save(Type t);
	
	Type delete(Identifier i);
}
