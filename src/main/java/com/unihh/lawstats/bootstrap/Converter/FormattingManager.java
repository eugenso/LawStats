package com.unihh.lawstats.bootstrap.Converter;

import com.unihh.lawstats.bootstrap.VerdictDownloader;

public class FormattingManager {

    int _counter;



    public void formatMultithread(int numberOfThreads, int startIndex, int endIndex, String basePath){
        _counter = startIndex;

        for(int i = 1; i <= numberOfThreads; i++){
            new RunnableFormatter(this, endIndex, basePath).run();
        }

    }


    public synchronized int getCounter(){
        return _counter;
    }

    public synchronized void setCounter(int newCounter){
        _counter = newCounter;
    }

    public synchronized  int getAndIncrementCounter(){
        _counter++;

        return _counter;
    }

}
