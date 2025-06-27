package org.nasdanika.models.html.producer;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.html.Producer;
import org.nasdanika.models.html.Page;

import reactor.core.publisher.Mono;

public class PageProducer implements Producer<Object> {

	public PageProducer(
			Context context, 
			Page page, 
			BiConsumer<EObject, BiConsumer<Producer<Object>, ProgressMonitor>> elementProvider) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mono<Object> produceAsync(int indent) {
		return Mono.just("Work in progress");
	}
	
	@Override
	public Object produce(int indent) {
		return "Work in progress";
	}

}
