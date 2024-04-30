package com.wherehouse.board.service;

import javax.servlet.http.HttpServletRequest;

public interface IBoardWriteCommand {
	
	public void writeReply(HttpServletRequest httpRequest);
}
