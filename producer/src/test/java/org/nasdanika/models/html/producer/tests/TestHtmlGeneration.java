package org.nasdanika.models.html.producer.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.nasdanika.common.Context;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.html.Producer;
import org.nasdanika.html.producer.HtmlGenerator;
import org.nasdanika.models.html.HtmlFactory;
import org.nasdanika.models.html.Page;
import org.nasdanika.models.html.Tag;

public class TestHtmlGeneration {

	@Test
	public void testTag() {
		PrintStreamProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		HtmlGenerator htmlGenerator = HtmlGenerator.load(
				Context.EMPTY_CONTEXT, 
				null, 
				progressMonitor);

		
		Tag tag = HtmlFactory.eINSTANCE.createTag();
		tag.setName("b");
		tag.getAttributes().put("style", org.nasdanika.ncore.String.wrap("margin:5px"));
		tag.getContent().add(org.nasdanika.ncore.String.wrap("Hello World"));
		
		assertTrue(htmlGenerator.canHandle(tag));
				
		Producer<Object> processor = htmlGenerator.createProducer(tag, progressMonitor);
		Object result = processor.produce(0);
		
		System.out.println(result);
	}
	
	@Test
	public void testPage() {
		PrintStreamProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		HtmlGenerator htmlGenerator = HtmlGenerator.load(
				Context.EMPTY_CONTEXT, 
				null, 
				progressMonitor);

		
		Tag tag = HtmlFactory.eINSTANCE.createTag();
		tag.setName("b");
		tag.getAttributes().put("style", org.nasdanika.ncore.String.wrap("margin:5px"));
		tag.getContent().add(org.nasdanika.ncore.String.wrap("Hello World"));
		
		assertTrue(htmlGenerator.canHandle(tag));
		
		Page page = HtmlFactory.eINSTANCE.createPage();
		page.setName("Test page");
		page.getBody().add(tag);		
				
		Producer<Object> processor = htmlGenerator.createProducer(page, progressMonitor);
		Object result = processor.produce(0);
		
		System.out.println(result);
	}
	

}
