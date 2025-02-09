package com.asu.librarysystem;

import java.util.ArrayList;

public class Borrower extends Account {
    private double borrowerFines = 0;
    private ArrayList<Transaction> borrowerTransactions;
    public boolean assignBefore;
    private int noOfBooks;
    private boolean isAdmin = false;


    public Borrower(String borrowerName, String password, String PhoneNumber) {
        super(borrowerName, password, PhoneNumber);
        borrowerTransactions = new ArrayList<>();
        assignBefore = false;
    }

    public void addTransaction(Book book, int borrowDate, int returnDate) {
        borrowerTransactions.add(new Transaction(book.getId(), getId(), borrowDate, returnDate));
    }

    public boolean deleteTransaction(int transactionId) {
        try {
            borrowerTransactions.remove(transactionId);
            return true;
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("cant delete because the index is out of bound");
            return false;
        }
    }

    public int searchTransactions(int transactionId) {
        for (int i = 0; i < borrowerTransactions.size(); i++) {
            if (borrowerTransactions.get(i).getTransactionId() == transactionId) {
                return borrowerTransactions.get(i).getBorrowerId();
            }
        }
        return -1;
    }

    public double finesIfLate() {
        for (Transaction borrowerTransaction : borrowerTransactions) {
            if (borrowerTransaction.getBorrowerId() == this.getId() && borrowerTransaction.getFines() >= 0) {
                borrowerFines += borrowerTransaction.getFines();
            }
        }
        return borrowerFines;
    }

    public void setAssignBefore(boolean assignBefore) {
        if (!assignBefore)
            this.assignBefore = true;
        else
            this.assignBefore = false;
    }

    public ArrayList<Transaction> getBorrowerTransactions() {
        return borrowerTransactions;
    }

    public int getNoOfBooks() {
        this.noOfBooks = this.getBorrowerTransactions().size();
        return noOfBooks;
    }

    public boolean getAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean admin) {
         this.isAdmin = admin;
    }
}
