package com.koreaIT.webProjectMuk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.webProjectMuk.dao.ReplyDao;
import com.koreaIT.webProjectMuk.vo.Reply;

@Service
public class ReplyService {
	
	private ReplyDao replyDao;
	
	@Autowired
	public ReplyService(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public void writeReply(int loginedMemberId, String relTypeCode, int relId,  String body) {
		replyDao.writeReply(loginedMemberId, relTypeCode, relId, body);
	}

	public List<Reply> getReplies(String relTypeCode, int relId) {
		
		List<Reply> replies = replyDao.getReplies(relTypeCode, relId);
		
		for (Reply reply : replies) {
			reply.setUpdateDate(reply.getUpdateDate().substring(0, reply.getUpdateDate().length() - 3));
		}
		
		return replies;
	}

	public void modifyReply(int id, String body) {
		replyDao.modifyReply(id, body);
	}

	public void deleteReply(int id) {
		replyDao.deleteReply(id);
	}

	public Reply getReply(int id) {
		return replyDao.getReply(id);
	}

}
