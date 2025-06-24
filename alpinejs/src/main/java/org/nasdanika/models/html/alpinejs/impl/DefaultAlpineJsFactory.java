package org.nasdanika.models.html.alpinejs.impl;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.exec.content.ContentFactory;
import org.nasdanika.exec.content.Text;
import org.nasdanika.models.html.HtmlElement;
import org.nasdanika.models.html.HtmlFactory;
import org.nasdanika.models.html.Tag;
import org.nasdanika.models.html.alpinejs.AlpineJs;
import org.nasdanika.models.html.alpinejs.AlpineJsFactory;

public class DefaultAlpineJsFactory implements AlpineJsFactory {
	
	private HtmlFactory htmlFactory;

	public DefaultAlpineJsFactory(HtmlFactory htmlFactory) {
		this.htmlFactory = htmlFactory;
	}
	
	public DefaultAlpineJsFactory() {
		this(HtmlFactory.eINSTANCE);
	}
	
	@Override
	public HtmlFactory getHtmlFactory() {
		return htmlFactory;
	}
	
	@Override
	public <H extends HtmlElement> AlpineJs<H> from(H htmlElement) {
		return new AlpineJsImpl<H>(this, htmlElement);
	}
	
	protected Tag createTemplateTag(HtmlElement contents) {		
		Tag tag = htmlFactory.createTag();
		tag.setName("template");
		tag.getContent().add(contents);
		return tag;
	}

	@Override
	public Tag teleport(Object selector, HtmlElement element) {
		return attribute(createTemplateTag(element), "x-teleport", selector);
	}

	@Override
	public Tag _for(Object expression, HtmlElement element) {
		return attribute(createTemplateTag(element), "x-for", expression);
	}

	@Override
	public Tag _if(Object condition, HtmlElement element) {
		return attribute(createTemplateTag(element), "x-if", condition);
	}
	
	public static <H extends HtmlElement> H attribute(H htmlElement, String attributeName, Object attributeValue) {
		htmlElement.getAttributes().put(attributeName, attributeValue instanceof EObject ? (EObject) attributeValue :  createText(attributeValue));
		return htmlElement;
	}
	
	public static Text createText(Object content) {
		if (content == null) {
			return null;
		}
		Text text = ContentFactory.eINSTANCE.createText();
		text.setContent(content.toString());
		return text;
	}
	

}
