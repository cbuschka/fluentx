package com.github.fluentxml4j.query;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.namespace.NamespaceContext;
import java.util.Optional;

public interface QueryFromNode
{
	QueryFromNode withNamespaceMapping(String prefix, String namespaceURI);

	QueryFromNode withNamespaceMappings(String... namespaceMappings);

	QueryFromNode withNamespaceContext(NamespaceContext namespaceContext);

	QueryFromNode withXPath(XPathConfigurer xPathConfigurer);

	Optional<Integer> selectInteger(String xPathQuery);

	Optional<Boolean> selectBoolean(String xPathQuery);

	Optional<String> selectString(String xPathQuery);

	Optional<Element> selectElement(String xPathQuery);

	Optional<Node> selectNode(String xPathQuery);

	SelectMultipleFromNode<Element> selectElements(String xPathQuery);

	SelectMultipleFromNode<String> selectStrings(String xPathQuery);

	SelectMultipleFromNode<Integer> selectIntegers(String xPathQuery);

	SelectMultipleFromNode<Boolean> selectBooleans(String xPathQuery);

	SelectMultipleFromNode<Node> selectNodes(String xPathQuery);
}
