package org.nasdanika.models.html.producer;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Producer;
import org.nasdanika.html.Tag;
import org.nasdanika.html.TagName;
import org.nasdanika.models.html.Script;

import reactor.core.publisher.Mono;

public class ScriptProducer implements Producer<Object> {
	
	private Tag scriptTag;

	public ScriptProducer(
			Context context, 
			Script script, 
			BiConsumer<EObject, BiConsumer<Producer<Object>, ProgressMonitor>> elementProvider) {
		
		HTMLFactory htmlFactory = context.get(HTMLFactory.class, HTMLFactory.INSTANCE);
		scriptTag = htmlFactory.tag(TagName.script); //, Util.toString(ctx, input))
		elementProvider.accept(script.getSource(), (sp, pm) -> scriptTag.accept(sp));
	}

	@Override
	public Mono<Object> produceAsync(int indent) {
		return scriptTag.produceAsync(indent);
	}
	
	@Override
	public Object produce(int indent) {
		return scriptTag.produce(indent);
	}

}
