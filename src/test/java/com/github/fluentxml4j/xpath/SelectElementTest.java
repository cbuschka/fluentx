package com.github.fluentxml4j.xpath;

import com.github.fluentxml4j.DocumentTestRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.w3c.dom.Element;

import java.util.Optional;

import static com.github.fluentxml4j.FluentXml.from;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectElementTest
{
	@ClassRule
	public static DocumentTestRule docRule = new DocumentTestRule("<a><b id=\"_1\">text1 word2</b><b id=\"_2\">text2 word3</b></a>");

	@Test
	public void selectSingleElementByIdWhenElementExists()
	{
		Element element = from(docRule.document()).selectElement("//*[@id='_2']").get();
		assertThat(element.getAttribute("id"), is("_2"));
	}

	@Test
	public void selectSingleElementByIdWhenElementNotExists()
	{
		Optional<Element> element = from(docRule.document()).selectElement("//*[@id='doesNotExists']");
		assertThat(element.isPresent(), is(false));
	}
}
