package com.asd.service.command;

public interface Command<E, J> {

	void execute();
	void undo();
}
