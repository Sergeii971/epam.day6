package com.verbovskiy.day6.model.entity;

import com.verbovskiy.day6.util.IdGenerator;

import java.util.UUID;

public class Book {
    private UUID id;
    private String name;
    private String author;
    private String edition;
    private int pageNumber;

    public Book() {
        name = "";
        author = "";
        edition = "";
    }

    public Book(String name, String author, String edition, int pageNumber) {
        id = IdGenerator.createId();
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.pageNumber = pageNumber;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null || this.getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        
        if (id == null) {
            if (book.id != null) {
                return false;
            }
        } else {
            if (!id.equals(book.id)) {
                return false;
            }
        }
        if (name == null) {
            if (book.name != null) {
                return false;
            }
        } else {
            if (!name.equals(book.name)) {
                return false;
            }
        }
        if (author == null) {
            if (book.author != null) {
                return false;
            }
        } else {
            if (!author.equals(book.author)) {
                return false;
            }
        }
        if (edition == null) {
            if (book.edition != null) {
                return false;
            }
        } else {
            if (!edition.equals(book.edition)) {
                return false;
            }
        }
        if (pageNumber != book.pageNumber) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (author == null ? 0 : author.hashCode());
        result = 31 * result + (edition == null ? 0 : edition.hashCode());
        result = 31 * result + pageNumber;

        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", name, author, edition, pageNumber);
    }
}
