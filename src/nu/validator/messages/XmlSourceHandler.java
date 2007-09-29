/*
 * Copyright (c) 2007 Mozilla Foundation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */

package nu.validator.messages;

import java.util.SortedSet;

import org.xml.sax.SAXException;

import nu.validator.source.SourceHandler;
import nu.validator.xml.AttributesImpl;

public class XmlSourceHandler implements SourceHandler {

    private final AttributesImpl attrs = new AttributesImpl();

    private static final char[] NEWLINE = {'\n'};
    
    private final XmlSaxEmitter emitter;
    
    public XmlSourceHandler(XmlSaxEmitter emitter) {
        this.emitter = emitter;
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        emitter.characters(ch, start, length);
    }

    public void endCharHilite() throws SAXException {
    }

    public void endRange() throws SAXException {
    }

    public void endSource() throws SAXException {
        emitter.endElement("source");
    }

    public void newLine() throws SAXException {
        emitter.characters(NEWLINE);
    }

    public void startCharHilite(int oneBasedLine, int oneBasedColumn)
            throws SAXException {
    }

    public void startRange(int oneBasedLine, int oneBasedColumn)
            throws SAXException {
    }

    public void startSource(String type, String encoding) throws SAXException {
        attrs.clear();
        if (type != null) {
            attrs.addAttribute("type", type);
        }
        if (encoding != null) {
            attrs.addAttribute("encoding", encoding);
        }
        emitter.startElement("source", attrs);
    }

    public void setLineErrors(SortedSet<Integer> oneBasedLineErrors) throws SAXException {
        
    }


}
