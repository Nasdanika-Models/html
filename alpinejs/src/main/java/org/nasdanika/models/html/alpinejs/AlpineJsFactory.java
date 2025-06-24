package org.nasdanika.models.html.alpinejs;

import org.nasdanika.models.html.HtmlElement;
import org.nasdanika.models.html.HtmlFactory;
import org.nasdanika.models.html.Tag;
import org.nasdanika.models.html.alpinejs.impl.DefaultAlpineJsFactory;

public interface AlpineJsFactory {
	
	AlpineJsFactory INSTANCE = new DefaultAlpineJsFactory(HtmlFactory.eINSTANCE);
	
	<H extends HtmlElement> AlpineJs<H> from(H htmlElement);
	
	HtmlFactory getHtmlFactory();
	
	/**
	 * Wraps the argument element into a template tag with a given teleport selector
	 * @param selector
	 * @param element
	 * @return
	 */
	Tag teleport(Object selector, HtmlElement element);
	
	/**
	 * Wraps the argument element into a template tag with a given for expression
	 * @param selector
	 * @param element
	 * @return
	 */
	Tag _for(Object expression, HtmlElement element);
	
	/**
	 * Wraps the argument element into a template tag with a given if condition
	 * @param selector
	 * @param element
	 * @return
	 */	
	Tag _if(Object condition, HtmlElement element);	

}
