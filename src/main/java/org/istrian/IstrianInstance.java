package org.istrian;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.NavigableSet;

public class IstrianInstance {

    private static IstrianInstance instance = null;
    private final DB db;
    private final NavigableSet<Entry> set;

    private IstrianInstance() {
        String istrianFolder = System.getProperty("user.home") + "/.istrian";
        new File(istrianFolder).mkdirs();
        db = DBMaker.fileDB(istrianFolder + "/istrianSet.db").make();
        DB.TreeSetMaker<Entry> treeSetMaker = new DB.TreeSetMaker<>(db, "istrianSet");
        set = treeSetMaker.createOrOpen();
    }

    public static IstrianInstance getInstance() {
        if (instance == null) {
            instance = new IstrianInstance();
        }
        return instance;
    }

    void destroy() {
        db.close();
        System.exit(0);
    }

    public NavigableSet<Entry> getSet() {
        return set;
    }

}
