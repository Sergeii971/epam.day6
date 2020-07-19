package com.verbovskiy.day6.util;

import java.util.UUID;

public class IdGenerator {
    public static UUID createId() {
       UUID newId = UUID.randomUUID();

       return newId;
    }
}
