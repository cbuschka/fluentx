package com.github.fluentxml4j.parse;

import org.w3c.dom.Document;

public interface ParseNode
{
	ParseWithDocumentBuilderNode withDocumentBuilder(DocumentBuilderConfigurer documentBuilderConfigurer);

	Document document();

	org.jdom2.Document toJDOM2Document();

	/**
	 * @deprecated Use {@link #document()} instead.
	 * @return The document parsed.
	 */
	@Deprecated
	Document asDocument();
}
