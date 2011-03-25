// User.java
// Created on Wed Oct 03 01:57:04 Asia/Calcutta 2001 by Apple EOModeler Version 5.0

package biz.forum.model;

import java.security.MessageDigest;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSLog;

public class User extends EOGenericRecord {
    
    /*
    * awakening
    */
    public void awakeFromInsertion(EOEditingContext editingContext) {
	super.awakeFromInsertion(editingContext);
	takeValueForKey(entityName(), "className");
    }
    
    /*
    * accessors
    */
    public boolean hasSignature() {
     return (valueForKey("signature") != null);
    }

    public void setPassword(String password) {
        String encryptedPassword = encrypt(password);
        takeStoredValueForKey(encryptedPassword, "password");
    }

    public boolean isModerator() {
        return (valueForKey("className").equals("Moderator"));
    }

    /*
     * public static
     */
    public static String encrypt(String plaintext) {
        String encoding = "ISO-8859-1";
        String ciphertext = null;

        // one-way encrption algorithm
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = plaintext.getBytes(encoding);
            
            // encrypt
            messageDigest.reset();
            byte[] encryptedBytes = messageDigest.digest(bytes);
            ciphertext = new String(encryptedBytes, encoding);        
        } catch (Exception exception) {
            NSLog.err.appendln("User: unable to encrypt plaintext: " + plaintext);
        }

        return ciphertext;
    }
}