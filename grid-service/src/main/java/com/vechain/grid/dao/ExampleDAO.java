package com.vechain.grid.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vechain.grid.db.mapper.SessionEntityMapper;
import com.vechain.grid.db.model.SessionEntity;
import com.vechain.grid.db.model.SessionEntityExample;

@Repository
public class ExampleDAO {

	@Autowired
	private SessionEntityMapper sessionEntityMapper;

	public SessionEntity readSessionEntity(String requestNo) {
		SessionEntityExample example = new SessionEntityExample();
		SessionEntityExample.Criteria criteria = example.createCriteria();
		criteria.andRequestNoEqualTo(requestNo);
		List<SessionEntity> sessionList = this.sessionEntityMapper.selectByExample(example);
		return sessionList.isEmpty() ? null : sessionList.get(0);
	}

	public boolean saveSessionEntity(SessionEntity session) {
		return this.sessionEntityMapper.insertSelective(session) == 1;
	}

	public SessionEntity readSessionEntityByToken(String token) {
		SessionEntityExample example = new SessionEntityExample();
		SessionEntityExample.Criteria criteria = example.createCriteria();
		criteria.andSessionEqualTo(token);
		List<SessionEntity> sessionList = this.sessionEntityMapper.selectByExample(example);
		return sessionList.isEmpty() ? null : sessionList.get(0);
	}

	public boolean updateAuthorizedSession(SessionEntity session, SessionEntity newSession) {
		SessionEntityExample example = new SessionEntityExample();
		SessionEntityExample.Criteria criteria = example.createCriteria();
		criteria.andSessionEqualTo(session.getSession());
		criteria.andStatusEqualTo(session.getStatus());
		return this.sessionEntityMapper.updateByExampleSelective(newSession, example) == 1;
	}
}
