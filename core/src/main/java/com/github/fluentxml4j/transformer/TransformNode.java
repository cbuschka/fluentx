package com.github.fluentxml4j.transformer;

import com.github.fluentxml4j.serializer.SerializeWithTransformerNode;
import com.github.fluentxml4j.serializer.SerializerConfigurer;
import org.w3c.dom.Document;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;

public interface TransformNode
{
	TransformNode withStylesheet(URL url);

	TransformNode withStylesheet(InputStream in);

	TransformNode withStylesheet(Document doc);

	TransformNode withPrefixMapping(String prefix, String newPrefix);

	SerializeWithTransformerNode withSerializer(SerializerConfigurer serializerConfigurer);

	void to(Result result);

	void to(XMLEventWriter out);

	void to(XMLStreamWriter out);

	void to(OutputStream out);

	void to(Writer out);

	Document toDocument();

	String toString();
}
