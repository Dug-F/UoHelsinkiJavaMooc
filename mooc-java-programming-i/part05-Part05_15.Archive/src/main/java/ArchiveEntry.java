/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doug
 */
public class ArchiveEntry {
    private String identifier;
    private String name;

    public ArchiveEntry(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }
    
    public boolean equals (Object compared) {
        if (this == compared) {
            return true;
        }
        
        if (!(compared instanceof ArchiveEntry)) {
            return false;
        }
        
        ArchiveEntry comparedArchiveEntry = (ArchiveEntry) compared;
        
        if (this.identifier.equals(comparedArchiveEntry.identifier)) {
            return true;
        }
        return false;
        
    }
    
    public String toString() {
        return this.identifier + ": " + this.name;
    }
}
