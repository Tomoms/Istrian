package org.istrian;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.NavigableSet;

public class Main {

    public static void main(String[] args) {
        String istrianFolder = System.getProperty("user.home") + "/.istrian";
        new File(istrianFolder).mkdirs();
        DB db = DBMaker.fileDB(istrianFolder + "/istrianSet.db").make();
        DB.TreeSetMaker<Entry> treeSetMaker = new DB.TreeSetMaker<>(db, "istrianSet");
        NavigableSet<Entry> set = treeSetMaker.createOrOpen();

        db.close();
    }

}
