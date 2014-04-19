/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author elison
 */
public class InsereLetras extends PlainDocument{
    
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet atr) throws BadLocationException{
        
        super.insertString(offset, str.replaceAll("[^a-z|^A-Z|^ ]",""), atr);
    
    }
    
    public void replace(int offset, String str, javax.swing.text.AttributeSet atr) throws BadLocationException{
        
        super.insertString(offset, str.replaceAll("[^a-z|^A-Z|^ ]",""), atr);
    
    }
}
