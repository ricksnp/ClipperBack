package com.clipper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clipper.dao.LikeDao;
import com.clipper.model.Like;

@Service
public class LikeService {
	
	private LikeDao ld;

	public LikeDao getLd() {
		return ld;
	}

	@Autowired
	public void setLd(LikeDao ld) {
		this.ld = ld;
	}
	
	public Like addLike(Like t) {
		return ld.save(t);
	}
	
	public Like removeLike(int id) {
		return ld.delete(id);
	}
	
	public List<Object[]> findByUserAndPost(int pId, int uId) {
		return ld.findByUserAndPost(pId, uId);
	}
}
