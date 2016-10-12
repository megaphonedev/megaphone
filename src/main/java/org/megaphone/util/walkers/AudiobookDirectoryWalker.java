package org.megaphone.util.walkers;


import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class AudiobookDirectoryWalker extends DirectoryWalker {

    private final String[] audioFileExtensions = {"mp3"};


    public AudiobookDirectoryWalker() {
        super();
    }

    public ArrayList<File> getDirectories(File startDirectory) throws IOException {
        ArrayList<File> dirs = new ArrayList<File>();
        walk(startDirectory, dirs);
        return dirs;
    }

    @Override
    protected boolean handleDirectory(File directory, int depth,
                                      Collection results) {

        if (FileUtils.listFiles(directory, audioFileExtensions, false).size() > 0) {
            results.add(directory);
        }

        return true;
    }
}
