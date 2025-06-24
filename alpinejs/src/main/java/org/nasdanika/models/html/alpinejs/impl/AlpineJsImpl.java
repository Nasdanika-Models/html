package org.nasdanika.models.html.alpinejs.impl;

import org.nasdanika.models.html.HtmlElement;
import org.nasdanika.models.html.alpinejs.AlpineJs;
import org.nasdanika.models.html.alpinejs.AlpineJsFactory;

class AlpineJsImpl<T extends HtmlElement> implements AlpineJs<T> {

	private static final String X_TRANSITION_ATTRIBUTE = "x-transition";

	private T htmlElement;
	
	private AlpineJsFactory factory;

	AlpineJsImpl(AlpineJsFactory factory, T htmlElement) {
		this.factory = factory;
		this.htmlElement = htmlElement;
	}
	
	@Override
	public T toHTMLElement() {
		return htmlElement;
	}

	@Override
	public AlpineJs<T> data(Object data) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-data", data);
		return this;
	}

	@Override
	public AlpineJs<T> text(Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-text", expression);
		return this;
	}

	@Override
	public AlpineJs<T> html(Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-html", expression);
		return this;
	}

	@Override
	public AlpineJs<T> init(Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-init", expression);
		return this;
	}

	@Override
	public AlpineJs<T> show(Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-show", expression);
		return this;
	}

	@Override
	public AlpineJs<T> bind(String attribute, Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-bind:" + attribute, expression);
		return this;
	}

	@Override
	public AlpineJs<T> on(String event, Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-on:" + event, expression);
		return this;
	}

	@Override
	public AlpineJs<T> model(Object dataField) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-model", dataField);
		return this;
	}

	@Override
	public AlpineJs<T> modelable(Object dataField) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-modelable", dataField);
		return this;
	}

	@Override
	public AlpineJs<T> effect(Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-effect", expression);
		return this;
	}

	@Override
	public AlpineJs<T> ignore() {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-ignore", true);
		return this;
	}

	@Override
	public AlpineJs<T> ref(Object name) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-ref", name);
		return this;
	}

	@Override
	public AlpineJs<T> cloak() {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-cloak", true);
		return this;
	}

	@Override
	public AlpineJs<T> id(Object ids) {
		DefaultAlpineJsFactory.attribute(htmlElement, "x-text", ids);
		return this;
	}

	@Override
	public AlpineJs<T> transition() {
		DefaultAlpineJsFactory.attribute(htmlElement, X_TRANSITION_ATTRIBUTE, true);
		return this;
	}

	@Override
	public AlpineJs<T> transition(String modifier) {
		DefaultAlpineJsFactory.attribute(htmlElement, X_TRANSITION_ATTRIBUTE + modifier, true);
		return this;
	}

	@Override
	public AlpineJs<T> transition(String modifier, Object expression) {
		DefaultAlpineJsFactory.attribute(htmlElement, X_TRANSITION_ATTRIBUTE + modifier, expression);
		return this;
	}
	
}
