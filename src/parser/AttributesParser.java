package parser;

import util.ErrorCode;

import java.util.*;

public class AttributesParser {

    private ArrayList<String> attributeStrings;

    private static final Set<String> VALID_ATTRIBUTES = new HashSet<>();
    static {
        VALID_ATTRIBUTES.add("framerate");
        VALID_ATTRIBUTES.add("tickrate");
        VALID_ATTRIBUTES.add("height");
        VALID_ATTRIBUTES.add("width");
        VALID_ATTRIBUTES.add("size");
    }

    public AttributesParser(ArrayList<String> attributeStrings) {
        this.attributeStrings = attributeStrings;
    }

    public Map<String, String> parse() throws IllegalArgumentException {
        Map<String, String> toReturn = new HashMap<>();

        for(String entry: attributeStrings) {
            String[] temp = entry.split("\\s+");

            if (temp.length != 2) {
                throw new IllegalArgumentException(ErrorCode.MALFORMED_ATTRIBUTE_ENTRY);
            }
            if (!VALID_ATTRIBUTES.contains(temp[0].trim())) {
                throw new IllegalArgumentException(ErrorCode.INVALID_ATTRIBUTE);
            }

            String attribute = temp[0].trim();
            String value = temp[1].trim();
            toReturn.put(attribute, value);
        }

        return toReturn;
    }
}
