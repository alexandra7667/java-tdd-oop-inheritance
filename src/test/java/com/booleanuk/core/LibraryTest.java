package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    @Test
    public void shouldReturnTrueIfItemIsAddedToStock() {
        Library library = new Library();
        Book book = new Book("LOTR");
        boolean added = library.addToStock(book);
        Assertions.assertTrue(added);
    }

    @Test
    public void assertIfItemIsCheckedOut() {
        Library library = new Library();
        Book book = new Book("LOTR");
        library.addToStock(book);
        String checkedOut = library.checkOutLibraryItem("LOTR");
        Assertions.assertEquals("item has been checked out", checkedOut);
    }

    @Test
    public void assertIfItemIsCheckedIn() {
        Library library = new Library();
        Book book = new Book("LOTR");
        library.addToStock(book);
        library.checkOutLibraryItem("LOTR");
        String checkedIn = library.checkInLibraryItem("LOTR");
        Assertions.assertEquals("item has been checked in", checkedIn);
    }
}
