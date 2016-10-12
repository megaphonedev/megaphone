package org.megaphone.rest;

import org.megaphone.util.walkers.AudiobookDirectoryWalker;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;
import java.util.ArrayList;

@RequestScoped
@Path("/directories")
public class DirectoryResource {
    private final String location = "v:\\Ready";

    @GET()
    @Produces("application/json")
    public ArrayList<File> getAllDirectories() {
        ArrayList directories = new ArrayList();

        AudiobookDirectoryWalker walker = new AudiobookDirectoryWalker();
        try {
            directories = walker.getDirectories(new File(location));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directories;
    }

    @GET
    @Produces("application/json")
    @Path("mp3")
    public String getMP3() {
        return "Hi from mp3";
    }
}
