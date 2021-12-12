package com.bufferoverflow.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Optional;

public class UserActivity {
    public static void main(String fileName) throws FileNotFoundException {
        // For saving the output into a file.
        saveOutPut(fileName);
        ProcessHandle.allProcesses()
                .forEach(process -> System.out.println(processDetails(process)));

    }

    private static String processDetails(ProcessHandle process) {
        return String.format("%8d %8s %8s %26s %-40s",
                process.pid(),
                text(process.parent().map(ProcessHandle::pid)),
                text(process.info().user()),
                text(process.info().totalCpuDuration()),
                text(process.info().commandLine()));
    }

    private static String text(Optional<?> optional) {
        return optional.map(Object::toString).orElse("-");
    }

    private static void saveOutPut(String fileName) throws FileNotFoundException {
        File file = new File(fileName) ;
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
    }
}
