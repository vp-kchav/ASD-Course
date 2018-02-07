package com.asd.visitor;

import com.asd.domain.Account;

public class BankReportGenerator implements ReportVisitor {
	String report = "";

	@Override
	public String getReport() {
		return report;
	}

	@Override
	public void visit(Account account) {
		report += account.toString();
	}

}
