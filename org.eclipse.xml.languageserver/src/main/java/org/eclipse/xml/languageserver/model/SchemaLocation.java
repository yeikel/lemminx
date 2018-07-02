package org.eclipse.xml.languageserver.model;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SchemaLocation {

	private final Map<String, String> schemaLocationValuePairs;

	public SchemaLocation(String value) {
		this.schemaLocationValuePairs = new HashMap<>();
		StringTokenizer st = new StringTokenizer(value);
		do {
			String locationHint;
			String namespaceURI = st.hasMoreTokens() ? st.nextToken() : null;
			String string = locationHint = st.hasMoreTokens() ? st.nextToken() : null;
			if (namespaceURI == null || locationHint == null)
				break;
			schemaLocationValuePairs.put(namespaceURI, locationHint);
		} while (true);
	}

	public String getLocationHint(String namespaceURI) {
		return schemaLocationValuePairs.get(namespaceURI);
	}
}
