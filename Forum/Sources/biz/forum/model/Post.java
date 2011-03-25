// Post.java
// Created by Apple EOModeler Version 5.0

package biz.forum.model;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSTimestamp;

public class Post extends EOGenericRecord {
    
    /*
    * awakening
    */
    public void awakeFromInsertion(EOEditingContext editingContext) {
	super.awakeFromInsertion(editingContext);
	takeValueForKey(new NSTimestamp(), "timestamp");
    }
    
    /*
    * accessors
    */
    public boolean hasAttachment() {
        return (valueForKey("attachment") != null);
    }
    
    /*
    * validation
    */
    public boolean hasFilePath() {
        String filePath = (String) valueForKey("filePath");
        return (filePath != null && !filePath.equals(""));
    }
    
    /*
    * validation
    */
    public void validateForSave() {
        super.validateForSave();
        
        // leave data null if there is no filePath
        if (!hasFilePath()) takeStoredValueForKey(null, "attachment");
    }
}