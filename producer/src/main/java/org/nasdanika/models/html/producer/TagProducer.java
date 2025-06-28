package org.nasdanika.models.html.producer;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Producer;
import org.nasdanika.models.html.Tag;

import reactor.core.publisher.Mono;

public class TagProducer implements Producer<Object> {
	
	private org.nasdanika.html.Tag delegate;
	
	public static Producer<Object> createProxyProducer(EObject element, BiConsumer<EObject, BiConsumer<Producer<Object>, ProgressMonitor>> elementProvider) {
		return new Producer<Object>() {
			
			private Producer<Object> cDelegate;
			
			{
				elementProvider.accept(element, (cp, pm) -> cDelegate = cp);
			}

			@Override
			public Mono<Object> produceAsync(int indent) {
				return cDelegate.produceAsync(indent);
			}
			
			@Override
			public Object produce(int indent) {
				return cDelegate.produce(indent);
			}
			
		};		
	}
	
	public static List<Producer<Object>> createProxyProducers(Collection<? extends EObject> elements, BiConsumer<EObject, BiConsumer<Producer<Object>, ProgressMonitor>> elementProvider) {
		return elements
				.stream()
				.map(e -> createProxyProducer(e, elementProvider))
				.toList();
	}

	public TagProducer(
			Context context, 
			Tag tag, 
			BiConsumer<EObject, BiConsumer<Producer<Object>, ProgressMonitor>> elementProvider) {
		
		HTMLFactory htmlFactory = context.get(HTMLFactory.class, HTMLFactory.INSTANCE);
		delegate = htmlFactory.tag(tag.getName()); 		
		
		for (Entry<String, EObject> attr: tag.getAttributes().entrySet()) {			
			elementProvider.accept(attr.getValue(), (ap, pm) -> delegate.attribute(attr.getKey(), ap));
		}
		
		for (EObject ce: tag.getContent()) {
			delegate.content(createProxyProducer(ce, elementProvider));
		}
	}

	@Override
	public Mono<Object> produceAsync(int indent) {
		return delegate.produceAsync(indent);
	}
	
	@Override
	public Object produce(int indent) {
		return delegate.produce(indent);
	}

}
