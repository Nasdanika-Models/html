package org.nasdanika.models.html.producer;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Producer;
import org.nasdanika.models.html.Page;

import reactor.core.publisher.Mono;

public class PageProducer implements Producer<String> {
	
	protected org.nasdanika.html.HTMLPage delegate;	

	public PageProducer(
			Context context, 
			Page page, 
			BiConsumer<EObject, BiConsumer<Producer<Object>, ProgressMonitor>> elementProvider) {
		
		HTMLFactory htmlFactory = context.get(HTMLFactory.class, HTMLFactory.INSTANCE);
		delegate = htmlFactory.page();
		delegate.lang(page.getLanguage());
		delegate.title(page.getName());
		for (String styleseet: page.getStylesheets()) {
			delegate.stylesheet(styleseet);
		}
		for (String script: page.getScripts()) {
			delegate.script(script);
		}
				
		for (EObject pe: page.getProlog()) {
			delegate.prolog(TagProducer.createProxyProducer(pe, elementProvider));
		}
		
		for (EObject he: page.getHead()) {
			delegate.head(TagProducer.createProxyProducer(he, elementProvider));
		}
		
		for (EObject be: page.getBody()) {
			delegate.body(TagProducer.createProxyProducer(be, elementProvider));
		}
		
		for (EObject ee: page.getEpilog()) {
			delegate.epilog(TagProducer.createProxyProducer(ee, elementProvider));
		}
		
		for (EObject builder: page.getProlog()) {
			elementProvider.accept(builder, (b, pm) -> b.build(delegate));
		}
	}

	@Override
	public Mono<String> produceAsync(int indent) {
		return delegate.produceAsync(indent);
	}
	
	@Override
	public String produce(int indent) {
		return delegate.produce(indent);
	}

}
