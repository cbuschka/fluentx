package com.github.fluentxml4j;

import com.github.fluentxml4j.parser.FluentXmlParser;
import com.github.fluentxml4j.parser.ParseNode;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.io.Reader;

import static com.github.fluentxml4j.FluentXml.from;
import static com.github.fluentxml4j.FluentXml.parse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FluentXmlParseTest
{
	@Rule
	public FluentXmlInjectionRule fluentXmlInjectionRule = new FluentXmlInjectionRule();

	@Mock
	private FluentXmlParser fluentXmlParser;

	@Mock
	private ParseNode parseNode;

	@Mock
	private InputStream inputStream;

	@Mock
	private Reader reader;

	@Mock
	private InputSource inputSource;

	@Mock
	private Document document;

	@Before
	public void setUp()
	{
		fluentXmlInjectionRule.setFluentXmlParser(fluentXmlParser);
		when(fluentXmlParser.parse(inputStream)).thenReturn(parseNode);
		when(fluentXmlParser.parse(reader)).thenReturn(parseNode);
		when(fluentXmlParser.parse(inputSource)).thenReturn(parseNode);
		when(parseNode.document()).thenReturn(document);
	}

	@Test
	public void parseFromInputStream()
	{
		ParseNode parseNodeReturned = parse(reader);

		assertThat(parseNodeReturned, is(this.parseNode));
	}

	@Test
	public void parseFromReader()
	{
		ParseNode parseNodeReturned = parse(inputStream);

		assertThat(parseNodeReturned, is(this.parseNode));
	}

	@Test
	public void parseFromInputSource()
	{
		ParseNode parseNodeReturned = parse(inputSource);

		assertThat(parseNodeReturned, is(this.parseNode));
	}

	@Test
	public void documentFromInputSource() {
		Document documentReturned = from(inputSource).parse().document();

		assertThat(documentReturned, is(this.document));
	}

	@Test
	public void documentFromInputStream() {
		Document documentReturned = from(inputStream).parse().document();

		assertThat(documentReturned, is(this.document));
	}

	@Test
	public void documentFromReader() {
		Document documentReturned = from(reader).parse().document();

		assertThat(documentReturned, is(this.document));
	}
}