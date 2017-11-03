package com.github.fluentxml4j.transformer;

import com.github.fluentxml4j.serializer.SerializeWithTransformerNode;
import com.github.fluentxml4j.serializer.SerializerConfigurer;
import org.w3c.dom.Document;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;

public interface TransformNode
{
	TransformNode withStylesheet(URL url);

	TransformNode withStylesheet(InputStream in);

	TransformNode withStylesheet(Document doc);

	SerializeWithTransformerNode withSerializer(SerializerConfigurer serializerConfigurer);

	void to(OutputStream out);

	void to(Writer out);

	Document toDocument();

	String toString();
}
