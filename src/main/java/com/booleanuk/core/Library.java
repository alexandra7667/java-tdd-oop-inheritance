package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    List<LibraryItem> libraryItems = new ArrayList<>();

    public boolean addToStock(LibraryItem item) {
        this.libraryItems.add(item);
        return true;
    }


    // The following methods may contain code that you are unfamiliar with. The strange syntax of article -> something
    // is called a lambda expression (https://www.w3schools.com/java/java_lambda.asp)
    public String checkInLibraryItem(String title) {
        List<LibraryItem> filtered = this.libraryItems
                .stream()
                .filter(item -> item.title.equals(title))
                .collect(Collectors.toList());

        if (filtered.size() < 1) {
            return "item is not part of the library's collection";
        }

        return filtered.get(0).checkIn();
    }

    public String checkOutLibraryItem(String title) {
        List<LibraryItem> filtered = this.libraryItems
                .stream()
                .filter(item -> item.title.equals(title))
                .collect(Collectors.toList());

        if (filtered.size() < 1) {
            return "item is not part of the library's collection";
        }

        return filtered.get(0).checkOut();
    }
}
