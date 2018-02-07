package com.asd.visitor;

import com.asd.domain.Account;

public interface ReportVisitor {
	
	void visit(Account account);
		
	String getReport();
}
