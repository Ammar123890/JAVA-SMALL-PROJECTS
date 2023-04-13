package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
    private String word;
    private String meaning;

    public Dictionary() {

    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Dictionary(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;

    }

}

