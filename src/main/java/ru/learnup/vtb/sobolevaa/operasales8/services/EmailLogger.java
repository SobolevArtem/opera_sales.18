package ru.learnup.vtb.sobolevaa.operasales8.services;

import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

public class EmailLogger implements Logger {

    @Override
    public void print(Object obj) {
        System.out.println("EMAIL: " + obj.toString());
    }

}
