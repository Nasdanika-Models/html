package org.nasdanika.models.html.alpinejs;

import org.nasdanika.models.html.HtmlElement;

public interface AlpineJs<H extends HtmlElement> {
	
	AlpineJs<H> data(Object data);
	
	AlpineJs<H> text(Object expression);
	AlpineJs<H> html(Object expression);
	AlpineJs<H> init(Object expression);
	AlpineJs<H> show(Object expression);
	AlpineJs<H> bind(String attribute, Object expression);
	AlpineJs<H> on(String event, Object expression);
	AlpineJs<H> model(Object dataField);
	AlpineJs<H> modelable(Object dataField);
	AlpineJs<H> effect(Object expression);
	AlpineJs<H> ignore();
	AlpineJs<H> ref(Object name);
	AlpineJs<H> cloak();

	AlpineJs<H> id(Object ids);
	
	AlpineJs<H> transition();
	AlpineJs<H> transition(String modifier);
	AlpineJs<H> transition(String modifier, Object expression);
	
	H toHTMLElement();

}
