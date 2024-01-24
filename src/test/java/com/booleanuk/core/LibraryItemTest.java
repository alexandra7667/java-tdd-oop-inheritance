package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibraryItemTest {

    @Test
    public void shouldReturnTrueIfItemIsOnLoan() {
        LibraryItem item = new LibraryItem("LOTR");
        item.checkOut();
        boolean checkedOut = item.isOnLoan();
        Assertions.assertTrue(checkedOut);
    }

    @Test
    public void shouldReturnFalseIfItemIsNotOnLoan() {
        LibraryItem item = new LibraryItem("LOTR");
        boolean onLoanBeforeCheckOut = item.isOnLoan();
        Assertions.assertFalse(onLoanBeforeCheckOut);
        item.checkOut();
        item.checkIn();
        boolean onLoanAfterCheckIn = item.isOnLoan();
        Assertions.assertFalse(onLoanAfterCheckIn);
    }

    @Test
    public void assertItemCannotBeCheckedOutTwice() {
        LibraryItem item = new LibraryItem("LOTR");
        String checkedOut = item.checkOut();
        Assertions.assertEquals(checkedOut, "item has been checked out");
        String alreadyOnLoan = item.checkOut();
        Assertions.assertEquals(alreadyOnLoan, "item is currently on loan");
    }
}
