package com.asd.ccard.domain;

import java.time.LocalDate;
import java.util.List;

import com.asd.domain.Account;
import com.asd.domain.AccountEntry;
import com.asd.visitor.ReportVisitor;

public class CreditCardAccountVisitor implements ReportVisitor {
	LocalDate currentDate = LocalDate.now();
	String report = "";

	@Override
	public String getReport() {
		return report;
	}

	@Override
	public void visit(Account account) {
		/*report += previousBalance(account) + "   " + totalCharges(account) + "   " + totalCredits(account) + "   "
				+ newBalance((CreditAccount) account) + "   " + totalDue((CreditAccount) account);*/
		report +=previousBalance(account) + "   " + totalCredits(account);
	}

	private double previousBalance(Account account) {

		List<AccountEntry> entries = account.getAccountEntries();
		int entryYear;
		int entryMonth;

		LocalDate previousMonth = currentDate.minusMonths(1);

		for (AccountEntry entry : entries) {

			entryYear = entry.getDate().getYear();
			entryMonth = entry.getDate().getMonthValue();

			if (entryYear == previousMonth.getYear() && entryMonth == previousMonth.getMonthValue()) {
				return entry.getBalance();

			}
		}

		return 0.0;

	}

	private double totalCharges(Account account) {
		Double totalCharges = 0.0;
		List<AccountEntry> entries = account.getAccountEntries();
		for (AccountEntry entry : entries) {
			if (entry.getDate().getMonthValue() == currentDate.getMonthValue()
					&& entry.getDate().getYear() == currentDate.getYear()
					&& entry.getDescription().equals("withdraw")) {
				totalCharges += entry.getAmount();
			}
		}
		return Math.abs(totalCharges);

	}

	private double totalCredits(Account account) {
		Double totalCredits = 0.0;
		List<AccountEntry> entries = account.getAccountEntries();
		for (AccountEntry entry : entries) {
			if (entry.getDate().getMonthValue() == currentDate.getMonthValue()
					&& entry.getDate().getYear() == currentDate.getYear() && entry.getDescription().equals("deposit")) {
				totalCredits += entry.getAmount();
			}
		}
		return Math.abs(totalCredits);

	}

	private double newBalance(CreditAccount account) {
		Double newBalance = previousBalance(account) - totalCredits(account) + totalCharges(account)
				+ (account.getAccountInterestCalculator().calculateInterest(account.getBalance())
						* (previousBalance(account) - totalCredits(account)));
		return newBalance;
	}

	private double totalDue(CreditAccount account) {
		Double newBalance = account.getMinimumPayment(account.getBalance()) * (newBalance(account));
		return newBalance;
	}

}
